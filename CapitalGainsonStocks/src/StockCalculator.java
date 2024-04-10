/**
 * StockCalculator.java - Runs all operations (Buy, Sell, Total Realized Capital Gain, and Quit)
 *
 * @author Onkar Dhillon
 * @version v4
 */
public class StockCalculator {

    private LinkedDeque<StockLot> ledger = new LinkedDeque<>();  // creating the ledger using linkedDeque
    private double totalRealizedCapitalGain = 0;  // total realized gain that is updated throughout the program
    private int totalNumberOfShares = 0;  // total number of shares to show the user how many they have
    private IOHandlerInterface ioh = new IOHandlerDialog();  // creating gui using and implementation of IOHandler

    private final String[] choices = {"Buy", "Sell", "Total Realized Capital Gain", "Quit"};  // the choices the user has

    /**
     * run() - it runs the stock calculator in a do while loop to run while the option selected isn't quit or cancel
     *
     */
    public void run() {

        int actionType;  // variable for the action type (one of the choices)

        do {
            String userAction = readUserAction(); // Use helper method to get user choice
            actionType = executeAction(userAction);  // getting the user action in int to run while loop

        } while(actionType != 3);

        System.exit(0);  // ends program

    }

    /**
     * buyStock() - simulates the buying of a stock by prompting user input and if the user presses cancel it won't run,
     * and it will bring you back to the main menu.
     */
    private void buyStock() {

        int numberOfShares = readNumberOfShares("Enter the number of Stocks you would like to purchase: ");  // reads number of share returns -1 if user cancels

        // checks if user cancels if they don't then proceed
        if(numberOfShares >= 0) {
            double pricePerShare = readPricePerStock("Enter the price per stock (format as xx.xx): "); // Use helper method to prompt for price per share
            StockLot stockLot = new StockLot(numberOfShares, pricePerShare);  // creating a new object of StockLot to add number of shares and price per for list
            ledger.addToBack(stockLot);  //  adding to the back of the list to keep in order

            String confirmationPrompt = "Successfully bought " + numberOfShares + " shares priced at $" + correctedPriceFormat(pricePerShare) + " each share. \nTotal Price: " + correctedPriceFormat(numberOfShares * pricePerShare);  // output string for confirmation of buying

            ioh.put(confirmationPrompt); // Use ioHandler method to display purchase confirmation

            totalNumberOfShares += numberOfShares;  // updates total number of shares
        }
    }

    /**
     * sellStock() - simulates the selling of a stock by prompting user input and if the user presses cancel it won't run,
     * and it will bring you back to the main menu.
     */
    private void sellStock() {

        int sharesToSell = readNumberOfSharesToSell("Enter the number of Stocks you would like to sell: ");  // reads number of shares to sell returns -1 if user cancels

        // checks if user cancels if they don't then proceed
        if(sharesToSell >= 0) {
            double salePrice = readPricePerStock("Enter the price per stock (format as xx.xx): ");  // Use helper method to prompt for price per share at selling

            int numberOfSalesOutput = sharesToSell;  // variable to output number of shares sold


            // Iterate through the ledger to sell shares
            while(validShareAmount(sharesToSell) && !ledger.isEmpty()) {
                StockLot firstLot = ledger.getFront();
                int sharesInLot = firstLot.getShares();

                if(sharesInLot <= sharesToSell) {
                    // If the current lot's shares are less than or equal to the shares to sell
                    double gain = (salePrice - firstLot.getBuyPrice()) * sharesInLot;
                    totalRealizedCapitalGain += gain;
                    sharesToSell -= sharesInLot;
                    ledger.removeFront();
                } else {
                    // If the current lot's shares are greater than the shares to sell
                    double gain = (salePrice - firstLot.getBuyPrice()) * sharesToSell;
                    totalRealizedCapitalGain += gain;
                    firstLot.setShares(firstLot.getShares() - sharesToSell);
                    sharesToSell = 0;
                }
            }

            String confirmationPrompt = "Successfully sold " + numberOfSalesOutput + " shares priced at $" + correctedPriceFormat(salePrice) + " each share. \nTotal Price: " + correctedPriceFormat(numberOfSalesOutput * salePrice);  // output string for confirmation of selling

            ioh.put(confirmationPrompt); // Use ioHandler method to display sale confirmation

            totalNumberOfShares -= numberOfSalesOutput;  // update total number of shares
        }

    }

    /**
     * validShareAmount() - Validates the number of shares
     *
     * @param numberOfShares - the number of shares that need to be validated
     * @return - true if number of shares is greater than 0 and less than total number of shares user has
     */
    public boolean validShareAmount(int numberOfShares) {

        return numberOfShares > 0 && numberOfShares <= totalNumberOfShares;  // validates number of shares
    }

    /**
     * totalRealizedCapitalGain() - outputs to the IOHandler gui the total realized capital gain using totalRealizedCapitalGain
     */
    private void totalRealizedCapitalGain() {

        String output = "Your current total realized capital gain is: $" + correctedPriceFormat(totalRealizedCapitalGain);  // output as string

        ioh.put(output);  // putting output on gui
    }

    /**
     * readUserAction() - giving the three parameters needed for gui and returns the gui and the choice selected
     *
     * @return - the gui using IOHandlerDialog and the choice they selected as a string
     */
    private String readUserAction() {

        String listTitle = "Actions";
        String prompt = "Select what action you would like to complete.";
        return ioh.getFromList(listTitle, prompt, choices);
    }

    /**
     * readNumberOfShares() - Prompts the user to input the number of shares to buy and handles the input validation.
     *
     * @param prompt - The prompt message asking the user to input the number of shares.
     * @return - The number of shares inputted by the user.
     */
    private int readNumberOfShares(String prompt) {

        int numberOfShares;

        try {

            String numberOfSharesString = ioh.get(prompt);

            if(numberOfSharesString.isEmpty()) {
                throw new NullPointerException();
            }

            numberOfShares = Integer.parseInt(numberOfSharesString);

        } catch(NumberFormatException | StringIndexOutOfBoundsException nfe) {
            ioh.put("Invalid amount of shares. Please try again.");
            return readNumberOfShares(prompt);
        } catch(NullPointerException npe) {
            return -1;
        }

        return numberOfShares;
    }

    /**
     * readNumberOfSharesToSell() - Prompts the user to input the number of shares to sell and handles the input validation.
     *
     * @param prompt - The prompt message asking the user to input the number of shares to sell.
     * @return - The number of shares inputted by the user.
     */
    private int readNumberOfSharesToSell(String prompt) {

        int numberOfShares;

        try {

            String numberOfSharesToSell = ioh.get(prompt);

            if(numberOfSharesToSell.isEmpty()) {
                throw new NullPointerException();
            }

            numberOfShares = Integer.parseInt(numberOfSharesToSell);

            if(!validShareAmount(numberOfShares)) {
                throw new InsufficientSharesException();
            }

        } catch(NumberFormatException | StringIndexOutOfBoundsException nfe) {
            ioh.put("Invalid amount of shares. Please try again.");
            return readNumberOfShares(prompt);
        } catch(InsufficientSharesException ise) {
            ioh.put("Trying to sell more shares then you have. You have " + totalNumberOfShares + " shares. Please try again.");
            return readNumberOfShares(prompt);
        } catch(NullPointerException npe) {
            return -1;
        }

        return numberOfShares;
    }

    /**
     * readPricePerStock() - Prompts the user to input the price per stock and handles the input validation.
     *
     * @param prompt - The prompt message asking the user to input the price per stock.
     * @return - The price per stock inputted by the user.
     */
    private double readPricePerStock(String prompt) {

        double price;

        try {

            String pricePerStock = ioh.get(prompt);

            price = Double.parseDouble(pricePerStock);

        } catch(NumberFormatException | StringIndexOutOfBoundsException nfe) {
            ioh.put("Invalid money Amount. Please try again.");
            return readPricePerStock(prompt);
        } catch(NullPointerException npe) {
            return -1;
        }

        return price;
    }

    /**
     * correctedPriceFormat() - Formats the price with two decimal places.
     *
     * @param price - The price to be formatted.
     * @return - The formatted price as a string.
     */
    private String correctedPriceFormat(double price) {

        return String.format("%.2f", price);
    }

    /**
     * goodbye() - Displays a goodbye message to the user.
     */
    public void goodbye() {

        ioh.put("Goodbye, Thank you for using the Stock Calculator");
    }

    /**
     * executeAction() - Executes the user-selected action based on the input.
     *
     * @param userTransaction - The user's chosen transaction.
     * @return - An integer representing the action executed.
     */
    private int executeAction(String userTransaction) {

        try {
            if(userTransaction.equals(choices[0])) {
                // BUY EXECUTION
                buyStock();
                return 0;
            } else if(userTransaction.equals(choices[1])) {
                sellStock();
                return 1;
            } else if(userTransaction.equals(choices[2])) {
                // TOTAL REALIZED CAPITAL GAIN EXECUTION
                totalRealizedCapitalGain();
                return 2;
            } else {
                // EXIT EXECUTION
                goodbye();
                return 3;
            }

        } catch(NullPointerException npe) {
            goodbye();
            return 3;
        }

    }

}
