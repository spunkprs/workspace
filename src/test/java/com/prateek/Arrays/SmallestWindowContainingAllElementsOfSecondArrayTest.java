package com.prateek.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SmallestWindowContainingAllElementsOfSecondArrayTest {

	private SmallestWindowContainingAllElementsOfSecondArray unit;
	
	@Before
	public void setUp() {
		unit = new SmallestWindowContainingAllElementsOfSecondArray();
	}
	
	@Test
	public void shouldGetWindowOfMinimumSizeFromFirstArrayContainingAllElementsOfSecondArray() {
		final int arrOne[] = {6, 7, 1, 3, 2, 4, 5, 2, 3, 1, 2, 5};
		final int arrTwo[] = {2, 5, 1};
		
		final Pair expectedPair = new Pair(9, 11);
		final Pair actualPair = unit.getSmallestWindowFromFirstArrayContainingAllElementsOfSecondArray(arrOne, arrTwo);
		
		Assert.assertTrue(expectedPair.equals(actualPair));
	}
}
