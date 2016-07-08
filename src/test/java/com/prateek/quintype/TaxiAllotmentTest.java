package com.prateek.quintype;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.prateek.quintype.TaxiAllotment.Pair;

import org.junit.Assert;

public class TaxiAllotmentTest {
	
	private TaxiAllotment unit;
	
	@Before
	public void setUp() {
		unit = new TaxiAllotment();
	}

	@Test
	public void shouldFetchTaxiNumbersCaseWhenNumberOfTaxisAndNumberOfUsersAreSame() {
		final List<Pair> users = Lists.newArrayList(new Pair("1", "100"), new Pair("2", "100"), new Pair("3", "100"), new Pair("4", "100"), new Pair("5", "100"));
		final int numberOfTaxis = 5;
		final List<Integer> expectedIndexesOfTaxis = Lists.newArrayList(1, 2, 3, 4, 5);
		final List<Integer> actualIndexesOfTaxis = unit.fetchIndexesOfTaxis(users, numberOfTaxis);
		
		Assert.assertEquals(expectedIndexesOfTaxis.size(), actualIndexesOfTaxis.size());
		verify(expectedIndexesOfTaxis, actualIndexesOfTaxis);
	}
	
	@Test
	public void shouldFetchTaxiNumbersCaseWhenNumberOfTaxisAndNumberOfUsersAreNotSameCaseOne() {
		final List<Pair> users = Lists.newArrayList(new Pair("1", "300"), new Pair("2", "100"), new Pair("3", "100"), new Pair("105", "100"), new Pair("180", "100"));
		final int numberOfTaxis = 3;
		final List<Integer> expectedIndexesOfTaxis = Lists.newArrayList(1, 2, 3, 2, 3);
		final List<Integer> actualIndexesOfTaxis = unit.fetchIndexesOfTaxis(users, numberOfTaxis);
		
		Assert.assertEquals(expectedIndexesOfTaxis.size(), actualIndexesOfTaxis.size());
		verify(expectedIndexesOfTaxis, actualIndexesOfTaxis);
	}

	private void verify(final List<Integer> expectedIndexesOfTaxis, final List<Integer> actualIndexesOfTaxis) {
		for (int i = 0; i < expectedIndexesOfTaxis.size(); i++) {
			Assert.assertEquals(expectedIndexesOfTaxis.get(i), actualIndexesOfTaxis.get(i));
		}
	}
}
