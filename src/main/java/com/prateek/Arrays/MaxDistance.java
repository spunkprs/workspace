package com.prateek.Arrays;

import java.util.List;

public class MaxDistance {
	
	static int maximumGap = -1;
	static int arrOne[];
	static int arrTwo[];
	
	public static int maximumGap(final List<Integer> numbers) {
		fetchMaximumGapApproachTwo(numbers);
		return maximumGap == 0 ? -1 : maximumGap;
	}

	private static void fetchMaximumGapApproachTwo(final List<Integer> numbers) {
		arrOne = new int[numbers.size()];
		arrTwo = new int[numbers.size()];
		if (numbers.size() > 1) {
			populateArrOne(numbers);
			populateArrTwo(numbers);
			processMaximumGap();
		} else {
			maximumGap = 0;
		}
	}

	private static void processMaximumGap() {
		int i = 0, j= 0;
		while(i < arrOne.length && j < arrTwo.length) {
			if (arrOne[i] > arrTwo[j]) {
				i++;
			} else {
				maximumGap = max(j - i, maximumGap);
				j++;
			}
		}
	}

	private static void populateArrTwo(final List<Integer> numbers) {
		arrTwo[numbers.size() - 1] = numbers.get(numbers.size() - 1);
		for (int i = numbers.size() - 2; i >= 0; i--) {
			arrTwo[i] = max(arrTwo[i + 1], numbers.get(i));
		}
	}

	private static int max(final int elementOne, final int elementTwo) {
		if (elementOne >= elementTwo) {
			return elementOne;
		}
		return elementTwo;
	}

	private static void populateArrOne(List<Integer> numbers) {
		arrOne[0] = numbers.get(0);
		for (int i = 1; i < numbers.size(); i++) {
			arrOne[i] = min(arrOne[i - 1], numbers.get(i));
		}
	}
	
	private static int min(int elementOne, int elementTwo) {
		if (elementOne <= elementTwo) {
			return elementOne;
		}
		return elementTwo;
	}

	/*
	private static void fetchMaximumGapApproachOne(final List<Integer> numbers) {
		for (int i = numbers.size() - 1; i >=0; i--) {
			if (i < maximumGap) {
				return;
			}
			for (int j = 0; j < i; j++) {
				if (i - j >= maximumGap) {
					if (numbers.get(i) >= numbers.get(j)) {
						maximumGap = i - j;
						break;
					}
				} else {
					break;
				}
			}
		}
	}
	*/
}
