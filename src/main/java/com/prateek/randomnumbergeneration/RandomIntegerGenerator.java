package com.prateek.randomnumbergeneration;

public class RandomIntegerGenerator {

	public static int randomInteger(final int n) {
		Long currentTime = System.currentTimeMillis();
		int number = currentTime.intValue() ^ (n - 1) & (n - 1);
		if (number < n && number >= 0) {
			return number;
		}
		return currentTime.intValue() & (n - 1);
	}
}
