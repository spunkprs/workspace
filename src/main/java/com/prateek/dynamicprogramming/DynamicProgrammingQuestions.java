package com.prateek.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

public class DynamicProgrammingQuestions {

	private Map<String, Integer> xorToMovesMap = new HashMap<String, Integer>();
	private int max_moves = 0;
	private Map<Pair<Integer, Integer>, Pair<Integer, String>> map = Maps.newHashMap();
	private Map<Integer, List<StringBuilder>> changeMap = Maps.newHashMap();
	private Map<Integer, Integer> fibonacciMap = Maps.newHashMap();
	private int minimumDistance = -1;
	private Map<Integer, List<Integer>> lisMap = new HashMap<Integer, List<Integer>>();
	private List<Integer> longestIncreasingSubsequence = Lists.newArrayList();
	
	public List<Integer> getLongestIncreasingSubSequence(final int arr[]) {
		prepareLongestIncreasingSubsequence(arr, 0);
		return longestIncreasingSubsequence;
	}
	
	private void prepareLongestIncreasingSubsequence(final int[] arr, int currentIndex) {
				if (!lisMap.containsKey(arr[currentIndex])) {
					final List<Integer> childIndexes = getChildrenIndexes(currentIndex, arr);
					for (int childIndex : childIndexes) {
						prepareLongestIncreasingSubsequence(arr, childIndex);
						final List<Integer> list = lisMap.get(arr[childIndex]);
						lisMap.put(arr[currentIndex], prepareListForParent(list, arr[currentIndex]));
						computeLongestIncreasingSubSequence(lisMap.get(arr[currentIndex]));
					}
					if (childIndexes.isEmpty()) {
						List<Integer> list = Lists.newArrayList(arr[currentIndex]);
						lisMap.put(arr[currentIndex], list);
						computeLongestIncreasingSubSequence(list);
					}
				} 
	}

	private void computeLongestIncreasingSubSequence(final List<Integer> sequence) {
		if (sequence.size() > longestIncreasingSubsequence.size()) {
			longestIncreasingSubsequence = sequence;
		}
	}

	private List<Integer> prepareListForParent(final List<Integer> list, final int parentElement) {
		List<Integer> lisForParent = null;
		if (!lisMap.containsKey(parentElement)) {
			lisForParent = createLISForParent(lisForParent, list, parentElement);
		} else {
			final List<Integer> existingLISForParent = lisMap.get(parentElement);
			if (existingLISForParent.size() - 1 < list.size()) {
				lisForParent = createLISForParent(existingLISForParent, list, parentElement);
			}
			lisForParent = existingLISForParent;
		}
		return lisForParent;
	}
	
	private List<Integer> createLISForParent(List<Integer> lisForParent, List<Integer> list, int parentElement) {
		lisForParent = Lists.newArrayList(list);
		lisForParent.add(parentElement);
		return lisForParent;
	}

	private List<Integer> getChildrenIndexes(final int currentIndex, final int[] arr) {
		final List<Integer> children = new ArrayList<Integer>();
		for (int i = currentIndex + 1; i < arr.length; i++) {
			if (arr[currentIndex] <= arr[i]) {
				children.add(i);
			}
		}
		return children;
	}

	public List<String> getLongestCommonSubSequence(final String str1, final String str2) {
		final int [][] table;
		List<Pair<Integer, Integer>> positions = Lists.newArrayList();
		if (str1.length() >= str2.length()) {
			table = new int[str1.length() + 1][str2.length() + 1];
			processTableForFindingLongestCommonSubSequence(table, str1.toCharArray(), str2.toCharArray());
			positions = getPositionsForMaxNumber(table, getMaxNumberFromTable(table, str1.length(), str2.length()), str1.length(), str2.length());
			return prepareCommonSubSequences(table, positions, str2.toCharArray());
		} else {
			table = new int[str2.length() + 1][str1.length() + 1];
			processTableForFindingLongestCommonSubSequence(table, str2.toCharArray(), str1.toCharArray());
			positions = getPositionsForMaxNumber(table, getMaxNumberFromTable(table, str2.length(), str1.length()), str2.length(), str1.length());
			return prepareCommonSubSequences(table, positions, str1.toCharArray());
		}
	}
	
	private List<String> prepareCommonSubSequences(final int[][] table, final List<Pair<Integer, Integer>> positions, final char[] arr) {
		final List<String> subSequences = Lists.newArrayList();
		for (Pair<Integer, Integer> p : positions) {
			subSequences.add(getCommonSubSequence(p, table, arr));
		}
		return subSequences;
	}

	private String getCommonSubSequence(final Pair<Integer, Integer> p, final int[][] table, final char[] arr) {
		 int row = p.getL();
		 int column = p.getR();
		 String st = "";
		 
		 while (row >= 0 && column >= 0 && table[row][column] != 0) {
			 if (table[row][column - 1] == table[row - 1][column]) {
				 st = arr[column - 1] + st;
				 row--;
				 column--;
			 } else {
				 if (table[row][column - 1] < table[row - 1][column]) {
					 row--;
				 } else {
					 column--;
				 }
			 }
		 }
		 return st;
	}

	private void processTableForFindingLongestCommonSubSequence(final int[][] table, final char[] str1, final char[] str2) {
		for (int i = 0; i < str1.length; i++) {
			for (int j = 0; j < str2.length; j++) {
				if (str1[i] == str2[j]) {
					table[i + 1][j + 1] = table[i][j] + 1;
				} else {
					table[i + 1][j + 1] = getMax(table[i + 1][j], table[i][j + 1]);
				}
			}
		}
	}

	private int getMax(final int a, final int b) {
		return (a >= b) ? a : b;
	}

	public List<String> getLongestCommonSubstring(final String str1, final String str2) {
		final int [][] table;
		List<Pair<Integer, Integer>> positions = Lists.newArrayList();
		if (str1.length() >= str2.length()) {
			table = new int[str1.length() + 1][str2.length() + 1];
			processTableForFindingCommonSubString(table, str1.toCharArray(), str2.toCharArray());
			positions = getPositionsForMaxNumber(table, getMaxNumberFromTable(table, str1.length(), str2.length()), str1.length(), str2.length());
			return prepareCommonSubStrings(positions, str2.toCharArray(), table);
		} else {
			table = new int[str2.length() + 1][str1.length() + 1];
			processTableForFindingCommonSubString(table, str2.toCharArray(), str1.toCharArray());
			positions = getPositionsForMaxNumber(table, getMaxNumberFromTable(table, str2.length(), str1.length()), str2.length(), str1.length());
			return prepareCommonSubStrings(positions, str1.toCharArray(), table);
		}
	}
	
	private List<String> prepareCommonSubStrings(final List<Pair<Integer, Integer>> positions, final char[] arr, final int [][] table) {
		final List<String> commonSubStrings = Lists.newArrayList();
		for (Pair<Integer, Integer> position : positions) {
			commonSubStrings.add(getCommonSubStrings(position, arr, table));
		}
		return commonSubStrings;
	}

	private String getCommonSubStrings(final Pair<Integer, Integer> position, final char[] arr, final int [][] table) {
		String st = "";
		int row = position.getL();
		int column = position.getR();
		
		while (0 <= row && 0 <= column && table[row][column] != 0) {
			st = arr[column - 1] + st;
			row--;
			column--;
		}
		return st;
	}

	private List<Pair<Integer, Integer>> getPositionsForMaxNumber(final int[][] table, final int maxNumber, final int row, final int column) {
		final List<Pair<Integer, Integer>> positions = Lists.newArrayList();
		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= column; j++) {
				if (table[i][j] == maxNumber) {
					Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i, j);
					positions.add(pair);
				}
			}
		}
		return positions;
	}

	private int getMaxNumberFromTable(final int[][] table, final int row, final int column) {
		int max = 0;
		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= column; j++) {
				if (table[i][j] > max) {
					max = table[i][j];
				}
			}
		}
		return max;
	}

	private void processTableForFindingCommonSubString(final int[][] table, final char str1[], final char str2[]) {
		for (int i = 0; i < str1.length; i++) {
			for (int j = 0; j < str2.length; j++) {
				if (str1[i] == str2[j]) {
					table[i + 1][j + 1] = table[i][j] + 1;
				}
			}
		}
	}

	public int getFibonacciSum(final int n) {
		return getSum(n);
	}
	
	private int getSum(final int n) {
		int sum = 0;
		if (n == 0) {
			return n;
		} else if (n == 1) {
			return n;
		} else {
			sum += process(sum, n - 2);
			sum = process(sum, n - 1);
			return sum;
		}
	}
	
	private int process(final int sum, final int num) {
		int n1 = 0;
		if (!fibonacciMap.containsKey(num)) {
			n1 = getSum(num);
			fibonacciMap.put(num , n1);
			return sum + n1;
		} else {
			return sum + fibonacciMap.get(num);
		}
	}

	public List<StringBuilder> getPossibleWaysOfGettingTheChange(final int amount, final int maxDenomination) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(amount));
		return getPossibleWaysToGetTheChange(amount, maxDenomination, sb);
	}
	
	private List<StringBuilder> getPossibleWaysToGetTheChange(final int amount, final int maxDenomination, final StringBuilder path) {
		List<StringBuilder> changePaths = Lists.newArrayList();
		if (amount == 0) {
			return Lists.newArrayList(path);
		} else {
			if (!changeMap.containsKey(amount)) {
				for (int i = 1; i <= maxDenomination && i <= amount; i++) {
					StringBuilder sb = new StringBuilder();
					sb.append("->" + String.valueOf(i));
					changePaths.addAll(getPossibleWaysToGetTheChange(amount - i, maxDenomination, sb));
				}
				changeMap.put(amount, changePaths);
				changePaths = appendPath(changePaths, path);
				return changePaths;
			} else {
				changePaths = appendPath(changeMap.get(amount), path);
				return changePaths;
			}
		}
	}

	private List<StringBuilder> appendPath(final List<StringBuilder> changePaths, final StringBuilder path) {
		List<StringBuilder> paths = Lists.newArrayList();
		for (int i = 0; i < changePaths.size(); i++) {
			paths.add(new StringBuilder().append(path.toString() + changePaths.get(i).toString()));
		}
		return paths;
	}
	
	public int getMinimumCostPathWithoutDP(final int arr[][], int destinationX, final int destinationY) {
		final Pair<Integer, Integer> origin = new Pair<Integer, Integer>(0, 0);
		getPathWithoutDP(origin, destinationX, destinationY, arr, arr[origin.getL()][origin.getR()]);
		return minimumDistance;
	}

	private void getPathWithoutDP(final Pair<Integer, Integer> origin, int destinationX, int destinationY, final int arr[][], final int pathSum) {
		for (Pair<Integer, Integer> child : getChildIndexes(origin, arr, destinationX, destinationY, pathSum)) {
			getPathWithoutDP(child, destinationX, destinationY, arr, pathSum + arr[child.getL()][child.getR()]);
		}
	}

	private List<Pair<Integer, Integer>> getChildIndexes(final Pair<Integer, Integer> pair, final int arr[][], int destinationX, int destinationY, final int pathSum) {
		final List<Pair<Integer, Integer>> children = new ArrayList<Pair<Integer,Integer>>();
		int currentX = pair.getL();
		int currentY = pair.getR();
		int sumOfPath = pathSum;
		if (currentX != destinationX && currentY != destinationY) {
			if (currentY < arr[0].length - 1) {
				children.add(new Pair<Integer, Integer>(currentX, currentY + 1));
			} 
			if (currentX < arr.length - 1) {
				children.add(new Pair<Integer, Integer>(currentX + 1, currentY));
			}
			if (currentX < arr.length - 1 && currentY < arr[0].length - 1) {
				children.add(new Pair<Integer, Integer>(currentX + 1, currentY + 1));
			}
		} else {
			sumOfPath = sumOfPath + arr[destinationX][destinationY];
			updateMinimumDistance(sumOfPath);
		}
		return children;
	}

	private void updateMinimumDistance(final int sumOfPath) {
		if (minimumDistance == -1) {
			minimumDistance = sumOfPath;
		} else if (minimumDistance > sumOfPath) {
			minimumDistance = sumOfPath;
		}
	}

	public Pair<Integer, String> getMinimumCostPath(final int arr[][], final int destinationX, final int destinationY) {
		return getPath(arr, 0, 0, destinationX, destinationY);
	}
	
	private Pair<Integer, String> getPath(final int[][] arr, final int startX, final int startY, final int destinationX, final int destinationY) {
		final List<Pair<Integer, String>> listOfPossibleChoices = new ArrayList<DynamicProgrammingQuestions.Pair<Integer,String>>();
		
		final Pair<Integer, Integer> source = new Pair<Integer, Integer>(startX, startY);
		if (source.getL() == destinationX && source.getR() == destinationY) {
			return new Pair<Integer, String>(arr[destinationX][destinationY], getStringToBeStored(destinationX, destinationY));
		} else {
			for (Pair<Integer, Integer> p : getChildIndexes(arr, startX, startY, destinationX, destinationY)) {
				if (!map.containsKey(p)) {
					map.put(p, getPath(arr, p.getL(), p.getR(), destinationX, destinationY));
					listOfPossibleChoices.add(map.get(p));
				} else {
					listOfPossibleChoices.add(map.get(p));
				}
		}
		}
		final Pair<Integer, String> bestPair = getBestChoice(listOfPossibleChoices);
		map.put(source, new Pair<Integer, String>(arr[startX][startY] + bestPair.getL(), getStringToBeStored(startX, startY) + bestPair.getR()));
		return map.get(source);
	}

	private Pair<Integer, String> getBestChoice(final List<Pair<Integer, String>> listOfPossibleChoices) {
		int a = 0;
		Pair<Integer, String> p = null;
		if (listOfPossibleChoices.size() == 1) {
			return listOfPossibleChoices.get(0);
		} else if (listOfPossibleChoices.size() == 2) {
			a = listOfPossibleChoices.get(0).getL();
			if (a >= listOfPossibleChoices.get(1).getL()) {
				return listOfPossibleChoices.get(1);
			} else {
				return listOfPossibleChoices.get(0);
			}
		} else {
			p = listOfPossibleChoices.get(0);
			for (int i = 1; i < listOfPossibleChoices.size(); i++) {
				if (p.getL() >= listOfPossibleChoices.get(i).getL()) {
					p = listOfPossibleChoices.get(i);
				}
			}
			return p;
		}
	}

	private String getStringToBeStored(final int destinationX, final int destinationY) {
		if (destinationX == 0 && destinationY == 0) {
			return String.valueOf(destinationX) + String.valueOf(destinationY);
		}
		return "->" + String.valueOf(destinationX) + String.valueOf(destinationY);
	}

	private List<Pair<Integer, Integer>> getChildIndexes(final int[][] arr, final int startX, final int startY, final int destinationX, final int destinationY) {
		final List<Pair<Integer, Integer>> childIndexes = Lists.newArrayList();
		if (startX < destinationX) {
			final Pair<Integer, Integer> p1 = new Pair<Integer, Integer>(startX + 1, startY);
			childIndexes.add(p1);
		}
		
		if (startY < destinationY) {
			final Pair<Integer, Integer> p2 = new Pair<Integer, Integer>(startX, startY + 1);
			childIndexes.add(p2);
		}
		
		if ((startX < destinationX) && (startY < destinationY)) {
			final Pair<Integer, Integer> p3 = new Pair<Integer, Integer>(startX + 1, startY + 1);
			childIndexes.add(p3);
		}
		return childIndexes;
	}

	public int maximumNumberOfMovesForWitch(final int arr[]) {
		 maximumNumberOfMoves(arr, 0);
		 return max_moves;
	}

	private int maximumNumberOfMoves(int[] arr, int moves) {
		String childString = "";
		String parentString = "";
		final List<Integer> movesList = new ArrayList<Integer>();
		List<Integer> heights = new ArrayList<Integer>();
		for (int i = 0; i < 2 ; i++) {
			heights = getHeightsBetweenTwoPositions(arr, i);
			for (int height : heights) {
				if (i == 0) {
					int childArray[] = copyContents(arr, 0, height);
					childString = convertElementsToString(childArray);
					moves = processAndCalculateMoves(childString, childArray, moves) + 1;
					movesList.add(moves);
				} else {
					int childArray[] = copyContents(arr, arr.length - 1, height);
					childString = convertElementsToString(childArray);
					moves = processAndCalculateMoves(childString, childArray, moves) + 1;
					movesList.add(moves);
				}
			}
		}
		parentString = convertElementsToString(arr);
		moves = getMaximumOfMovesList(movesList);
		updateMaxMoves(moves);
		xorToMovesMap.put(parentString, moves);
		return moves;
	}
	
	private Integer getMaximumOfMovesList(final List<Integer> movesList) {
		int a = 0;
		int b = 0;
		if (!movesList.isEmpty()) {
			if (movesList.size() == 1) {
				return movesList.get(0);
			} else if (movesList.size() == 2) {
				a = movesList.get(0);
				b = movesList.get(1);
				return a >= b ? a : b; 
			} else {
				a = movesList.get(0);
				for (int i = 1; i < movesList.size(); i++) {
					a = a >= movesList.get(i) ? a : movesList.get(i);
				}
				return a;
			}
		} else {
			return 0;
		}
	}

	private int processAndCalculateMoves(final String childString, final int childArray[], int moves) {
		if (xorToMovesMap.containsKey(childString)) {
			moves = xorToMovesMap.get(childString);
		} else {
			moves = maximumNumberOfMoves(childArray, moves);
		}
		return moves;
	}

	private void updateMaxMoves(final int moves) {
		if (max_moves < moves) {
			max_moves = moves;
		}
	}

	private int[] copyContents(final int[] arr, final int index, int height) {
		final int array[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			array[i] = arr[i];
		}
		array[index] = height;
		Arrays.sort(array);
		return array;
	}

	private String convertElementsToString(int[] arr) {
		String s = "";
		for (int i : arr) {
			s += String.valueOf(i);
		}
		return s;
	}

	private List<Integer> getHeightsBetweenTwoPositions(final int[] arr, final int indexOfPrisoner) {
		List<Integer> heights = Lists.newArrayList();
		if (indexOfPrisoner == 0) {
			heights = getHeights(arr, arr[1], arr[arr.length - 1]);
		} else {
			heights = getHeights(arr, arr[0], arr[1]);
		}
		return heights;
	}

	private List<Integer> getHeights(final int[] arr, final int heightOne, int heightTwo) {
		final List<Integer> heights = Lists.newArrayList();
		for (int i = heightOne + 1; i < heightTwo; i++) {
			heights.add(i);
		}
		return heights;
	}
	
	static class Pair<L, R> {
		@BusinessKey private L l;
		@BusinessKey private R r;
		
		private Pair(final L a, final R b) {
			this.l = a;
			this.r = b;
		}
		
		public L getL() {
			return this.l;
		}
		
		public R getR() {
			return this.r;
		}
		
		public int hashCode() {
			return BusinessIdentity.getHashCode(this);
		}
		
		public boolean equals(final Object obj) {
			return BusinessIdentity.areEqual(this, obj);
		}
	}
}
