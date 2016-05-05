package com.prateek.Arrays;

import org.junit.Test;

import com.google.common.collect.Sets;

import java.util.Set;

import org.junit.Assert;

public class PermutationOfAStringTest {

	@Test
	public void shouldGetPermutationsOfAString() {
		final String word = "abc";
		final Set<String> expectedPermutations = Sets.newHashSet("abc", "acb", "bac", "bca", "cab", "cba");
		
		final Set<String> actualPermutations = PermutationOfAString.fetchPermutations(word);
		Assert.assertEquals(6, actualPermutations.size());
		verifyPermutations(expectedPermutations, actualPermutations);
	}
	
	@Test
	public void shouldGetPermutationsOfAStringWhenSomeOfTheCharactersRepeatsInTheWord() {
		final String word = "aba";
		final Set<String> expectedPermutations = Sets.newHashSet("aba", "aab", "baa");
		
		final Set<String> actualPermutations = PermutationOfAString.fetchPermutations(word);
		Assert.assertEquals(3, actualPermutations.size());
		verifyPermutations(expectedPermutations, actualPermutations);
	}
	
	@Test
	public void shouldGetPermutationsOfAStringWhenSomeOfTheCharactersRepeatsInTheWordCaseOne() {
		final String word = "abca";
		//final Set<String> expectedPermutations = Sets.newHashSet("aba", "aab", "baa");
		
		final Set<String> actualPermutations = PermutationOfAString.fetchPermutations(word);
		Assert.assertEquals(12, actualPermutations.size());
		//verifyPermutations(expectedPermutations, actualPermutations);
	}

	private void verifyPermutations(final Set<String> expectedPermutations, final Set<String> actualPermutations) {
		for (String word : expectedPermutations) {
			Assert.assertTrue(actualPermutations.contains(word));
		}
	}
}
