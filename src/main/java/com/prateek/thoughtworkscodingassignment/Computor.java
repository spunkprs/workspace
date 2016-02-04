package com.prateek.thoughtworkscodingassignment;

import java.util.Map;

/*Calculates the value of Roman character pattern provided by taking provided rules in to consideration.  
 * */

public class Computor {
	
	private static Map<String, Integer> map = RomanCharacters.getCharacterToValueMap();
	private static int jump = 0;
	private static boolean flag = false;

	protected static int computeUnits(final char[] arr) {
		int computedValue = 0;
		flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			computedValue += compute(arr, i);
			i = i + jump;
		}
		if (!flag) {
			computedValue += map.get(String.valueOf(arr[arr.length - 1]));
		}
		return computedValue;
	}

	private static int compute(char[] arr, int i) {
		int val = 0;
		jump = 0;
		final int valueOne = map.get(String.valueOf(arr[i]));
		final int valueTwo = map.get(String.valueOf(arr[i + 1]));
		if (valueOne >= valueTwo) {
			val += valueOne;
			flag = false;
		} else {
			val += computeWhenIncreasing(i, arr);
		}
		return val;
	}

	private static int computeWhenIncreasing(int i, char[] arr) {
		int j = i + 1;
		int counter = 0;
		int value = 0;
		while(i < arr.length - 1 && map.get(String.valueOf(arr[j])) > map.get(String.valueOf(arr[i]))) {
			if (counter == 0) {
				value = map.get(String.valueOf(arr[j])) - map.get(String.valueOf(arr[i]));
				counter++;
			} else {
				value = map.get(String.valueOf(arr[j])) - value;
				counter++;
			}
			i++;
			j++;
		}
		flag = j == arr.length ? true : false;
		jump += counter;
		return value;
	}
}
