package com.prateek.thoughtworkscodingassignment;

import java.util.Map;

/*This rule is applicable to characters 'I', 'X', 'C', 'M'*/

public class RuleOne extends Rule {
	
	private Map<Character, Integer> map;
	private static RuleOne ruleOne;
	
	public RuleOne(final Map<Character, Integer> m) {
		this.map = m;
	}
	
	public static RuleOne getInstance(final Map<Character, Integer> m) {
		if (null != ruleOne) {
			return ruleOne;
		}
		ruleOne = new RuleOne(m);
		return ruleOne;
	}

	@Override
	public boolean validate(final int i, final char[] arr) {
		final Integer count = map.get(arr[i]);
		if (count != null) {
			if ((arr[i] == arr[i - 1]) && count == 3) {
				map.put(arr[i], null);
				return false;
			} else if (arr[i] == arr[i - 1] && count < 3) {
				map.put(arr[i], count + 1);
				return true;
			} else if (count == 3) {
				map.put(arr[i], 1);
				return true;
			}
		}
		map.put(arr[i], 1);
		return true;
	}
	
	protected void setMap(final Map<Character, Integer> m) {
		this.map = m;
	}
}