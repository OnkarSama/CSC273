
/**
 * OnlineShopper.java - driver to test out shopping cart implementation of a Bag
 */
public class OnlineShopper
{
    public static void main(String[] args)
    {
        //Create some Items to add
        Item[] items = {new Item("Bird feeder", 2050),
                new Item("Squirrel guard", 1587),
                new Item("Bird bath", 4499),
                new Item("Sunflower seeds", 1299)};

        //Create a Bag implementation
        BagInterface<Item> shoppingCart = new ArrayBag<>();

        //Add items to our bag
        for (int index = 0; index < items.length; index++)
        {
            Item nextItem = items[index];
            shoppingCart.add(nextItem);
        }

        //Simulate check out (remove/isEmpty)
        int totalCost = 0;
        while(!shoppingCart.isEmpty())
        {
            Item nextItem = shoppingCart.remove();  //remove 1 item from cart
            System.out.println(nextItem);           //rely on toString to print
            totalCost += nextItem.getPrice();       //add its price to total
        }

        //Print out total
        System.out.println("Total cost:\t$" + totalCost/100 +
                "." + totalCost % 100);
    }
}
