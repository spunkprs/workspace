package com.prateek.Arrays;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
	
	private MergeSort unit;

	@Before
	public void init() {
		unit = new MergeSort();
	}
	
	@Test
	public void shouldSort() {
		//Set Up
		final int arr[] = {9, 7, 116, 1, 4, 0, 112, 80, 92, 80};
		final int expectedArray[] = {0, 1, 4, 7, 9, 80, 80, 92, 112, 116};
		
		//Execute
		final int actualArray[] = unit.sort(arr);
		
		//Verify
		Assert.assertEquals(expectedArray.length, actualArray.length);
		verify(expectedArray, actualArray);
	}

	private void verify(final int[] expectedArray, final int[] actualArray) {
		for (int i = 0; i < expectedArray.length; i++) {
			Assert.assertEquals(expectedArray[i], actualArray[i]);
		}
	}
}
