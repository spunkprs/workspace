package com.prateek.thoughtworkscodingassignment;

import java.util.HashMap;
import java.util.Map;

/*This rule is applicable to characters 'D', 'L', 'V'*/

public class RuleTwo extends Rule {
	
	private Map<Character, Integer> map = new HashMap<Character, Integer>();
	private static RuleTwo ruleTwo;
	
	private RuleTwo() {
		
	}
	
	public static RuleTwo getInstance() {
		if (null != ruleTwo) {
			return ruleTwo;
		} 
		ruleTwo = new RuleTwo();
		return ruleTwo;
	}

	@Override
	public boolean validate(final int i, final char[] arr) {
		if (i < arr.length - 1) {
			return validateForElementsNotPresentAtEndOfArray(i, arr);
		}
		return validateForElementPresentAtEndOfArray(arr.length - 1, arr);
	}
	
	private boolean validateForElementPresentAtEndOfArray(final int i, final char[] arr) {
		Integer count = map.get(arr[i]);
		if (count != null) {
			return false;
		}
		return true;
	}

	private boolean validateForElementsNotPresentAtEndOfArray(final int i, final char[] arr) {
		Integer count = map.get(arr[i]);
		
		if (null != count) {
		return false;
		} else {
			map.put(arr[i], 1);
			return !isFollowedByCharacterWithGreaterRank(arr[i], arr[i + 1]);
		}
	}
	
	private boolean isFollowedByCharacterWithGreaterRank(final char firstCharacter, final char secondCharacter) {
		final Map<String, Integer> m = RomanCharacters.getCharacterToRankMap();
		return m.get(Character.toString(firstCharacter)) < m.get(Character.toString(secondCharacter)) ? true : false;
	}

	protected void setMap(final Map<Character, Integer> m) {
		this.map = m;
	}
}
