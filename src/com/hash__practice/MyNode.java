package com.hash__practice;

public class MyNode<K> implements INode<K> {
	private K key;
	private INode next;

	MyNode(K key) {
		this.key = key;
		this.next = null;
	}

	@Override
	public void setNext(INode newNode) {
		this.next = newNode;
	}

	public INode getNext() {
		return next;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

}