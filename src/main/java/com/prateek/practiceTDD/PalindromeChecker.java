package com.prateek.practiceTDD;

public class PalindromeChecker {

	public static boolean isPalindrome(final String word) {
		if (word != null) {
			final String reversedWord = reverseWord(word);
			if (reversedWord.equals(word)) {
				return true;
			}
			return false;
		}
		return false;
	}

	private static String reverseWord(final String word) {
		final StringBuilder sb = new StringBuilder(word);
		sb.reverse();
		return sb.toString();
	}
}
