
/**
 * SortedArrayDictionary.java - array-based implementation of a sorted dictionary
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedArrayDictionary<K extends Comparable<? super K>, V>
        implements DictionaryInterface<K, V> {

    //declare our properties
    private Entry<K, V>[] dictionary;            //the array holding our entries
    private int numberOfEntries;   //number of entries currently in our dictionary
    private final static int DEFAULT_CAPACITY = 25;
    private final static int MAX_CAPACITY = 1000;       //maximum allowable size
    private boolean integrityOK;    //flag value to signal data is not corrupt

    //define our constructors

    //default constructor
    public SortedArrayDictionary() {

        this(DEFAULT_CAPACITY);
    }

    //parameterized constructor
    public SortedArrayDictionary(int capacity) {

        integrityOK = false;

        if(capacity <= 0) {
            dictionary = new Entry[DEFAULT_CAPACITY];   // capacity too small, use default value
        } else {
            checkCapacity(capacity);
            dictionary = new Entry[capacity];   // capacity is good
        }

        numberOfEntries = 0;
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
            throw new IllegalStateException("Attempted to create a dictionary that exceeds max capacity.");
    }

    //ensureCapacity() -- helper method to double capacity of array when full (if allowed)
    private void ensureCapacity() {

        int capacity = dictionary.length;

        //check if array is full
        if(numberOfEntries >= capacity) {

            int newCapacity = capacity * 2;

            checkCapacity(newCapacity);

            //copy contents into new array using copyOf
            dictionary = Arrays.copyOf(dictionary, newCapacity + 1);
        }
    }

    //DictionaryInterface methods

    /**
     * Adds a new entry for the given key, value if key is not already present.
     * If key is already in the dictionary, replaces entry's value with the new value
     *
     * @param key   A search key object for the new entry
     * @param value A value object for the new entry
     *
     * @return Either NULL if new entry was added; or the replaced value
     * if the key already exists
     */
    public V add(K key, V value) {

        checkIntegrity();
        //make sure key and value are not null
        if((key == null) || (value == null))
            throw new IllegalArgumentException("Cannot add null to this dictionary.");

        //find the index containing the key (if it exists) OR where it should go (if it does not)
        int keyIndex = locateIndex(key);

        V result = null;

        //if key is already present, replace the entry
        if((keyIndex < numberOfEntries) && key.equals(dictionary[keyIndex].getKey())) {
            result = dictionary[keyIndex].getValue();   //save result
            dictionary[keyIndex].setValue(value);       //replace value of the entry
        } else {
            //if the key is not present, create a new entry
            makeRoom(keyIndex);

            dictionary[keyIndex] = new Entry<>(key, value);
            numberOfEntries++;
            ensureCapacity();
        }

        //result is either the replaced value or null if new entry
        return result;
    }

    //helper method to locate the index of the entry with the given key
    // or returns the index where the key should be found if no such entry is found
    private int locateIndex(K key) {

        int index = 0;

        while((index < numberOfEntries) && (key.compareTo(dictionary[index].getKey()) > 0))
            index++;

        return index;
    }

    //helper method to make room for a new entry at a given index by shifting entries
    //  towards the back of the array
    //Pre-condition:  keyIndex is valid; list length is the old length before adding
    private void makeRoom(int keyIndex) {
        //start at the back
        for(int index = numberOfEntries - 1; index >= keyIndex; index--) {
            dictionary[index + 1] = dictionary[index];
        }
    }

    /**
     * Removes the entry associated with given key, if it exists
     *
     * @param key A search key object for the entry to be removed
     *
     * @return Either the value associated with the key (if found), or
     * NULL if no such entry exists
     */
    public V remove(K key) {

        checkIntegrity();
        //make sure key is not null
        if(key == null)
            throw new IllegalArgumentException("Can't have null keys in dictionary.");

        //find index of entry containing key
        int keyIndex = locateIndex(key);
        V result = null;

        //if entry exists... remove it
        if((keyIndex < numberOfEntries) && (key.equals(dictionary[keyIndex].getKey()))) {
            result = dictionary[keyIndex].getValue();

            //call helper method to remove the entry and close up the gap
            removeArrayEntry(keyIndex);

            numberOfEntries--;
        }

        //result is either the removed value or null (if not found)
        return result;
    }

    //helper method to remove an entry at a given index by shifting array
    // entries to the left towards the entry to be removed
    private void removeArrayEntry(int keyIndex) {

        for(int fromIndex = keyIndex + 1; fromIndex < numberOfEntries; fromIndex++) {
            dictionary[fromIndex - 1] = dictionary[fromIndex];
        }

        //delete the last spot
        dictionary[numberOfEntries - 1] = null;
    }

    /**
     * Retrieves the entry associated with given key, if it exists
     *
     * @param key A search key object for the entry to be retrieved
     *
     * @return Either the value associated with the key (if found), or
     * NULL if no such entry exists
     */
    public V getValue(K key) {

        checkIntegrity();
        //make sure key is not null
        if(key == null)
            throw new IllegalArgumentException("Can't have null keys in dictionary.");

        //find index of entry containing key
        int keyIndex = locateIndex(key);
        V result = null;

        //if entry exists... remove it
        if((keyIndex < numberOfEntries) && key.equals(dictionary[keyIndex].getKey())) {
            result = dictionary[keyIndex].getValue();

        }

        //result is either the removed value or null (if not found)
        return result;
    }

    /**
     * Checks to see if an entry associated with given key is in the dictionary
     *
     * @param key A search key object for the entry
     *
     * @return TRUE if an entry with the key is found; FALSE otherwise
     */
    public boolean contains(K key) {
        //return (locateIndex(key) < numberOfEntries);

        return (getValue(key) != null);
    }

    /**
     * Returns an object to iterate through the keys in this dictionary
     */
    public Iterator<K> getKeyIterator() {

        return new KeyIterator();
    }

    /**
     * Returns an object to iterate through the values in this dictionary
     */
    public Iterator<V> getValueIterator() {

        return new ValueIterator();
    }

    //check if empty
    public boolean isEmpty() {

        return (numberOfEntries == 0);
    }

    //returns the number of entries in dictionary
    public int getSize() {

        return numberOfEntries;
    }

    //clear out the dictionary
    public void clear() {

        for(int index = 0; index < numberOfEntries; index++)
            dictionary[index] = null;

        numberOfEntries = 0;
    }

    private class Entry<K, V> {

        private K key;
        private V value;

        private Entry(K theKey, V theValue) {

            key = theKey;
            value = theValue;
        }

        private K getKey() {

            return key;
        }

        private V getValue() {

            return value;
        }

        private void setValue(V newValue) {

            value = newValue;
        }

    }

    private class KeyIterator implements Iterator<K> {

        private int currentIndex;

        public KeyIterator() {

            currentIndex = 0;
        }

        //hasNext() - tells us whether there is a next key to get
        public boolean hasNext() {

            return (currentIndex < numberOfEntries);
        }

        //next() - return the next Key in our dictionary AND advance cursor to next entry
        public K next() {

            K result = null;
            if(hasNext()) {
                Entry<K, V> currentEntry = dictionary[currentIndex];
                result = currentEntry.getKey();
                currentIndex++;
            } else
                throw new NoSuchElementException();

            return result;
        }

        //remove() is disabled
        public void remove() {

            throw new UnsupportedOperationException();
        }

    }

    private class ValueIterator implements Iterator<V> {

        private int currentIndex;

        public ValueIterator() {

            currentIndex = 0;
        }

        //hasNext() - tells us whether there is a next key to get
        public boolean hasNext() {

            return (currentIndex < numberOfEntries);
        }

        //next() - return the next Value in our dictionary AND advance cursor to next entry
        public V next() {

            V result = null;
            if(hasNext()) {
                Entry<K, V> currentEntry = dictionary[currentIndex];
                result = currentEntry.getValue();
                currentIndex++;
            } else
                throw new NoSuchElementException();

            return result;
        }

        //remove() is disabled
        public void remove() {

            throw new UnsupportedOperationException();
        }

    }

}