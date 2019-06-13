package com.datastructure;

/**
 * Interpretation: A HashMap represents a sequence of 
 * key-value data structure, with operations analogous
 * to those which are used in built java HashMap 
 */
public interface Map<K, V> {
	
	// Is this HashMap empty?
	boolean isEmpty();
	
	// Does this HashMap contains this Key
	boolean contains(K k);
	
	// insert an element into map
	void add(K k, V v);
	
	// delete an element from the map
	void remove(K k);
	
	// returns a value corresponding to the given key
	V get(K k);
	
	// returns size of the map
	int getSize();
	
	// returns the load factor of the HashMap
	float getLoadFactor();
	
	// returns an index
	int getBucketIndex(K k);
}
