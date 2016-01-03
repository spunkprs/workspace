package com.prateek.reversestackusingrecursion;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class ReverseStackUsingRecursionTest {
	
	private ReverseStackUsingRecursion unit;
	private Node testNode;
	
	@Before
	public void setUp() {
		unit = new ReverseStackUsingRecursion();
		testNode = Node.create();
		testNode.setValue(3);
		testNode = testNode.pushOperation(2);
		testNode = testNode.pushOperation(1);
	}

	@Test
	public void shouldGetReversedStack() {
		Assert.assertEquals(testNode.size(), unit.reverseStackUsingRecursion(testNode).size());
		verifyElements(testNode, unit.reverseStackUsingRecursion(unit.reverseStackUsingRecursion(testNode)));
	}

	private void verifyElements(Node expectedStack, Node resultStack) {
		Node n = expectedStack;
		Node n1 = resultStack;
		while (n != null && n1 != null) {
			Assert.assertEquals(n.getValue(), n1.getValue());
			n = n.getNext();
			n1 = n1.getNext();
		}
	}
}
