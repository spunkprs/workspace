package com.prateek.vmware;

public class TestClass {

	private static int diff = Integer.MIN_VALUE;
	private static int min = Integer.MIN_VALUE;
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		final int arr[] = {7, 9, 5, 6, 3, 2};
		maxDifferenceInAnArray(arr);
	}
	
	private static int maxDifferenceInAnArray(final int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			process(arr, i);
		}
		return diff;
	}
	
	private static void process(final int[] arr, final int index) {
		if (index == 0) {
			if (arr[index + 1] >= arr[index]) {
				 calculateDiff(arr[index + 1], arr[index]);
			} else {
				min = arr[index + 1];
				calculateDiff(max, min);
			}
		} else {
			if (arr[index + 1] > min) {
				calculateDiff(arr[index + 1], min);
			}
			
			if (arr[index + 1] > arr[index]) {
				calculateDiff(arr[index + 1], arr[index]);
			}
		}
	}

	private static void calculateDiff(int maximum, int minimum) {
		if (maximum - minimum > diff) {
			max = maximum;
			min = minimum;
			diff = max - min;
		}
	}

}
