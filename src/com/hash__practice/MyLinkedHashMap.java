package com.hash__practice;

import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {
	private final int numBuckets;
	ArrayList<MyLinkedList<K>> myBucketArray;

	public MyLinkedHashMap() {
		this.numBuckets = 10;
		this.myBucketArray = new ArrayList<>(numBuckets);
		for (int i = 0; i < numBuckets; i++) {
			this.myBucketArray.add(null);
		}
	}

	public V get(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			return null;
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	private int getBucketIndex(K key) {
		// TODO Auto-generated method stub
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numBuckets;
		System.out.println("Key : " + " hashcode : " + hashCode + " index : " + index);
		return index;
	}

	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			myLinkedList = new MyLinkedList<>();
			this.myBucketArray.set(index, myLinkedList);
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<>(key, value);
			myLinkedList.append(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	@Override
	public String toString() {
		return "MyLinkedHashMapList { " + myBucketArray + " } ";
	}

	public boolean delete(K key) {
		// TODO Auto-generated method stub
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			System.out.println("This word already doesn't exist");
			return true;
		} else {
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.searchForDeletion(key);
			if (myMapNode == null) {
				return true;
			} else {
				MyMapNode<K, V> previousMapNode = (MyMapNode<K, V>) myLinkedList.head;
				if (previousMapNode == myMapNode) {
					myLinkedList.head = null;
					return true;
				} else {
					while (previousMapNode.getNext() != myMapNode) {
						previousMapNode = (MyMapNode<K, V>) previousMapNode.getNext();
					}
					if (myLinkedList.tail == myMapNode) {
						myLinkedList.tail = previousMapNode;
						myMapNode.setKey(null);
						myMapNode.setValue(null);
						return true;
					} else {
						previousMapNode.setNext(myMapNode.getNext());
						myMapNode = null;
						return true;
					}
				}
			}
		}
	}
}
