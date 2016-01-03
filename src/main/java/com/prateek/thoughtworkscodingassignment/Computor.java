package com.prateek.thoughtworkscodingassignment;

import java.util.Map;
import java.util.HashMap;

/*Calculates the value of Roman character pattern provided by taking provided rules in to consideration.  
 * */

public class Computor {
	
	private Map<Character, Integer> map = getMap();
	private int jump = 0;
	private boolean flag = false;

	private static Map<Character, Integer> getMap() {
		final Map<Character, Integer> m = new HashMap<Character, Integer>();
		for (RomanCharacters rc : RomanCharacters.values()) {
			m.put(rc.getNameOfCharacter().toCharArray()[0], rc.getValueOfRomanCharacter());
		}
		return m;
	}
	
	public int computeUnits(final char[] arr) {
		int computedValue = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			computedValue += compute(arr, i);
			i = i + jump;
		}
		if (!flag) {
			computedValue += map.get(arr[arr.length - 1]);
		}
		return computedValue;
	}

	private int compute(char[] arr, int i) {
		int val = 0;
		int j = i + 1;
		jump = 0;
		final int valueOne = map.get(arr[i]);
		final int valueTwo = map.get(arr[j]);
		if (valueOne >= valueTwo) {
			val += valueOne;
			flag = false;
		} else {
			val += computeWhenIncreasing(i, arr);
		}
		return val;
	}


	private int computeWhenIncreasing(int i, char[] arr) {
		int j = i + 1;
		int counter = 0;
		int value = 0;
		while(i < arr.length - 1 && map.get(arr[j]) > map.get(arr[i])) {
			if (counter == 0) {
				value = map.get(arr[j]) - map.get(arr[i]);
				counter++;
			} else {
				value = map.get(arr[j]) - value;
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
