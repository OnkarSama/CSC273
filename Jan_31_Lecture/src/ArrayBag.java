/**
 * Array Bases implementation of our Bag ADT
 *
 * @author Onkar Dhillon
 * @version 1
 */
public class ArrayBag<T> implements BagInterface<T> {

    private T[] bag;  // array of entries in the bag
    private int numOfEntries;  // number of entries in the bag
    private final static int DEFAULT_CAPACITY = 25;

    private final static int MAX_CAPACITY = 1000;
    private static boolean integrityOK = true;


    /**
     * Default constructor
     */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Parameterized constructor
     */
    public ArrayBag(int capacity) {

        integrityOK = false;

        if (capacity <= 0) {
            bag = (T[]) new Object[DEFAULT_CAPACITY];  // if capacity is too small use the default
        } else if(capacity <= MAX_CAPACITY){
            bag = (T[]) new Object[capacity];
        } else {

            throw new IllegalStateException("attempted  to create a bag that exceeds max capacity");
        }

        numOfEntries = 0;
        integrityOK = true;

    }


    /**
     * isArrayFull() it is private helper method to check if bag is at capacity
     * @return isFull a boolean true if full false if not full
     */
    private boolean isArrayFull() {

        return(numOfEntries >= bag.length);
    }

    /**
     *
     */
    private void checkIntegrity() {

        if(!integrityOK) {
            throw new SecurityException("Data is corrupt");
        }
    }

    /**
     * Gets current number of entries in this bag
     *
     * @return currentSize the number of items in the bag
     */
    public int getCurrentSize() {

        return -1;  // STUB

    }

    /**
     * Sees whether the bag is empty
     *
     * @return isEmpty a boolean true if empty and false if not.
     */
    public boolean isEmpty() {

        return false;  // STUB

    }

    /**
     * Adds a new item to the bag
     *
     * @param anEntry the object to be added as a new entry to the bag
     * @return added a boolean true if addition was true and false if not successful.
     */
    public boolean add(T anEntry) {

        checkIntegrity();

        // check if full, if full then can't add, return false
        if(isArrayFull()) {
            return false;
        }

        integrityOK = false;

        // if room, add to the next spot
        bag[numOfEntries] = anEntry;

        // increment numEntries
        numOfEntries++;

        integrityOK = true;

        return true;

    }


    /**
     * Remove an unspecified item (random item), if possible
     *
     * @return anItem which is of type T if remove was successful and NULL if not
     */
    public T remove() {

        return null;  // STUB

    }

    /**
     * Remove one instance of a specified item, if possible
     *
     * @param anEntry the specified item that the user wants to remove
     * @return isSuccessful true if successfully removed false if not
     */
    public boolean remove(T anEntry) {

        return false;  // STUB

    }

    /**
     * Removes all entries from the bag
     */

    public void clear() {

        // STUB
    }

    /**
     * Counts the number of items a given entry appears in this bag
     *
     * @param anEntry the entry to be counted
     * @return frequencyOf the number of times an entry appears
     */
    public int getFrequencyOf(T anEntry) {

        return -1;  // STUB

    }

    /**
     * Tests whether this bag contains a given entry
     *
     * @param anEntry the entry to check
     * @return doesContain true if the bag has the item false otherwise
     */
    public boolean contains(T anEntry) {

        return false;  // STUB

    }


    /**
     * Like toString method but converts bag into array
     *
     * @return bag an array of all items in the bag an empty array if the bag is empty
     */
    public T[] toArray() {

        checkIntegrity();

        // create a new array of size bag numOfEntries
        T[] resultArray = (T[]) new Object[numOfEntries];

        // copy the contents of the bag over to the array
        for(int i = 0; i < numOfEntries; i++) {
            resultArray[i] = bag[i];
        }

        return resultArray;
    }

}
