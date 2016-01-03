package com.prateek.backtracking;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class BacktrackingQuestionsTest {
	
	private BacktrackingQuestions unit;
	
	@Before
	public void setUp() {
		unit = new BacktrackingQuestions();
	}
	
	@Test
	public void shouldReturnNumberOfColorsRequiredToColorAGraph() {
		final int [][] adjacencyMatrix = {{0, 1, 0, 1, 1}, {1, 0, 1, 0, 1}, {0, 1, 0, 1, 1}, {1, 0, 1, 0, 1}, {1, 1, 1, 1, 0}}; 
		
		Assert.assertEquals(3, unit.solveGraphColoringProblem(adjacencyMatrix));
	}
	
	@Test
	public void shouldReturnNumberOfColorsRequiredToColorAGraphWhenNumberOfVertexAreThree() {
		final int [][] adjacencyMatrix = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}; 
		
		//Execute
		Assert.assertEquals(3, unit.solveGraphColoringProblem(adjacencyMatrix));
	}
	
	@Test
	public void shouldReturnNumberOfColorsRequiredToColorGraphWhenNoneOfTheVertexesAreConnected() {
		final int [][] adjacencyMatrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}; 
		
		//Execute
		Assert.assertEquals(1, unit.solveGraphColoringProblem(adjacencyMatrix));
	}
	
	@Test
	public void shouldGetNQueensNonAttackingPositionsWhenChessBoardIsOfSizeFourCrossFour() {
		//Set Up
		int chessBoard[][] = new int[4][4];
		
		final Integer positionOne[] = {1, 3, 0, 2};
		final Integer positionTwo[] = {2, 0, 3, 1};
		final List<Integer[]> expectedNonAttackingPositions = Lists.newArrayList(positionOne, positionTwo);
		
		//Execute
		final List<Integer[]> nonAttackingPositions = unit.solveNQueensProblem(chessBoard);
		
		//Verify
		Assert.assertEquals(expectedNonAttackingPositions.size(), nonAttackingPositions.size());
		verifyPositions(expectedNonAttackingPositions, nonAttackingPositions);
	}
	
	@Test
	public void shouldGetNQueensNonAttackingPositionsWhenChessBoardIsOfSizeEightCrossEight() {
		//Set Up
		int chessBoard[][] = new int[8][8];
		
		//Execute
		final List<Integer[]> nonAttackingPositions = unit.solveNQueensProblem(chessBoard);
		
		//Verify
		Assert.assertEquals(92, nonAttackingPositions.size());
	}
	
	@Test
	public void shouldNotGetNQueensNonAttackingPositionsWhenChessBoardIsOfSizeThreeCrossThree() {
		//Set Up
		int chessBoard[][] = new int[3][3];
		
		//Execute
		final List<Integer[]> nonAttackingPositions = unit.solveNQueensProblem(chessBoard);
		
		//Verify
		Assert.assertEquals(0, nonAttackingPositions.size());
	}
	
	private void verifyPositions(final List<Integer[]> expectedNonAttackingPositions, final List<Integer[]> nonAttackingPositions) {
		for (int i = 0; i < expectedNonAttackingPositions.size(); i++) {
			for (int j = 0; j < expectedNonAttackingPositions.get(i).length; j++) {
				Assert.assertEquals(expectedNonAttackingPositions.get(i)[j], nonAttackingPositions.get(i)[j]);
			}
		}
	}

	@Test
	public void shouldGetMinimumNumberOfStepsForAMouseToReachDestinationInTheMazeCaseOne() {
		//Set Up
		int maze[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}};
		
		//Execute && Verify
		final List<String> expectedPaths = Lists.newArrayList("00101121222333", "00101121223233", "00101121313233");
		final List<String> actualPaths = unit.ratInMazeProblemWithRestrictedApproach(maze, 0, 0, 3, 3);
		
		Assert.assertEquals(expectedPaths.size(), actualPaths.size());
		verify(expectedPaths, actualPaths);
	}
	
	@Test
	public void shoulgGetPathWithMinimumStepsWhenMouseCanMoveWithNoRestrictionsCaseOne() {
		//Set Up
		int maze[][] = {{1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {1, 0, 0, 1, 1}, {1, 0, 0, 1, 0}, {1, 0, 0, 1, 1}};
		
		//Execute && Verify
		final List<String> expectedPaths = Lists.newArrayList("00101112020304142423334344");
		final List<String> actualPaths = unit.ratInMazeProblemWithNoRestrictedApproach(maze, 0, 0, 4, 4);
		
		Assert.assertEquals(expectedPaths.size(), actualPaths.size());
		verify(expectedPaths, actualPaths);
	}
	
	@Test
	public void shoulgGetPathWithMinimumStepsWhenMouseCanMoveWithNoRestrictionsCaseTwo() {
		//Set Up
		int maze[][] = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 1}};
		
		//Execute && Verify
		//final List<String> expectedPaths = Lists.newArrayList("00101112020304142423334344");
		final List<String> actualPaths = unit.ratInMazeProblemWithNoRestrictedApproach(maze, 0, 0, 3, 3);
		Assert.assertEquals(7, actualPaths.size());
	}
	
	private void verify(final List<String> expectedPaths, final List<String> actualPaths) {
		for (int i = 0; i < expectedPaths.size(); i++) {
			Assert.assertEquals(expectedPaths.get(i), actualPaths.get(i));
		}
	}
	
	@Test
	public void shouldGetAllPossibleCombinationsCaseOne() {
		//Set Up
		final String str = RandomStringUtils.randomAlphanumeric(6);
		int r = 4;
		
		int numberOfCombinations = new NumberOfCombinations().getNumberOfCombinations(str.length(), r);
		
		//Execute
		final List<String> combinations = unit.getCombinations(str.toCharArray(), r);
		
		//Verify
		Assert.assertEquals(numberOfCombinations, combinations.size());
	}

	@Test
	public void shouldGetAllPossibleCombinationsCaseTwo() {
		//Set Up
		final String str = "abcd";
		int r = 3;
		
		int numberOfCombinations = new NumberOfCombinations().getNumberOfCombinations(str.length(), r);
		final List<String> expectedCombinations = Lists.newArrayList("abc", "abd", "acd", "bcd");
		
		//Execute
		final List<String> actualCombinations = unit.getCombinations(str.toCharArray(), r);
		
		//Verify
		Assert.assertEquals(numberOfCombinations, actualCombinations.size());
		verifyCombinations(expectedCombinations, actualCombinations);
	}
	
	@Test
	public void shouldGetNoCombinationsWhenAskedLengthIsGreaterThanLengthOfOriginalSet() {
		//Set Up
		final String str = "abcd";
		int r = 6;
		
		//Execute && Verify
		final List<String> actualCombinations = unit.getCombinations(str.toCharArray(), r);
		Assert.assertEquals(0, actualCombinations.size());
	}
	
	@Test
	public void shouldGetSingleCombinationWhenAskedLengthIsEqualToLengthOfOriginalSet() {
		//Set Up
		final String str = "abcd";
		int r = 4;
		
		//Execute && Verify
		final List<String> actualCombinations = unit.getCombinations(str.toCharArray(), r);
		Assert.assertEquals(1, actualCombinations.size());
		verify(Lists.newArrayList("abcd"), actualCombinations);
	}
	
	private void verifyCombinations(final List<String> expectedCombinations, final List<String> actualCombinations) {
		for (int i = 0; i < expectedCombinations.size(); i++) {
			Assert.assertEquals(expectedCombinations.get(i), actualCombinations.get(i));
		}
	}

	private static class NumberOfCombinations {
		
		private int getNumberOfCombinations(final int n, final int r) {
			int numberOfCombinations = getFactorial(n)/(getFactorial(n - r) * getFactorial(r));
			return numberOfCombinations;
		}
		
		private int getFactorial(final int n) {
			int factorial = n;
			if (n == 1) {
				return 1;
			} else {
				factorial = factorial * getFactorial(n - 1);
				return factorial;
			}
		}
	}
	
}
