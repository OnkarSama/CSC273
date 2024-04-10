/**
 * An implementation of our Stack ADT
 * @author Onkar Dhillon
 * @version 1
 */
public interface StackInterface<T> {

    /**
     * push adds a new entry to the top of the stack
     * @param newEntry - the object
     */
    public void push(T newEntry);

    /**
     * Removes and returns the entry at the top of the stack
     * @return anEntry - the object at the top of the stack
     * @throws java.util.EmptyStackException if stack is empty before the operation is called
     */
    public T pop();

    /**
     * Returns the entry at the top of this stack
     * @return anEntry - the object at the top of the stack
     * @throws java.util.EmptyStackException if stack is empty before the operation is called
     */
    public T peek();

    /**
     * Checks if stack is empty
     * @return if empty return true else false
     */
    public boolean isEmpty();

    /**
     * Removes all entries from the stack
     */
    public void clear();
}
