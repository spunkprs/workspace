package com.prateek.progresssoftware;

import org.junit.Assert;
import org.junit.Test;

public class NumberToWordConvertorTest {

	@Test
	public void shouldConvertOneDigitNumberToWord() {
		//Set Up
		int num = 9;
		
		//Execute
		final String word = NumberToWordConvertor.convertNumberToWord(num);
		
		//Verify
		Assert.assertEquals("Nine", word);
	}
	
	@Test
	public void shouldConvertTwoDigitNumberToWord() {
		//Set Up
		int num = 27;
		
		//Execute
		final String word = NumberToWordConvertor.convertNumberToWord(num);
		
		//Verify
		Assert.assertEquals("TwentySeven", word);
	}
	
	@Test
	public void shouldConvertTwoDigitNumberBetween10And19ToWord() {
		//Set Up
		int num1 = 10;
		int num2 = 18;
		
		//Execute
		final String word1 = NumberToWordConvertor.convertNumberToWord(num1);
		final String word2 = NumberToWordConvertor.convertNumberToWord(num2);
		
		//Verify
		Assert.assertEquals("Ten", word1);
		Assert.assertEquals("Eighteen", word2);
	}
	
	@Test
	public void shouldConvertTwoDigitNumberToWordWhenNumberFactorOfTen() {
		//Set Up
		int num = 30;
		
		//Execute
		final String word = NumberToWordConvertor.convertNumberToWord(num);
		
		//Verify
		Assert.assertEquals("Thirty", word);
	}
	
	@Test
	public void shouldConvertThreeDigitNumberToWordWhenNumberIsFactorOfTen() {
		//Set Up
		int num = 100;
		
		//Execute
		final String word = NumberToWordConvertor.convertNumberToWord(num);
		
		//Verify
		Assert.assertEquals("OneHundred", word);
	}
	
	@Test
	public void shouldConvertThreeDigitNumberToWord() {
		//Set Up
		int num1 = 123;
		int num2 = 119;
		
		//Execute
		final String word1 = NumberToWordConvertor.convertNumberToWord(num1);
		final String word2 = NumberToWordConvertor.convertNumberToWord(num2);
		
		//Verify
		Assert.assertEquals("OneHundredTwentyThree", word1);
		Assert.assertEquals("OneHundredNineteen", word2);
	}
	
	@Test
	public void shouldConvertFourDigitNumberToWord() {
		//Set Up
		int num = 1023;
		
		//Execute
		final String word = NumberToWordConvertor.convertNumberToWord(num);
		
		//Verify
		Assert.assertEquals("OneThousandTwentyThree", word);
	}
	
	@Test
	public void shouldConvertFiveDigitNumberToWord() {
		//Set Up
		int num1 = 22230;
		int num2 = 11023;
		int num3 = 20023;
		int num4 = 10023;
		int num5 = 20003;
		
		//Execute
		final String word1 = NumberToWordConvertor.convertNumberToWord(num1);
		final String word2 = NumberToWordConvertor.convertNumberToWord(num2);
		final String word3 = NumberToWordConvertor.convertNumberToWord(num3);
		final String word4 = NumberToWordConvertor.convertNumberToWord(num4);
		final String word5 = NumberToWordConvertor.convertNumberToWord(num5);
		
		//Verify
		Assert.assertEquals("TwentyTwoThousandTwoHundredThirty", word1);
		Assert.assertEquals("ElevenThousandTwentyThree", word2);
		Assert.assertEquals("TwentyThousandTwentyThree", word3);
		Assert.assertEquals("TenThousandTwentyThree", word4);
		Assert.assertEquals("TwentyThousandThree", word5);
	}
}
