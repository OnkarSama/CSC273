
/**
 * DictionaryInterface.java - implementation of the Dictionary ADT
 */

import java.util.Iterator;

public interface DictionaryInterface<K, V> {

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
    public V add(K key, V value);

    /**
     * Removes the entry associated with given key, if it exists
     *
     * @param key A search key object for the entry to be removed
     *
     * @return Either the value associated with the key (if found), or
     * NULL if no such entry exists
     */
    public V remove(K key);

    /**
     * Retrieves the entry associated with given key, if it exists
     *
     * @param key A search key object for the entry to be retrieved
     *
     * @return Either the value associated with the key (if found), or
     * NULL if no such entry exists
     */
    public V getValue(K key);

    /**
     * Checks to see if an entry associated with given key is in the dictionary
     *
     * @param key A search key object for the entry
     *
     * @return TRUE if an entry with the key is found; FALSE otherwise
     */
    public boolean contains(K key);

    /**
     * Returns an object to iterate through the keys in this dictionary
     */
    public Iterator<K> getKeyIterator();

    /**
     * Returns an object to iterate through the values in this dictionary
     */
    public Iterator<V> getValueIterator();

    //check if empty
    public boolean isEmpty();

    //returns the number of entries in dictionary
    public int getSize();

    //clear out the dictionary
    public void clear();

}