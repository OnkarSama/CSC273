import java.io.IOException;
import java.util.Scanner;

public class StockCalculator {

    private LinkedDeque<StockLot> ledger = new LinkedDeque<>();
    private double totalRealizedCapitalGain = 0;
    private IOHandlerInterface ioh = new IOHandlerDialog(); // Using the interface reference
    public void run() {

        int actionType;

        do {
            String userAction = readUserAction(ioh); // Use interface method to get user choice
            actionType = executeAction(userAction, ioh);

        } while(actionType != 3);


    }

    private void buyStock() {
//        int shares =
            double price = pricePerStock(ioh, "Enter the price per stock (format as xx.xx): "); // Use interface method to prompt for price per share
//        StockLot stockLot = new StockLot(shares, price);
//        ledger.addFront(stockLot);
//
//        ioh.displayPurchaseConfirmation(shares, price); // Use interface method to display purchase confirmation
    }

    private void sellStock() {
//        int sharesToSell = ioh.promptForSharesToSell(scanner); // Use interface method to prompt for shares to sell
//        double salePrice = ioh.promptForSalePrice(scanner); // Use interface method to prompt for sale price
//
//        while (sharesToSell > 0 && !ledger.isEmpty()) {
//            StockLot firstLot = ledger.getFront();
//            int sharesInLot = firstLot.getShares();
//
//            if (sharesInLot > sharesToSell) {
//                double gain = (salePrice - firstLot.getPurchasePrice()) * sharesToSell;
//                totalRealizedCapitalGain += gain;
//                firstLot.sellShares(sharesToSell);
//                sharesToSell = 0;
//            } else {
//                double gain = (salePrice - firstLot.getPurchasePrice()) * sharesInLot;
//                totalRealizedCapitalGain += gain;
//                sharesToSell -= sharesInLot;
//                ledger.removeFront();
//            }
//        }
//
//        ioh.displaySaleConfirmation(); // Use interface method to display sale confirmation
    }

    private double pricePerStock(IOHandlerInterface ioh, String prompt) {

        double price;

        String moneyAmount = ioh.get(prompt);

        try {

            price = Double.parseDouble(moneyAmount);

        } catch(NumberFormatException | StringIndexOutOfBoundsException nfe) {
            ioh.put("Invalid money Amount. Please try again.");
            return pricePerStock(ioh,prompt);
        }

        return price;


    }


    private String readUserAction(IOHandlerInterface ioh) {

        String listTitle = "Actions";
        String prompt = "Select what action you would like to complete.";
        String[] choices = {"Buy", "Sell", "Total Realized Capital Gain", "Quit"};
        return ioh.getFromList(listTitle, prompt, choices);
    }

    private int executeAction(String userTransaction, IOHandlerInterface ioh) {

        String[] choices = {"Buy", "Sell", "Total Realized Capital Gain", "Quit"};

        if(userTransaction.equals(choices[0])) {
            // BUY EXECUTION
            buyStock();
            return 0;
        } else if(userTransaction.equals(choices[1])) {
//            // SELL EXECUTION
//            try {
//                // SUCCESSFUL SELL
//            } catch(){
//                // UNSUCCESSFUL SELL
//            }
            return 1;
        } else if(userTransaction.equals(choices[2])) {
            // TOTAL REALIZED CAPITAL GAIN EXECUTION
            return 2;
        } else {
            // EXIT EXECUTION
            return 3;
        }

    }

}
