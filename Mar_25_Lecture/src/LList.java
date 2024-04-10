public class LList<T> implements ListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    private class Node{
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this.data = dataPortion;
            this.next = null;
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

        Node newNode = new Node(newEntry);

        if(isEmpty()) {
            firstNode = newNode;

        } else {

            // Node lastNode = getNodeAt(numberOfEntries);
           //  lastNode.next = newNode;
        }

        numberOfEntries++;
    }

    /**
     * Adds a new entry at a specified position within this list.
     * Entries originally at and above the specified position are the next higher position within the list.
     * The list's size increases by one
     *
     * @param newPosition - an integer that specifies the desired position of the entry within the list.
     * @param newEntry - an entry you want to add to the list
     * @throws IndexOutOfBoundsException if either newPosition is < 1 or newPosition > getLength() + 1
     */
    public void add(int newPosition, T newEntry) {

        if((newPosition >= 1) && (newPosition <= numberOfEntries)) {

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

        return null;

    }

    /**
     * Removes all entries from the list.
     */
    public void clear() {

    }

    /**
     * Replaces the entry at a given position in the list.
     *
     * @param givenPosition - an integer that indicated the position of the entry to be replaced
     * @param newEntry - an entry you want to add to the list
     * @throws IndexOutOfBoundsException -
     */
    public T replace(int givenPosition, T newEntry) {

        return null;

    }

    /**
     * Retrieves
     *
     * @param givenPosition -
     * @return
     * @throws IndexOutOfBoundsException
     */
    public T getEntry(int givenPosition) {

        return null;

    }

    /**
     * Retrieves all the entries that are in the list in the order in which they occur in the list.
     *
     * @return list - a newly allocated array of all entries in the list.
     * if the list is empty then returned array is empty
     */
    public T[] toArray() {

        return null;

    }

    /**
     * Sees whether the list contains given entry.
     *
     * @param anEntry - an entry you want to add to the list
     * @return
     */
    public boolean contains(T anEntry) {

        boolean found = false;

        Node currentNode = firstNode;

        while(!found && currentNode !=null ) {

            if(anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
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

        return numberOfEntries;

    }

    public boolean isEmpty() {

        return (numberOfEntries == 0) && (firstNode ==null);

    }
}
