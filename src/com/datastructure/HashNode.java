package com.datastructure;

public class HashNode<K, V> {
	
	K key;
	V value;
	
	HashNode<K,V> next;
	HashNode<K,V> prev;
	
	public HashNode(K k, V v) {
		
		this.key = k;
		this.value = v;
	
	}
}
