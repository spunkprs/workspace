package com.prateek.Arrays;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class AllUniqueCharactesTest {

	private AllUniqueCharacters unit;
	
	@Before
	public void setUp() {
		unit = new AllUniqueCharacters();
	}
	
	@Test
	public void shouldCheckIfStringContainsAllUniqueCharacters() {
		//Set Up
		final String str = "ababafl";
		final String str1 = "abcdefg1";
		
		//Execute && Verify
		Assert.assertFalse(unit.allUniqueCharacters(str));
		Assert.assertTrue(unit.allUniqueCharacters(str1));
	}
}
