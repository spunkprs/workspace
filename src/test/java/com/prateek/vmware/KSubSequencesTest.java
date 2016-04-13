package com.prateek.vmware;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class KSubSequencesTest {

	private KSubSequences unit;
	
	@Before
	public void setUp() {
		unit = new KSubSequences();
	}
	
	@Test
	public void shouldGiveCountOfKSubSequencesCaseOne() {
		final int arr[] = {1, 2, 3, 4, 1};
		Assert.assertEquals(4, unit.countOfKSubSequences(arr, 3));
	}
	
	@Test
	public void shouldGiveCountOfKSubSequencesCaseTwo() {
		final int arr[] = {1, 2, 3, 4, 2};
		Assert.assertEquals(7, unit.countOfKSubSequences(arr, 3));
	}
}
