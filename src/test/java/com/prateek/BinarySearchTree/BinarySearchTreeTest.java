package com.prateek.BinarySearchTree;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class BinarySearchTreeTest {
	
	private BinarySearchTree unit;
	private List<Integer> elements = Lists.newArrayList();
	
	@Before
	public void setUp() {
		unit = new BinarySearchTree();
		addElementsToList();
	}

	private void addElementsToList() {
		elements.add(10);
		elements.add(12);
		elements.add(16);
		elements.add(18);
		elements.add(15);
		elements.add(8);
		elements.add(9);
		elements.add(6);
		elements.add(5);
		elements.add(7);
		elements.add(110);
	}
	
	
	@Test
	public void shouldPerformBoundaryTraversal() {
		//Set Up
		insertElementsInBST();
		
		//Execute
		unit.displayCircumferenceOfTree();
	}
	
	@Test
	public void shouldFindHeightOfTree() {
		//Set Up
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertEquals(5, unit.getHeightOfTree());
	}
	
	@Test
	public void shouldFindSumOfDiagonalsOfBST() {
		//Set Up
		unit = new BinarySearchTree();
		insertElementsInBST();
		
	}
	
	@Test
	public void doesTreeHasPathSumForSumLessThanRootElement() {
		//Set Up
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertEquals(false, unit.hasPathSum(5));
	}
	
	
	@Test
	public void shouldFindHeightOfTreeWithOneNode() {
		//Set Up
		elements = Lists.newArrayList();
		elements.add(10);
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertEquals(1, unit.getHeightOfTree());
	}
	
	@Test
	public void shouldFindHeightOfTreeHavingZeroNodes() {
		//Set Up
		elements = Lists.newArrayList();
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertEquals(0, unit.getHeightOfTree());
	}
	
	
	@Test
	public void shouldEnsureTreeHasSumOfLeafPathForTreeHavingOneNode() {
		//Set Up
		elements = Lists.newArrayList();
		elements.add(10);
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertEquals(true, unit.hasPathSum(10));
	}
	
	
	@Test
	public void shouldEnsureTreeHasSumOfLeafPathForTreeHavingNoLeftSubTree() {
		//Set Up
		elements = Lists.newArrayList();
		elements.add(10);
		elements.add(20);
		elements.add(30);
		elements.add(40);
		
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertEquals(true, unit.hasPathSum(100));
	}
	
	
	@Test
	public void shouldEnsureTreeHasSumOfLeafPathForTreeHavingNoRightSubTree() {
		//Set Up
		elements = Lists.newArrayList();
		elements.add(10);
		elements.add(8);
		elements.add(9);
		elements.add(6);
		
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertEquals(true, unit.hasPathSum(24));
	}

	@Test
	public void shouldPerformInorderTraversal() {
		//Set Up
		//Inserting elements
		insertElementsInBST();
		
		//Execute
		unit.displayInorderTraversal();
		
		//Verify
		final List<Node> expectedList = unit.getNodeList();
		Assert.assertEquals(elements.size(), expectedList.size());
		verify();
	}
	
	@Test
	public void shouldSearchANodeInATreeHavingOnlyOneNode() {
		//Set Up
		elements = Lists.newArrayList(10);
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertEquals(new Node(10), unit.find(10));
	}
	
	@Test
	public void shouldSearchANodeAndItsParent() {
		//Set Up
		elements = Lists.newArrayList(10, 20, 30, 40, 8, 9);
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertEquals(new Node(8), unit.find(8));
		Assert.assertEquals(new Node(10), unit.getParent());
	}
	
	
	@Test
	public void shouldSearchANodeInATreeHavingZeroNodes() {
		//Set Up
		elements = Lists.newArrayList();
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertNull(unit.find(10));
	}
	
	@Test
	public void shouldSearchANodeInATree() {
		//Set Up
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertEquals(new Node(110), unit.find(110));
		Assert.assertEquals(new Node(9), unit.find(9));
		Assert.assertEquals(new Node(110), unit.find(110));
		Assert.assertEquals(new Node(16), unit.find(16));
		Assert.assertEquals(new Node(8), unit.find(8));
		Assert.assertNull(unit.find(122));
	}
	
	@Test
	public void shouldDeleteLeafNode() {
		//Set Up
		elements = Lists.newArrayList(10, 20, 30, 7, 8, 5, 15);
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertTrue(unit.delete(15));
		elements.remove(new Integer(15));
		
        unit.displayInorderTraversal();
		final List<Node> expectedList = unit.getNodeList();
		Assert.assertEquals(elements.size(), expectedList.size());
		verify();
	}
	
	@Test
	public void shouldDeleteNodeHavingBothLeftAndRightSubTree() {
		//Set Up
		elements = Lists.newArrayList(10, 20, 30, 7, 8, 5, 15, 16);
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertTrue(unit.delete(20));
		elements.remove(new Integer(20));
		
		unit.displayInorderTraversal();
		final List<Node> expectedList = unit.getNodeList();
		Assert.assertEquals(elements.size(), expectedList.size());
		verify();
	}
	
	@Test
	public void shouldDeleteNodeInTheTreeThatIsCompletelyRightAlligned() {
		//Set Up
		elements = Lists.newArrayList(10, 20, 30, 40, 50, 60, 48);
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertTrue(unit.delete(30));
		elements.remove(new Integer(30));
		
		unit.displayInorderTraversal();
		final List<Node> expectedList = unit.getNodeList();
		Assert.assertEquals(elements.size(), expectedList.size());
		verify();
	}
	
	
	@Test
	public void shouldDeleteNodeInTheTreeThatIsCompletelyLeftAlligned() {
		//Set Up
		elements = Lists.newArrayList(20, 18, 15, 12, 10, 8);
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertTrue(unit.delete(12));
		elements.remove(new Integer(12));
		
		unit.displayInorderTraversal();
		final List<Node> expectedList = unit.getNodeList();
		Assert.assertEquals(elements.size(), expectedList.size());
		verify();
	}
	
	@Test
	public void shouldDeleteRootNodeHavingBothRightAndLeftSubTree() {
		//Set Up
		elements = Lists.newArrayList(20, 18, 15, 28, 24, 9, 32, 19);
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertTrue(unit.delete(20));
	    elements.remove(new Integer(20));
				
		unit.displayInorderTraversal();
		final List<Node> expectedList = unit.getNodeList();
		Assert.assertEquals(elements.size(), expectedList.size());
		verify();
	}
	
	@Test
	public void shouldDeleteRootHavingNoLeftAndRightSubTree() {
		//Set Up
		elements = Lists.newArrayList(20);
		insertElementsInBST();
		
		//Execute && Verify
		Assert.assertTrue(unit.delete(20));
	    elements.remove(new Integer(20));
	    unit.displayInorderTraversal();
		final List<Node> expectedList = unit.getNodeList();
		Assert.assertEquals(elements.size(), expectedList.size());
	}
	
	@Test
	public void shouldShowAllPathsFromRootToLeaves() {
		//Set Up
		elements = Lists.newArrayList(20, 18, 15, 19, 25, 32, 8, 9, 6);
		insertElementsInBST();
		final String str1 = "20181586";
		final String str2 = "20181589";
		final String str3 = "201819";
		final String str4 = "202532";
		final List<String> paths = Lists.newArrayList(str1, str2, str3, str4);
		
		//Execute && Verify
		unit.showAllPathsFromRootToLeaves();
		Assert.assertEquals(paths.size(), unit.getPaths().size());
		verifyPaths(paths, unit.getPaths());
		
	}
	
	@Test
	public void shouldApplyReflectionOnToTheTree() {
		//Set Up
		elements = Lists.newArrayList(10, 20, 30, 7, 5, 8);
		insertElementsInBST();
		//inorder traversal of elements after reflection
		elements = Lists.newArrayList(30, 20, 10, 8, 7, 5);
		
		//Execute && Verify
		unit.applyReflectionThroughRoot();
		unit.displayInorderTraversal();
		Assert.assertEquals(elements.size(), unit.getNodeList().size());
		verifyElementsAfterReflection(elements, unit.getNodeList());
	}
	
	@Test
	public void shouldApplyReflectionOnToTheTreeWhichIsRightAlligned() {
		//Set Up
		elements = Lists.newArrayList(10, 20, 30, 40);
		insertElementsInBST();
		//inorder traversal of elements after reflection
		elements = Lists.newArrayList(40, 30, 20, 10);
		
		//Execute && Verify
		unit.applyReflectionThroughRoot();
		unit.displayInorderTraversal();
		Assert.assertEquals(elements.size(), unit.getNodeList().size());
		verifyElementsAfterReflection(elements, unit.getNodeList());
	}
	
	@Test
	public void shouldApplyReflectionOnToTheTreeWhichIsLeftAlligned() {
		//Set Up
		elements = Lists.newArrayList(10, 8, 7, 5);
		insertElementsInBST();
		//inorder traversal of elements after reflection
		elements = Lists.newArrayList(10, 8, 7, 5);
		
		//Execute && Verify
		unit.applyReflectionThroughRoot();
		unit.displayInorderTraversal();
		Assert.assertEquals(elements.size(), unit.getNodeList().size());
		verifyElementsAfterReflection(elements, unit.getNodeList());
	}
	
	@Test
	public void shouldApplyReflectionOnToTheTreeHavingRootAsTheOnlyNode() {
		//Set Up
		elements = Lists.newArrayList(10);
		insertElementsInBST();
		//inorder traversal of elements after reflection
		elements = Lists.newArrayList(10);
		
		//Execute && Verify
		unit.applyReflectionThroughRoot();
		unit.displayInorderTraversal();
		Assert.assertEquals(elements.size(), unit.getNodeList().size());
		verifyElementsAfterReflection(elements, unit.getNodeList());
	}
	
	@Test
	public void shouldFindLowestCommonAncestorForTheNodes() {
		//Set Up
		elements = Lists.newArrayList(35, 30, 45, 29, 32, 40, 55, 53, 77, 89);
		insertElementsInBST();
		
		
		//Execute && Verify
		//unit.findLowestCommonAncestorForTheNodes(new Node(40), new Node(89));
	}
	
	@Test
	public void shouldTraverseTreeUsingBFS() {
		//Set Up
		elements = Lists.newArrayList(35, 20, 55, 10, 30, 45, 60);
		insertElementsInBST();
		//BFS traversal of tree would be
		elements = Lists.newArrayList(35, 20, 55, 10, 30, 45, 60);
		
		//Execute && Verify
		unit.traverseTreeUsingBFSApproach();
		Assert.assertEquals(elements.size(), unit.getNodeList().size());
		for (int i = 0; i < unit.getNodeList().size(); i++) {
			Assert.assertEquals(elements.get(i).intValue(), unit.getNodeList().get(i).getElement());
		}
	}
	
	@Test
	public void shouldMaintainListOfNodesAtEachLevel() {
		//Set Up
		elements = Lists.newArrayList(35, 20, 55, 10, 30, 45, 60);
		insertElementsInBST();
		
		final List<Node> rootList = Lists.newArrayList(new Node(35));
		final List<Node> list1 = Lists.newArrayList(new Node(20), new Node(55));
		final List<Node> list2 = Lists.newArrayList(new Node(10), new Node(30), new Node(45), new Node(60));
		final List<List<Node>> listOfNodesAtEachLevel = Lists.newArrayList(rootList, list1, list2);
		
		//Execute && Verify
		unit.traverseTreeUsingBFSApproach();
		Assert.assertEquals(listOfNodesAtEachLevel.size(), unit.getNodesAtEachLevel().size());
		verifyNodesInLinkListForEachLevel(listOfNodesAtEachLevel);
	}
	
	@Test
	public void shouldPerformLevelOrderTraversalInSpiralForm() {
		elements = Lists.newArrayList(35, 20, 55, 10, 30, 45, 60, 100, 33);
		insertElementsInBST();
		
		final String expectedTraversal = "35" + "20" + "55" + "60" + "45" + "30" + "10" + "33" + "100";
		final String actualTraversal = unit.levelOrderTraversalInSpiralForm();
		
		Assert.assertTrue(expectedTraversal.equals(actualTraversal));
	}
	
	private void verifyNodesInLinkListForEachLevel(final List<List<Node>> listOfNodesAtEachLevel) {
		for (int i = 0; i < unit.getNodesAtEachLevel().size(); i++) {
			final List<Node> actualListOfNodes = unit.getNodesAtEachLevel().get(i);
			final List<Node> expectedListNodes = listOfNodesAtEachLevel.get(i);
			Assert.assertEquals(expectedListNodes.size(), actualListOfNodes.size());
			for (int j = 0; j < actualListOfNodes.size(); j++) {
				Assert.assertEquals(expectedListNodes.get(j).getElement(), actualListOfNodes.get(j).getElement());
			}
		}
	}

	private void verifyElementsAfterReflection(List<Integer> expected, List<Node> actual) {
		for (int i = 0; i < actual.size(); i++) {
			Assert.assertEquals(expected.get(i).intValue(), actual.get(i).getElement());
		}
	}

	private void verifyPaths(final List<String> expectedPaths, final List<String> actualPaths) {
		for (int i = 0; i < actualPaths.size(); i++) {
			Assert.assertEquals(expectedPaths.get(i), actualPaths.get(i));
		}
	}

	private void verify() {
		Collections.sort(elements);
		for (int i = 0; i < elements.size(); i++) {
			Assert.assertEquals(new Integer(elements.get(i)), new Integer(unit.getNodeList().get(i).getElement()));
		}
	}

	private void insertElementsInBST() {
		for (Integer element : elements) {
			unit.insert(element);
		}
	}
}
