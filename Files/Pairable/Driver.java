
/**
 * Driver for our generic pair objects
 */
public class Driver
{
    public static void main(String[] args)
    {
        /*//create a pair object
        OrderedPair<Integer> pair = new OrderedPair(3, 5);
        System.out.println(pair);
        System.out.println("First item is " + pair.getFirst());
        System.out.println("Swapping order...");
        pair.changeOrder();
        System.out.println(pair);
        System.out.println();*/
        /*
        //create a pair object
        OrderedPair<Double> pair = new OrderedPair(3.14, 5.42);
        System.out.println(pair);
        System.out.println("First item is " + pair.getFirst());
        System.out.println("Swapping order...");
        pair.changeOrder();
        System.out.println(pair);
        System.out.println();*/
        /*
        //create a pair object
        OrderedPair<String> pair = new OrderedPair("John", "Sherlock");
        System.out.println(pair);
        System.out.println("First item is " + pair.getFirst());
        System.out.println("Swapping order...");
        pair.changeOrder();
        System.out.println(pair);
        System.out.println();*/
        /*
        //create a pair object
        OrderedPair<Person> pair = new OrderedPair(new Person("John",25),
                                                   new Person("Sherlock", 33));
        System.out.println(pair);
        System.out.println("First item is " + pair.getFirst());
        System.out.println("Swapping order...");
        pair.changeOrder();
        System.out.println(pair);
        System.out.println();*/
        
        //create a pair object
        OrderedPair<OrderedPair<Integer>> pair = new OrderedPair(new OrderedPair(3,4),
                                                        new OrderedPair(2, 6));
        System.out.println(pair);
        System.out.println("First item is " + pair.getFirst());
        System.out.println("Swapping order...");
        pair.changeOrder();
        System.out.println(pair);
        System.out.println();
        
    }
}
