package com.prateek.thoughtworkscodingassignment;

import java.util.Map;
import java.util.HashMap;

/*This rule is applicable for characters 'I', 'X', 'C'*/

public class RuleThree extends Rule {
	
	private static RuleThree ruleThree;
	
	public static RuleThree getInstance() {
		if (null != ruleThree) {
			return ruleThree;
		}
		ruleThree = new RuleThree();
		return ruleThree;
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
		final Map<String, Integer> map = RomanCharacters.getMap();
		
		int rank1 = map.get(Character.toString(arr[i]));
		int rank2 = map.get(Character.toString(arr[i + 1]));
		
		if (arr[i] == 'I') {
			if (rank1 >= rank2) {
				return true;
			} else if (rank1 < rank2 && (rank2 == RomanCharacters.V.getRankOfRomanCharacter() || rank2 == RomanCharacters.X.getRankOfRomanCharacter())) {
				return true;
			}
			return false;
		} else if (arr[i] == 'X') {
			if (rank1 >= rank2) {
				return true;
			} else if (rank1 < rank2 && (rank2 == RomanCharacters.L.getRankOfRomanCharacter() || rank2 == RomanCharacters.C.getRankOfRomanCharacter())) {
				return true;
			}
			return false;
		} else if (arr[i] == 'C') {
			if (rank1 >= rank2) {
				return true;
			} else if (rank1 < rank2 && (rank2 == RomanCharacters.D.getRankOfRomanCharacter() || rank2 == RomanCharacters.M.getRankOfRomanCharacter())) {
				return true;
			}
			return false;
		} 
		return true;
	}

}
