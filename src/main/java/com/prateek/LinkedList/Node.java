package com.prateek.LinkedList;

public class Node {

	private int value;
	private Node next;
	
	public Node(final int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public Node getNext() {
		return next;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
