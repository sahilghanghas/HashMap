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
	
	// 
	void add(K k, V v);
	
	// 
	void remove(K k);
	
	// 
	V get(K k);
	
	// 
	int getSize();
	
	// 
	float getLoadFactor();
	
	int getBucketIndex(K k);
}
