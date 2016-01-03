package com.prateek.Arrays;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class StringCompressionTest {

	private StringCompression unit;
	
	@Before
	public void setUp() {
		unit = new StringCompression();
	}
	
	@Test
	public void shouldCompressString1() {
		//Set Up
		final String str = "aaabcccddd";
		
		//Execute && Verify
		final String compressedString = "a3b1c3d3";
		Assert.assertEquals(compressedString, unit.compress(str));
	}
	
	@Test
	public void shouldCompressString2() {
		//Set Up
		final String str = "abcd";
		
		//Execute && Verify
		final String compressedString = "abcd";
		Assert.assertEquals(compressedString, unit.compress(str));
	}
	
	@Test
	public void shouldCompressString3() {
		//Set Up
		final String str = "aabbcccd";
		
		//Execute && Verify
		final String compressedString = "aabbcccd";
		Assert.assertEquals(compressedString, unit.compress(str));
	}
}
