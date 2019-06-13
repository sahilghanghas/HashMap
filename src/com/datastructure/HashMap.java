package com.datastructure;

import java.util.ArrayList;

public class HashMap<K, V> implements Map{
	
	ArrayList<HashNode<K, V>> bucket;
	
	int bucketSize;
	static final double LOAD_FACTOR_THRESHOLD = 0.75;
	int size;
	
	
	public HashMap() {
		
		bucket = new ArrayList<>();
		bucketSize = 16;
		size = 0;
		
	}
	
	public HashMap(int initialBucketSize) {
		
		bucket = new ArrayList<>();
		this.bucketSize = initialBucketSize;
		size = 0;
		
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
		int bucketIndex = getBucketIndex(k);
		
		HashNode<K,V> head = bucket.get(bucketIndex);
		
		while (head != null) {
			if (head.key.equals(k)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	@Override
	public void add(Object k, Object v) {
		
		int bucketIndex = getBucketIndex(k);
		
		HashNode<K,V> head = bucket.get(bucketIndex);
		
		while (head != null) {
			
			if (head.key.equals(k)) {
				head.value = (V) v;
				return;
			}
			
			head = head.next;
		}
		
		size++;
		head = bucket.get(bucketIndex);
		HashNode<K, V> newHashNode = new HashNode<K, V>((K)k, (V)v);
		newHashNode.next = head;
		bucket.set(bucketIndex, newHashNode);
		
		// increase bucket size if load factor is achieved
		if(getLoadFactor() >= LOAD_FACTOR_THRESHOLD) {
			
			reconfigureBucket();
		
		}
	}
	
	// reconfigure bucket when load factor crosses threshold
	private void reconfigureBucket() {
		
		ArrayList<HashNode<K,V>> tempBucket = bucket;
		bucket = new ArrayList<>();
		
		bucketSize = 2 * bucketSize;
		size = 0;
		
		for (int i = 0; i < bucketSize; i++) {
			bucket.add(null);
		}
		
		for (HashNode<K,V> node: tempBucket) {
			
			while (node != null) {
				
				add(node.key, node.value);
				node = node.next;
				
			}
		}
	}

	@Override
	public void remove(Object k) {
		
		int bucketIndex = getBucketIndex(k);
		
		HashNode<K,V> head = bucket.get(bucketIndex);
		
		while (head != null) {
			
			if (head.key.equals(k)) {
				break;
			}
			
			head = head.next;
		}
		
		size--;
		
		if(head.prev != null) {
			
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
		
		int bucketIndex = getBucketIndex(k);
		
		HashNode<K,V> head = bucket.get(bucketIndex);
		
		while (head != null) {
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

	private int getBucketIndex(Object k) {
		int h;
		int hash = (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
		int index = (bucketSize - 1) & hash;
		return index;
	}

}
