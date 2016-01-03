package com.hackerrank.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class NumberListOne {

	private static Map<Integer, List<List<Integer>>> map = Maps.newHashMap();
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
		for (int i = arr.length - 1 ; i >= 0; i--) {
			if (i == arr.length - 1) {
				map.put(i, getSubArrayAtPosition(arr, i));
				if (arr[i] > limit) {
					counter++;
				}
			} else {
				if (arr[i] > limit) {
					counter++;
				}
				updateMapForPosition(arr, i, limit);
			}
		}
	}

	private static void updateMapForPosition(int[] arr, int i, int limit) {
		final List<List<Integer>> lists = map.get(i + 1);
		final List<Integer> list = new ArrayList<Integer>();
		list.add(arr[i]);
		lists.add(list);
		for (int j = 0; j < lists.size() - 1; j++) {
			lists.get(j).add(arr[i]);
			if (lists.get(j).size() > 1) {
				if (getMaximumNumberFromList(lists.get(j)) > limit) {
					counter++;
				}
			} 
		}
		map.put(i, lists);
	}

	private static int getMaximumNumberFromList(List<Integer> list) {
		Heapify heapify = new Heapify();
		return heapify.getMaxNumberFromHeap(list);
	}

	private static List<List<Integer>> getSubArrayAtPosition(int[] arr, int position) {
		final List<List<Integer>> lists = new ArrayList<List<Integer>>();
		final List<Integer> subArray = new ArrayList<Integer>();
		subArray.add(arr[position]);
		lists.add(subArray);
		return lists;
	}

	private static void populateArray(int[] arr, String[] in) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(in[i]);
		}
	}
	
	static class Heapify {
		private int getMaxNumberFromHeap(final List<Integer> list) {
			int indexOne = list.size() - 1; 
			int indexTwo = indexOne - 1;
			int parentOne = getParent(indexOne);
			int parentTwo = getParent(indexTwo);
			int parent = 0;
			
			if (isParentSame(parentOne, parentTwo)) {
				 parent = parentTwo;
			 } else {
				 parent = parentOne;
				 shuffle(parent, indexOne, list);
				 indexOne = indexTwo;
				 indexTwo = indexTwo - 1;
				 parent = getParent(indexOne);
			 }
			
			 while(indexOne != 0) {
				 
				 if (isShufflingRequired(parent, indexOne, indexTwo, list)) {
					 if (list.get(indexOne) >= list.get(indexTwo)) {
						 swap(indexOne, parent, list);
					 } else {
						 swap(indexTwo, parent, list);
					 }
				 }
				 indexOne-= 2;
				 indexTwo-= 2;
				 parent = getParent(indexOne);
		 }
			return list.get(0);
		}
		
		private boolean isShufflingRequired(int parent, int indexOne, int indexTwo, List<Integer> list) {
			if (list.get(parent) < list.get(indexOne) || list.get(parent) < list.get(indexTwo)) {
				return true;
			}
			return false;
		}

		private int getParent(int index) {
			if (index == 0) {
				return -1;
			}
			return (index - 1) / 2;
		}
		
		private boolean isParentSame(final int parentOne, final int parentTwo) {
			return parentOne == parentTwo ? true : false;
		}
		
		private void shuffle(int parent, int indexOne, List<Integer> list) {
			if (list.get(parent) < list.get(indexOne)) {
				swap(indexOne, parent, list);
			}
		}

		private void swap(int indexOne, int indexTwo, List<Integer> list) {
			list.set(indexOne, list.get(indexOne) ^ list.get(indexTwo));
			list.set(indexTwo, list.get(indexOne) ^ list.get(indexTwo));
			list.set(indexOne, list.get(indexOne) ^ list.get(indexTwo));
		}
	}
}
