package com.prateek.thoughtworkscodingassignment;

import java.util.List;

/*Responsible for parsing the Roman characters pattern by taking provided rules in to consideration.*/

public class Parser {

	public boolean parseText(final String text) {
		RulesProviderFactory.setRules();
		final char arr[] = text.toCharArray();
		return parse(arr);
	}

	private boolean parse(final char[] arr) {
		boolean flag = true;
		for (int i = 0; i < arr.length - 1; i++) {
			 flag = validateRules(RulesProviderFactory.getRules(i, arr), i, arr);
			 if (!flag) {
			 return flag;
			}
		}
		
		flag = validateRules(RulesProviderFactory.getRules(arr.length - 1, arr), arr.length - 1, arr);
		return flag;
	}

	private boolean validateRules(final List<Rule> rules, final int i, final char arr[]) {
		boolean flag = true;
		for (Rule rule : rules) {
			flag = rule.validate(i, arr);
			if (!flag) {
			return flag;
			}
		}
		return flag;
	}
}
