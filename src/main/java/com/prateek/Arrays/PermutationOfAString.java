package com.prateek.Arrays;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.google.common.collect.Sets;

public class PermutationOfAString {
	
	private static Set<String> permutations = Sets.newHashSet();
	
	public static Set<String> fetchPermutations(final String string) {
		permutations.clear();
		final char arr [] = string.toCharArray();
		final Set<Integer> set = new LinkedHashSet<Integer>();
		final Set<Character> repeatCharacter = new HashSet<Character>();
		
		for (int i = 0; i < arr.length; i++) {
			if (!repeatCharacter.contains(arr[i])) {
				repeatCharacter.add(arr[i]);
				set.add(i);
				generatePermutations(arr, set);
				set.remove(i);
			}
		}
		return permutations;
	}

	private static void generatePermutations(char[] arr, Set<Integer> set) {
		if (arr.length != set.size()) {
			for (Integer index : getNextCharacters(arr, set)) {
				set.add(index);
				generatePermutations(arr, set);
				set.remove(index);
			}
		} else {
			permutations.add(getWord(set, arr));
		}
	}

	private static String getWord(Set<Integer> set, final char arr[]) {
		String word = "";
		for (Integer index : set) {
			word = word + arr[index];
		}
		return word;
	}

	private static Set<Integer> getNextCharacters(final char[] arr, final Set<Integer> set) {
		Set<Integer> nextCharacters = Sets.newHashSet();
		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(i)) {
				nextCharacters.add(i);
			}
		}
		return nextCharacters;
	}
}
