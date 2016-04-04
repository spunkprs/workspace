package com.prateek.Arrays;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;

import org.junit.Assert;

public class FindDuplicatesInArrayTest {

	private FindDuplicatesInArray unit;
	
	@Before
	public void setUp() {
		unit = new FindDuplicatesInArray();
	}
	
	@Test
	public void shouldFindDuplicatesWhenThereAreNoZeroesInTheArrayCaseOne() {
		final int arr[]= {1, 4, 3, 4, 1};
		
		final Set<Integer> expectedList = Sets.newHashSet(1, 4);
		final Set<Integer> actualList = unit.findDuplicates(arr);
		
		Assert.assertEquals(expectedList.size(), actualList.size());
		for (Integer a : expectedList) {
			Assert.assertTrue(actualList.contains(a));
		}
	}
	
	@Test
	public void shouldFindDuplicatesWhenThereAreNoZeroesInTheArrayCaseTwo() {
		final int arr[]= {1, 4, 3, 4, 4};
		
		final Set<Integer> expectedList = Sets.newHashSet(4);
		final Set<Integer> actualList = unit.findDuplicates(arr);
		
		Assert.assertEquals(expectedList.size(), actualList.size());
		for (Integer a : expectedList) {
			Assert.assertTrue(actualList.contains(a));
		}
	}
	
	@Test
	public void shouldFindDuplicatesWhenThereAreZeroesInTheArray() {
		final int arr[]= {0, 0, 3, 4, 4};
		
		final Set<Integer> expectedList = Sets.newHashSet(4, 0);
		final Set<Integer> actualList = unit.findDuplicates(arr);
		
		Assert.assertEquals(expectedList.size(), actualList.size());
		for (Integer a : expectedList) {
			Assert.assertTrue(actualList.contains(a));
		}
	}
	
	/*
	@Test
	public void test() {
		final List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 4);
		
		Assert.assertEquals(4, unit.repeatedNumber(list));
	}
	*/
	
}
