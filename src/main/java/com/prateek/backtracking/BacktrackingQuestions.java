package com.prateek.backtracking;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

public class BacktrackingQuestions {
	
	private int steps = Integer.MAX_VALUE;
	private List<String> paths = Lists.newArrayList();
	private List<String> combinations = Lists.newArrayList();
	private List<Integer[]> queenNonAttackingPositions = Lists.newArrayList();
	private Integer[] queenPositions;
	
	private Map<Integer, Boolean> exploredIndexesMap;
	private ListMultimap<Integer, Integer> colorToVertexMapping = ArrayListMultimap.create();
	private int numberOfColors = 1;
	
	public int solveGraphColoringProblem(final int[][] adjacencyMatrix) {
		exploredIndexesMap = Maps.newHashMap();
		for (int i = 0; i < adjacencyMatrix[0].length; i++) {
			assignColorsToGraphVertexes(i, adjacencyMatrix);
		}
		return numberOfColors;
	}
	
	private void assignColorsToGraphVertexes(final int vertex, final int[][] adjacencyMatrix) {
		if (!exploredIndexesMap.containsKey(vertex)) {
			exploredIndexesMap.put(vertex, true);
			assignColor(vertex, adjacencyMatrix);
			for (int adjacentVertex : getAdjacentVertexes(vertex, adjacencyMatrix)) {
				assignColorsToGraphVertexes(adjacentVertex, adjacencyMatrix);
			}
		}
	}

	private List<Integer> getAdjacentVertexes(final int vertex, final int[][] adjacencyMatrix) {
		final List<Integer> adjacentVertexes = Lists.newArrayList();
		for (int i = 0; i < adjacencyMatrix[0].length; i++) {
			if (adjacencyMatrix[vertex][i] != 0 && !exploredIndexesMap.containsKey(i)) {
				adjacentVertexes.add(i);
			}
		}
		return adjacentVertexes;
	}

	private void assignColor(final int vertex, final int[][] adjacencyMatrix) {
		boolean flag = false;
		for (int i = 0; i < numberOfColors; i++) {
			flag = false;
			if(colorToVertexMapping.isEmpty()) {
				colorToVertexMapping.put(i, vertex);
			} else {
				List<Integer> vertexesSharingSameColor = colorToVertexMapping.get(i);
				for (int vertexeSharingSameColor : vertexesSharingSameColor) {
					if (adjacencyMatrix[vertex][vertexeSharingSameColor] == 1) {
						flag = true;
						break;
					} 
				}
				if (!flag) {
						colorToVertexMapping.put(i, vertex);
						return;
				}
			}
		}
		updateNumberOfColors(flag, vertex);
	}

	private void updateNumberOfColors(final boolean flag, final int vertex) {
		if (flag) {
			numberOfColors = numberOfColors + 1;
			colorToVertexMapping.put(numberOfColors - 1, vertex);
		}
	}

	public List<Integer[]> solveNQueensProblem(final int[][] chessBoard) {
		queenPositions = new Integer[chessBoard[0].length]; 
		solveNQueen(chessBoard, 0);
		return queenNonAttackingPositions;
	}
	
	private void solveNQueen(final int[][] chessBoard, final int queenNumber) {
		if (queenNumber < chessBoard[0].length) {
			for (int i = 0; i < chessBoard[0].length; i++) {
				if (queenNumber == 0) {
					queenPositions[queenNumber] = i;
					solveNQueen(chessBoard, queenNumber + 1);
				} else {
					if (checkIsSafe(chessBoard, queenPositions, queenNumber, i)) {
						queenPositions[queenNumber] = i;
						solveNQueen(chessBoard, queenNumber + 1);
						boolean signal = publishResults(queenNumber, chessBoard[0].length);
						queenPositions = updateQueenPositions(signal, queenPositions);
					}
				}
			}
		}
	}

	private Integer[] updateQueenPositions(final boolean signal, final Integer[] queenPositions) {
		if (signal) {
			Integer [] updatedQueenPositions = new Integer[queenPositions.length];
			copyContents(updatedQueenPositions, queenPositions);
			return updatedQueenPositions;
		} 
		return queenPositions;
	}

	private void copyContents(final Integer[] updatedQueenPositions, final Integer[] queenPositions) {
		for (int i = 0; i < queenPositions.length; i++) {
			updatedQueenPositions[i] = queenPositions[i];
		}
	}

	private boolean publishResults(final int queenNumber, final int length) {
		boolean flag = false;
		if (queenNumber == length - 1) {
			queenNonAttackingPositions.add(queenPositions);
			flag = true;
		}
		return flag;
	}

	private boolean checkIsSafe(final int[][] chessBoard, final Integer[] queenPositions, final int queenNumber, final int currentQueenPosition) {
		for (int i = 0; i < queenNumber; i++) {
			final int difference = queenNumber - i;
			if (queenPositions[i] == currentQueenPosition || (queenPositions[i] == currentQueenPosition + difference) || (queenPositions[i] == currentQueenPosition - difference)) {
				return false;
			}
		}
		return true;
	}

	public List<String> ratInMazeProblemWithRestrictedApproach(final int [][] maze, final int sourceOne, final int sourceTwo, final int destinationOne, final int destinationTwo) {

		final Pair<Integer, Integer> source = new Pair<Integer, Integer>(sourceOne, sourceTwo, 1);
		final Pair<Integer, Integer> destination = new Pair<Integer, Integer>(destinationOne, destinationTwo, 1);
		String path = "";
		path = getPath(source, path);
		
		final List<Pair<Integer, Integer>> positiones = getPositionsUsingRestrictedApproach(maze, source);
		int stepsTaken = 0;
		for (Pair<Integer, Integer> p : positiones) {
		path = getPath(p, path);
		ratInMazeWithRestrictedApproach(maze, p, destination, stepsTaken + 1, path);
		}
		return paths;
	}
	
	public List<String> ratInMazeProblemWithNoRestrictedApproach(final int [][] maze, final int sourceOne, final int sourceTwo, final int destinationOne, final int destinationTwo) {
		final Pair<Integer, Integer> source = new Pair<Integer, Integer>(sourceOne, sourceTwo, 1);
		final Pair<Integer, Integer> destination = new Pair<Integer, Integer>(destinationOne, destinationTwo, 1);
		
		int stepsTaken = 0;
		String path = "";
		path = getPath(source, path);
		
		final Map<Pair<Integer, Integer>, Integer> map = Maps.newHashMap();
		ratInMazeWithNoRestrictedApproach(maze, source, destination, map, stepsTaken, path);
		return paths;
	}
	
	 private void ratInMazeWithNoRestrictedApproach(final int[][] maze, final Pair<Integer, Integer> source, final Pair<Integer, Integer> destination, final Map<Pair<Integer, Integer>, Integer> map, int steps, String path) {
		if (!source.equals(destination)) {
			map.put(source, 1);
			for (Pair<Integer, Integer> position : getPositionsUsingNoRestrictedApproach(maze, source, map)) {
				path = getPath(position, path);
				ratInMazeWithNoRestrictedApproach(maze, position, destination, map, steps + 1, path);
				map.remove(position);
				path = path.substring(0, path.length() - 2);
			}
		} else {
			updateMinSteps(steps, path);
		}
	}

	private List<Pair<Integer, Integer>> getPositionsUsingNoRestrictedApproach(final int[][] maze, final Pair<Integer, Integer> source, final Map<Pair<Integer, Integer>, Integer> map) {
		final List<Pair<Integer, Integer>> positions = Lists.newArrayList();
		
		Pair<Integer, Integer> positionOne = null;
		Pair<Integer, Integer> positionTwo = null;
		Pair<Integer, Integer> positionThree = null;
		Pair<Integer, Integer> positionFour = null;
		
		int row = source.getRow();
		int column = source.getColumn();
		
		if (column < maze[0].length - 1 && maze[row][column + 1] != 0) {
			positionOne = new Pair<Integer, Integer>(row, column + 1, maze[row][column + 1]);
			addPositionToPositions(positionOne, positions, map);
		} 
		
		if (column >= 1 && maze[row][column - 1] != 0) {
			positionTwo = new Pair<Integer, Integer>(row, column - 1, maze[row][column - 1]);
			addPositionToPositions(positionTwo, positions, map);
		}
		
		if (row < maze.length - 1 && maze[row + 1][column] != 0) {
			positionThree = new Pair<Integer, Integer>(row + 1, column, maze[row + 1][column]);
			addPositionToPositions(positionThree, positions, map);
		}
		
		if (row >= 1 && maze[row - 1][column] != 0) {
			positionFour = new Pair<Integer, Integer>(row - 1, column, maze[row - 1][column]);
			addPositionToPositions(positionFour, positions, map);
		}
		
		return positions;
	}

	private boolean isPresentInMap(final Pair<Integer, Integer> position, final Map<Pair<Integer, Integer>, Integer> map) {
		return map.containsKey(position) ? true : false;
	}
	
	private void addPositionToPositions(final Pair<Integer, Integer> position, final List<Pair<Integer, Integer>> positions, final Map<Pair<Integer, Integer>, Integer> map) {
		if (!isPresentInMap(position, map)) {
			positions.add(position);
		}
	}
	
	private String getPath(final Pair<Integer, Integer> source, String path) {
		path += String.valueOf(source.getRow());
		path += String.valueOf(source.getColumn());
		return path;
	}

	private void updateMinSteps(final int stepsTaken, final String path) {
		 if (stepsTaken < steps) {
			 steps = stepsTaken;
			 paths = Lists.newArrayList();
			 paths.add(path);
		 } else if (stepsTaken == steps) {
			 paths.add(path);
		 }
	}

	private void ratInMazeWithRestrictedApproach(final int[][] maze, final Pair<Integer, Integer> source, final Pair<Integer, Integer> destination, int steps, String path) {
		if (source.equals(destination)) {
			updateMinSteps(steps, path);
			path = path.substring(0, path.length() - 2);
			return;
		} else {
			for (Pair<Integer, Integer> p : getPositionsUsingRestrictedApproach(maze, source)) {
					path = getPath(p, path);
					ratInMazeWithRestrictedApproach(maze, p, destination, steps + 1, path);
					path = path.substring(0, path.length() - 2);
			}
		}
	}

	private List<Pair<Integer, Integer>> getPositionsUsingRestrictedApproach(final int[][] maze, final Pair<Integer, Integer> source) {
		final List<Pair<Integer, Integer>> positions = Lists.newArrayList();
		
		Pair<Integer, Integer> positionOne = null;
		Pair<Integer, Integer> positionTwo = null;
		
		int row = source.getRow();
		int column = source.getColumn();
		if (column < maze[0].length - 1 && maze[row][column + 1] != 0) {
			positionOne = new Pair<Integer, Integer>(row, column + 1, maze[row][column + 1]);
			positions.add(positionOne);
		} 
		if (row < maze.length - 1 && maze[row + 1][column] != 0) {
			positionTwo = new Pair<Integer, Integer>(row + 1, column, maze[row + 1][column]);
			positions.add(positionTwo);
		}
		return positions;
	}
	
	public List<String> getCombinations(final char arr[], final int n) {
		List<String> result = Lists.newArrayList();
		if (n > arr.length) {
			return result;
		} else if (n == arr.length) {
			return Lists.newArrayList(prepareResult(arr));
		} else {
			prepareCombinations(arr, n, "", 0);
			return combinations;
		}
	}

	private void prepareCombinations(final char[] arr, final int n, String str, final int startPosition) {
		if (n != 0) {
			for (int i = startPosition; i <= arr.length - n; i++) {
				str += String.valueOf(arr[i]);
				prepareCombinations(arr, n - 1, str, i + 1);
				str = str.substring(0, str.length() - 1);
			}
		} else {
			combinations.add(str);
		}
	}

	private String prepareResult(final char[] arr) {
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			result += String.valueOf(arr[i]);
		}
		return result;
	}

	public List<String> divideArrayInToTwoHalvesSuchThatTheirDifferenceIsMinimum(final int arr[]) {
		return Lists.newArrayList();
	}
	
	private static class Pair<L, R> {
		
		@BusinessKey private L row;
		@BusinessKey private R column;
		private int value;
		
		Pair(final L row, final R column, final int value) {
			this.row = row;
			this.column = column;
			this.value = value;
		}
		
		@Override
		public boolean equals(final Object obj) {
			final Pair<L, R> pair = (Pair<L, R>)obj;
			return BusinessIdentity.areEqual(this, pair);
		}
		
		@Override
		public int hashCode() {
			return BusinessIdentity.getHashCode(this);
		}
		
		public L getRow() {
			return this.row;
		}
		
		public R getColumn() {
			return this.column;
		}
	}
}
