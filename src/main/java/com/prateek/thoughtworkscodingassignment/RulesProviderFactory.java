package com.prateek.thoughtworkscodingassignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Takes care of providing the rules that applies on any Roman character.*/

public class RulesProviderFactory {
	
	public static List<Rule> getRules(final int i, final char arr[]) {
		final List<Rule> rules = new ArrayList<Rule>();
		final Map<Character, Integer> map = new HashMap<Character, Integer>();
		if (arr[i] == 'I' || arr[i] == 'X' || arr[i] == 'C') {
			rules.add(RuleOne.getInstance(map));
			rules.add(RuleThree.getInstance());
		} else if (arr[i] == 'D' || arr[i] == 'L' || arr[i] == 'V') {
			rules.add(RuleTwo.getInstance(map));
			rules.add(RuleThree.getInstance());
		} else {
			rules.add(RuleOne.getInstance(map));
		}
		return rules;
	}
	
	protected static void setRules() {
		final Map<Character, Integer> m = new HashMap<Character, Integer>();
		final RuleOne ruleOne = RuleOne.getInstance(m);
		ruleOne.setMap(m);
		
		final RuleTwo ruleTwo = RuleTwo.getInstance(m);
		ruleTwo.setMap(m);
	}
}
