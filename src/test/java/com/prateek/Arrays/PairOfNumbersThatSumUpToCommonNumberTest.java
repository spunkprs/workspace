package com.prateek.Arrays;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;

public class PairOfNumbersThatSumUpToCommonNumberTest {

	private PairOfNumbersThatSumUpToCommonNumber unit;
	
	@Before
	public void setUp() {
		unit = new PairOfNumbersThatSumUpToCommonNumber();
	}
	
	@Test
	public void shouldFindPairsHavingCommonSum1() {
		//Set UP
		System.out.println("FIRST TEST RESULT");
		final int arr[] = {20, 2, 6, 4, 18, 7, 4, 22};
		final Set<Pair> pairs = createPairOfNumbers1();
		
		//Execute
		final Set<Pair> actualPairs = unit.getPairOfNumbersThatSumUpToACommonNumber(arr);
				
		//Verify
	    Assert.assertEquals(pairs.size(), actualPairs.size());
		verify(pairs, actualPairs);
		printPairs(actualPairs);
	}
	
	@Test
	public void shouldFindPairsHavingCommonSum2() {
		//Set UP
		System.out.println("SECOND TEST RESULT");
		final int arr[] = {20, 2, 6, 18, 8, 4, 11};
		final Set<Pair> pairs = createPairOfNumbers2();
		
		//Execute
		final Set<Pair> actualPairs = unit.getPairOfNumbersThatSumUpToACommonNumber(arr);
				
		//Verify
	    Assert.assertEquals(pairs.size(), actualPairs.size());
		verify(pairs, actualPairs);
		printPairs(actualPairs);
	}
	
	
	@Test
	public void shouldFindPairsHavingCommonSum3() {
		//Set UP
		System.out.println("THIRD TEST RESULT");
		final int arr[] = {20, 48, 6, 18, 9, 100};
		final Set<Pair> pairs = Sets.newHashSet();
		
		//Execute
		final Set<Pair> actualPairs = unit.getPairOfNumbersThatSumUpToACommonNumber(arr);
				
		//Verify
	    Assert.assertEquals(pairs.size(), actualPairs.size());
		verify(pairs, actualPairs);
		printPairs(actualPairs);
	}

	private void printPairs(final Set<Pair> actualPairs) {
		for (Pair pair : actualPairs) {
			System.out.println("First Num" +" "+ pair.getFirst() + " "+ "Second Num" + " " + pair.getSecond());
		}
	}

	private Set<Pair> createPairOfNumbers1() {
		final Set<Pair> pairs = Sets.newHashSet();
		final Pair pair1 = new Pair(20, 4);
		final Pair pair2 = new Pair(18, 6);
		final Pair pair3 = new Pair(22, 2);
		final Pair pair4 = new Pair(2, 6);
		final Pair pair5 = new Pair(4, 4);
		final Pair pair6 = new Pair(20, 6);
		final Pair pair7 = new Pair(22, 4);
		final Pair pair8 = new Pair(20, 2);
		final Pair pair9 = new Pair(18, 4);
		pairs.add(pair1);
		pairs.add(pair2);
		pairs.add(pair3);
		pairs.add(pair4);
		pairs.add(pair5);
		pairs.add(pair6);
		pairs.add(pair7);
		pairs.add(pair8);
		pairs.add(pair9);
		return pairs;
	} 
	
	private Set<Pair> createPairOfNumbers2() {
		final Set<Pair> pairs = Sets.newHashSet();
		final Pair pair1 = new Pair(20, 2);
		final Pair pair2 = new Pair(18, 4);
		final Pair pair3 = new Pair(20, 6);
		final Pair pair4 = new Pair(18, 8);
		final Pair pair5 = new Pair(2, 8);
		final Pair pair6 = new Pair(4, 6);
		final Pair pair7 = new Pair(20, 4);
		final Pair pair8 = new Pair(6, 18);
		pairs.add(pair1);
		pairs.add(pair2);
		pairs.add(pair3);
		pairs.add(pair4);
		pairs.add(pair5);
		pairs.add(pair6);
		pairs.add(pair7);
		pairs.add(pair8);
		return pairs;
	}
	
	private void verify(Set<Pair> pairs, Set<Pair> actualPairs) {
		for (Pair pair : actualPairs) {
			Assert.assertTrue(pairs.contains(pair));
		}
	}
}
