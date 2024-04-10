

/**
 * Basic test program for our stack ADT
 */
public class Driver {

    public static void main(String[] args) {

        StackInterface<String> stringStack = new LinkedStack<String>();

        stringStack.push("Jim");
        printTop(stringStack);  // Jim

        stringStack.push("Jess");
        printTop(stringStack);  // Jess -> Jim

        stringStack.push("Jill");
        printTop(stringStack);  // Jill -> Jess -> Jim

        stringStack.push("Jane");
        printTop(stringStack);  // Jane -> Jill -> Jess -> Jim

        stringStack.push("Joe");
        printTop(stringStack);  //  Joe -> Jane -> Jill -> Jess -> Jim

        stringStack.pop();
        printTop(stringStack);  //  Jane -> Jill -> Jess -> Jim

        stringStack.pop();
        printTop(stringStack);  //  Jill -> Jess -> Jim

        stringStack.pop();
        printTop(stringStack);  //  Jess -> Jim

        stringStack.pop();
        printTop(stringStack);  //  Jim

        stringStack.pop();
        printTop(stringStack);  //  {empty}

        stringStack.pop();
        printTop(stringStack);  // Throws and error


    }

    public static void printTop(StackInterface theStack){

        System.out.println("The top item is: " + theStack.peek());
    }
}
