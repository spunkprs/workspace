package com.prateek.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapSortTest {
	
	private HeapSort unit;

	@Before
	public void init() {
		unit = new HeapSort();
	}
	
	@Test
	public void shouldSortCaseOne() {
		//Set Up
		final int arr[] = {9, 7, 18, 2, 1, 22, 100, 2};
		final int expectedArray[] = {1, 2, 2, 7, 9, 18, 22, 100};
		
		//Execute
		final int actualArray[] = unit.sort(arr);
		
		//Verify
		Assert.assertEquals(expectedArray.length, actualArray.length);
		verify(expectedArray, actualArray);
	}
	
	@Test
	public void shouldSortCaseTwo() {
		//Set Up
		final int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		final int expectedArray[] = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2};
		
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
