/**
 * ShoppingCart.java - Emulate a Shopping Cart
 *
 * This class represents a shopping cart where items can be added, removed,
 * and checked out. It maintains the total cost of items in the cart and
 * provides methods to interact with the cart.
 *
 * @author Onkar Dhillon
 * @version 1
 */
public class ShoppingCart {

    private BagInterface<Item> shoppingCart; // The shopping cart containing items
    private int totalInCents; // Total cost of items in the cart, in cents

    /**
     * Constructs an empty shopping cart with a total cost of zero.
     */
    public ShoppingCart() {
        shoppingCart = new LinkedBag<>(); // Initialize the shopping cart as a LinkedBag
        totalInCents = 0; // Initialize the total cost to zero
    }

    /**
     * Adds an item to the shopping cart.
     *
     * @param anEntry The item to be added
     * @return true if the item is successfully added, false otherwise
     */
    public boolean add(Item anEntry) {
        System.out.println(anEntry + " is being added to the Shopping Cart");
        if(shoppingCart.add(anEntry)) {
            totalInCents += anEntry.getPrice();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds multiple instances of an item to the shopping cart.
     *
     * @param anEntry The item to be added
     * @param numOfItems The number of instances of the item to add
     * @return true if the items are successfully added, false otherwise
     */
    public boolean addMultipleItems(Item anEntry, int numOfItems) {
        System.out.println(anEntry + " with a quantity of " + numOfItems + " is being added to the Shopping Cart");
        while(numOfItems != 0) {
            if(shoppingCart.add(anEntry)) {
                totalInCents += anEntry.getPrice();
                numOfItems--;
            }
        }
        return true;
    }

    /**
     * Removes an item from the shopping cart.
     *
     * @return The item removed from the cart, or null if the cart is empty
     */
    public Item remove() {
        Item itemRemoved = shoppingCart.remove();
        if(itemRemoved != null) {
            totalInCents -= itemRemoved.getPrice();
        }
        return itemRemoved;
    }

    /**
     * Removes a specified item from the shopping cart.
     *
     * @param anEntry The item to be removed
     * @return true if the item is successfully removed, false otherwise
     */
    public boolean removeSpecified(Item anEntry) {
        if(shoppingCart.remove(anEntry)) {
            totalInCents -= anEntry.getPrice();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the total cost exceeds a specified budget and removes items
     * until the cost is within the budget.
     *
     * @param budget The budget to check against
     */
    public void checkBudget(int budget) {
        while(budget < totalInCents) {
            Item removedItem = remove();
            System.out.println();
            System.out.println("Your cart total exceeded your budget");
            System.out.println(removedItem.toString() + " was removed ");
            System.out.println();
        }
    }

    /**
     * Checks out items from the shopping cart and displays the final cost.
     */
    public void checkOut() {
        int budget = 250000; // Budget limit
        int totalFinalCost = 0; // Total cost of items after checkout
        int numOfItems = 0; // Number of items checked out

        checkBudget(budget); // Check if cart total exceeds budget

        displayFinalCart(); // Display final items in the cart

        while(!shoppingCart.isEmpty()) {
            Item item = remove();
            numOfItems++;
            totalFinalCost += item.getPrice();
        }

        System.out.println();

        System.out.println("You Spent " + toString(totalFinalCost) + " on " + numOfItems + " items");
    }

    /**
     * Converts the shopping cart to an array.
     *
     * @return An array containing the items in the shopping cart
     */
    public Object[] toArray() {
        return shoppingCart.toArray();
    }

    /**
     * Displays the items in the shopping cart.
     *
     * @param cart The shopping cart to display
     */
    public void displayCart(ShoppingCart cart) {
        System.out.println();
        System.out.println("Items in the shopping cart: ");
        Object[] itemsArray = toArray();
        for(Object o : itemsArray) {
            Item item = (Item) o;
            System.out.println(item);
        }
    }

    /**
     * Converts a cost in cents to a formatted string representation.
     *
     * @param cost The cost in cents
     * @return The formatted cost string
     */
    public String toString(int cost) {
        if(cost % 100 == 0) {
            return "$" + cost / 100 + "." + cost % 100 + "0";
        } else if(cost % 100 > 0 && cost % 100 < 10 )  {
            return"$" + cost / 100 + ".0" + cost % 100;
        } else {
            return "$" + cost / 100 + "." + cost % 100;
        }
    }

    /**
     * Displays the final items in the shopping cart.
     */
    public void displayFinalCart() {
        System.out.println("Displaying final shopping cart: ");
        Object[] itemsArray = toArray();
        for(Object o : itemsArray) {
            Item item = (Item) o;
            System.out.println(item);
        }
    }
}
