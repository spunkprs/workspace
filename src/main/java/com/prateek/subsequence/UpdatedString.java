package com.prateek.subsequence;

public class UpdatedString {

	public static boolean isOneStringSubsequenceOfAnother(final String stringOne, final String stringTwo) {
		final int lengthOfFirstString = stringOne.length();
		final int lengthOfSecondString = stringTwo.length();
		
		if (lengthOfFirstString > lengthOfSecondString) {
			return isOneSubsequenceOfAnother(stringOne, stringTwo);
		} else if (lengthOfFirstString < lengthOfSecondString) {
			return isOneSubsequenceOfAnother(stringTwo, stringOne);
		} else {
			return stringOne.equals(stringTwo);
		}
	}

	private static boolean isOneSubsequenceOfAnother(String stringOne, String stringTwo) {
		final char arrOne[] = stringOne.toCharArray();
		final char arrTwo[] = stringTwo.toCharArray();
		
		int counter = 0;
		int i = 0;
		int j = 0;
		while(i < arrOne.length && j < arrTwo.length) {
			if (arrOne[i] == arrTwo[j]) {
				i++;
				j++;
				counter++;
			} else {
				i++;
			}
		}
		
		return counter == arrTwo.length ? true : false;
	}
}
