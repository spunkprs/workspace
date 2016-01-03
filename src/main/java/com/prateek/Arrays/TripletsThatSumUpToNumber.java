package com.prateek.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class TripletsThatSumUpToNumber {

	public static TripletsThatSumUpToNumber newInstance() {
		return new TripletsThatSumUpToNumber();
	}
	
	public TripletsThatSumUpToNumber() {
		
	}
	
	private Map<Integer, Boolean> map = Maps.newHashMap();
	
	public List<Triplet> findTriplets(final int arr[], final int number) {
		final Integer arr2[] = new Integer[arr.length];
		assignValues(arr2, arr);
		putValuesInMap(arr);
		Arrays.sort(arr);
		Arrays.sort(arr2, Collections.reverseOrder());
		return traverseAndFindTriplets(arr, arr2, number);
	}

	private List<Triplet> traverseAndFindTriplets(final int[] arr, final Integer[] arr2, final int number) {
		final List<Triplet> triplets = Lists.newArrayList();
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				
				int sum = arr2[i] + arr[j];
				if (sum >= number) {
					break;
				} else if (j != 0 && arr[j] == arr[j-1] || check(arr, j, number - sum, arr2, i)){
						continue;
				}
							else {
								final int difference = number - sum;
								if (map.containsKey(difference)) {
									if (difference == arr[j] && arr[j] == arr[j+1]) {
										map.put(arr2[i], true);
										map.put(difference, true);
										triplets.add(new Triplet(arr2[i], arr[j], difference));
									} else if (difference != arr[j] && difference != arr2[i]) {
										map.put(arr2[i], true);
										map.put(arr[j], true);
										map.put(difference, true);
										triplets.add(new Triplet(arr2[i], arr[j], difference));
									}
								}
							}
						}
				}
		return triplets;
			}

	private boolean check(int[] arr, int j,final int differnce, final Integer arr2[], final int i) {
		if (map.containsKey(differnce)) {
			return  map.get(arr[j]).booleanValue() && map.get(differnce).booleanValue() && map.get(arr2[i]).booleanValue();
		}
		return false;
	}

	private void putValuesInMap(final int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], false);
		}
	}

	private void assignValues(final Integer[] arr2, final int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = arr[i];
		}
	}
	
}
