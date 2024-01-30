/**
 * @author Onkar Dhillon
 * @version 1
 */
public class Driver1 {

    public static void main(String[] args) {

        OrderedPair<Integer> pair = new OrderedPair(3,5);

        System.out.println(pair);
        System.out.println("First item is " + pair.getFirst());
        System.out.println("Second item is " + pair.getSecond());

        System.out.println("Swapping order...");
        pair.changeOrder();
        System.out.println(pair);

        System.out.println();

        OrderedPair<String> newPair = new OrderedPair("Hello", "World");

        System.out.println(newPair);
        System.out.println("First item is " + newPair.getFirst());
        System.out.println("Second item is " + newPair.getSecond());

        System.out.println("Swapping order...");
        newPair.changeOrder();
        System.out.println(newPair);

        System.out.println();

        OrderedPair<OrderedPair<Integer>> NewPair2 = new OrderedPair(new OrderedPair(3,4), new OrderedPair(2, 6));
        System.out.println(NewPair2);
        System.out.println("First item is " + NewPair2.getFirst());
        System.out.println("Swapping order...");
        NewPair2.changeOrder();
        System.out.println(NewPair2);
        System.out.println();



    }

}
