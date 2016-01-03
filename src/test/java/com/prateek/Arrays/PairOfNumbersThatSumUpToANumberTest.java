package com.prateek.Arrays;

import java.util.Set;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;

public class PairOfNumbersThatSumUpToANumberTest {

	
	private PairOfNumbersThatSumUpToANumber unit;
	
	@Before
	public void setUp() {
		unit = new PairOfNumbersThatSumUpToANumber();
	}
	
	@Test
	public void shouldFindPairOfNumbersThatSumUpToANumber1() {
		//Set Up
		final int number = 24;
		final int arr[] = {20, 2, 6, 4, 18, 7, 4, 22};
		final Set<Pair> pairs = createPairOfNumbers1();
		
		//Execute
		final Set<Pair> actualPairs = unit.getPairOfNumbersThatSumUpToANumber(arr, number);
		
		//Verify
		Assert.assertEquals(pairs.size(), actualPairs.size());
		verify(pairs, actualPairs);
	}

	private Set<Pair> createPairOfNumbers1() {
		final Set<Pair> pairs = Sets.newHashSet();
		final Pair pair1 = new Pair(20, 4);
		final Pair pair2 = new Pair(18, 6);
		final Pair pair3 = new Pair(22, 2);
		pairs.add(pair1);
		pairs.add(pair2);
		pairs.add(pair3);
		return pairs;
	}
	
	@Test
	public void shouldFindPairOfNumbersThatSumUpToANumber2() {
		//Set Up
		final int number = 19;
		final int arr[] = {5, 17, 13, 2, 6};
		final Set<Pair> pairs = createPairOfNumbers2();
		
		//Execute
	    final Set<Pair> actualPairs = unit.getPairOfNumbersThatSumUpToANumber(arr, number);
				
		//Verify
		Assert.assertEquals(pairs.size(), actualPairs.size());
		verify(pairs, actualPairs);
				
	}

	private void verify(Set<Pair> pairs, Set<Pair> actualPairs) {
		for (Pair pair : actualPairs) {
			Assert.assertTrue(pairs.contains(pair));
		}
	}

	private Set<Pair> createPairOfNumbers2() {
		final Set<Pair> pairs = Sets.newHashSet();
		final Pair pair1 = new Pair(13, 6);
		final Pair pair2 = new Pair(17, 2);
		pairs.add(pair1);
		pairs.add(pair2);
		return pairs;
	}
	
}
