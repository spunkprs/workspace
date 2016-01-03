package com.prateek.Arrays;

import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class FibonacciSeriesTest {
	
	private FibonacciSeries unit;
	
	@Before
	public void setUp() {
		unit = new FibonacciSeries();
	}
	
	@Test
	public void shouldGetFibonacciList() {
		//Set Up
		final List<Integer> expectedFibonacciList = Lists.newArrayList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
		
		//Execute && Verify
		final List<Integer> actualFibonacciList = unit.getFibonacciSeries(11);
		Assert.assertEquals(expectedFibonacciList.size(), actualFibonacciList.size());
		verify(expectedFibonacciList, actualFibonacciList);
	}
	
	private void verify(List<Integer> expectedFibonacciList, List<Integer> actualFibonacciList) {
		for (int i = 0; i < actualFibonacciList.size(); i++) {
			Assert.assertEquals(expectedFibonacciList.get(i).intValue(), actualFibonacciList.get(i).intValue());
		}
	}
}
