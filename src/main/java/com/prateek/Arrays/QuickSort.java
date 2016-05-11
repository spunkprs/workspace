package com.prateek.Arrays;

public class QuickSort {

	public static int[] sortInAscendingOrder(final int arr[]) {
		int pivot = arr.length - 1;
		sort(0, pivot, arr);
		return arr;
	}

	private static void sort(final int startIndex, final int pivot, final int[] arr) {
		int currentIndex = startIndex;
		if (pivot - startIndex >= 1 && pivot <= arr.length - 1) {
			for (int i = startIndex; i < pivot; i++) {
				if (arr[i] <= arr[pivot]) {
					if (currentIndex != i) {
						swap(currentIndex, i, arr);
						currentIndex++;
					} else {
						currentIndex++;
					}
				}
			}
			swap(currentIndex, pivot, arr);
			sort(startIndex, currentIndex - 1, arr);
			sort(currentIndex + 1, pivot, arr);
		} 
	}

	private static void swap(final int currentIndex, final int i, final int[] arr) {
		int temp = arr[currentIndex];
		arr[currentIndex] = arr[i];
		arr[i] = temp;
	}
}
