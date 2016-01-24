package com.prateek.thoughtworkscodingassignment;

import java.util.List;

/*Responsible for parsing the Roman characters pattern by taking provided rules in to consideration.*/

public class Parser {

	public static boolean parseText(final String text) {
		final char arr[] = text.toCharArray();
		return parse(arr);
	}

	private static boolean parse(final char[] arr) {
		boolean flag = true;
		RulesProviderFactory.clearCache();
		for (int i = 0; i < arr.length; i++) {
			 flag = validateRules(RulesProviderFactory.getRules(arr[i]), i, arr);
			 if (!flag) {
			 return flag;
			}
		}
		return flag;
	}

	private static boolean validateRules(final List<Rule> rules, final int i, final char arr[]) {
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
