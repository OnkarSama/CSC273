import java.util.EmptyStackException;

/**
 * LinkedStack.java - Linked list based implementation of the Stack ADT
 * @author Onkar Dhillon
 * @version 1
 */
public class LinkedStack<T> implements StackInterface<T> {

    private Node topNode;  // declare properties

    // constructor
    public LinkedStack() {
        topNode = null;
    }

    private class Node{
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this.data = dataPortion;
            this.next = null;
        }
    }

    /**
     * push adds a new entry to the top of the stack
     * @param newEntry - the object
     */
    public void push(T newEntry) {

        Node newNode = new Node(newEntry);  // create a new node

        newNode.next = topNode; // linking node to the top node

        topNode = newNode;  // reassigning topNode to the new node

    }

    /**
     * Removes and returns the entry at the top of the stack
     * @return anEntry - the object at the top of the stack
     * @throws java.util.EmptyStackException if stack is empty before the operation is called
     */
    public T pop() {

        T result = peek();  // could possibly throw an exception

        topNode = topNode.next;  // redefines topNode to next to cut off topNode

        return result;

    }

    /**
     * Returns the entry at the top of this stack
     * @return anEntry - the object at the top of the stack
     * @throws java.util.EmptyStackException if stack is empty before the operation is called
     */
    public T peek() {

        if(isEmpty()) {
            throw  new EmptyStackException();  // throws exception if empty
        } else {
            return topNode.data;  // else returns
        }
    }

    /**
     * Checks if stack is empty
     * @return if empty return true else false
     */
    public boolean isEmpty() {

        return topNode == null;  // if top node is null it means it is empty

    }

    /**
     * Removes all entries from the stack
     */
    public void clear() {

        topNode = null;  // making stack empty
    }
}
