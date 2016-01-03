package com.prateek.reversestackusingrecursion;

public class Node {
	
private int value;
private Node next;

public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public Node getNext() {
	return next;
}
public void setNext(Node next) {
	this.next = next;
}

public Node pushOperation(final int data) {
	Node newNode = create();
	newNode.setValue(data);
	newNode.setNext(this);
	return newNode;
}

public Node popOperation() {
	return this.getNext();
}

public static Node create() {
	return new Node();
}

public int size() {
	int count = 1;
	Node n = this;
	while(n != null) {
		++count;
		n = n.getNext();
	}
	return count;
}

}
