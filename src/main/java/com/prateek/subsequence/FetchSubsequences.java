package com.prateek.subsequence;

import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;

public class FetchSubsequences {

	private ListMultimap<Integer, String> map = ArrayListMultimap.create();
	
	public List<String> fetchSubSequences(final String string) {
		final List<String> subSequences = Lists.newArrayList();
		return checkForNullabilityOrEmptiness(string) ? subSequences : fetch(string, subSequences);
	}
	
	private List<String> fetch(String input, List<String> subSequences) {
		final char arr[] = input.toCharArray();
		process(arr, subSequences);
		return subSequences;
	}

	private void process(char[] arr, List<String> subSequences) {
		String str;
		
		for (int i = arr.length - 1; i >= 0; i--) {
			if (i == arr.length - 1) {
				str = getStringAtPosition(arr, i);
				map.put(i, str);
				subSequences.add(str);
			} else {
				str = getStringAtPosition(arr, i);
				map.put(i, str);
				subSequences.add(str);
				updateListAndMap(subSequences, str, i, arr.length);
			}
		}
	}
	
	private void updateListAndMap(final List<String> subSequences, final String string, final int position, int length) {
		for (int i = position + 1 ; i < length; i++) {
			for (String str : getStringsFromNextPosition(i)) {
				map.put(position, string + str);
				subSequences.add(string + str);
			}
		}
	}
	
	private String getStringAtPosition(final char[] arr, int position) {
		return new Character(arr[position]).toString();
	}

	private List<String> getStringsFromNextPosition(int i) {
		return map.get(i);
	}

	private boolean checkForNullabilityOrEmptiness(String str) {
		if (str == null) {
			return true;
		} else if (str.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
