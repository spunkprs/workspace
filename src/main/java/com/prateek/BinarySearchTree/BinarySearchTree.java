package com.prateek.BinarySearchTree;

import java.util.List;
//Many questions that are need to be solved are still remaining but going with time I'll try to do most of them.

import com.google.common.collect.Lists;

public class BinarySearchTree {
	
	private Node root;
	private List<Node> nodeList = Lists.newArrayList();
	final List<List<Node>> nodesAtEachLevel = Lists.newArrayList();
	private boolean flag = false;
	private List<String> paths = Lists.newArrayList();
	private Node parent = null;
	private boolean rightElementPresent = false;
	private boolean leftElementPresent = false;
	private Node lcaForNodes = null;
	private String postOrderTraversal = "";
	
	protected String levelOrderTraversalInSpiralForm() {
		final StringBuilder sb = new StringBuilder();
		Element<Node> element = new Element<Node>(root, true);
		Stack stackOne = new Stack();
		stackOne.push(element);
		Stack stackTwo = new Stack();
		performOperationsOnStacks(stackOne, stackTwo, sb);
		return sb.toString();
	}
	
	protected String postOrderTraversalNonRecursiveApproach() {
		final ElementForTravesal<Node> elementForTravesal = new ElementForTravesal<Node>(root);
		final StackForPostOrderTraversal<Node> stack = new StackForPostOrderTraversal<Node>();
		stack.push(elementForTravesal);
		processStackForPostOrderTraversal(stack);
		return postOrderTraversal;
	}
	
	protected List<Integer> getAncestorsOfANodeWithoutRecursion(final int nodeValue) {
		final ElementForTravesal<Node> elementForTravesal = new ElementForTravesal<Node>(root);
		if (root.getElement() == nodeValue) {
			return Lists.newArrayList();
		} else {
			final StackForPostOrderTraversal<Node> stack = new StackForPostOrderTraversal<Node>();
			stack.push(elementForTravesal);
			return processStackToFetchAncestors(stack, nodeValue);
		}
	}
	
	private List<Integer> processStackToFetchAncestors(final StackForPostOrderTraversal<Node> stack, final int nodeValue) {
		final List<Integer> ancestors = Lists.newArrayList();
		ElementForTravesal<Node> head = stack.getHead();
		while(head != null && head.getElement().getElement() != nodeValue) {
			head = processStack(head, stack);
		}
		populateAncestors(ancestors, stack);
		return ancestors;
	}

	private void populateAncestors(final List<Integer> ancestors, final StackForPostOrderTraversal<Node> stack) {
		ElementForTravesal<Node> head = stack.getHead();
		if (head != null) {
			while(head.getNext() != null) {
				ancestors.add(head.getNext().element.getElement());
				head = head.getNext();
			}
		}
	}

	private void processStackForPostOrderTraversal(final StackForPostOrderTraversal<Node> stack) {
		ElementForTravesal<Node> head = stack.getHead();
		while(head != null) {
			head = processStack(head, stack);
		}
	}
	
	private ElementForTravesal<Node> processStack(ElementForTravesal<Node> head, final StackForPostOrderTraversal<Node> stack) {
		decorateHead(head);
		if (head.isLeftChildUnExplored()) {
			ElementForTravesal<Node> node = new ElementForTravesal<Node>(head.element.getLeft());
			stack.push(node);
			head.setIsLeftChildUnExplored(!head.isLeftChildUnExplored());
			head = stack.getHead();
		} else if (head.isRightChildUnExplored()) {
			ElementForTravesal<Node> node = new ElementForTravesal<Node>(head.element.getRight());
			stack.push(node);
			head.setIsRightChildUnExplored(!head.isRightChildUnExplored());
			head = stack.getHead();
		} else {
			postOrderTraversal += String.valueOf(head.getElement().getElement());
			head = stack.pop();
		}
		return head;
	}

	private void decorateHead(final ElementForTravesal<Node> head) {
		if (!head.isNodeExplored()) {
			final Node node = head.getElement();
			head.setIsLeftChildUnExplored(node.getLeft() != null);
			head.setIsRightChildUnExplored(node.getRight() != null);
			head.setIsNodeExplored(!head.isNodeExplored());
		}
	}

	private void performOperationsOnStacks(final Stack stackOne, final Stack stackTwo, final StringBuilder sb) {
		flag = true;
		while(flag) {
			performOperationOnStackOne(stackOne, stackTwo, sb);
			performOperationOnStackTwo(stackTwo, stackOne, sb);
			if (stackOne.isEmpty() && stackTwo.isEmpty()) {
				flag = false;
			}
		}
	}

	private void performOperationOnStackTwo(final Stack stackTwo, final Stack stackOne, final StringBuilder sb) {
		while(!stackTwo.isEmpty()) {
			final Element<Node> currentElement = stackTwo.getHead();
			final Element<Node> elementOne = createElement(currentElement.getElement().getLeft(), currentElement);
			final Element<Node> elementTwo = createElement(currentElement.getElement().getRight(), currentElement);
			stackOne.push(elementOne);
			stackOne.push(elementTwo);
			
			sb.append(String.valueOf(currentElement.getElement().getElement()));
			stackTwo.pop();
		}
	}
	
	private Element<Node> createElement(final Node element, final Element<Node> currentElement) {
		 if (element != null) {
			 return new Element<Node>(element, !currentElement.getFlag());
		 }
		 return null;
	}

	private void performOperationOnStackOne(final Stack stackOne, final Stack stackTwo, final StringBuilder sb) {
		while(!stackOne.isEmpty()) {
				final Element<Node> currentElement = stackOne.getHead();
				final Element<Node> elementOne = createElement(currentElement.getElement().getRight(), currentElement);
				final Element<Node> elementTwo = createElement(currentElement.getElement().getLeft(), currentElement);
				stackTwo.push(elementOne);
				stackTwo.push(elementTwo);
				
				sb.append(String.valueOf(currentElement.getElement().getElement()));
				stackOne.pop();
		}
	}

	public List<List<Node>> getNodesAtEachLevel() {
		return nodesAtEachLevel;
	}

	public Node getParent() {
		return parent;
	}

	public List<String> getPaths() {
		return paths;
	}

	public void insert(final int element) {
		if (null != root) {
			final Node node = new Node(element);
			insertInTree(root, node);
		} else {
			root = new Node(element);
		}
	}
	
	public int getHeightOfTree() {
		return calculateHeightOfTree(root);
	}
	
	public List<Integer> diagonalSumOfBinarySearchTree() {
		return null;
	}
	
	private int calculateHeightOfTree(final Node rootNode) {
		if (rootNode == null) {
			return 0;
		} else if (rootNode.getLeft() == null && rootNode.getRight() == null) {
			return 1;
		}
		return max(calculateHeightOfTree(rootNode.getLeft()), calculateHeightOfTree(rootNode.getRight())) + 1;
	}

	private int max(int leftHeight, int rightHeight) {
		if (leftHeight >= rightHeight) {
			return leftHeight;
		} else {
			return rightHeight;
		}
	}
	
	public boolean hasPathSum(final int sum) {
		calculateAndEnsureTreeHasSumOfLeafPath(root, sum);
		if (flag)
			return true;
		else {
			return false;
		}
	}
	
	private void calculateAndEnsureTreeHasSumOfLeafPath(final Node rootNode, int sum) {
		if (rootNode != null && rootNode.getElement() <= sum) {
			final int sumRemaining = sum - rootNode.getElement();
			
			final Node leftChild = rootNode.getLeft();
			final Node rightChild = rootNode.getRight();
			
			if (leftChild != null) {
				if (sumRemaining < leftChild.getElement())
					return;
				else {
					calculateAndEnsureTreeHasSumOfLeafPath(leftChild, sumRemaining);
					if (rightChild !=null && sumRemaining != 0)
					calculateAndEnsureTreeHasSumOfLeafPath(rightChild, sumRemaining);
				}
			} else if (rightChild != null) {
				calculateAndEnsureTreeHasSumOfLeafPath(rightChild, sumRemaining);
			} else if (leftChild == null && rightChild == null && sumRemaining == 0) {
				flag = true;
				return;
			}
		} else {
			return;
		}
	}
	
	public void showAllPathsFromRootToLeaves() {
		final String str = "";
		exploreAllPaths(root, str);
	}
	
	private void exploreAllPaths(final Node node, String str) {
		if (node != null) {
				str+= Integer.toString(node.getElement());
				exploreAllPaths(node.getLeft(), str);
				exploreAllPaths(node.getRight(), str);
				if (isLeafNode(node)) {
					paths.add(str);
				}
		}
	}

	private boolean isLeafNode(Node node) {
		if (node.getLeft() == null && node.getRight() == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void applyReflectionThroughRoot() {
		applyReflection(root);
	}

	private void applyReflection(final Node node) {
		if (node != null) {
			applyReflection(node.getLeft());
			applyReflection(node.getRight());
			Node tempLeft = node.getLeft();
			node.setLeft(node.getRight());
			node.setRight(tempLeft);
		}
	}

	public boolean delete(final int num) {
		final Node nodeToBeDeleted = find(num);
		if (nodeToBeDeleted != null) {
			deleteAndReArrangeTree(nodeToBeDeleted);
			return true;
		} else {
			return false;
		}
	}
	
	private void deleteAndReArrangeTree(final Node nodeToBeDeleted) {
		if (root == nodeToBeDeleted && nodeToBeDeleted.getLeft() == null && nodeToBeDeleted.getRight() == null) {
			root = null;
		} else if (nodeToBeDeleted.getLeft() == null && nodeToBeDeleted.getRight() == null) {
			if (parent.getLeft() == nodeToBeDeleted) {
				parent.setLeft(null);
			} else if (parent.getRight() == nodeToBeDeleted) {
				parent.setRight(null);
			}
		} else if(nodeToBeDeleted.getLeft() != null && nodeToBeDeleted.getRight() == null) {
			restructureTree(findInorderPredecessor(nodeToBeDeleted.getLeft(), nodeToBeDeleted), nodeToBeDeleted);
		} else if (nodeToBeDeleted.getRight() != null && nodeToBeDeleted.getLeft() == null) {
			restructureTree(findInorderSuccessor(nodeToBeDeleted.getRight(), nodeToBeDeleted), nodeToBeDeleted);
		} else {
			restructureTree(findInorderPredecessor(nodeToBeDeleted.getLeft(), nodeToBeDeleted), nodeToBeDeleted);
		}
	}

	private void restructureTree(Node processedNode, final Node nodeToBeDeleted) {
		if (root != nodeToBeDeleted) {
			if (parent.getRight() == nodeToBeDeleted) {
				parent.setRight(processedNode);
			} else if (parent.getLeft() == nodeToBeDeleted) {
				parent.setLeft(processedNode);
			}
			
			if (isProcessedNodeImmediateLeftOrRightChildOfNodeToBeDeleted(processedNode, nodeToBeDeleted)) {
				process(processedNode, nodeToBeDeleted);
			} else {
				processedNode.setLeft(nodeToBeDeleted.getLeft());
				processedNode.setRight(nodeToBeDeleted.getRight());
			}
		} else {
			if (isProcessedNodeImmediateLeftOrRightChildOfNodeToBeDeleted(processedNode, nodeToBeDeleted)) {
				process(processedNode, nodeToBeDeleted);
				root = processedNode;
			} else {
				processedNode.setLeft(root.getLeft());
				processedNode.setRight(root.getRight());
				root = processedNode;
			}
		}
	}
	
	private void process(final Node processedNode, final Node nodeToBeDeleted) {
		if (nodeToBeDeleted.getLeft() != null && processedNode.equals(nodeToBeDeleted.getLeft())) {
			processedNode.setRight(nodeToBeDeleted.getRight());
		} else if (nodeToBeDeleted.getRight() != null && processedNode.equals(nodeToBeDeleted.getRight())) {
			processedNode.setLeft(nodeToBeDeleted.getLeft());
		}
	}

	private boolean isProcessedNodeImmediateLeftOrRightChildOfNodeToBeDeleted(final Node processedNode, final Node nodeToBeDeleted) {
		if ((nodeToBeDeleted.getLeft() != null && processedNode.equals(nodeToBeDeleted.getLeft())) || (nodeToBeDeleted.getRight() != null && processedNode.equals(nodeToBeDeleted.getRight()))) {
			return true;
		} else {
			return false;
		}
	}

	private Node findInorderPredecessor(final Node node, final Node nodeToBeDeleted) {
		Node temporaryNode = null;
		if (node.getRight() != null) {
			temporaryNode = findInorderPredecessor(node.getRight(), nodeToBeDeleted);
			if (temporaryNode == null) {
				temporaryNode = node.getRight();
				node.setRight(node.getRight().getLeft());
			}
		} else if (nodeToBeDeleted.getLeft() == node) {
			temporaryNode = node;
		}
		return temporaryNode;
	}
	
	private Node findInorderSuccessor(final Node node, final Node nodeToBeDeleted) {
		Node temporaryNode = null;
		if (node.getLeft() != null) {
			temporaryNode = findInorderSuccessor(node.getLeft(), nodeToBeDeleted);
			if (temporaryNode == null) {
				temporaryNode = node.getLeft();
				node.setLeft(node.getLeft().getRight());
			}
		} else if (nodeToBeDeleted.getRight() == node) {
			temporaryNode = node;
		}
		return temporaryNode;
	}

	public Node find(final int num) {
		final Node node = searchForNode(root, num);
		if (node != null) {
			return node;
		} else {
			return null;
		}
	}

	private Node searchForNode(final Node rootNode, final int num) {
		Node tempNode = null; 
		if (rootNode != null) {
			if (rootNode.getElement() == num) {
				tempNode = rootNode;
				return tempNode;
			} else if (rootNode.getElement() < num) {
				tempNode = searchForNode(rootNode.getRight(), num);
				instantiateParentNode(tempNode, rootNode);
			} else {
				tempNode = searchForNode(rootNode.getLeft(), num);
				instantiateParentNode(tempNode, rootNode);
			}
		} 
		return tempNode;
	}

	private void instantiateParentNode(final Node temporaryNode, final Node parentNode) {
		if (temporaryNode != null && parent == null) {
			parent = parentNode;
		}
	}

	private void insertInTree(Node rootNode, final Node node) {
		if (node.getElement() > rootNode.getElement()) {
			if (rootNode.getRight() == null) {
				rootNode.setRight(node);
			} else {
				rootNode = rootNode.getRight();
				insertInTree(rootNode, node);
			}
		} else if (node.getElement() <= rootNode.getElement()) {
			if (rootNode.getLeft() == null) {
				rootNode.setLeft(node);
			} else {
				rootNode = rootNode.getLeft();
				insertInTree(rootNode, node);
			}
		}
	}

	public void displayInorderTraversal() {
		nodeList = Lists.newArrayList();
		traverse(root);
	}
	
	
	public List<Node> displayCircumferenceOfTree() {
		nodeList = Lists.newArrayList();
		Node node = root;
		if (root != null) {
			nodeList.add(root);
			fetchBoundaryElements(root, root.getLeft(), root.getRight(), true);
			exploreRightBoundaryNonLeaves(root, root.getRight());
		} 
		return nodeList;
	}

	private void exploreRightBoundaryNonLeaves(Node parentNode, Node rightChild) {
		if (rightChild != null && !isLeafNode(rightChild)) {
			exploreRightBoundaryNonLeaves(rightChild, rightChild.getRight());
			nodeList.add(rightChild);
		}
	}

	private void fetchBoundaryElements(final Node parentNode, final Node leftChild, final Node rightChild, final boolean flag) {
		exploreLeftBoundary(parentNode, leftChild, flag);
		exploreRightBoundaryOrientedLeaves(parentNode, rightChild);
	}

	private void exploreRightBoundaryOrientedLeaves(final Node parentNode, final Node child) {
		if(child != null && !isLeafNode(child)) {
			fetchBoundaryElements(child, child.getLeft(), child.getRight(), false);
		} else {
			nodeList.add(child);
		}
	}

	private void exploreLeftBoundary(final Node parentNode, final Node child, final boolean flag) {
		if (parentNode != null && child != null) {
			if (flag) {
				nodeList.add(child);
			} else if (isLeafNode(child)){
				nodeList.add(child);
			}
		}
		
		if (child != null) {
			fetchBoundaryElements(child, child.getLeft(), child.getRight(), flag);
		}
	}

	public List<Node> getNodeList() {
		return nodeList;
	}

	public void setNodeList(List<Node> nodeList) {
		this.nodeList = nodeList;
	}

	private void traverse(Node rootNode) {
		if (rootNode != null) {
			if (rootNode.getLeft() != null || rootNode.getRight() != null) {
				if (rootNode.getLeft() != null) {
					traverse(rootNode.getLeft());
				}
				
				nodeList.add(rootNode);
				
				if (rootNode.getRight() != null) {
					traverse(rootNode.getRight());
				}
			} else {
				nodeList.add(rootNode);
			}
		}
	}
	
public Node findLowestCommonAncestorForTheNodes(final int leftElement, final int rightElement) {
	return findLCA(leftElement, rightElement, root);
}
	
	private Node findLCA(int leftElement, int rightElement, Node node) {
	find(node, leftElement, rightElement);
	return lcaForNodes;
}

	private void find(Node node, int leftElement, int rightElement) {
		if (!isNull(node)) {
			if (node.getElement() == leftElement) {
				leftElementPresent = true;
				checkRightElementPresence(node, rightElement, true);
				initializeLCANode(node);
				return;
			} else {
				if (!leftElementPresent) {
					find(node.getLeft(), leftElement, rightElement);
				}
				
				if (!leftElementPresent) {
					find(node.getRight(), leftElement, rightElement);
				}
				
				if (leftElementPresent && !rightElementPresent) {
					checkRightElementPresence(node, rightElement, false);
					initializeLCANode(node);
				}
				
			}
		}
	}

	private void initializeLCANode(Node node) {
		if (rightElementPresent) {
			lcaForNodes = node;
		} else {
			lcaForNodes = null;
		}
	}

	private void checkRightElementPresence(Node node, int rightElement, boolean exploreBothSubTrees) {
		if (!isNull(node)) {
			if (node.getElement() == rightElement) {
				rightElementPresent = true;
				return;
			} else {
				if (exploreBothSubTrees) {
					if (!rightElementPresent) {
						checkRightElementPresence(node.getLeft(), rightElement, exploreBothSubTrees);
					}
					
					if(!rightElementPresent) {
						checkRightElementPresence(node.getRight(), rightElement, exploreBothSubTrees);
					}
				} else {
					exploreBothSubTrees = true;
					checkRightElementPresence(node.getRight(), rightElement, exploreBothSubTrees);
				}
			}
		}
	}

	private boolean isNull(final Node node) {
		return null != node ? false : true;
	}

	/*
	 * For now this method is doing two things 
	 * 1. Traversing the tree using BFS approach
	 * 2. Preparing list of all nodes that are present at each level
	 * Need to decompose this method in to two according to SRP principle.
	 */
	public void traverseTreeUsingBFSApproach() {
		nodeList = Lists.newArrayList();
		List<Node> list = Lists.newArrayList();
		final Queue queue = new Queue();
		if (root != null) {
			queue.push(new Element<Node>(root, 0));
			if (maintainingLevelInfo(0)) {
				list.add(root);
				nodesAtEachLevel.add(list);
			}
			
			while(queue.getHead() != null) {
				final Node node = queue.getHead().getElement();
				nodeList.add(node);
				if (node.getLeft() != null) {
					queue.push(new Element<Node>(node.getLeft(), queue.getHead().getLevel() + 1));
					if (maintainingLevelInfo(queue.getHead().getLevel() + 1)) {
						list = Lists.newArrayList(node.getLeft());
						nodesAtEachLevel.add(list);
					} else {
						nodesAtEachLevel.get(queue.getHead().getLevel() + 1).add(node.getLeft());
					}
				}
				if (node.getRight() != null) {
					queue.push(new Element<Node>(node.getRight(), queue.getHead().getLevel() + 1));
					if (maintainingLevelInfo(queue.getHead().getLevel() + 1)) {
						list = Lists.newArrayList(node.getRight());
						nodesAtEachLevel.add(list);
					} else {
						nodesAtEachLevel.get(queue.getHead().getLevel() + 1).add(node.getRight());
					}
				}
				queue.pop();
			}
		}
	}
	
	private boolean maintainingLevelInfo(final int level) {
		if (nodesAtEachLevel.size() == level) {
			return true;
		} else {
			return false;
		}
	}

	public static class Queue {
		
		private Element<Node> head;
		private Element<Node> tail;
		
		public void push(final Element<Node> element) {
			if (head != null) {
				tail.setNext(element);
				tail = element;
			} else {
				head = element;
				tail = element;
			}
		}
		
		public void pop() {
			if (head != null) {
				if (head == tail) {
					head = null;
					tail = null;
				} else {
					head = head.getNext();
				}
			}
		}

		public Element<Node> getHead() {
			return head;
		}
	}
	
	private static class StackForPostOrderTraversal<T> {
		
		private ElementForTravesal<T> head;
		
		private void push(final ElementForTravesal element) {
			if (head == null) {
				head = element;
			} else {
				element.setNext(head);
				head = element;
			}
		}
		
		private ElementForTravesal<T> getHead() {
			return head;
		}
		
		private ElementForTravesal<T> pop() {
			if (head != null) {
				head = head.getNext();
			}
			return head;
		}
	}
	
	private static class ElementForTravesal<T> {
		private T element;
		private ElementForTravesal<T> next;
		private boolean isNodeExplored;
		private boolean isLeftChildUnexplored;
		private boolean isRightChildUnexplored;
		
		private ElementForTravesal(final T element) {
			this.element = element;
		}
		
		private void setNext(final ElementForTravesal<T> nextElement) {
			this.next = nextElement;
		}
		
		private ElementForTravesal<T> getNext() {
			return this.next;
		}
		
		private T getElement() {
			return this.element;
		}
		
		private void setIsLeftChildUnExplored(final boolean flag) {
			this.isLeftChildUnexplored = flag;
		}
		
		private void setIsRightChildUnExplored(final boolean flag) {
			this.isRightChildUnexplored = flag;
		}
		
		private boolean isLeftChildUnExplored() {
			return this.isLeftChildUnexplored;
		}
		
		private boolean isRightChildUnExplored() {
			return this.isRightChildUnexplored;
		}
		
		private boolean isNodeExplored() {
			return this.isNodeExplored;
		}
		
		private void setIsNodeExplored(final boolean isNodeExplored) {
			this.isNodeExplored = isNodeExplored;
		}
	}
	
	private static class Stack {
		private Element<Node> head;
		private Element<Node> tail;
		
		private void push(final Element<Node> element) {
			if (element != null) {
				if (head == null) {
					head = element;
					tail = element;
				} else {
					element.setNext(head);
					head = element;
				}
			}
		}
		
		private boolean isEmpty() {
			return head== null;
		}
		
		private void pop() {
			if (head != null) {
				if (head == tail) {
					head = null;
					tail = null;
				} else {
					head = head.getNext();
				}
			}
		}
		
		private Element<Node> getHead() {
			return head;
		}
	}
	
	public static class Element<T> {
		
		private T element;
		private Element<T> next;
		private int level;
		private boolean flag;
		
		public int getLevel() {
			return level;
		}

		private Element(final T t, final int level) {
			this.element = t;
			this.level = level;
		}
		
		private Element(final T t, final boolean flag) {
			this.element = t;
			this.flag = flag;
		}
		
		public T getElement() {
			return element;
		}

		public Element<T> getNext() {
			return next;
		}
		
		private boolean getFlag() {
			return this.flag;
		}
		
		public void setNext(Element<T> next) {
			this.next = next;
		}
	}
}
