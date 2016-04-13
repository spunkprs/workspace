package com.prateek.vmware;

public class MaxDifferenceInArray {

	private int min = Integer.MIN_VALUE + 1;
	private int max = Integer.MIN_VALUE + 1;
	private int diff = Integer.MIN_VALUE + 1;
	
	public int maxDifferenceInArray(final int arr[]) {
		if (arr.length >= 2) {
			for (int i = 0; i < arr.length - 1; i++) {
				process(arr, i);
			}
			if (diff == Integer.MIN_VALUE + 1) {
				return -1;
			}
			return diff;
		}
		return -1;
	}

	private void process(int[] arr, int index) {
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

	private void calculateDiff(int maximum, int minimum) {
		if (maximum != Integer.MIN_VALUE + 1 && maximum - minimum > diff) {
			max = maximum;
			min = minimum;
			diff = max - min;
		}
	}
}
