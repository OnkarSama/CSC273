/**
 *
 * BagInterface.java - ADT Bag type describes the operations of a bag of objects
 * @author Onkar Dhillon
 * @version 1
 *
 */
public interface BagInterface<T> {

    /**
     * Gets current number of entries in this bag
     * @return currentSize the number of items in the bag
     */
    public int getCurrentSize();

    /**
     *  Sees whether the bag is empty
     * @return isEmpty a boolean true if empty and false if not.
     */
    public boolean isEmpty();

    /**
     *  Adds a new item to the bag
     * @param anEntry the object to be added as a new entry to the bag
     * @return added a boolean true if addition was true and false if not successful.
     */
    public boolean add(T anEntry);

    /**
     *  Remove an unspecified item (random item), if possible
     * @return anItem which is of type T if remove was successful and NULL if not
     */
    public T remove();

    /**
     *  Remove one instance of a specified item, if possible
     * @param anEntry the specified item that the user wants to remove
     * @return isSuccessful true if successfully removed false if not
     */
    public boolean remove(T anEntry);

    /**
     * Removes all entries from the bag
     */

    public void clear();

    /**
     * Counts the number of items a given entry appears in this bag
     * @param anEntry the entry to be counted
     * @return frequencyOf the number of times an entry appears
     */
    public int getFrequencyOf(T anEntry);

    /**
     * Tests whether this bag contains a given entry
     * @param anEntry the entry to check
     * @return doesContain true if the bag has the item false otherwise
     */
    public boolean contains(T anEntry);


    /**
     * Like toString method but converts bag into array
     * @return bag an array of all items in the bag an empty array if the bag is empty
     */
    public T[] toArray();
}
