package com.prateek.Arrays;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

import com.google.common.collect.Lists;

public class TripletsThatSumUpToNumberTest {
	
	private TripletsThatSumUpToNumber unit;
	
	@Before
	public void setUp() {
		unit = TripletsThatSumUpToNumber.newInstance();
	}
	
	@Test
	public void shouldFindOutTriplets1() {
		//Set Up
		final int arr[]= {20, 6, 4, 18, 4, 7};
		final int number = 28;
		List<Triplet> expectedTriplets = createTriplets1();
		
		//Execute
		final List<Triplet> result = unit.findTriplets(arr, number);
		
		//Verify
		Assert.assertEquals(expectedTriplets.size(), result.size());
		for (int j = 0; j < expectedTriplets.size(); j++) {
			for (int i = 0; i < expectedTriplets.get(j).getTriplets().size(); i++) {
				Assert.assertEquals(expectedTriplets.get(j).getTriplets().get(i), result.get(j).getTriplets().get(i));
			}
		}
	}

	private List<Triplet> createTriplets1() {
		final List<Triplet> triplets = Lists.newArrayList();
		final Triplet triplets1 = new Triplet(20, 4, 4);
		final Triplet triplets2 = new Triplet(18, 4, 6);
		triplets.add(triplets1);
		triplets.add(triplets2);
		return triplets;
	}
	
	
	@Test
	public void shouldFindOutTriplets2() {
		//Set Up
		final int arr[]= {20, 6, 18, 2, 4, 11, 17, 9, 8};
		final int number = 28;
		List<Triplet> expectedTriplets = createTriplets2();
		
		//Execute
		final List<Triplet> result = unit.findTriplets(arr, number);
		
		//Verify
		Assert.assertEquals(expectedTriplets.size(), result.size());
		for (int j = 0; j < expectedTriplets.size(); j++) {
			for (int i = 0; i < expectedTriplets.get(j).getTriplets().size(); i++) {
				Assert.assertEquals(expectedTriplets.get(j).getTriplets().get(i), result.get(j).getTriplets().get(i));
			}
		}
	}
	
	private List<Triplet> createTriplets2() {
		final List<Triplet> triplets = Lists.newArrayList();
		final Triplet triplets1 = new Triplet(20, 2, 6);
		final Triplet triplets2 = new Triplet(18, 2, 8);
		final Triplet triplets3 = new Triplet(18, 4, 6);
		final Triplet triplets4 = new Triplet(17, 2, 9);
		final Triplet triplets5 = new Triplet(11, 8, 9);
		triplets.add(triplets1);
		triplets.add(triplets2);
		triplets.add(triplets3);
		triplets.add(triplets4);
		triplets.add(triplets5);
		return triplets;
	}

}
