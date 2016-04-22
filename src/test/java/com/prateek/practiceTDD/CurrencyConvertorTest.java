package com.prateek.practiceTDD;

import org.junit.Test;

import org.junit.Assert;

public class CurrencyConvertorTest {
	
	@Test
	public void shouldReturnZeroWhenCurrencyOneAmountIsZero() {
		Assert.assertEquals(0.0, CurrencyConvertor.convert(Currency.US_DOLLAR, 0.0, Currency.INDIAN_RUPPEE), 0.0);
	}
	
	@Test
	public void shouldNotReturnZeroWhenCurrencyOneIsUSDollarAndCurrencyTwoIsIndianRuppeeAndAmountIsNotZero() {
		Assert.assertEquals(55.0, CurrencyConvertor.convert(Currency.US_DOLLAR, 1.0, Currency.INDIAN_RUPPEE), 0.0);
	}
	
	@Test
	public void shouldNotReturnZeroWhenCurrencyOneIsUKDollarAndCurrencyTwoIsIndianRuppeeAndAmountIsNotZero() {
		Assert.assertEquals(88.0, CurrencyConvertor.convert(Currency.UK_POUND, 1.0, Currency.INDIAN_RUPPEE), 0.0);
	}
	
	@Test
	public void shouldNotReturnZeroWhenCurrencyOneIsIndianRuppeeAndCurrencyTwoUKPoundAndAmountIsNotZero() {
		Assert.assertEquals(1.0, CurrencyConvertor.convert(Currency.INDIAN_RUPPEE, 88.0, Currency.UK_POUND), 0.0);
	}

}
