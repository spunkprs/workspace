package com.prateek.dynamicprogramming;

import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.prateek.dynamicprogramming.DynamicProgrammingQuestions.Pair;

public class DynamicProgrammingQuestionsTest {
	
	private DynamicProgrammingQuestions unit;
	
	@Before
	public void setUp() {
		unit = new DynamicProgrammingQuestions();
	}
	
	@Test
	public void shouldReturnMaximumMovesCaseOne() {
		int arr[] = {2, 4, 8};
		
		Assert.assertEquals(3, unit.maximumNumberOfMovesForWitch(arr));
	}
	
	@Test
	public void shouldReturnMaximumMovesCaseTwo() {
		int arr[] = {1, 2, 4};
		
		Assert.assertEquals(1, unit.maximumNumberOfMovesForWitch(arr));
	}
	
	@Test
	public void shouldReturnMaximumMovesCaseThree() {
		int arr[] = {1, 2, 3};
		
		Assert.assertEquals(0, unit.maximumNumberOfMovesForWitch(arr));
	}
	
	@Test
	public void shouldReturnMaximumMovesCaseFour() {
		int arr[] = {7, 9, 14};
		
		Assert.assertEquals(4, unit.maximumNumberOfMovesForWitch(arr));
	}
	
	@Test
	public void shouldGetMinCostPath() {
		//Set Up
		int arr[][] = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
		final String expectedPath = "00->01->12->22";
		
		//Execute
		final Pair<Integer, String> minCostPath = unit.getMinimumCostPath(arr, 2, 2);
		
		//Verify
		Assert.assertEquals(new Integer(8), (Integer)minCostPath.getL());
		Assert.assertTrue(minCostPath.getR().equals(expectedPath));
	}
	
	@Test
	public void shouldGetPossibleWaysToGetTheChangeWhenTheAmountIsFourAndMaxDenominationIsThree() {
		//Set Up
		int amount = 4;
		final List<StringBuilder> expectedPaths = Lists.newArrayList(new StringBuilder("4->1->1->1->1"), new StringBuilder("4->1->1->2"), new StringBuilder("4->1->2->1"), new StringBuilder("4->1->3"), new StringBuilder("4->2->1->1"), new StringBuilder("4->2->2"), new StringBuilder("4->3->1"));
		
		final List<StringBuilder> actualChangePaths = unit.getPossibleWaysOfGettingTheChange(amount, 3);
		Assert.assertEquals(expectedPaths.size(), actualChangePaths.size());
		verify(expectedPaths, actualChangePaths);
	}
	
	@Test
	public void shouldGetPossibleWaysToGetTheChangeWhenTheAmountIsTwoAndMaxDenominationIsTwo() {
		//Set Up
		int amount = 2;
		final List<StringBuilder> expectedPaths = Lists.newArrayList(new StringBuilder("2->1->1"), new StringBuilder("2->2"));
		
		final List<StringBuilder> actualChangePaths = unit.getPossibleWaysOfGettingTheChange(amount, 2);
		Assert.assertEquals(expectedPaths.size(), actualChangePaths.size());
		verify(expectedPaths, actualChangePaths);
	}
	
	@Test
	public void shouldGetFibonacciSum() {
		//Set Up , Execute && Verify
		Assert.assertEquals(3, unit.getFibonacciSum(4));
		Assert.assertEquals(8, unit.getFibonacciSum(6));
	}
	
	@Test
	public void shouldGetLongestCommonSubstringWhenStringsAreOfDifferentLength() {
		final String s1 = "abcdaf";
		final String s2 = "zdaf";
		
		final List<String> expectedCommonSubStrings = Lists.newArrayList("daf");
		final List<String> actualCommonSubStrings = unit.getLongestCommonSubstring(s1, s2);
		
		Assert.assertEquals(expectedCommonSubStrings.size(), actualCommonSubStrings.size());
		verifyCommonSubStringsOrSubSequences(expectedCommonSubStrings, actualCommonSubStrings);
	}
	
	@Test
	public void shouldGetLongestCommonSubstringWhenStringsAreOfSameLength() {
		final String s1 = "ABBAB";
		final String s2 = "BBABB";
		
		final List<String> expectedCommonSubStrings = Lists.newArrayList("BBAB");
		final List<String> actualCommonSubStrings = unit.getLongestCommonSubstring(s1, s2);
		
		Assert.assertEquals(expectedCommonSubStrings.size(), actualCommonSubStrings.size());
		verifyCommonSubStringsOrSubSequences(expectedCommonSubStrings, actualCommonSubStrings);
	}
	
	@Test
	public void shouldGetLongestCommonSubstringWhenMultipleCommonSubStringsCouldBePresent() {
		final String s1 = "ABBD";
		final String s2 = "BBAB";
		
		final List<String> expectedCommonSubStrings = Lists.newArrayList("AB", "BB");
		final List<String> actualCommonSubStrings = unit.getLongestCommonSubstring(s1, s2);
		
		Assert.assertEquals(expectedCommonSubStrings.size(), actualCommonSubStrings.size());
		verifyCommonSubStringsOrSubSequences(expectedCommonSubStrings, actualCommonSubStrings);
	}
	
	@Test
	public void shouldGetLongestCommonSubSequenceWhenTwoStringAreOfDifferentLength() {
		final String s1 = "abcdaf";
		final String s2 = "acbcf";
		
		final List<String> expectedCommonSubSequences = Lists.newArrayList("abcf");
		final List<String> actualCommonSubSequences = unit.getLongestCommonSubSequence(s1, s2);
		
		Assert.assertEquals(expectedCommonSubSequences.size(), actualCommonSubSequences.size());
		verifyCommonSubStringsOrSubSequences(expectedCommonSubSequences, actualCommonSubSequences);
	}
	

	private void verifyCommonSubStringsOrSubSequences(final List<String> expectedCommonSubStrings, final List<String> actualCommonSubStrings) {
		for (int i = 0; i < expectedCommonSubStrings.size(); i++) {
			Assert.assertEquals(expectedCommonSubStrings.get(i), actualCommonSubStrings.get(i));
		}
	}

	private void verify(final List<StringBuilder> expectedPaths, final List<StringBuilder> actualChangePaths) {
		for (int i = 0; i < expectedPaths.size(); i++) {
			Assert.assertEquals(expectedPaths.get(i).toString(), actualChangePaths.get(i).toString());
		}
	}
}
