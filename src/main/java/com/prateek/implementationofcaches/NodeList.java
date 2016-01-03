package com.prateek.implementationofcaches;

public class NodeList {

	private NodeList previous;
	private NodeList next;
	private Node node;
	
	NodeList(final NodeList previous, final NodeList next, final Node node) {
		this.next = next;
		this.previous = previous;
		this.next = next;
	}

	public NodeList getPrevious() {
		return previous;
	}

	public NodeList getNext() {
		return next;
	}

	public Node getNode() {
		return node;
	}
	
	public void setNext(final NodeList next) {
		this.next = next;
	}
	
	public void setPrevious(final NodeList previous) {
		this.previous = previous;
	}
	
}
