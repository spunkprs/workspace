package com.prateek.LinkedList;

import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class LinkedListTest {
	
	private Linklist unit;
	
	@Before
	public void setUp() {
		unit = new Linklist();
	}
	
	@Test
	public void shouldReverseLinkedListWhenNumberOfNodesInListAreMoreThanTwo() {
		//Set Up
		int limit = 5;
		final Node head = new Node(1);
		createLinkedList(head, limit);
		final Node headOne = new Node(limit);
		createReverseLinkedList(headOne, 1);
		
		//Execute
		final Node reversedNode = unit.reverseLinkListRecursiveApproach(head);
		
		//Verify
		verify(headOne, reversedNode);
	}

	@Test
	public void shouldReverseLinkedListWhenNumberOfNodesInListAreTwo() {
		//Set Up
		int limit = 2;
		final Node head = new Node(1);
		createLinkedList(head, limit);
		final Node headOne = new Node(limit);
		createReverseLinkedList(headOne, 1);
		
		//Execute
		final Node reversedNode = unit.reverseLinkListRecursiveApproach(head);
		
		//Verify
		verify(headOne, reversedNode);
	}
	
	@Test
	public void shouldPerformGroupWiseReversalWhenNumberOfNodesInGroupIsThreeCaseOne() {
		//Set Up
		Node head = new Node(1);
		createLinkedList(head, 8);
		final List<Integer> expectedListOfValues = Lists.newArrayList(3, 2, 1, 6, 5, 4, 7, 8);
		
		//Execute
		head = unit.groupWiseReversal(head, 3);
		//Verify
		verify(head, expectedListOfValues);
	}
	
	private void verify(final Node head, final List<Integer> expectedListOfValues) {
		Node n = head;
		for (int i = 0; i < expectedListOfValues.size(); i++) {
			Assert.assertEquals(expectedListOfValues.get(i).intValue(), n.getValue());
			n = n.getNext();
		}
	}

	@Test
	public void shouldPerformGroupWiseReversalWhenNumberOfNodesInGroupIsThreeCaseTwo() {
		//Set Up
		Node head = new Node(1);
		createLinkedList(head, 9);
		final List<Integer> expectedListOfValues = Lists.newArrayList(3, 2, 1, 6, 5, 4, 9, 8, 7);
		
		//Execute
		head = unit.groupWiseReversal(head, 3);
		
		//Verify
		verify(head, expectedListOfValues);
	}
	
	@Test
	public void shouldPerformGroupWiseReversalWhenNumberOfNodesInGroupIsTwoCaseOne() {
		//Set Up
		Node head = new Node(1);
		createLinkedList(head, 5);
		final List<Integer> expectedListOfValues = Lists.newArrayList(2, 1, 4, 3, 5);
		
		//Execute
		head = unit.groupWiseReversal(head, 2);
		
		//Verify
		verify(head, expectedListOfValues);
	}
	
	@Test
	public void shouldPerformGroupWiseReversalWhenNumberOfNodesInGroupIsTwoCaseTwo() {
		//Set Up
		Node head = new Node(1);
		createLinkedList(head, 4);
		final List<Integer> expectedListOfValues = Lists.newArrayList(2, 1, 4, 3);
		
		//Execute
		head = unit.groupWiseReversal(head, 2);
		
		//Verify
		verify(head, expectedListOfValues);
	}
	
	@Test
	public void shouldPerformGroupWiseReversalWhenNumberOfNodesInGroupIsEqualToLengthOfList() {
		//Set Up
		Node head = new Node(1);
		createLinkedList(head, 4);
		final List<Integer> expectedListOfValues = Lists.newArrayList(4, 3, 2, 1);
				
		//Execute
		head = unit.groupWiseReversal(head, 4);
				
		//Verify
		verify(head, expectedListOfValues);
	}
	
	@Test
	public void shouldReverseLinkedListWhenNumberOfNodesInListIsOne() {
		int limit = 1;
		final Node head = new Node(1);
		createLinkedList(head, limit);
		final Node headOne = new Node(limit);
		createReverseLinkedList(headOne, 1);
		
		//Execute
		final Node reversedNode = unit.reverseLinkListRecursiveApproach(head);
		
		//Verify
		verify(headOne, reversedNode);
	}

	@Test
	public void shouldGetLengthOfList() {
		int limit = 5;
		final Node head = new Node(1);
		createLinkedList(head, limit);
		
		Assert.assertEquals(limit, unit.getLengthOfLinkList(head));
	}
	
	@Test
	public void shouldGetLengthOfListForEmptyList() {
		final Node head = null;
		Assert.assertEquals(0, unit.getLengthOfLinkList(head));
	}

	private void verify(final Node nodeOne, final Node nodeTwo) {
		Node headOne = nodeOne;
		Node headTwo = nodeTwo;
		
		while(headOne != null && headTwo != null) {
			Assert.assertEquals(headOne.getValue(), headTwo.getValue());
			headOne = headOne.getNext();
			headTwo = headTwo.getNext();
		}
	}

	private void createReverseLinkedList(final Node node, int limit) {
		if (limit != node.getValue()) {
			int counter = node.getValue() - 1;
			final Node n = new Node(counter);
			node.setNext(n);
			createReverseLinkedList(n, limit);
		} else {
			node.setNext(null);
		}
	}

	private void createLinkedList(final Node node, final int limit) {
		if (limit != node.getValue()) {
			int counter = node.getValue() + 1;
			final Node n = new Node(counter);
			node.setNext(n);
			createLinkedList(n, limit);
		} else {
			node.setNext(null);
		}
	}
}
