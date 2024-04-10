import java.io.IOException;
import java.util.Scanner;

public class StockCalculator {

    private LinkedDeque<StockLot> ledger = new LinkedDeque<>();
    private double totalRealizedCapitalGain = 0;
    private int totalNumberOfShares = 0;
    private IOHandlerInterface ioh = new IOHandlerDialog(); // Using the interface reference

    private final String[] choices = {"Buy", "Sell", "Total Realized Capital Gain", "Quit"};

    public void run() {

        int actionType;

        do {
            String userAction = readUserAction(); // Use interface method to get user choice
            actionType = executeAction(userAction);

        } while(actionType != 3);

        System.exit(0);


    }

    private void buyStock() {

        int numberOfShares = readNumberOfShares("Enter the number of Stocks you would like to purchase: ");

        if(numberOfShares >= 0) {
            double pricePerShare = readPricePerStock("Enter the price per stock (format as xx.xx): "); // Use interface method to prompt for price per share
            StockLot stockLot = new StockLot(numberOfShares, pricePerShare);
            ledger.addToBack(stockLot);

            String confirmationPrompt = "Successfully bought " + numberOfShares + " shares priced at $" + correctedPriceFormat(pricePerShare) + " each share. \nTotal Price: " + correctedPriceFormat(numberOfShares * pricePerShare);

            ioh.put(confirmationPrompt); // Use interface method to display purchase confirmation
            totalNumberOfShares += numberOfShares;
        }
    }

    private void sellStock() {

        int sharesToSell = readNumberOfSharesToSell("Enter the number of Stocks you would like to sell: "); // Use interface method to prompt for shares to sell

        if(sharesToSell >= 0) {
            double salePrice = readPricePerStock("Enter the price per stock (format as xx.xx): "); // Use interface method to prompt for sale price

            int numberOfSalesOutput = sharesToSell;


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

            String confirmationPrompt = "Successfully sold " + numberOfSalesOutput + " shares priced at $" + correctedPriceFormat(salePrice) + " each share. \nTotal Price: " + correctedPriceFormat(numberOfSalesOutput * salePrice);

            ioh.put(confirmationPrompt); // Use interface method to display sale confirmation

            totalNumberOfShares -= numberOfSalesOutput;
        }

    }

    public boolean validShareAmount(int numberOfShares) {

        return numberOfShares > 0 && numberOfShares <= totalNumberOfShares;
    }

    private void totalRealizedCapitalGain() {

        String output = "Your current total realized capital gain is: $" + correctedPriceFormat(totalRealizedCapitalGain);

        ioh.put(output);
    }

    private String readUserAction() {

        String listTitle = "Actions";
        String prompt = "Select what action you would like to complete.";
        return ioh.getFromList(listTitle, prompt, choices);
    }

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

    private String correctedPriceFormat(double price) {

        return String.format("%.2f", price);
    }

    public void goodbye() {

        ioh.put("Goodbye, Thank you for using the Stock Calculator");
    }

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
