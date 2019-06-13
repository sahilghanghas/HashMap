package com.datastructure;

import java.util.ArrayList;

/**
 * HashMap implementation of Map interface using ArrayList and linked-list.
 * Implements methods of Map and permits all types of data, including null.
 * Additionally, rehashing when load factor crosses threshold.
 * 
 * @author Sahil Ghanghas
 * 
 * @param <K> Key
 * @param <V> Value
 */
public class HashMap<K, V> implements Map<Object, Object>{
	
	// bucket is collection (array) of chains
	ArrayList<HashNode<K, V>> bucket;
	
	// Size of the bucket
	int bucketSize;
	
	// Load Factor threshold value for rehashing
	static final double LOAD_FACTOR_THRESHOLD = 0.75;
	
	// size of the HashMap
	int size;
	
	// Default constructor
	public HashMap() {
		
		bucket = new ArrayList<>();
		bucketSize = 16;
		size = 0;
		
		// initializing chaining 
		for (int i = 0; i < bucketSize; i++) {
			bucket.add(null);
		}
	}
	
	// Parameterized constructor with custom bucket size
	public HashMap(int initialBucketSize) {
		
		bucket = new ArrayList<>();
		this.bucketSize = initialBucketSize;
		size = 0;
		
		// initializing chaining 
		for (int i = 0; i < bucketSize; i++) {
			bucket.add(null);
		}
	
	}
	
	
	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}

	@Override
	public boolean contains(Object k) {
		
		// get index corresponding to the given Key
		int bucketIndex = getBucketIndex(k);
		
		// get head of the chain corresponding to the index
		HashNode<K,V> head = bucket.get(bucketIndex);
		
		// find the HashNode corresponding to the given Key
		while (head != null) {
			if (head.key.equals(k)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(Object k, Object v) {
		
		// get index corresponding to the given Key
		int bucketIndex = getBucketIndex(k);
		
		// get head of the chain corresponding to the index
		HashNode<K,V> head = bucket.get(bucketIndex);
		
		// find the HashNode corresponding to the given Key
		while (head != null) {
			
			if (head.key.equals(k)) {
				// insert value for the Key "k"
				head.value = (V) v;
				return;
			}
			
			head = head.next;
		}
		// increase size of the hash map
		size++;
		
		head = bucket.get(bucketIndex);
		
		HashNode<K, V> newHashNode = new HashNode<K, V>((K)k, (V)v);
		newHashNode.next = head;
		bucket.set(bucketIndex, newHashNode);
		
		// increase bucket size if load factor is achieved
		if(getLoadFactor() >= LOAD_FACTOR_THRESHOLD) {
			// rehashing
			reconfigureBucket();
		
		}
	}
	
	/**
	 *  rehashing bucket as load factor crosses threshold
	 */
	private void reconfigureBucket() {
		
		// create a temporary bucket and clone the current bucket 
		ArrayList<HashNode<K,V>> tempBucket = bucket;
		
		// create new bucket array
		bucket = new ArrayList<>();
		
		// expand bucket size by 2 times
		bucketSize = 2 * bucketSize;
		
		// initialize size to 0
		size = 0;
		
		// initialize chaining
		for (int i = 0; i < bucketSize; i++) {
			bucket.add(null);
		}
		
		// add elements into new bucket
		for (HashNode<K,V> node: tempBucket) {
			
			while (node != null) {
				
				add(node.key, node.value);
				node = node.next;
				
			}
		}
	}

	@Override
	public void remove(Object k) {
		
		// get index corresponding to the given Key
		int bucketIndex = getBucketIndex(k);
		
		// get head of the chain corresponding to the index
		HashNode<K,V> head = bucket.get(bucketIndex);
		
		while (head != null) {
			
			// break when key-value pair is found
			if (head.key.equals(k)) {
				break;
			}
			
			head = head.next;
		}
		// reduce the size of the hash map
		size--;
		
		if(head.prev != null) {
			// removes the node 
			HashNode<K, V> prev = head.prev;
	        HashNode<K, V> next = head.next;
	        
	        prev.next = next;
	        next.prev = prev;
	        
		} else {
			
			bucket.set(bucketIndex, head.next);
			
		}
		
	}

	@Override
	public Object get(Object k) {
		
		// get index corresponding to the given Key
		int bucketIndex = getBucketIndex(k);
		
		// get head of the chain corresponding to the index
		HashNode<K,V> head = bucket.get(bucketIndex);
		
		while (head != null) {
			// return of value is found
			if (head.key.equals(k)) {
				return head.value;
			}
			head = head.next;
		}
		return null;		
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public double getLoadFactor() {
		return size / bucketSize;
	}
	
	/**
	 * Calculates index using hash value and the given Key 
	 * 
	 * @param k Key
	 * @return bucket index
	 */
	private int getBucketIndex(Object k) {
		int h;
		// calculate the hash value for the given Key
		int hash = (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
		int index = (bucketSize - 1) & hash;
		return index;
	}
}
