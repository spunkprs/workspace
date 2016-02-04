package com.prateek.thoughtworkscodingassignment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {
	
	@Before
	public void setUp() {
		RulesProviderFactory.clearCache();
	}
	
	@Test
	public void shouldReturnTrueWhenValidStringIsParsed() {
		//Set Up
		final String textOne = "MMDXCMX";
		final String textTwo = "MMDXLIV";
		
		//Execute && Verify
		Assert.assertTrue(Parser.parseText(textOne));
		Assert.assertTrue(Parser.parseText(textTwo));
	}
	
	@Test
	public void shouldReturnFalseWhenCharacterXRepeatsMoreThanThreeTimesWithoutAnyIntermittentCharacter() {
		//Set Up
		final String textOne = "XXXXCX";
		final String textTwo = "MXXXX";
		
		//Execute && Verify
		Assert.assertFalse(Parser.parseText(textOne));
		Assert.assertFalse(Parser.parseText(textTwo));
	}
	
	@Test
	public void shouldReturnFalseWhenCharacterXIsNotFollowedByEitherByLORC() {
		//Set Up
		final String text = "MMXDI";
		
		//Execute && Verify
		Assert.assertFalse(Parser.parseText(text));
	}
	
	@Test
	public void shouldReturnFalseWhenCharacterIIsNotFollowedByEitherVOrX() {
		//Set Up
		final String text = "MMID";
		
		//Execute && Verify
		Assert.assertFalse(Parser.parseText(text));
	}
	
	@Test
	public void shouldParseTheStringWhenLengthOfTextIsOne() {
		//Set Up
		final String text = "X";
		
		//Execute && Verify
		Assert.assertTrue(Parser.parseText(text));
	}
	
	@Test
	public void shouldReturnFalseWhenCharacterDOrLOrVRepeats() {
		//Set Up
		final String textOne = "DDXI";
		final String textTwo = "MLXL";
		final String textThree = "MVVI";
		
		
		//Execute && Verify
		Assert.assertFalse(Parser.parseText(textOne));
		Assert.assertFalse(Parser.parseText(textTwo));
		Assert.assertFalse(Parser.parseText(textThree));
	}
	
	@Test
	public void shouldReturnFalseWhenCharacterVIsFollowedByCharacterGreaterThanIt() {
		//Set Up
		final String textOne = "MVX";
		final String textTwo = "MVL";
		final String textThree = "MVC";
		final String textFour = "MVD";
		final String textFive = "MVM";
		
		//Execute && Verify
		Assert.assertFalse(Parser.parseText(textOne));
		Assert.assertFalse(Parser.parseText(textTwo));
		Assert.assertFalse(Parser.parseText(textThree));
		Assert.assertFalse(Parser.parseText(textFour));
		Assert.assertFalse(Parser.parseText(textFive));
	}
	
	@Test
	public void shouldReturnFalseWhenCharacterLIsFollowedByCharacterGreaterThanIt() {
		//Set Up
		final String textOne = "MLC";
		final String textTwo = "MLD";
		final String textThree = "MLM";
		
		//Execute && Verify
		Assert.assertFalse(Parser.parseText(textOne));
		Assert.assertFalse(Parser.parseText(textTwo));
		Assert.assertFalse(Parser.parseText(textThree));
	}
	
	@Test
	public void shouldReturnFalseWhenCharacterDIsFollowedByCharacterGreaterThanIt() {
		//Set Up
		final String textOne = "MDM";
		
		//Execute && Verify
		Assert.assertFalse(Parser.parseText(textOne));
	}
	
}
