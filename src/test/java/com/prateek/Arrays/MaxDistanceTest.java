package com.prateek.Arrays;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;

public class MaxDistanceTest {
	
	@Before
	public void setUp() {
		MaxDistance.maximumGap = -1;
	}

	@Test
	public void shouldFetchMaximumDistanceCaseOne() {
		List<Integer> numbers = Lists.newArrayList(3, 5, 4, 2);
		
		final int expectedMaxDistance = 2;
		Assert.assertEquals(expectedMaxDistance, MaxDistance.maximumGap(numbers));
	}
	
	@Test
	public void shouldFetchMaximumDistanceCaseTwo() {
		List<Integer> numbers = Lists.newArrayList(34, 8, 10, 3, 2, 80, 30, 33, 1);
		
		final int expectedMaxDistance = 6;
		Assert.assertEquals(expectedMaxDistance, MaxDistance.maximumGap(numbers));
	}
	
	@Test
	public void shouldFetchMaximumDistanceCaseWhenAllTheELmentsArePresentInDescendingOrder() {
		List<Integer> numbers = Lists.newArrayList(6, 5, 4, 3, 2, 1);
		
		final int expectedMaxDistance = -1;
		Assert.assertEquals(expectedMaxDistance, MaxDistance.maximumGap(numbers));
	}
	
	@Test
	public void shouldFetchMaximumDistanceWhenAllTheELmentsArePresentInAscendingOrder() {
		List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5, 6);
		
		final int expectedMaxDistance = 5;
		Assert.assertEquals(expectedMaxDistance, MaxDistance.maximumGap(numbers));
	}
}
