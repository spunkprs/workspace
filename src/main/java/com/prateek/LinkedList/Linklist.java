package com.prateek.LinkedList;

import java.util.List;

import com.google.common.collect.Lists;

public class Linklist {
	
	private Node head;
	private Node headOne;
	private int nodeCounter = 1;
	private int lengthOfList = 0;
	private int counter = 0;
	private List<Node> currentList = Lists.newArrayList();
	private List<Node> previousList = Lists.newArrayList();

	public Node reverseLinkListRecursiveApproach(final Node node) {
		if (node.getNext() != null) {
			reverseLinkList(null, node);
			return head;
		}
		return node;
	}
	
	public int getLengthOfLinkList(final Node node) {
		if (node == null) {
			return 0;
		} else {
			return getLengthOfList(node);
		}
	}
	
	private int getLengthOfList(final Node node) {
		if (node != null) {
			++lengthOfList;
			getLengthOfList(node.getNext());
		}
		return lengthOfList;
	}

	public Node groupWiseReversal(Node node, final int numberOfNodesInGroup) {
		int lengthOfList = getLengthOfLinkList(node);
		
		if (numberOfNodesInGroup != lengthOfList && numberOfNodesInGroup >= 2) {
			headOne = node;
			while(headOne != null && (lengthOfList - counter) >= numberOfNodesInGroup) {
				addToPreviousList(node);
				reverse(null, node, numberOfNodesInGroup);
				node = headOne;
				nodeCounter = 1;
			}
			prepareReversedList();
			counter = 1;
			return head;
		} 
		return reverseLinkListRecursiveApproach(node);
	}

	private void prepareReversedList() {
		head = currentList.get(0);
		Node node = previousList.get(0);
		for (int i = 1; i < previousList.size(); i++) {
				 node.setNext(currentList.get(i));
				 node = previousList.get(i);
		}
		previousList.get(previousList.size() - 1).setNext(headOne);
	}

	private void reverse(final Node previous, final Node current, final int numberOfNodesInGroup) {
		if (current != null && nodeCounter != numberOfNodesInGroup) {
			nodeCounter++;
			counter++;
			reverse(current, current.getNext(), numberOfNodesInGroup);
			current.setNext(previous);
		} else if (nodeCounter == numberOfNodesInGroup) {
			counter++;
			headOne = current.getNext();
			current.setNext(previous);
			addToCurrentList(current);
		}
	}

	private void addToCurrentList(final Node current) {
		currentList.add(current);
	}
	
	private void addToPreviousList(final Node previous) {
		previousList.add(previous);
	}

	private void reverseLinkList(final Node previous, final Node current) {
		if (current != null) {
			reverseLinkList(current, current.getNext());
			current.setNext(previous);
			if (previous == null) {
				current.setNext(null);
			}
		} else {
			head = previous;
		}
	}
}
