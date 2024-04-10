/**
 * Driver.java - Simulates a shopping scenario with a shopping cart
 *
 * @author Onkar Dhillon
 * @version 1
 */
public class Driver {
    public static void main(String[] args) {

        // Declare the shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();

        // Create an array of items
        Item[] items = {
                new Item("AMD Ryzen 9 5900X", 54999),          // Example price: $549.99
                new Item("NVIDIA GeForce RTX 3080", 69999),    // Example price: $699.99
                new Item("ASUS ROG Strix B550-F Gaming", 20999),// Example price: $209.99
                new Item("Corsair Vengeance LPX 16GB DDR4", 8999), // Example price: $89.99
                new Item("Samsung 970 EVO Plus SSD 1TB", 14999),   // Example price: $149.99
                new Item("NZXT H510 - Compact ATX Mid-Tower", 7999), // Example price: $79.99
                new Item("Corsair RM750x, 750W PSU", 11999),   // Example price: $119.99
                new Item("Cooler Master Hyper 212 RGB", 4499),  // Example price: $44.99
                new Item("Logitech G Pro X Superlight Mouse", 14999),  // Example price: $149.99
                new Item("SteelSeries Apex Pro TKL Keyboard", 17999)    // Example price: $179.99
        };


        // Simulate adding one or multiple of one item
        shoppingCart.add(items[0]);
        shoppingCart.add(items[1]);
        shoppingCart.add(items[2]);
        shoppingCart.addMultipleItems(items[3], 3);
        shoppingCart.addMultipleItems(items[4], 2);
        shoppingCart.add(items[5]);
        shoppingCart.add(items[6]);
        shoppingCart.add(items[7]);
        shoppingCart.add(items[8]);
        shoppingCart.add(items[9]);

        // Display the current cart
        shoppingCart.displayCart(shoppingCart);


        // Simulate removing the specified item
        if(!shoppingCart.removeSpecified(items[3])) {
            // If failed to remove, print a message
            System.out.println();
            System.out.println("Failed to remove " + items[3]);
        } else {
            // If successfully removed, print a message
            System.out.println();
            System.out.println("Successfully removed " + items[3]);
        }

        // Display the current cart to see if the method worked
        shoppingCart.displayCart(shoppingCart);

        // Simulate removing an unspecified item
        System.out.println();
        System.out.println(shoppingCart.remove() + " Was successfully Removed");

        // Display the current cart to see if the method worked
        shoppingCart.displayCart(shoppingCart);

        System.out.println();

        // Checkout and give the total
        shoppingCart.checkOut();

    }
}
