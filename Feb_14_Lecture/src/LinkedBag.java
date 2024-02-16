
/**
 * LinkedBag.java - Link-based implementation of the Bag ADT
 */
public class LinkedBag<T> implements BagInterface<T> {
    private Node firstNode;
    private int numEntries;

    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        }
    }

    //constructor
    public LinkedBag() {
        firstNode = null;
        numEntries = 0;
    }

    //interface methods

    //Gets the current number of entries in this bag
    // @return The integer number of entries currently in the bag
    public int getCurrentSize() {
        return numEntries;
    }

    //Sees whether the bag is empty
    // @return TRUE if the bag is empty, FALSE otherwise
    public boolean isEmpty() {
        return (numEntries == 0);
    }

    //Adds a new entry to this bag
    // @param newEntry - the object to be added as a new entry
    // @return TRUE if add was successful, FALSE otherwise
    public boolean add(T newEntry) {
        //create a new node
        Node newNode = new Node(newEntry);

        //attach new node to the first node
        newNode.next = firstNode;

        //reassign first node to be the new node
        firstNode = newNode;

        numEntries++;
        return true;
    }

    //Retrieves all entries that are in this bag
    // @return A newly allocated array of all the entries in this bag
    //  NOTE:  If the bag is empty, the returned array is empty
    public T[] toArray() {

        //allocate new result array
        T[] result = (T[]) new Object[numEntries];
        int index = 0;
        Node curr = firstNode;  // start at first node

        //traverse our list, copying current data into array
        while (curr != null) {
            //copy over
            result[index] = curr.data;
            //hop to next node
            curr = curr.next;
            index++;
        }

        return result;
    }

    //Remove (general, unspecified version) an item
    //Removes one unspecified entry from this bag, if possible
    // @return either the removed entry (if successful), or NULL
    public T remove() {

        T result = null;

        if(!isEmpty()) {
            result = firstNode.data;   // saves the entry so it can be returned
            firstNode = firstNode.next;  // removes the first node from the chain
            numEntries--;
        }

        return result;
    }

    //Remove (specific version)
    //Removes one occurrence of a given entry from the bag, if possible
    // @param anEntry - the entry to be removed
    // @return TRUE if successful, FALSE otherwise
    public boolean remove(T anEntry) {

        Node p = getNodeContaining(anEntry);

        if(p == null)
            return false;

        p.data = firstNode.data;  // copy firstNode's data into current

        remove();  // remove first node

        return true;

    }

    /**
     * Helper method to traverse the chain and find the node containing a specific entry
     * @param anEntry the specific entry
     * @return
     */
    private Node getNodeContaining(T anEntry) {
        Node current = firstNode;

        while(current != null) {

            // check if  current data is equal to entry
            if(current.data.equals(anEntry)) {
                return current;
            }
            current = current.next;  // hop to next node
        }

        return null;
    }

    //Removes all entries from this bag
    public void clear() {

        firstNode = null;
        numEntries = 0;
    }

    //Counts the number of times a given entry appears in this bag
    // @param anEntry - the entry to be counted
    // @return the number of times anEntry appears in the bag
    public int getFrequencyOf(T anEntry) {

        Node current = firstNode;

        int results = 0;

        //  traverse our list, adding to total if an entry is found
        while(current != null) {

            if(current.data.equals(anEntry)) {
                results++;  // if found add one to results
            }

            current = current.next;
        }

        return results;
    }

    //Tests whether this bag contains a given entry
    // @param anEntry - the entry to find
    // @return TRUE if the bag contains anEntry, FALSE otherwise
    public boolean contains(T anEntry) {

        Node p = getNodeContaining(anEntry);

        return p != null;
    }


}
