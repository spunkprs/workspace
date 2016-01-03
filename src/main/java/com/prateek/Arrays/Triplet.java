package com.prateek.Arrays;

import java.util.List;

import com.google.common.collect.Lists;

public class Triplet {

	private List<Integer> triplets;
	
	public Triplet(final int a, final int b, final int c) {
		triplets = Lists.newArrayList(a, b, c);
	}
	
	public List<Integer> getTriplets() {
		return this.triplets;
	}
}
