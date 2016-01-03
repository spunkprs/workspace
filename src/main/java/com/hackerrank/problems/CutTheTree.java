package com.hackerrank.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CutTheTree {

	private static Node[] nodes;
	private static Node rootNode;
	public static void main(final String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
		
		process(input);
		
		while((input = br.readLine()) != null) {
			final String pos[] = input.split(" ");
			final int parent = Integer.parseInt(pos[0]);
			final int child = Integer.parseInt(pos[1]);
			buildTree(parent, child);
		}
	}
	
	private static void buildTree(final int parent, final int child) {
		Node parentNode = nodes[parent - 1];
		Node childNode = nodes[child - 1];
		
		if (parent - 1 == 0) {
			rootNode = parentNode;
		}
		
		if (parentNode.getParent() == null && childNode.getParent() != null) {
			final Node temp = parentNode;
			parentNode = childNode;
			childNode = temp;
		}
		
		if (parentNode.getLeft() == null && parentNode.getRight() == null) {
			setChildAndParent(parentNode, childNode);
		} else if (parentNode.getLeft() == null && parentNode.getRight() != null) {
			setChildAndParent(parentNode, childNode);
		} else {
			setChildAndParent(parentNode, childNode);
		}
	}

	private static void setChildAndParent(final Node parentNode, final Node childNode) {
		if (parentNode.getLeft() == null) {
			parentNode.setLeft(childNode);
		} else {
			parentNode.setRight(childNode);
		}
		childNode.setParent(parentNode);
	}
	
	private static void process(final String input) {
		final String vertices[] = input.split(" ");
		nodes = new Node[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			nodes[i] = new Node(Integer.parseInt(vertices[i]));
		}
	}

     static class Node {
		int value;
		Node parent;
		Node left;
		Node right;
		
		 private Node(final int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
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
		
		public void setParent(final Node parent) {
			this.parent = parent;
		}
		
		public Node getParent() {
			return this.parent;
		}
	}
}
