package com.prateek.Arrays;

public class BubbleSort {

	public static int[] sortInAscendingOrder(final int arr[]) {
		if (checkIfSortingRequired(arr)) {
			sortArray(arr);
		} 
		return arr;
	}

	private static void sortArray(final int[] arr) {
		int pass = 0;
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - pass; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j);
				}
			}
			pass++;
		}
	}

	private static void swap(int[] arr, int j) {
		int c = arr[j];
		arr[j] = arr[j + 1];
		arr[j + 1] = c;
	}

	private static boolean checkIfSortingRequired(final int[] arr) {
		int numberOfSwaps = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				numberOfSwaps++;
			}
		}
		return numberOfSwaps != 0 ? true : false;
	}
}
