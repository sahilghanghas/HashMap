package com.datastructure;

/**
 * Interpretation: A HashMap represents a sequence of 
 * key-value data structure, with operations analogous
 * to those which are used in built java HashMap 
 */
public interface Map<K, V> {
	
	/**
	 * 
	 * @return true if HashMap is empty
	 */
	boolean isEmpty();
	
	/**
	 * Does this HashMap contains this Key
	 * @param k key
	 * @return true if the key is present in HashMap
	 */
	boolean contains(K k);
	
	/**
	 * Append's a key-value pair in HashMap
	 * @param k key to be inserted into HashMap
	 * @param v value to be inserted into HashMap
	 */
	void add(K k, V v);
	
	/**
	 * Remove's the element corresponding to the key 
	 * @param k key
	 */
	void remove(K k);
	
	/**
	 *  
	 * @param k Key
	 * @return value corresponding to the Key
	 */
	V get(K k);
	
	/**
	 * Size of the HashMap 
	 * @return integer
	 */
	int getSize();
	
	/**
	 * Load Factor of the HashMap 
	 * @return double value
	 */
	double getLoadFactor();
	
	/**
	 * Removes all the mappings from the HashMap
	 */
	void clear();
	
}
