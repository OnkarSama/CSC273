/**
 * @author Onkar Dhillon
 * @version 1
 *
 * BagInterface.java - ADT Set type
 * describes the operations of a bag of objects
 */
public interface SetInterface<T> {

    /**
     * Gets current number of entries in this set
     * @return currentSize the number of items in the set
     */
    public int getCurrentSize();

    /**
     *  Sees whether the set is empty
     * @return isEmpty a boolean true if empty and false if not.
     */
    public boolean isEmpty();

    /**
     *  Adds a new item to the set, avoiding duplicates
     * @param anEntry the object to be added as a new entry to the bag
     * @return added a boolean true if addition was true and false if not successful or if the item was in the set.
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
     * @return doesContain true if found, false otherwise
     */
    public boolean contains(T anEntry);

    /**
     * Like toString method but converts bag into array
     * @return set an array of all items in the set an empty array if the set is empty
     */
    public T[] toArray();




}
