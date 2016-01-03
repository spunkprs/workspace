package com.prateek.pubmatic;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class QuestionTwoTest {
	
	private QuestionTwo unit;

	@Before
	public void setUp() {
		unit = new QuestionTwo();
	}
	
	@Test
	public void shouldGiveIndexOfElementInCircularSortedIncreasingArrayOne() {
		//Set Up
		int arr[] = {6, -1, 0, 1, 2, 3, 4, 4, 5};
		int elementOne = 6;
		int elementTwo = 83;
		int elementThree = 4;
		
		int arrOne[] = {2, 3, 1};
		int element = 3;
		
		
		//Execute && Verify
		int index = unit.searchForElement(arr, elementOne);
		Assert.assertEquals(0, index);
		
		int indexTwo = unit.searchForElement(arr, elementTwo);
		Assert.assertEquals(-1, indexTwo);
		
		int indexThree = unit.searchForElement(arr, elementThree);
		Assert.assertEquals(6, indexThree);
		
		Assert.assertEquals(1, unit.searchForElement(arrOne, element));
	}
	
	@Test
	public void shouldGiveIndexOfElementInCircularSortedIncreasingArrayTwo() {
		//Set Up
		int arr[] = {6, 7, 8, 9, 10, 11, 12, 2, 3, 4};
		int elementOne = 3;
		int elementTwo = 10;
		int elementThree = 7;
		
		//Execute
		int indexOne = unit.searchForElement(arr, elementOne);
		Assert.assertEquals(8, indexOne);
		
		int indexTwo = unit.searchForElement(arr, elementTwo);
		Assert.assertEquals(4, indexTwo);
		
		int indexThree = unit.searchForElement(arr, elementThree);
		Assert.assertEquals(1, indexThree);
	}
	
	@Test
	public void shouldGiveIndexOfElementInCircularSortedDecreasingArrayOne() {
		//Set Up
		int arr[] = {25, 22, 21, 10, 8, 66, 53, 42, 42, 42};
		int elementOne = 53;
		int elementTwo = 66;
		int elementThree = 88;
		int elementFour = 42;
		int elementFive = 25;
		
		//Execute && Verify
		int indexOne = unit.searchForElement(arr, elementOne);
		Assert.assertEquals(6, indexOne);
		
		int indexTwo = unit.searchForElement(arr, elementTwo);
		Assert.assertEquals(5, indexTwo);
		
		int indexThree = unit.searchForElement(arr, elementThree);
		Assert.assertEquals(-1, indexThree);
		
		int indexFour = unit.searchForElement(arr, elementFour);
		Assert.assertEquals(7, indexFour);
		
		int indexFive = unit.searchForElement(arr, elementFive);
		Assert.assertEquals(0, indexFive);
	}
	
	@Test
	public void shouldGiveIndexOfElementInCircularSortedDecreasingArrayTwo() {
		//Set Up
		int arr[] = {4, 3, 6};
		
		int element = 3;
		
		//Execute && Verify
		Assert.assertEquals(1, unit.searchForElement(arr, element));
		
	}
}
