package com.prateek.KrisQuestion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConvertStringToIntegerTest {

	
	private ConvertStringToInteger unit;
	
	@Before
	public void setUp() {
		unit = new ConvertStringToInteger();
	}
	
	@Test
	public void shouldConvert() {
		
		//Set Up
		final String str = "12345";
		
		Assert.assertEquals(12345, unit.convert(str));
	}
}
