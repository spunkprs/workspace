package com.prateek.binaryoperations;

import org.junit.Test;

import org.junit.Assert;

public class DecimalToBinaryConversionTest {

	@Test
	public void shouldConvertDecimalToBinaryWhenDecimalIsZero() {
		Assert.assertEquals("0", DecimalToBinaryConversion.decimalToBinaryConversion(0));
	}
	
	@Test
	public void shouldConvertDecimalToBinaryWhenDecimalIsOne() {
		Assert.assertEquals("1", DecimalToBinaryConversion.decimalToBinaryConversion(1));
	}
	
	@Test
	public void shouldConvertDecimalToBinaryWhenDecimalIsTwo() {
		Assert.assertEquals("10", DecimalToBinaryConversion.decimalToBinaryConversion(2));
	}
	
	@Test
	public void shouldConvertDecimalToBinaryWhenDecimalIsSeven() {
		Assert.assertEquals("111", DecimalToBinaryConversion.decimalToBinaryConversion(7));
	}
	
	@Test
	public void shouldConvertDecimalToBinaryWhenDecimalIs14() {
		Assert.assertEquals("1110", DecimalToBinaryConversion.decimalToBinaryConversion(14));
	}
	
	@Test
	public void shouldConvertDecimalToBinaryWhenDecimalIs20() {
		Assert.assertEquals("10100", DecimalToBinaryConversion.decimalToBinaryConversion(20));
	}
}
