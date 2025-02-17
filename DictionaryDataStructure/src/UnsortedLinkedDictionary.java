
/**
 * UnsortedLinkedDictionary.java - implementation of a linked-based unsorted Dictionary ADT
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedLinkedDictionary<K,V> implements DictionaryInterface<K,V>
{
    private Node firstNode;
    private int numberOfEntries;

    public UnsortedLinkedDictionary()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    private class Node
    {
        private K key;
        private V value;
        private Node next;

        private Node (K theKey, V theValue)
        {
            key = theKey;
            value = theValue;
            next = null;
        }

        private K getKey()
        {
            return key;
        }

        private V getValue()
        {
            return value;
        }

        private void setValue(V newValue)
        {
            value = newValue;
        }
    }

    //DictionaryInterface methods

    /** Adds a new entry for the given key, value if key is not already present.
     *  If key is already in the dictionary, replaces entry's value with the new value
     *  @param key      A search key object for the new entry
     *  @param value    A value object for the new entry
     *  @return         Either NULL if new entry was added; or the replaced value
     *                   if the key already exists
     */
    public V add(K key, V value)
    {
        //confirm key and value are not null
        if ((key == null) || (value == null))
            throw new IllegalArgumentException("Null objects not permitted in this dictionary.");

        //see if key is in our dictionary
        V result = null;
        Node currentNode = firstNode;

        while ((currentNode != null) && !key.equals(currentNode.getKey()))
            currentNode = currentNode.next; // no match, keep going


        //if key not found, add as a new entry (at front)
        if (currentNode == null)
        {
            Node newNode = new Node(key, value);
            newNode.next = firstNode;
            firstNode = newNode;
            numberOfEntries++;
        } else {
            //otherwise, replace value of the node with the key
            result = currentNode.getValue();
            currentNode.setValue(value);
        }

        return result;
    }

    /** Removes the entry associated with given key, if it exists
     *  @param key      A search key object for the entry to be removed
     *  @return         Either the value associated with the key (if found), or
     *                   NULL if no such entry exists
     */
    public V remove(K key)
    {
        //confirm key is not null
        if (key==null)
            throw new IllegalArgumentException("Null objects not allowed in dictionary.");

        //check dictionary is not empty
        if (isEmpty())
            return null;

        //find node containing key (using a trail node)
        V result = null;
        Node currentNode = firstNode;
        Node nodeBefore = null;

        while ((currentNode != null) && !key.equals(currentNode.getKey()))
        {
            nodeBefore = currentNode;   //catch up the nodeBefore first...
            currentNode = currentNode.next;     //...then advance currentNode
        }

        //if node found, remove it
        if (currentNode != null)
        {
            result = currentNode.getValue();

            Node nodeAfter = currentNode.next;

            //are we removing the first Node?
            if (nodeBefore == null)
                firstNode = nodeAfter;
            else
                nodeBefore.next = nodeAfter;

            numberOfEntries--;
        }

        return result;
    }

    /** Retrieves the entry associated with given key, if it exists
     *  @param key      A search key object for the entry to be retrieved
     *  @return         Either the value associated with the key (if found), or
     *                   NULL if no such entry exists
     */
    public V getValue(K key)
    {
        //check key is not null;
        if (key == null)
            throw new IllegalArgumentException("No null objects in dictionary.");

        //look for the key
        V result = null;
        Node currentNode = firstNode;
        while ((currentNode != null) && !key.equals(currentNode.getKey()))
            currentNode = currentNode.next;

        //if found, return the value
        if (currentNode != null)
            result = currentNode.getValue();

        return result;
    }

    /** Checks to see if an entry associated with given key is in the dictionary
     *  @param key      A search key object for the entry
     *  @return         TRUE if an entry with the key is found; FALSE otherwise
     */
    public boolean contains(K key)
    {
        return (getValue(key) != null);
    }

    /** Returns an object to iterate through the keys in this dictionary
     *
     */
    public Iterator<K> getKeyIterator()
    {
        return new KeyIterator();
    }

    /** Returns an object to iterate through the values in this dictionary
     *
     */
    public Iterator<V> getValueIterator()
    {
        return new ValueIterator();
    }

    //check if empty
    public boolean isEmpty()
    {
        return (numberOfEntries == 0);
    }

    //returns the number of entries in dictionary
    public int getSize()
    {
        return numberOfEntries;
    }

    //clear out the dictionary
    public void clear()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    private class KeyIterator implements Iterator<K>
    {
        private Node currentNode;

        public KeyIterator()
        {
            currentNode = firstNode;
        }

        public boolean hasNext()
        {
            return (currentNode != null);
        }

        public K next()
        {
            K result = null;

            if (hasNext())
            {
                result = currentNode.getKey();  //grab the current Key
                currentNode = currentNode.next; //hope to next node
            } else
                throw new NoSuchElementException();

            return result;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    private class ValueIterator implements Iterator<V>
    {
        private Node currentNode;

        public ValueIterator()
        {
            currentNode = firstNode;
        }

        public boolean hasNext()
        {
            return (currentNode != null);
        }

        public V next()
        {
            V result = null;

            if (hasNext())
            {
                result = currentNode.getValue();  //grab the current Value
                currentNode = currentNode.next; //hope to next node
            } else
                throw new NoSuchElementException();

            return result;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}