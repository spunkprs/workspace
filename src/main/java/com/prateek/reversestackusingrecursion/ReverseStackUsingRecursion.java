package com.prateek.reversestackusingrecursion;

public class ReverseStackUsingRecursion {

	private Node helperNode;
	public Node reverseStackUsingRecursion(final Node node) {
		return reverseStack(node, 0);
	}

	private Node reverseStack(final Node node, int count) {
		if (count == 0) {
			helperNode = Node.create();
			helperNode.setValue(node.getValue());
		} else {
			helperNode = pushReversedEntriesInAnotherStack(helperNode, node.getValue());
		}
		
		if (null != node.getNext()) {
			reverseStack(node.popOperation(), ++count);
		}
		return helperNode;
	}

	private Node pushReversedEntriesInAnotherStack(final Node n, int data) {
		return n.pushOperation(data);
	}
}
