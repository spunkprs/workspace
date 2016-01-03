package com.prateek.substring;

import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;

public class FetchSubstrings {
	
	private ListMultimap<Integer, String> map = ArrayListMultimap.create();
	public List<String> fetchSubStrings(final String str) {
		final List<String> subStrings = Lists.newArrayList();
		return checkForNullabilityOrEmptiness(str) ? subStrings : fetch(str, subStrings);
	}

	private List<String> fetch(final String input, List<String> subStrings) {
		final char arr[] = input.toCharArray();
		process(arr, subStrings);
		return subStrings;
	}

	private void process(char[] arr, List<String> subStrings) {
		String str;
		
		for (int i = arr.length - 1; i >= 0; i--) {
			if (i == arr.length - 1) {
				str = getStringAtPosition(arr, i);
				map.put(i, str);
				subStrings.add(str);
			} else {
				str = getStringAtPosition(arr, i);
				map.put(i, str);
				subStrings.add(str);
				updateListAndMap(getStringsFromNextPosition(i), subStrings, str, i);
			}
		}
	}
	
	private void updateListAndMap(List<String> stringsFromNextPosition, final List<String> subStrings, final String string, final int position) {
		for (String str : stringsFromNextPosition) {
			map.put(position, string + str);
			subStrings.add(string + str);
		}
	}

	private List<String> getStringsFromNextPosition(int i) {
		return map.get(i + 1);
	}

	private String getStringAtPosition(final char[] arr, int position) {
		return new Character(arr[position]).toString();
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
