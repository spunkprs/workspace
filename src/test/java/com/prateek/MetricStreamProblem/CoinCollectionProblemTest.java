package com.prateek.MetricStreamProblem;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class CoinCollectionProblemTest {
	
	private CoinCollectionProblem unit;

	@Before
	public void init() {
		unit = new CoinCollectionProblem();
	}
	
	@Test
	public void shouldReturnMaxCollectedCoins() {
		//Set Up
		final int stacks[] = {3, 2, 3, 1, 1, 5, 2, 2, 1, 3, 1, 1, 1, 1, 2, 1};
		final int limit = 2;
		
		final int expectedOutput = 7;
		
		//Execute 
		final int actualOutput = unit.countMaximumNumberOfCollectedCoins(stacks, limit);
		
		//Verify
		Assert.assertEquals(expectedOutput, actualOutput);
	}
}
