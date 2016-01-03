package com.prateek.Arrays;

import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class PrintingRecursiveBoundariesIn2DArrayTest {
	
	private PrintingRecursiveBoundariesIn2DArray unit;
	
	
	@Before
	public void setUp() {
		unit = new PrintingRecursiveBoundariesIn2DArray();
	}
	
	
	@Test
	public void shouldPrintRecursiveBoundariesIn2DArrayForSquareMatrix100() {
		//Set Up
		final int array [][] = new int[1000][1000];
		
		//final List<Integer> expected = Lists.newArrayList(1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10);
		
		int num = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				array[i][j] = i + j + 1;
			}
		}
		final long timeStart = System.currentTimeMillis();
		
		//Execute
		final List<Integer> actualPattern = unit.getPatternOfNumbers(array);
		System.out.println(System.currentTimeMillis() - timeStart);
		
		//Verify
		
		//Assert.assertEquals(expected.size(), actualPattern.size());
		//verify(expected, actualPattern);
	}
	
	
	@Test
	public void shouldPrintRecursiveBoundariesIn2DArrayForSquareMatrix1() {
		//Set Up
		final int array [][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		
		final List<Integer> expected = Lists.newArrayList(1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10);
		
		//Execute
		final List<Integer> actualPattern = unit.getPatternOfNumbers(array);
		
		//Verify
		Assert.assertEquals(expected.size(), actualPattern.size());
		verify(expected, actualPattern);
	}
	
	@Test
	public void shouldPrintRecursiveBoundariesIn2DArrayForSquareMatrix2() {
		//Set Up
		final int array [][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		final List<Integer> expected = Lists.newArrayList(1,2,3,6,9,8,7,4,5);
		
		//Execute
		final List<Integer> actualPattern = unit.getPatternOfNumbers(array);
		
		//Verify
		Assert.assertEquals(expected.size(), actualPattern.size());
		verify(expected, actualPattern);
	}

	@Test
	public void shouldPrintRecursiveBoundariesIn2DArrayForNonSquareMatrix1() {
		//Set Up
		final int array [][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		
		final List<Integer> expected = Lists.newArrayList(1,2,3,4,8,12,11,10,9,5,6,7);
		
		//Execute
		final List<Integer> actualPattern = unit.getPatternOfNumbers(array);
		
		//Verify
		Assert.assertEquals(expected.size(), actualPattern.size());
		verify(expected, actualPattern);
	}
	
	@Test
	public void shouldPrintRecursiveBoundariesIn2DArrayForNonSquareMatrix2() {
		//Set Up
		final int array [][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
		
		final List<Integer> expected = Lists.newArrayList(1,2,3,6,9,12,11,10,7,4,5,8);
		
		//Execute
		final List<Integer> actualPattern = unit.getPatternOfNumbers(array);
		
		//Verify
		Assert.assertEquals(expected.size(), actualPattern.size());
		verify(expected, actualPattern);
	}
	
	@Test
	public void shouldPrintRecursiveBoundariesIn2DArrayForNonSquareMatrix3() {
		//Set Up
		final int array [][] = {{1}, {2}, {3}, {4}};
		
		final List<Integer> expected = Lists.newArrayList(1,2,3,4);
		
		//Execute
		final List<Integer> actualPattern = unit.getPatternOfNumbers(array);
		
		//Verify
		Assert.assertEquals(expected.size(), actualPattern.size());
		verify(expected, actualPattern);
	}
	
	@Test
	public void shouldPrintRecursiveBoundariesIn2DArrayForNonSquareMatrix4() {
		//Set Up
		final int array [][] = {{1, 2, 3, 4}};
		
		final List<Integer> expected = Lists.newArrayList(1,2,3,4);
		
		//Execute
		final List<Integer> actualPattern = unit.getPatternOfNumbers(array);
		
		//Verify
		Assert.assertEquals(expected.size(), actualPattern.size());
		verify(expected, actualPattern);
	}
	
	
	private void verify(final List<Integer> expected, final List<Integer> actualPattern) {
		for (int i = 0; i < actualPattern.size(); i++) {
			Assert.assertEquals(expected.get(i), actualPattern.get(i));
		}
	}
}
