package com.prateek.practiceTDD;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeCheckerTest {

	@Test
	public void shouldCheckIfAWordIsPalindromeWhenWordIsNull() {
		final String word = null;
		Assert.assertFalse(PalindromeChecker.isPalindrome(word));
	}
	
	@Test
	public void shouldReturnFalseForNonPalindromicWord() {
		final String word = "kskksl";
		Assert.assertFalse(PalindromeChecker.isPalindrome(word));
	}
	
	@Test
	public void shouldReturnTrueForPalindromicWord() {
		final String word = "abcba";
		Assert.assertTrue(PalindromeChecker.isPalindrome(word));
	}
}
