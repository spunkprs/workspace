package com.prateek.Arrays;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import org.junit.Assert;

public class FirstMissingPositiveIntegerTest {
	
	private FirstMissingPositiveInteger unit;
	
	@Before
	public void setUp() {
		unit = new FirstMissingPositiveInteger();
	}

	@Test
	public void shouldGetFirstMissingPositiveIntegerCaseOne() {
		final List<Integer> list = new ArrayList<Integer>();
		list.add(-8);
		list.add(-7);
		list.add(-6);
		
		Assert.assertEquals(1, unit.firstMissingPositive(list));
	}
	
	@Test
	public void shouldGetFirstMissingPositiveIntegerCaseTwo() {
		final List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(0);
		
		Assert.assertEquals(3, unit.firstMissingPositive(list));
	}
	
	@Test
	public void shouldGetFirstMissingPositiveIntegerCaseThree() {
		final List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		list.add(-1);
		list.add(1);
		
		Assert.assertEquals(2, unit.firstMissingPositive(list));
	}
	
	@Test
	public void shouldGetFirstMissingPositiveIntegerCaseFour() {
		final List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(2);
		list.add(-1);
		list.add(-2);
		
		Assert.assertEquals(1, unit.firstMissingPositive(list));
	}
	
	@Test
	public void shouldGetFirstMissingPositiveIntegerCaseFive() {
		final List<Integer> listOne = Lists.newArrayList(2, 3, 3, 4, 8, -1, -3);
		final List<Integer> listTwo = Lists.newArrayList(1, 3, -7, 6, 8, 1, -5, 5);
		final List<Integer> listThree = Lists.newArrayList(8,-3, 0, -1, -2, 1, 3, 4, 2);
		
		Assert.assertEquals(1, unit.firstMissingPositive(listOne));
		Assert.assertEquals(2, unit.firstMissingPositive(listTwo));
		Assert.assertEquals(5, unit.firstMissingPositive(listThree));
	}
	
	@Test
	public void shouldGetFirstMissingPositiveIntegerCaseSix() {
		final List<Integer> listOne = Lists.newArrayList(1);
		final List<Integer> listTwo = Lists.newArrayList(1, 2, 3, 4, 5, 6);
		
		Assert.assertEquals(2, unit.firstMissingPositive(listOne));
		Assert.assertEquals(7, unit.firstMissingPositive(listTwo));
	}
}
