
/**
 * ListDriver.java - a simple test program for our List ADT implementations
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoadRace {

    public static void main(String[] args) {

        ListInterface<String> runnerList = new AList<>();

        runnerList.add("16");   //Winner
        runnerList.add("4");    //Second place
        runnerList.add("33");   //Third place
        runnerList.add("27");   //Fourth place
        displayList(runnerList);


        ListInterface<String> alphaList = new AList<>();

        alphaList.add(1, "Amy");    //Amy
        alphaList.add(2, "Elias");  //Amy, Elias
        alphaList.add(2, "Bob");    //Amy, Bob, Elias
        alphaList.add(3, "Drew");   //Amy, Bob, Drew, Elias
        alphaList.add(1, "Aaron");  //Aaron, Amy, Bob, Drew, Elias
        alphaList.add(4, "Carol");  //Aaron, Amy, Bob, Carol, Drew, Elias
        displayList(alphaList);

        alphaList.remove(4);        //Aaron, Amy, Bob, Drew, Elias
        displayList(alphaList);

        alphaList.replace(4, "David");        //Aaron, Amy, Bob, David, Elias
        displayList(alphaList);

        alphaList.clear();
        displayList(alphaList);

    }

    public static void displayList(ListInterface list) {
        int numEntries = list.getLength();
        System.out.println("The list contains " + numEntries + " entries, as follows:");
        for(int pos = 1; pos <= numEntries; pos++)
            System.out.println(list.getEntry(pos) + " is entry " + pos);

        System.out.println();
    }
}