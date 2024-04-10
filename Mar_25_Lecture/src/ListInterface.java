/**
 * ListInterface.java - Implementaion of List ADT
 *
 * @author Onkar Dhillon
 *
 */
public interface ListInterface<T> {

    /**
     * Adds a new entry to the end of the list
     * Entries in the list are unaffected
     * The list''s size increased by one
     *
     * @param newEntry - an entry you want to add to the list
     */
    public void add(T newEntry);

    /**
     * Adds a new entry at a specified position within this list.
     * Entries originally at and above the specified position are the next higher position within the list.
     * The list's size increases by one
     *
     * @param newPosition - an integer that specifies the desired position of the entry within the list.
     * @param newEntry - an entry you want to add to the list
     * @throws IndexOutOfBoundsException if either newPosition is < 1 or newPosition > getLength() + 1
     */
    public void add(int newPosition, T newEntry);

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
    public T remove(int givenPosition);

    /**
     * Removes all entries from the list.
     */
    public void clear();

    /**
     * Replaces the entry at a given position in the list.
     *
     * @param givenPosition - an integer that indicated the position of the entry to be replaced
     * @param newEntry - an entry you want to add to the list
     * @throws IndexOutOfBoundsException -
     */
    public T replace(int givenPosition, T newEntry);

    /**
     * Retrieves
     *
     * @param givenPosition -
     * @return
     * @throws IndexOutOfBoundsException
     */
    public T getEntry(int givenPosition);

    /**
     * Retrieves all the entries that are in the list in the order in which they occur in the list.
     *
     * @return list - a newly allocated array of all entries in the list.
     * if the list is empty then returned array is empty
     */
    public T[] toArray();

    /**
     * Sees whether the list contains given entry.
     *
     * @param anEntry - an entry you want to add to the list
     * @return
     */
    public boolean contains(T anEntry);

    /**
     * Gets the length of the list
     *
     * @return listLength - the length of the list
     */
    public int getLength();

    public boolean isEmpty();



}
