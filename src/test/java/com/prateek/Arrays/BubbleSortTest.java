package com.prateek.Arrays;

import org.junit.Test;

import org.junit.Assert;

public class BubbleSortTest {

	@Test
	public void shouldSortArrayInAscendingOrder() {
		int arr[] = {2, 9, 7, 3, 1, 21, 0};
		
		final int expectedArr[] = {0, 1, 2, 3, 7, 9, 21};
		final int actualSortedArr[] = BubbleSort.sortInAscendingOrder(arr);
		
		verifyEquality(expectedArr, actualSortedArr);
	}
	
	@Test
	public void shouldNotSortArrayWhenArrayIsAlreadySortedInAscendingOrder() {
		int arr[] = {1, 2, 3, 4, 5};
		
		final int actualSortedArr[] = BubbleSort.sortInAscendingOrder(arr);
		
		verifyEquality(arr, actualSortedArr);
	}
	
	@Test
	public void shouldSortArrayWhenArrayIsSortedInDescendingOrder() {
		int arr[] = {10, 9, 8, 7, 6};
		
		final int expectedArr[] = {6, 7, 8, 9, 10};
		final int actualSortedArr[] = BubbleSort.sortInAscendingOrder(arr);
		
		verifyEquality(expectedArr, actualSortedArr);
	}
	
	@Test
	public void shouldSortArrayContainingOnlyZeroesAndOnes() {
		int arr[] = {0, 1, 1, 1, 0};
		
		final int expectedArr[] = {0, 0, 1, 1, 1};
		final int actualSortedArr[] = BubbleSort.sortInAscendingOrder(arr);
		
		verifyEquality(expectedArr, actualSortedArr);
	}
	
	@Test
	public void shouldNotSortArrayOfLengthOne() {
		int arr[] = {1};
		final int actualSortedArr[] = BubbleSort.sortInAscendingOrder(arr);
		
		verifyEquality(arr, actualSortedArr);
	}
	
	@Test
	public void shouldSortArrayContainingBothPositivesAndNegatives() {
		int arr[] = {0, -10, -20, 20, 21, 1};
		
		final int expectedArr[] = {-20, -10, 0, 1, 20, 21};
		final int actualSortedArr[] = BubbleSort.sortInAscendingOrder(arr);
		
		verifyEquality(expectedArr, actualSortedArr);	
	}

	private void verifyEquality(final int[] expectedArr, final int[] actualSortedArr) {
		Assert.assertEquals(expectedArr.length, actualSortedArr.length);
		for (int i = 0; i < expectedArr.length; i++) {
			Assert.assertEquals(expectedArr[i], actualSortedArr[i]);
		}
	}
}
