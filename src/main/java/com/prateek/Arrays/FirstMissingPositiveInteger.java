package com.prateek.Arrays;

import java.util.List;

public class FirstMissingPositiveInteger {

	public int firstMissingPositive(final List<Integer> a) {
		final Integer arr[] = a.toArray(new Integer[a.size()]);
		final int countOfNegativesIncludingZero = segregatePositiveAndNegativeIntegers(arr);
		if (countOfNegativesIncludingZero != arr.length) {
			return processToFetchMissingNumberFromUnsortedArray(arr, countOfNegativesIncludingZero);
		} else {
			return 1;
		}
	}

	private int processToFetchMissingNumberFromUnsortedArray(final Integer[] arr, final int countOfNegativesIncludingZero) {
		final int countOfPositives = arr.length - countOfNegativesIncludingZero;
		if (countOfPositives == arr.length && arr.length == 1) {
			return arr[0] + 1;
		}
		
		for (int i = countOfNegativesIncludingZero; i < arr.length; i++) {
			if (Math.abs(arr[i]) < countOfPositives) {
				if (arr[Math.abs(arr[i]) + countOfNegativesIncludingZero - 1] > 0) {
					arr[Math.abs(arr[i]) + countOfNegativesIncludingZero - 1] = -arr[Math.abs(arr[i]) + countOfNegativesIncludingZero - 1];
				}
			}
		}
		int i = 0, j = 0;
		for (i = countOfNegativesIncludingZero; i < arr.length; i++) {
			if (arr[i] > 0) {
				break;
			} else {
				j++;
			}
		}
		return j + 1;
	}

	private int segregatePositiveAndNegativeIntegers(final Integer arr[]) {
		int countOfNegativesIncludingZero = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 0) {
				swap(i, countOfNegativesIncludingZero, arr);
				countOfNegativesIncludingZero++;
			} 
		}
		return countOfNegativesIncludingZero;
	}

	private void swap(final int i, final int countOfNegativesIncludingZero, final Integer arr[]) {
		if (i != countOfNegativesIncludingZero) {
			int temp = arr[i];
			arr[i] = arr[countOfNegativesIncludingZero];
			arr[countOfNegativesIncludingZero] = temp;
		}
	}
}
