package com.prateek.CodingDojo;

import java.util.Map;

import com.google.common.collect.Maps;

public class NumberOfWaysToClimbStairs {

	private Map<Integer, Integer> map = Maps.newHashMap();
	
	private int totalWays = 0;
	
	public int calculateNumberOfWaysToClimbStairs(final int numberOfStairs) {
		map.put(0, 0);
		if (numberOfStairs <=0) {
			return 0;
		} else {
			return calculate(numberOfStairs);
		}
	}

	private int calculate(final int numberOfStairs) {
		final int arr[] = {1, 2, 3};
		for (int i = 0; i < arr.length; i++) {
			final int remaining = numberOfStairs - arr[i];
			if (0 != remaining) {
				if (!map.keySet().contains(new Integer(remaining))) {
					calculate(remaining);
				} else {
					totalWays += map.get(remaining);
					map.put(numberOfStairs, totalWays);
				}
			} else {
				if (numberOfStairs == arr[i]) {
					if (!map.keySet().contains(numberOfStairs)) {
						map.put(numberOfStairs, map.get(numberOfStairs - 1) + 1);
					} else {
						map.put(numberOfStairs, map.get(numberOfStairs) + 1);
					}
					totalWays = map.get(numberOfStairs);
					break;
				}
			}
		}
		return totalWays;
	}
}
