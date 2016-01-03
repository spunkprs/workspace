package com.prateek.CodingDojo;

import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class SkiingProblemTest {
	
	private SkiingProblem unit;

	@Before
	public void setUp() {
		unit = new SkiingProblem();
	}
	
	@Test
	public void shouldFindLongestPathOfSkiiWhenTwoCrossTwoMatrixIsProvided1() {
		//Set Up
		final int grid[][] = {{1,2}, {7,6}};
		final Point p = new Point(1, 0);
		
		final List<Integer> path = Lists.newArrayList(7, 6, 2, 1);
		final List<List<Integer>> expectedMappedPaths = Lists.newArrayList();
		expectedMappedPaths.add(path);
		
		//Execute
		final List<List<Integer>> actualMappedPaths = unit.findMaximumPathOfSkii(grid, p);
		Assert.assertEquals(expectedMappedPaths.get(0).size(), actualMappedPaths.get(0).size());
		verify(expectedMappedPaths.get(0), actualMappedPaths.get(0));
		
	}
	
	
	@Test
	public void shouldFindLongestPathOfSkiiWhenTwoCrossTwoMatrixIsProvided2() {
		//Set Up
		final int grid[][] = {{1,2}, {7,6}};
		final Point p = new Point(1, 1);
		
		final List<Integer> path = Lists.newArrayList(6, 2, 1);
		final List<List<Integer>> expectedMappedPaths = Lists.newArrayList();
		expectedMappedPaths.add(path);
		
		//Execute
		final List<List<Integer>> actualMappedPaths = unit.findMaximumPathOfSkii(grid, p);
		Assert.assertEquals(expectedMappedPaths.get(0).size(), actualMappedPaths.get(0).size());
		verify(expectedMappedPaths.get(0), actualMappedPaths.get(0));
		
	}
	
	
	@Test
	public void shouldFindLongestPathOfSkiiWhenThreeCrossThreeMatrixIsProvided1() {
		//Set Up
		final int grid[][] = {{2,3,4}, {1,7,9}, {5,7,8}};
		final Point p = new Point(1, 2);
		
		final List<Integer> path = Lists.newArrayList(9, 8, 7, 7, 3, 2, 1);
		final List<List<Integer>> expectedMappedPaths = Lists.newArrayList();
		expectedMappedPaths.add(path);
		
		
		//Execute
		final List<List<Integer>> actualMappedPaths = unit.findMaximumPathOfSkii(grid, p);
		Assert.assertEquals(expectedMappedPaths.get(0).size(), actualMappedPaths.get(0).size());
		verify(expectedMappedPaths.get(0), actualMappedPaths.get(0));
		
	}
	
	
	@Test
	public void shouldFindLongestPathOfSkiiWhenThreeCrossThreeMatrixIsProvided2() {
		//Set Up
		final int grid[][] = {{2,3,4}, {1,7,9}, {5,7,8}};
		final Point p = new Point(1, 1);
		
		final List<Integer> path = Lists.newArrayList(9, 8, 7, 7, 3, 2, 1);
		final List<List<Integer>> expectedMappedPaths = Lists.newArrayList();
		expectedMappedPaths.add(path);
		
		
		//Execute
		final List<List<Integer>> actualMappedPaths = unit.findMaximumPathOfSkii(grid, p);
		Assert.assertEquals(expectedMappedPaths.get(0).size(), actualMappedPaths.get(0).size());
		verify(expectedMappedPaths.get(0), actualMappedPaths.get(0));
		
	}

	private void verify(List<Integer> expectedList, List<Integer> actualList) {
		for (int i = 0; i < expectedList.size(); i++) {
			Assert.assertEquals(expectedList.get(i), actualList.get(actualList.size() - i - 1));
		}
	}
}
