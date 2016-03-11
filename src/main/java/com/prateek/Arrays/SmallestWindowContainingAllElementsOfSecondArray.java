package com.prateek.Arrays;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingAllElementsOfSecondArray {
	
	private Map<Integer, Node> map = new HashMap<Integer, Node>();
	private DoublyLinkList doublyLinkList = new DoublyLinkList();
	private Pair pair = new Pair(0, 0);
	
	public Pair getSmallestWindowFromFirstArrayContainingAllElementsOfSecondArray(final int arrOne[], final int arrTwo[]) {
		final int bufferSize = arrTwo.length;
		populateArrayTwoElementsIntoMap(arrTwo);
		processWindow(arrOne, arrTwo, bufferSize);
		return pair;
	}
	
	private void populateArrayTwoElementsIntoMap(final int[] arrTwo) {
		for (int i = 0; i < arrTwo.length; i++) {
			map.put(arrTwo[i], null);
		}
	}

	private void processWindow(final int[] arrOne, final int[] arrTwo, final int bufferSize) {
		int windowSize = 0;
		for (int i = 0; i < arrOne.length; i++) {
			if (map.containsKey(arrOne[i]) && map.get(arrOne[i]) == null) {
				final Node node = createNode(arrOne[i], i);
				windowSize++;
				map.put(arrOne[i], node);
				computeWindowStartAndEndIndex(windowSize, arrTwo.length, doublyLinkList.getHead(), doublyLinkList.getTail());
			} else if (map.containsKey(arrOne[i]) && map.get(arrOne[i]) != null) {
				final Node node = map.get(arrOne[i]);
				node.setIndex(i);
				adjustNode(node);
				computeWindowStartAndEndIndex(windowSize, arrTwo.length, doublyLinkList.getHead(), doublyLinkList.getTail());
			}
		}
	}

	private void adjustNode(final Node node) {
		final Node head = doublyLinkList.getHead();
		final Node tail = doublyLinkList.getTail();
		
		if (head == node) {
			doublyLinkList.setHead(node.getNext());
			addAtTheTail(node, tail);
		} else if (node != tail) {
			final Node nextNode = node.getNext();
			final Node previousNode = node.getPrevious();
			previousNode.setNext(nextNode);
			nextNode.setPrevious(previousNode);
			addAtTheTail(node, tail);
		}
	}
	
	private void addAtTheTail(final Node node, final Node tail) {
		tail.setNext(node);
		node.setPrevious(tail);
		node.setNext(null);
		doublyLinkList.setTail(node);
	}

	private void computeWindowStartAndEndIndex(final int windowSize, final int length, final Node head, final Node tail) {
		if (windowSize == length) {
			if (pair.getFirst() == 0 && pair.getSecond() == 0) {
				pair.setFirst(head.index);
				pair.setSecond(tail.index);
			} else {
				int diff = pair.getSecond() - pair.getFirst();
				if ((tail.index - head.index) < diff) {
					pair.setFirst(head.index);
					pair.setSecond(tail.index);
				}
			}
		}
	}

	private Node createNode(int value, int index) {
		final Node head = doublyLinkList.getHead();
		final Node tail = doublyLinkList.getTail();
		Node node = null;
		if (head == null && tail == null) {
			 node = new Node(value, index, head, tail);
			doublyLinkList.setHead(node);
			doublyLinkList.setTail(node);
		} 
		if (tail != null) {
			node = new Node(value, index, tail, null);
			tail.setNext(node);
			doublyLinkList.setTail(node);
		}
		return node;
	}

	class DoublyLinkList {
		private Node head;
		private Node tail;
		
		Node getHead() {
			return this.head;
		}
		
		Node getTail() {
			return this.tail;
		}

		void setHead(Node head) {
			this.head = head;
		}

		void setTail(Node tail) {
			this.tail = tail;
		}
	}
	
	class Node {
		private Node next;
		private Node previous;
		private int value;
		private int index;
		
		Node(final int value, final int index, final Node previous, final Node next) {
			this.index = index;
			this.value = value;
			this.previous = previous;
			this.next = next;
		}

		public Node getNext() {
			return next;
		}

		public Node getPrevious() {
			return previous;
		}

		public int getIndex() {
			return index;
		}

		public void setNext(final Node next) {
			this.next = next;
		}
		
		public void setPrevious(final Node previous) {
			this.previous = previous;
		}

		public void setIndex(final int index) {
			this.index = index;
		}
	}
}
