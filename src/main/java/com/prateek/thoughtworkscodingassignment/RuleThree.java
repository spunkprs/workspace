package com.prateek.thoughtworkscodingassignment;

import java.util.Map;
import java.util.HashMap;

/*This rule is applicable for characters 'I', 'X', 'C', 'V', 'L', 'D'*/

public class RuleThree extends Rule {
	
	private static RuleThree ruleThree;
	private Map<Character, Integer> map = prepareMap();
	
	public static RuleThree getInstance() {
		if (null != ruleThree) {
			return ruleThree;
		}
		ruleThree = new RuleThree();
		return ruleThree;
	}

	private Map<Character, Integer> prepareMap() {
		final Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (RomanCharacters rc : RomanCharacters.values()) {
			map.put(rc.getNameOfCharacter().toCharArray()[0], rc.getRankOfRomanCharacter());
		}
		return map;
	}

	@Override
	public boolean validate(int i, char[] arr) {
		if (i == 0 && i == arr.length - 1) {
			return true;
		} else if (i < arr.length - 1) {
			return validateForElementsThatAreNotPresentAtEndOfArray(i, arr);
		}
		return true;
	}

	private boolean validateForElementsThatAreNotPresentAtEndOfArray(final int i, final char[] arr) {
		int j = i + 1;
		int rank1 = map.get(arr[i]);
		int rank2 = map.get(arr[j]);
		
		if (arr[i] == 'I') {
			if (rank1 >= rank2) {
				return true;
			} else if (rank1 < rank2 && (rank2 == 2 || rank2 == 3)) {
				return true;
			}
			return false;
		} else if (arr[i] == 'X') {
			if (rank1 >= rank2) {
				return true;
			} else if (rank1 < rank2 && (rank2 == 4 || rank2 == 5)) {
				return true;
			}
			return false;
		} else if (arr[i] == 'C') {
			if (rank1 >= rank2) {
				return true;
			} else if (rank1 < rank2 && (rank2 == 6 || rank2 == 7)) {
				return true;
			}
			return false;
		} else if(arr[i] == 'V' || arr[i] == 'L' || arr[i] == 'D') {
			if (rank1 >= rank2) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

}
