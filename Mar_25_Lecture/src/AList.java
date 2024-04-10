import java.util.Arrays;

public class AList<T> implements ListInterface<T> {

    private T[] list;
    private int numOfEntries;
    private final static int DEFAULT_CAPACITY = 25;
    private final static int MAX_CAPACITY = 1000;
    private boolean integrityOK;

    public AList() {
        this(DEFAULT_CAPACITY);
    }

    public AList(int capacity) {

        integrityOK = false;

        if(capacity <= 0) {
            list = (T[]) new Object[DEFAULT_CAPACITY];  // if capacity too small, use default
        } else {
            checkCapacity(capacity);
            list = (T[]) new Object[capacity];
        }

        numOfEntries = 0;

        integrityOK = true;
    }

    //checkIntegrity() - helper method to ensure bag is okay to work with
    private void checkIntegrity() {
        if(!integrityOK)
            throw new SecurityException("Data is corrupt.");
    }

    //checkCapacity() - ensure desired capacity is allowed; else throw exception
    private void checkCapacity(int capacity) {
        if(capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempted to create a bag that exceeds max capacity.");
    }

    //ensureCapacity() -- helper method to double capacity of array when full (if allowed)
    private void ensureCapacity() {

        int capacity = list.length - 1;
        //check if array is full
        if(numOfEntries >= capacity) {

            int newCapacity = capacity * 2;

            checkCapacity(newCapacity);

            //copy contents into new array using copyOf
            list = Arrays.copyOf(list, newCapacity + 1);
        }
    }


    /**
     * Adds a new entry to the end of the list
     * Entries in the list are unaffected
     * The list''s size increased by one
     *
     * @param newEntry - an entry you want to add to the list
     */
    public void add(T newEntry) {

        checkIntegrity();

        integrityOK = false;

        list[numOfEntries + 1] = newEntry;

        numOfEntries++;

        integrityOK = true;

        ensureCapacity();

    }

    /**
     * Adds a new entry at a specified position within this list.
     * Entries originally at and above the specified position are the next higher position within the list.
     * The list's size increases by one
     *
     * @param newPosition - an integer that specifies the desired position of the entry within the list.
     * @param newEntry    - an entry you want to add to the list
     * @throws IndexOutOfBoundsException if either newPosition is < 1 or newPosition > getLength() + 1
     */
    public void add(int newPosition, T newEntry) {

        checkIntegrity();

        // check if position number is withing bounds
        if((newPosition >= 1) && (newPosition <= numOfEntries + 1)) {
            if(newPosition <= numOfEntries) {
                makeRoom(newPosition);
            }
            list[newPosition] = newEntry;
            numOfEntries++;
            ensureCapacity();
            integrityOK = true;
        } else {
            throw new IndexOutOfBoundsException("Illegal position no. given to add.");
        }

    }

    /**
     * Helper method to shift the entries one position higher to the right to make room at the new position.
     * Pre-Condition: 1 <= givenPosition <= numberOfEntries and
     * numOfEntries must be the current size before the add operation
     *
     * @param newIndex - where we want the object to be
     */
    private void makeRoom(int newIndex) {

        int lastIndex = numOfEntries;

        for(int index = lastIndex; index >= newIndex; index--) {
            list[index + 1] = list[lastIndex];
        }

    }

    /**
     * Removes the entry at a given position from the list.
     * Entries originally at positions higher than the given position
     * are at the next lower position within the list.
     * The list's size decreases by one
     *
     * @param givenPosition - an integer that specifies the desired position of the entry to be removed.
     * @return removedEntry - a reference to the entry removed
     * @throws IndexOutOfBoundsException -
     */
    public T remove(int givenPosition) {

        checkIntegrity();

        if((givenPosition >= 1) && (givenPosition <= numOfEntries)) {

            integrityOK = false;

            T result = list[givenPosition];

            if(givenPosition < numOfEntries) removeGap(givenPosition);

            list[numOfEntries] = null;
            numOfEntries--;
            integrityOK = true;
            return result;

        } else {
            throw new IndexOutOfBoundsException("Illegal position no. given to remove.");
        }

    }

    /**
     * Helper method to shift the entries one position lower to close the gap.
     * Pre-Condition: 1 <= givenPosition <= numberOfEntries and
     * numOfEntries must be the current size before the remove operation
     *
     * @param removedIndex - where we want the object to be
     */
    private void removeGap(int removedIndex) {

        for(int index = removedIndex; index < numOfEntries; index++) {
            list[index] = list[index + 1];
        }

    }

    /**
     * Removes all entries from the list.
     */
    public void clear() {

        for(int index = 1; index <= numOfEntries; index++) {
            list[index] = null;
        }

        numOfEntries = 0;

    }

    /**
     * Replaces the entry at a given position in the list.
     *
     * @param givenPosition - an integer that indicated the position of the entry to be replaced
     * @param newEntry      - an entry you want to add to the list
     * @throws IndexOutOfBoundsException -
     */
    public T replace(int givenPosition, T newEntry) {

        checkIntegrity();

        if((givenPosition >= 1) && (givenPosition <= numOfEntries)) {

            integrityOK = false;

            T result = list[givenPosition];

            list[givenPosition] = newEntry;

            integrityOK = true;

            return result;
        } else {
            throw new IndexOutOfBoundsException("Illegal position no. given to replace.");
        }

    }

    /**
     * Retrieves
     *
     * @param givenPosition -
     * @return
     * @throws IndexOutOfBoundsException
     */
    public T getEntry(int givenPosition) {

        checkIntegrity();

        if((givenPosition >= 1) && (givenPosition <= numOfEntries)) {
            return list[givenPosition];
        } else {
            throw new IndexOutOfBoundsException("Illegal position no. given to getEntry.");
        }
    }

    /**
     * Retrieves all the entries that are in the list in the order in which they occur in the list.
     *
     * @return list - a newly allocated array of all entries in the list.
     * if the list is empty then returned array is empty
     */
    public T[] toArray() {

        checkIntegrity();

        T[] result = (T[]) new Object[numOfEntries];

        for(int i = 0; i < numOfEntries; i++) {
            result[i] = list[i];
        }

        return result;

    }

    /**
     * Sees whether the list contains given entry.
     *
     * @param anEntry - an entry you want to add to the list
     * @return
     */
    public boolean contains(T anEntry) {

        checkIntegrity();

        boolean found = false;

        int index = 1;

        while(!found && (index <=numOfEntries)){

            if(anEntry.equals(list[index])) {
                found = true;
            }
        }

        return found;

    }

    /**
     * Gets the length of the list
     *
     * @return listLength - the length of the list
     */
    public int getLength() {

        return numOfEntries;

    }

    public boolean isEmpty() {

        return numOfEntries == 0;

    }
}
