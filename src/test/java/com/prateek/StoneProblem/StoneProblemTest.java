package com.prateek.StoneProblem;

import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class StoneProblemTest {
	
	private StoneProblem unit;
	
	@Before
	public void init() {
		unit= new StoneProblem();
	}
	
	@Test
	public void shouldGenerateDistinctStonePatternCombinationThatAlwaysStartsWithStoneZeroWhenNumberOfStonesAreThree() {
		//Set Up
		int numberOfStones = 3;
		final int steps[] = {1, 2};
		
		final List<Integer> combination1 = Lists.newArrayList(0, 1, 1);
		final List<Integer> combination2 = Lists.newArrayList(0, 1, 2);
		final List<Integer> combination3 = Lists.newArrayList(0, 2, 2);
		final List<List<Integer>> expectedCombinations = Lists.newArrayList(combination1, combination2, combination3);
		
		//Execute
		final List<List<Integer>> actualCombinations = unit.getAllPossibleCombinationsOfStones(steps, numberOfStones);
		
		//Verify
		Assert.assertEquals(expectedCombinations.size(), actualCombinations.size());
		verify(expectedCombinations, actualCombinations);
	}
	
	@Test
	public void shouldGenerateDistinctStonePatternCombinationThatAlwaysStartsWithStoneZeroWhenNumberOfStonesAreFive() {
		//Set Up
		int numberOfStones = 5;
		final int steps[] = {1, 2};
		
		final List<Integer> combination1 = Lists.newArrayList(0, 1, 1, 1, 1);
		final List<Integer> combination2 = Lists.newArrayList(0, 1, 1, 1, 2);
		final List<Integer> combination3 = Lists.newArrayList(0, 1, 1, 2, 2);
		final List<Integer> combination4 = Lists.newArrayList(0, 1, 2, 2, 2);
		final List<Integer> combination5 = Lists.newArrayList(0, 2, 2, 2, 2);
		final List<List<Integer>> expectedCombinations = Lists.newArrayList(combination1, combination2, combination3, combination4, combination5);
		
		//Execute
		final List<List<Integer>> actualCombinations = unit.getAllPossibleCombinationsOfStones(steps, numberOfStones);
		
		//Verify
		Assert.assertEquals(expectedCombinations.size(), actualCombinations.size());
		verify(expectedCombinations, actualCombinations);
	}
	
	
	@Test
	public void shouldGenerateDistinctStonePatternCombinationThatAlwaysStartsWithStoneZeroWhenNumberOfStonesAreFiveAndStepsAreThree() {
		//Set Up
		int numberOfStones = 5;
		final int steps[] = {1, 2, 3};
		
		final List<Integer> combination1 = Lists.newArrayList(0, 1, 1, 1, 1);
		final List<Integer> combination2 = Lists.newArrayList(0, 1, 1, 1, 2);
		final List<Integer> combination3 = Lists.newArrayList(0, 1, 1, 1, 3);
		final List<Integer> combination4 = Lists.newArrayList(0, 1, 1, 2, 2);
		final List<Integer> combination5 = Lists.newArrayList(0, 1, 1, 2, 3);
		final List<Integer> combination6 = Lists.newArrayList(0, 1, 1, 3, 3);
		final List<Integer> combination7 = Lists.newArrayList(0, 1, 2, 2, 2);
		final List<Integer> combination8 = Lists.newArrayList(0, 1, 2, 2, 3);
		final List<Integer> combination9 = Lists.newArrayList(0, 1, 2, 3, 3);
		final List<Integer> combination10 = Lists.newArrayList(0, 1, 3, 3, 3);
		final List<Integer> combination11 = Lists.newArrayList(0, 2, 2, 2, 2);
		final List<Integer> combination12 = Lists.newArrayList(0, 2, 2, 2, 3);
		final List<Integer> combination13 = Lists.newArrayList(0, 2, 2, 3, 3);
		final List<Integer> combination14 = Lists.newArrayList(0, 2, 3, 3, 3);
		final List<Integer> combination15 = Lists.newArrayList(0, 3, 3, 3, 3);
		
		final List<List<Integer>> expectedCombinations = Lists.newArrayList(combination1, combination2, combination3, combination4, combination5, combination6, combination7, 
				combination8, combination9, combination10, combination11, combination12, combination13, combination14, combination15);
		
		//Execute
		final List<List<Integer>> actualCombinations = unit.getAllPossibleCombinationsOfStones(steps, numberOfStones);
		
		//Verify
		Assert.assertEquals(expectedCombinations.size(), actualCombinations.size());
		verify(expectedCombinations, actualCombinations);
	}
	

	private void verify(final List<List<Integer>> expectedCombinations, final List<List<Integer>> actualCombinations) {
		for (int i = 0; i < expectedCombinations.size(); i++) {
			for (int j = 0; j < expectedCombinations.get(i).size(); j++) {
				Assert.assertEquals(expectedCombinations.get(i).get(j), actualCombinations.get(i).get(j));
			}
		}
	}
}
