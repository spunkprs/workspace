package com.prateek.SubsetProblem;

import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class SubsetSumClientTest {

	private SubsetSumClient unit;
	
	@Before
	public void setUp() {
		unit = new SubsetSumClient();
	}
	
	@Test
	public void shouldGenerateSubsetSumsForArrayHavingDistinctNumbers1() {
		//Set Up
		final int array [] = {9, 6, 7, 5, 4, 11, 18};
		final int desiredSum = 18;
		final List<Integer> set1 = Lists.newArrayList(9, 5, 4);
		final List<Integer> set2 = Lists.newArrayList(6, 7, 5);
		final List<Integer> set3 = Lists.newArrayList(7, 11);
		final List<Integer> set4 = Lists.newArrayList(18);
		final List<List<Integer>> expectedSubSets = Lists.newArrayList(set1, set2, set3, set4);
		
		//Execute
		final List<List<Integer>> actualSubSets = unit.getSubsetsThatSumUpToANumber(array, desiredSum);
		
		//Verify
		Assert.assertEquals(expectedSubSets.size(), actualSubSets.size());
		verify(expectedSubSets, actualSubSets);
	}
	
	@Test
	public void shouldGenerateSubsetSumsForArrayHavingDistinctNumbers2() {
		//Set Up
		final int array [] = {9, 6, 7, 5, 4, 11, 18};
		final int desiredSum = 25;
		final List<Integer> set1 = Lists.newArrayList(9, 7, 5, 4);
		final List<Integer> set2 = Lists.newArrayList(9, 5, 11);
		final List<Integer> set3 = Lists.newArrayList(7, 18);
		final List<List<Integer>> expectedSubSets = Lists.newArrayList(set1, set2, set3);
		
		//Execute
		final List<List<Integer>> actualSubSets = unit.getSubsetsThatSumUpToANumber(array, desiredSum);
		
		//Verify
		Assert.assertEquals(expectedSubSets.size(), actualSubSets.size());
		verify(expectedSubSets, actualSubSets);
	}
	
	@Test
	public void shouldGenerateSubsetSumsForArrayHavingNonDistinctNumbers() {
		//Set Up
		final int array [] = {11, 9, 8, 9, 7};
		final int desiredSum = 18;
		final List<Integer> set1 = Lists.newArrayList(11, 7);
		final List<Integer> set2 = Lists.newArrayList(9, 9);
		final List<List<Integer>> expectedSubSets = Lists.newArrayList(set1, set2);
		
		//Execute
		final List<List<Integer>> actualSubSets = unit.getSubsetsThatSumUpToANumber(array, desiredSum);
		
		//Verify
		Assert.assertEquals(expectedSubSets.size(), actualSubSets.size());
		verify(expectedSubSets, actualSubSets);
	}
	
	@Test
	public void shouldGenerateSubsetSumsForArrayHavingNonDistinctNumbersWithGreaterFrequency() {
		//Set Up
		final int array [] = {11, 9, 8, 9, 7, 9};
		final int desiredSum = 18;
		final List<Integer> set1 = Lists.newArrayList(11, 7);
		final List<Integer> set2 = Lists.newArrayList(9, 9);
		final List<List<Integer>> expectedSubSets = Lists.newArrayList(set1, set2);
		
		//Execute
		final List<List<Integer>> actualSubSets = unit.getSubsetsThatSumUpToANumber(array, desiredSum);
		
		//Verify
		Assert.assertEquals(expectedSubSets.size(), actualSubSets.size());
		verify(expectedSubSets, actualSubSets);
	}
	
	@Test
	public void shouldGenerateSubsetSumsForArrayHavingNonDistinctNumbersWithGreaterFrequency1() {
		//Set Up
		final int array [] = {9, 9, 9};
		final int desiredSum = 18;
		final List<Integer> set1 = Lists.newArrayList(9, 9);
		final List<List<Integer>> expectedSubSets = Lists.newArrayList();
		expectedSubSets.add(set1);
		
		//Execute
		final List<List<Integer>> actualSubSets = unit.getSubsetsThatSumUpToANumber(array, desiredSum);
		
		//Verify
		Assert.assertEquals(expectedSubSets.size(), actualSubSets.size());
		verify(expectedSubSets, actualSubSets);
	}
	
	@Test
	public void shouldNotGenerateSubsetSumsForArrayHavingNonDistinctNumbers() {
		//Set Up
		final int array [] = {11, 9, 8, 9, 7, 9};
		final int desiredSum = 1202;
		
		//Execute
		final List<List<Integer>> actualSubSets = unit.getSubsetsThatSumUpToANumber(array, desiredSum);
		
		//Verify
		Assert.assertEquals(0, actualSubSets.size());
	}


	private void verify(List<List<Integer>> expectedSubSets, List<List<Integer>> actualSubSets) {
		for (int i = 0; i < actualSubSets.size(); i++) {
			final List<Integer> actual = actualSubSets.get(i);
			final List<Integer> expected = expectedSubSets.get(i);
			Assert.assertEquals(expected.size(), actual.size());
			for (int j = 0; j < actual.size(); j++) {
				Assert.assertEquals(expected.get(j), actual.get(j));
			}
		}
	}
}
