package com.datastructure;

import java.util.ArrayList;

public class HashMap<K, V> implements Map{
	
	ArrayList<HashNode<K, V>> bucket;
	
	int bucketSize;
	
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
		return false;
	}

	@Override
	public void add(Object k, Object v) {
		
	}

	@Override
	public void remove(Object k) {
		
		int bucketIndex = getBucketIndex(k);
		
		HashNode<K,V> head = bucket.get(bucketIndex);
		
		while (head != null) {
			if (head.key.equals(k)) {
				return head.value;
			}
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
	public float getLoadFactor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBucketIndex(Object k) {
		int h;
		int hash = (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
		int index = (bucketSize - 1) & hash;
		return index;
	}

}
