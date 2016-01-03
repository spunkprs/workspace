package com.prateek.Arrays;

public class InsertionSort {
	
	public int[] sort(final int array[]) {
		if (array.length > 1) {
			for (int j = 1; j < array.length; j++) {
				for (int i = j - 1; i >= 0; i--) {
					if (array[i + 1] < array[i]) {
						int c = array[i + 1];
						array[i + 1] = array[i];
						array[i] = c;
					} else {
						break;
					}
				}
			}
		}
		return array;
	}
}
