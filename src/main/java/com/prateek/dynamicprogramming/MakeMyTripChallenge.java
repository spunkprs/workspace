package com.prateek.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeMyTripChallenge {

private static int maximumNumberOfMoves = 0;
	
	public static int maximumNumberOfMovesForWitch(final int arr[]) {
		maximumNumberOfMoves(arr, 0);
		return maximumNumberOfMoves;
	}

	private static void maximumNumberOfMoves(int[] arr, int moves) {
		for (int i = 0; i < 2 ; i++) {
			final List<Integer> heights = getHeightsBetweenTwoPositions(arr, i);
			for (int height : heights) {
				if (i == 0) {
					arr[0] = height;
					Arrays.sort(arr);
					maximumNumberOfMoves(arr, moves + 1);
				} else {
					arr[arr.length - 1] = height;
					Arrays.sort(arr);
					maximumNumberOfMoves(arr, moves + 1);
				}
			}
			if (heights.isEmpty()) {
				updateMaximumNumberOfMoves(moves);
			}
		}
	}

	private static void updateMaximumNumberOfMoves(final int moves) {
		if (moves > maximumNumberOfMoves) {
			maximumNumberOfMoves = moves;
		}
	}

	private static List<Integer> getHeightsBetweenTwoPositions(final int[] arr, final int indexOfPrisoner) {
		List<Integer> heights = new ArrayList<Integer>();
		if (indexOfPrisoner == 0) {
			heights = getHeights(arr, arr[1], arr[arr.length - 1]);
		} else {
			heights = getHeights(arr, arr[0], arr[1]);
		}
		return heights;
	}

	private static List<Integer> getHeights(final int[] arr, final int heightOne, int heightTwo) {
		final List<Integer> heights = new ArrayList<Integer>();
		for (int i = heightOne + 1; i < heightTwo; i++) {
			heights.add(i);
		}
		return heights;
	}
	
	public static void main(final String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
        int numberOfTestCases = Integer.parseInt(line);
        
        for (int i = 0; i < numberOfTestCases; i++) {
        	line = br.readLine();
        	final String input[] = line.split(" ");
        	final int arr[] = convertToInputArray(input);
        	System.out.println(maximumNumberOfMovesForWitch(arr));
        }
	}

	/*
	private static void checkConcept(int[] array, int i) {
		if (i < array.length) {
			array[i] = 10;
			Arrays.sort(array);
			System.out.println(array);
			checkConcept(array, i + 1);
		}
	}
	*/

	private static int[] convertToInputArray(final String[] input) {
		final int arr[] = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		return arr;
	}
}
