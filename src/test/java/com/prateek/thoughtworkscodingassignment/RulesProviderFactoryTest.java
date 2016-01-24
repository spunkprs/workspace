package com.prateek.thoughtworkscodingassignment;

import java.util.List;

import org.junit.Test;

import org.junit.Assert;

public class RulesProviderFactoryTest {

	@Test
	public void shouldProvideRulesWhenAskedCharacterIsI() {
		//Set, Execute && Verify
		final List<Rule> rules = RulesProviderFactory.getRules('I');
		
		Assert.assertEquals(2, rules.size());
		Assert.assertTrue(rules.get(0) instanceof RuleOne);
		Assert.assertTrue(rules.get(1) instanceof RuleThree);
	}
	
	@Test
	public void shouldProvideRulesWhenAskedCharacterIsX() {
		//Set, Execute && Verify
		final List<Rule> rules = RulesProviderFactory.getRules('X');
		
		Assert.assertEquals(2, rules.size());
		Assert.assertTrue(rules.get(0) instanceof RuleOne);
		Assert.assertTrue(rules.get(1) instanceof RuleThree);
	}
	
	@Test
	public void shouldProvideRulesWhenAskedCharacterIsC() {
		//Set, Execute && Verify
		final List<Rule> rules = RulesProviderFactory.getRules('C');
		
		Assert.assertEquals(2, rules.size());
		Assert.assertTrue(rules.get(0) instanceof RuleOne);
		Assert.assertTrue(rules.get(1) instanceof RuleThree);
	}
	
	@Test
	public void shouldProvideRulesWhenAskedCharacterIsD() {
		//Set, Execute && Verify
		final List<Rule> rules = RulesProviderFactory.getRules('D');
		
		Assert.assertEquals(1, rules.size());
		Assert.assertTrue(rules.get(0) instanceof RuleTwo);
	}
	
	@Test
	public void shouldProvideRulesWhenAskedCharacterIsL() {
		//Set, Execute && Verify
		final List<Rule> rules = RulesProviderFactory.getRules('L');
		
		Assert.assertEquals(1, rules.size());
		Assert.assertTrue(rules.get(0) instanceof RuleTwo);
	}
	
	@Test
	public void shouldProvideRulesWhenAskedCharacterIsV() {
		//Set, Execute && Verify
		final List<Rule> rules = RulesProviderFactory.getRules('V');
		
		Assert.assertEquals(1, rules.size());
		Assert.assertTrue(rules.get(0) instanceof RuleTwo);
	}
	
	@Test
	public void shouldProvideRulesWhenAskedCharacterIsM() {
		//Set, Execute && Verify
		final List<Rule> rules = RulesProviderFactory.getRules('M');
		
		Assert.assertEquals(1, rules.size());
		Assert.assertTrue(rules.get(0) instanceof RuleOne);
	}
}
