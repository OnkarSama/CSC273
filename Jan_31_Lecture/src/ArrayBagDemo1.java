/**
 * Driver to test the core methods of ArrayBag
 */
public class ArrayBagDemo1 {

    public static void main(String[] args) {

        System.out.println("Testing an initially empty bag with sufficient capacity: ");
        BagInterface<String> aBag = new ArrayBag<>();

        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        testAdd(aBag, contentsOfBag1);

        System.out.println("\nTesting an initially empty bag that will be filled to capacity: ");
        aBag = new ArrayBag(7);

        String[] contentsOfBag2 = {"A", "B", "A", "C", "C", "A"};
        testAdd(aBag, contentsOfBag2);

    }

    /**
     *  test the method add
     * @param aBag of type BagInterface<String>
     * @param content of type String[] all the items in the bag
     */
    private static void testAdd(BagInterface<String> aBag, String[] content) {

        System.out.println("Adding the following strings to the bag");

        for(int i =0; i < content.length; i++) {

            if(aBag.add(content[i])) {
                System.out.print(content[i] + " ");
            } else {
                System.out.println("\nUnable to add " + content[i] + " to the bag.");
            }
        }
        System.out.println();
        displayBag(aBag);
    }

    /**
     * tests the method toArray() while displaying the bag
     * @param aBag of type BagInterface<String>
     */
    private static void displayBag(BagInterface<String> aBag) {

        System.out.println("The bag contains the following strings(s): ");

        Object[] bagArray =  aBag.toArray();

        for(int i = 0; i < bagArray.length; i++) {

            System.out.print(bagArray[i] + " ");
        }
        System.out.println();
    }
}
