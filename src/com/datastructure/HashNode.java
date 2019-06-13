package com.datastructure;

/**
 * Implementation of hash node of a doubly linked list
 * with Key and Value
 * 
 * @author Sahil Ghanghas
 *
 * @param <K> Key
 * @param <V> Value
 */
public class HashNode<K, V> {
	
	K key;
	V value;
	
	HashNode<K,V> next;
	HashNode<K,V> prev;
	
	// constructor 
	public HashNode(K k, V v) {
		
		this.key = k;
		this.value = v;
	
	}
}
