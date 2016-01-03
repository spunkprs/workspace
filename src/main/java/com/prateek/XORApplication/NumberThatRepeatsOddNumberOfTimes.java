package com.prateek.XORApplication;

public class NumberThatRepeatsOddNumberOfTimes {

	public int findNumberThatRepeatsOddNumberOfTimes(final int arr[]) {
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			num = num ^ arr[i];
		}
		return num;
	}
}
