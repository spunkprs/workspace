package com.prateek.BinarySearchTree;

public class Node {

	private int element;
    private Node left;
    private Node right;

    public Node(final int element) {
    	this.element = element;
    }

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getElement() {
		return element;
	}
	
	public boolean equals(final Object obj) {
		final Node node = (Node)obj;
		if (node.getElement() == this.getElement())
		return true;
		else 
		return false;	
	}
	
	public int hashCode() {
		return this.getElement();
	}
}
