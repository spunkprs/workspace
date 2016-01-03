package com.hackerrank.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class NumberList {

	private static Map<Integer, List<Integer>> map = Maps.newHashMap();
	private static int counter = 0;
	
	public static void main(String[] args) throws IOException {
		int arr[];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		final int numberOfTestCases = Integer.parseInt(input);
		for (int i = 0; i < numberOfTestCases; i++) {
			input = br.readLine();
			String in[] = input.split(" ");
			final int arrayLength = Integer.parseInt(in[0]);
			final int limit = Integer.parseInt(in[1]);
			arr = new int[arrayLength];
			input = br.readLine();
			in = input.split(" ");
			populateArray(arr, in);
			System.out.println(getCountOfNumbersGreaterThanLimit(arr, limit));
			counter = 0;
		}
	}

	private static int getCountOfNumbersGreaterThanLimit(int[] arr, int limit) {
		prepareMapOfSubArrays(arr, limit);
		return counter;
	}

	private static void prepareMapOfSubArrays(int[] arr, int limit) {
		for (int i = arr.length - 1; i >= 0; i--) {
			
			if (i == arr.length - 1) {
				map.put(i, getSubArrayAtPosition(arr, i));
			} else {
				
				if (isElementGreaterThanLimit(getNumberAtPosition(arr, i),  limit)) {
					counter++;
				}
				updateMapForPosition(arr, i, limit);
			}
		}
	}

	private static boolean isElementGreaterThanLimit(int numberAtPosition, int limit) {
		if (numberAtPosition > limit) {
			return true;
		}
		return false;
	}

	private static void updateMapForPosition(int arr[], int i, int limit) {
		final List<Integer> list = map.get(i + 1);
		incrementCounter(list, limit);
		compare(arr, i , i + 1);
		for (Integer integer : list) {
			final int num = map.get(i).get(0);
			if (num < integer) {
				map.get(i).add(integer);
			}
		}
	}

	private static void incrementCounter(List<Integer> list, final int limit) {
		for (Integer integer : list) {
			if (isElementGreaterThanLimit(integer, limit)) {
				counter++;
			}
		}
	}

	private static void compare(int[] arr, int i, int j) {
		final List<Integer> l = new ArrayList<Integer>(); 
		
		if (getNumberAtPosition(arr, i) >= getNumberAtPosition(arr, j)) {
			l.add(getNumberAtPosition(arr, i));
			map.put(i, l);
		} else {
			l.add(getNumberAtPosition(arr, j));
			map.put(i, l);
		}
	}

	private static int getNumberAtPosition(int[] arr, int i) {
		return arr[i];
	}

	private static void populateArray(int[] arr, String[] in) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(in[i]);
		}
	}
	
	private static List<Integer> getSubArrayAtPosition(final int arr[], int position) {
		final List<Integer> subArray = new ArrayList<Integer>();
		subArray.add(arr[position]);
		return subArray;
	}
}
