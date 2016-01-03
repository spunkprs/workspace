package com.prateek.Arrays;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class InsertionSortTest {
	
	private InsertionSort unit;
	
	@Before
	public void setUp() {
		unit = new InsertionSort();
	}

	@Test
	public void shouldSortArrayWhenArrayHasSingleElementInIt() {
		int array[] = {10};
		Assert.assertEquals(array.length, unit.sort(array).length);
	}
	
	@Test
	public void shouldSortArrayWhenArrayHaveTwoElementsInIt() {
		int array[] = {10, 9};
		int expectedSortedArray[] = {9, 10};
		
		int actualSortedArray[] = unit.sort(array);
		
		Assert.assertEquals(expectedSortedArray.length, actualSortedArray.length);
		verify(expectedSortedArray, actualSortedArray);
	}
	
	@Test
	public void shouldSortWhenArrayHasMultipleElementsCaseOne() {
		int array[] = {10, 9, 8, 7, 7, 3};
		int expectedSortedArray[] = {3, 7, 7, 8, 9, 10};
		
		int actualSortedArray[] = unit.sort(array);
		
		Assert.assertEquals(expectedSortedArray.length, actualSortedArray.length);
		verify(expectedSortedArray, actualSortedArray);
	}
	
	@Test
	public void shouldSortWhenArrayHasMultipleElementsCaseTwo() {
		int array[] = {10, 9, 11, 7, 8, 1};
		int expectedSortedArray[] = {1, 7, 8, 9, 10, 11};
		
		int actualSortedArray[] = unit.sort(array);
		
		Assert.assertEquals(expectedSortedArray.length, actualSortedArray.length);
		verify(expectedSortedArray, actualSortedArray);
	}
	
	@Test
	public void shouldSortWhenArrayHasMultipleElementsCaseThree() {
		int array[] = {10, 11, 12, 13, 14};
		int expectedSortedArray[] = {10, 11, 12, 13, 14};
		
		int actualSortedArray[] = unit.sort(array);
		
		Assert.assertEquals(expectedSortedArray.length, actualSortedArray.length);
		verify(expectedSortedArray, actualSortedArray);
	}

	private void verify(final int[] expectedSortedArray, final int[] actualSortedArray) {
		for (int i = 0;i < expectedSortedArray.length; i++) {
			Assert.assertEquals(expectedSortedArray[i], actualSortedArray[i]);
		}
	}
}
