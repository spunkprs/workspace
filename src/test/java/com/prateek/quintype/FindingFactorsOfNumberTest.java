package com.prateek.quintype;

import org.junit.Test;

import com.google.common.collect.Lists;

import org.junit.Assert;

import java.util.List;
public class FindingFactorsOfNumberTest {
	
	@Test
	public void shouldFindNumberOfFactorsForNumberCaseOne() {
		final List<Integer> numbers = Lists.newArrayList(2, 3, 5, 11);
		
		Assert.assertEquals(6, FindingFactorsOfNumber.fetchNumberOfFactorsForProductOfElements(numbers).intValue());
	}
	
	@Test
	public void shouldFindNumberOfFactorsForNumberCaseTwo() {
		final List<Integer> numbers = Lists.newArrayList(2, 3, 4);
		
		Assert.assertEquals(8, FindingFactorsOfNumber.fetchNumberOfFactorsForProductOfElements(numbers).intValue());
	}
	
	@Test
	public void shouldFindNumberOfFactorsForNumberCaseThree() {
		final List<Integer> numbersOne = Lists.newArrayList(20, 300000, 40000);
		final List<Integer> numbersTwo = Lists.newArrayList(20, 300000, 40000);
		final List<Integer> numbersThree = Lists.newArrayList(20, 300000, 40000);
		final List<Integer> numbersFour = Lists.newArrayList(20, 300000, 40000);
		final List<Integer> numbersFive = Lists.newArrayList(20, 300000, 40000);
		final List<Integer> numbersSix = Lists.newArrayList(20, 300000, 40000);
		final List<Integer> numbersSeven = Lists.newArrayList(20, 300000, 40000);
		
		
		Assert.assertEquals(8, FindingFactorsOfNumber.fetchNumberOfFactorsForProductOfElements(numbersOne).intValue());
	}
}
