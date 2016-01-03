package com.prateek.divideandconquer;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import java.util.List;

import org.junit.Assert;

public class MaximumSumSubArrayTest {
	
	private MaximumSumSubArray unit;
	
	@Before
	public void setUp() {
		unit = new MaximumSumSubArray();
	}

	@Test
	public void shouldFetchIndexesOfMaximumSumSubArrayCaseOne() {
		final int array []= {-18, 20, -7, 12, -5, -8};
		
		final List<Integer> expectedIndexes = Lists.newArrayList(1, 3);
		
		final List<Integer> actualIndexes = unit.getMaximumSumSubArrayIndexesUsingBruteForceApproach(array);
		
		verify(expectedIndexes, actualIndexes);
	}
	
	@Test
	public void shouldFetchIndexesOfMaximumSumSubArrayCaseTwo() {
		final int array []= {13, -3, -25, 20, -3, -16, -23, 18};
		
		final List<Integer> expectedIndexes = Lists.newArrayList(3, 3);
		
		final List<Integer> actualIndexes = unit.getMaximumSumSubArrayIndexesUsingBruteForceApproach(array);
		
		verify(expectedIndexes, actualIndexes);
	}
	
	@Test
	public void shouldFetchIndexesOfMaximumSumSubArrayCaseThree() {
		final int array []= {20, -7, 12, -5, -22, 15, -4, 7};
		
		final List<Integer> expectedIndexes = Lists.newArrayList(0, 2);
		
		final List<Integer> actualIndexes = unit.getMaximumSumSubArrayIndexesUsingBruteForceApproach(array);
		
		verify(expectedIndexes, actualIndexes);
	}
	
	@Test
	public void shouldFetchIndexesOfMaximumSumSubArrayCaseFour() {
		final int array []= {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		
		final List<Integer> expectedIndexes = Lists.newArrayList(7, 10);
		
		final List<Integer> actualIndexes = unit.getMaximumSumSubArrayIndexesUsingBruteForceApproach(array);
		
		verify(expectedIndexes, actualIndexes);
	}
	
	@Test
	public void shouldFetchIndexesWhenArrayIsOfSizeOne() {
		final int arr[] = {10};
		final List<Integer> expectedIndexesWithSum = Lists.newArrayList(0, 0, 10);
		
		final List<Integer> actualIndexesWithSum = unit.getMaximumSumSubArrayIndexesUsingDivideAndConquerApproach(arr);
		
		verify(expectedIndexesWithSum, actualIndexesWithSum);
	}
	
	@Test
	public void shouldFetchIndexesWhenArrayIsOfSizeTwoCaseOne() {
		final int arr[] = {10, 12};
		final List<Integer> expectedIndexesWithSum = Lists.newArrayList(0, 1, 22);
		
		final List<Integer> actualIndexesWithSum = unit.getMaximumSumSubArrayIndexesUsingDivideAndConquerApproach(arr);
		
		verify(expectedIndexesWithSum, actualIndexesWithSum);
	}
	
	@Test
	public void shouldFetchIndexesWhenArrayIsOfSizeTwoCaseTwo() {
		final int arr[] = {10, -12};
		final List<Integer> expectedIndexesWithSum = Lists.newArrayList(0, 0, 10);
		
		final List<Integer> actualIndexesWithSum = unit.getMaximumSumSubArrayIndexesUsingDivideAndConquerApproach(arr);
		
		verify(expectedIndexesWithSum, actualIndexesWithSum);
	}
	
	@Test
	public void shouldFetchIndexesWhenArrayIsOfSizeTwoCaseThree() {
		final int arr[] = {-10, -12};
		final List<Integer> expectedIndexesWithSum = Lists.newArrayList(0, 0, -10);
		
		final List<Integer> actualIndexesWithSum = unit.getMaximumSumSubArrayIndexesUsingDivideAndConquerApproach(arr);
		
		verify(expectedIndexesWithSum, actualIndexesWithSum);
	}
	
	@Test
	public void shouldFetchIndexesWithSumCaseOne() {
		final int arr[] = {20, 17, -18, -24, 22, 10};
		final List<Integer> expectedIndexesWithSum = Lists.newArrayList(0, 1, 37);
		
		final List<Integer> actualIndexesWithSum = unit.getMaximumSumSubArrayIndexesUsingDivideAndConquerApproach(arr);
		verify(expectedIndexesWithSum, actualIndexesWithSum);
	}
	
	@Test
	public void shouldFetchIndexesWithSumCaseTwo() {
		final int arr[] = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		final List<Integer> expectedIndexesWithSum = Lists.newArrayList(7, 10, 43);
		
		final List<Integer> actualIndexesWithSum = unit.getMaximumSumSubArrayIndexesUsingDivideAndConquerApproach(arr);
		verify(expectedIndexesWithSum, actualIndexesWithSum);
	}
	
	private void verify(final List<Integer> expectedIndexes, final List<Integer> actualIndexes) {
		Assert.assertEquals(expectedIndexes.size(), actualIndexes.size());
		for (int i = 0; i < expectedIndexes.size(); i++) {
			Assert.assertEquals(expectedIndexes.get(i), actualIndexes.get(i));
		}
	}
}
