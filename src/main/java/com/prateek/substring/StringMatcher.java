package com.prateek.substring;


public class StringMatcher {

	private boolean result = false;
	
	//This method returns true if StringOne contains StringTwo false otherwise
	public boolean doesContains(final String stringOne, final String stringTwo) {
		if (stringTwo.length() <= stringOne.length()) {
			int stringTwoHash = computeHash(0, stringTwo.length() - 1, stringTwo);
			compare(stringOne, stringTwoHash, stringTwo);
			return result;
		}
		return false;
	}

	private void compare(String stringOne, int stringTwoHash, final String stringTwo) {
		final char arr[] = stringOne.toCharArray();
		int hash = 0;
		int finalIndex = 0;
		for (int i = 0; i < stringOne.length(); i++) {
			finalIndex = i + stringTwo.length() - 1;
			if (finalIndex < stringOne.length()) {
				if (i == 0) {
					hash = computeHash(i, finalIndex, stringOne);
					checkForEquality(i, finalIndex, stringOne, stringTwo, hash, stringTwoHash);
					if (result) {
						return;
					}
				} else {
					hash = hash - (arr[i - 1] * ((Double)Math.pow(10, stringTwo.length() - 1)).intValue());
					hash = hash * 10 + arr[finalIndex];
					checkForEquality(i, finalIndex, stringOne, stringTwo, hash, stringTwoHash);
					if (result) {
						return;
					}
				}
			}
		}
	}

	private void checkForEquality(final int startingIndex, final int finalIndex, final String stringOne, final String stringTwo, final int stringOnehash, int stringTwoHash) {
		int initialIndex = startingIndex;
		if (stringOnehash == stringTwoHash) {
			final char arrTwo[] = stringTwo.toCharArray();
			final char arrOne[] = stringOne.toCharArray();
			for (int i = 0; i < stringTwo.length(); i++) {
				if (arrTwo[i] != arrOne[initialIndex]) {
					return;
				}
				initialIndex++;
			}
			result = true;
		}
	}

	private int computeHash(final int initialIndex, final int finalIndex, final String s) {
		int hash = 0;
		int startingIndex = initialIndex;
		final char arr[] = s.toCharArray();
		int length = finalIndex - initialIndex + 1;
		for (int i = 0; i < length; i++) {
			hash += arr[startingIndex] * Math.pow(10, length - i - 1);
			startingIndex++;
		}
		return hash;
	}
}
