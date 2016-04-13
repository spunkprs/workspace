package com.prateek.vmware;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class MaxDifferenceInArrayTest {
	
	private MaxDifferenceInArray unit;
	
	@Before
	public void setUp() {
		unit = new MaxDifferenceInArray();
	}
	
	@Test
	public void shouldReturnMaxDifferenceInArrayCaseOne() {
		final int arr[] = {2, 3, 10, 2, 4, 8, 1};
		Assert.assertEquals(8, unit.maxDifferenceInArray(arr));
	}
	
	@Test
	public void shouldReturnMaxDifferenceInArrayCaseTwo() {
		final int arr[] = {7, 9, 5, 6, 3, 2};
		Assert.assertEquals(2, unit.maxDifferenceInArray(arr));
	}
	
	@Test
	public void shouldReturnMaxDifferenceInArrayWhenArrayIsSortedInIncreasingOrder() {
		final int arr[] = {1, 2, 3, 4, 5, 6};
		Assert.assertEquals(5, unit.maxDifferenceInArray(arr));
	}
	
	@Test
	public void shouldReturnNegativeOneWhenArrayIsSortedInDecreasingOrder() {
		final int arr[] = {6, 5, 4, 3, 2};
		Assert.assertEquals(-1, unit.maxDifferenceInArray(arr));
	}
	
	@Test
	public void shouldReturnNegativeOneWhenArrayIsSortedInDecreasingOrderAndHasOnlyTwoElements() {
		final int arr[] = {6, 5};
		Assert.assertEquals(-1, unit.maxDifferenceInArray(arr));
	}
	
	@Test
	public void shouldReturnNegativeOneWhenArrayHasOnlyOneElement() {
		final int arr[] = {6};
		Assert.assertEquals(-1, unit.maxDifferenceInArray(arr));
	}
	
	@Test
	public void shouldReturnMaxDifferenceInArrayCaseTwoWhenArrayHasTwoElements() {
		final int arr[] = {7, 9};
		Assert.assertEquals(2, unit.maxDifferenceInArray(arr));
	}
	
}
