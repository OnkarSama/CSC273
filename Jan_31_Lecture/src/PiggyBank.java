///**
// * PiggyBank.java a class that implements a Piggy Bank using a Bag
// */
//public class PiggyBank {
//
//    private BagInterface<Coin> coins;
//
//    public PiggyBank(){
//        this.coins = new Bag<>();  // initialize with bag implementation
//    }
//
//    /**
//     * add() adds a coin to our piggy bank
//     * @param aCoin the coin you want to add to the piggy bank
//     * @return true if added successful, otherwise false
//     */
//    public boolean add(Coin aCoin) {
//        coins.add(aCoin);
//    }
//
//    /**
//     * isEmpty() whether it is empty or not.
//     * @return true if empty, otherwise false
//     */
//    public boolean isEmpty(){
//        return coins.isEmpty();
//    }
//
//    public int smash(){
//        int totalValue = 0;
//
//        while(!coins.isEmpty()) {
//            Coin nextCoin = coins.remove();
//            totalValue += nextCoin.getValue();
//        }
//        System.out.println("Piggy bank smashed; " + totalValue + " retrieved from inside.");
//
//        return totalValue;
//    }
//}
