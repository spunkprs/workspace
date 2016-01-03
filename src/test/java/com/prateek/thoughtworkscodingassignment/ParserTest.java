package com.prateek.thoughtworkscodingassignment;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class ParserTest {
	
	private Parser unit;

	@Before
	public void setUp() {
		unit = new Parser();
	}
	
	@Test
	public void shouldReturnTrueWhenValidStringIsParsed() {
		//Set Up
		final String textOne = "MMDXCMX";
		final String textTwo = "MMDXLIV";
		
		//Execute && Verify
		Assert.assertTrue(unit.parseText(textOne));
		Assert.assertTrue(unit.parseText(textTwo));
	}
	
	@Test
	public void shouldReturnFalseWhenCharacterXRepeatsMoreThanThreeTimesWithoutAnyIntermittentCharacter() {
		//Set Up
		final String textOne = "XXXXCX";
		final String textTwo = "MXXXX";
		
		//Execute && Verify
		Assert.assertFalse(unit.parseText(textOne));
		Assert.assertFalse(unit.parseText(textTwo));
	}
	
	@Test
	public void shouldReturnFalseWhenCharacterXIsNotFollowedByEitherByLORC() {
		//Set Up
		final String text = "MMXDI";
		
		//Execute && Verify
		Assert.assertFalse(unit.parseText(text));
	}
	
	@Test
	public void shouldReturnFalseWhenCharacterIIsNotFollowedByEitherVOrX() {
		//Set Up
		final String text = "MMID";
		
		//Execute && Verify
		Assert.assertFalse(unit.parseText(text));
	}
	
	@Test
	public void shouldParseTheStringWhenLengthOfTextIsOne() {
		//Set Up
		final String text = "X";
		
		//Execute && Verify
		Assert.assertTrue(unit.parseText(text));
	}
	
	@Test
	public void shouldReturnFalseWhenCharacterDOrLOrVRepeats() {
		//Set Up
		final String textOne = "DDXI";
		final String textTwo = "MLXL";
		final String textThree = "MVVI";
		
		
		//Execute && Verify
		Assert.assertFalse(unit.parseText(textOne));
		Assert.assertFalse(unit.parseText(textTwo));
		Assert.assertFalse(unit.parseText(textThree));
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
		Assert.assertFalse(unit.parseText(textOne));
		Assert.assertFalse(unit.parseText(textTwo));
		Assert.assertFalse(unit.parseText(textThree));
		Assert.assertFalse(unit.parseText(textFour));
		Assert.assertFalse(unit.parseText(textFive));
	}
	
	@Test
	public void shouldReturnFalseWhenCharacterLIsFollowedByCharacterGreaterThanIt() {
		//Set Up
		final String textOne = "MLC";
		final String textTwo = "MLD";
		final String textThree = "MLM";
		
		//Execute && Verify
		Assert.assertFalse(unit.parseText(textOne));
		Assert.assertFalse(unit.parseText(textTwo));
		Assert.assertFalse(unit.parseText(textThree));
	}
	
	@Test
	public void shouldReturnFalseWhenCharacterDIsFollowedByCharacterGreaterThanIt() {
		//Set Up
		final String textOne = "MDM";
		
		//Execute && Verify
		Assert.assertFalse(unit.parseText(textOne));
	}
	
}
