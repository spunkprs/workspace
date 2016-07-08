package com.prateek.Arrays;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import org.junit.Assert;
import org.junit.Before;

public class RepeatAndMissingNumberTest {
	
	private RepeatAndMissingNumber unit;
	
	@Before
	public void setUp() {
		unit = new RepeatAndMissingNumber();
	}

	@Test
	public void shouldFetchRepeatingAndMissingNumber() {
		final List<Integer> numbers = Lists.newArrayList(3, 1, 2, 5, 3);
		
		final List<Integer> expectedList = Lists.newArrayList(3, 4);
		final List<Integer> actualList = unit.repeatedNumber(numbers);
		
		Assert.assertEquals(expectedList.size(), actualList.size());
		verify(expectedList, actualList);
}

	private void verify(final List<Integer> expectedList, final List<Integer> actualList) {
		for (int i = 0; i < expectedList.size(); i++) {
			Assert.assertEquals(expectedList.get(i), actualList.get(i));
		}
	}
}
