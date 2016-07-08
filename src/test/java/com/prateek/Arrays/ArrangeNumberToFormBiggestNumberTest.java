package com.prateek.Arrays;

import org.junit.Test;
import java.util.List;

import com.google.common.collect.Lists;

import org.junit.Assert;
import org.junit.Before;

public class ArrangeNumberToFormBiggestNumberTest {

	private ArrangeNumberToFormBiggestNumber unit;
	
	@Before
	public void setUp() {
		unit = new ArrangeNumberToFormBiggestNumber();
	}
	
	@Test
	public void shouldFormBiggestNumberOutOfListOfNumbersCaseOne() {
		final List<Integer> numbers = Lists.newArrayList(3, 30, 34, 5, 9);
		
		Assert.assertEquals("9534330", unit.biggestNumberApproachOne(numbers));
	}
	
	@Test
	public void shouldFormBiggestNumberOutOfListOfNumbersCaseTwo() {
		final List<Integer> numbers = Lists.newArrayList(1, 34, 3, 98, 9, 76, 45, 4);
		
		Assert.assertEquals("998764543431", unit.biggestNumberApproachOne(numbers));
	}
	
	@Test
	public void shouldFormBiggestNumberOutOfListOfNumbersCaseThree() {
		final List<Integer> numbers = Lists.newArrayList(8, 89);
		
		Assert.assertEquals("898", unit.biggestNumberApproachOne(numbers));
	}
	
	@Test
	public void shouldFormBiggestNumberOutOfListOfNumbersCaseFour() {
		final List<Integer> numbers = Lists.newArrayList(0, 0, 0, 0);
		
		Assert.assertEquals("0", unit.biggestNumberApproachTwo(numbers));
	}
}
