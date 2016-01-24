package com.prateek.thoughtworkscodingassignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Takes care of providing the rules that applies on any Roman character.*/

public class RulesProviderFactory {
	
	public static List<Rule> getRules(final char character) {
		final List<Rule> rules = new ArrayList<Rule>();
		final Map<Character, Integer> map = new HashMap<Character, Integer>();
		if (character == 'I' || character == 'X' || character == 'C') {
			rules.add(RuleOne.getInstance(map));
			rules.add(RuleThree.getInstance());
		} else if (character == 'D' || character == 'L' || character == 'V') {
			rules.add(RuleTwo.getInstance(map));
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
