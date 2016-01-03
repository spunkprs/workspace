package com.prateek.XORApplication;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class NumberThatRepeatsOddNumberOfTimesTest {
	
	private NumberThatRepeatsOddNumberOfTimes unit;
	
	@Before
	public void init() {
		unit = new NumberThatRepeatsOddNumberOfTimes();
	}

	@Test
	public void shouldFindNumberThatRepeatsOddNumberOfTimes() {
		//Set Up
		final int arr[] = {1, 2, 1, 2, 3, 2, 2, 1, 1};
		
		//Execute && Verify
		Assert.assertEquals(3, unit.findNumberThatRepeatsOddNumberOfTimes(arr));
	}
}
