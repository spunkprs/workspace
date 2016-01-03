package com.prateek.thoughtworkscodingassignment;

import java.util.Map;

/*This rule is applicable to characters 'D', 'L', 'V'*/

public class RuleTwo extends Rule {
	
	private Map<Character, Integer> map;
	private static RuleTwo ruleTwo;
	
	private RuleTwo(final Map<Character, Integer> m) {
		this.map = m;
	}
	
	public static RuleTwo getInstance(final Map<Character, Integer> m) {
		if (null != ruleTwo) {
			return ruleTwo;
		} 
		ruleTwo = new RuleTwo(m);
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
		if (i == 0 && i == arr.length - 1) {
			return true;
		} else if (null != count) {
			return false;
		} else {
			return true;
		}
	}

	private boolean validateForElementsNotPresentAtEndOfArray(final int i, final char[] arr) {
		int j = i + 1;
		Integer count = map.get(arr[i]);
		
		if (null != count) {
		return false;
		} else if (count == null && arr[i] == arr[j] && j == arr.length - 1) {
			return false;
		}
		map.put(arr[i], 1);
		return true;
	}

	protected void setMap(final Map<Character, Integer> m) {
		this.map = m;
	}

}
