
/**
 * Driver.java - basic test program for our Stack ADT
 */
public class VectorDriver {
    public static void main(String[] args) {

        StackInterface<String> stringStack = new VectorStack<>(2);

        stringStack.push("Jim");
        printTop(stringStack);          // Jim

        stringStack.push("Jess");
        printTop(stringStack);          // Jess -> Jim

        stringStack.push("Jill");
        printTop(stringStack);          // Jill -> Jess -> Jim

        stringStack.push("Jane");
        printTop(stringStack);          // Jane -> Jill -> Jess -> Jim

        stringStack.push("Joe");
        printTop(stringStack);          // Joe -> Jane -> Jill -> Jess -> Jim

        stringStack.pop();
        printTop(stringStack);          // Jane -> Jill -> Jess -> Jim

        stringStack.pop();
        printTop(stringStack);          // Jill -> Jess -> Jim

        stringStack.push("Jules");
        printTop(stringStack);          // Jules -> Jill -> Jess -> Jim


        stringStack.pop();
        printTop(stringStack);          // Jill -> Jess -> Jim
        
        /*stringStack.pop();
        printTop(stringStack);          // Jess -> Jim
        
        stringStack.pop();
        printTop(stringStack);          // Jim
        
        stringStack.pop();
        printTop(stringStack);          // {empty} */

        stringStack.clear();
        stringStack.pop();              //should throw EmptyStack Exception 

    }

    public static void printTop(StackInterface theStack) {
        System.out.println("The top item is: " + theStack.peek());
    }
}