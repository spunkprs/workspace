package com.prateek.thoughtworkschallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CandidateCode {
	
	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	private static final String INVALID = "Invalid";
	private static final String EQUAL = "Equal";
	private static final String UNEQUAL = "Unequal";
	private static int elementsDiffCounter = 0;
	
	public static String output = EQUAL;

	public static String partiesCompare(int arr1[], int arr2[]) {
		parseInputAndPutElementsInMap(arr1);
		
		if (!output.equals(INVALID)) {
			parseInputAndReconstructMap(arr2, arr1);
			if (output.equals(EQUAL)) {
				parseMapElements();
			}
		}
		return output;
	}

	private static void parseMapElements() {
		Set<Integer> keys = map.keySet(); 
		for (Integer key : keys) {
			if (elementsDiffCounter !=0 || map.get(key) != 0) {
				output = UNEQUAL;
				return;
			}
		}
		output = EQUAL;
	}

	private static void parseInputAndReconstructMap(int[] arrTwo, int [] arrOne) {
		parseForValidity(arrTwo);
		if (!output.equals(INVALID)) {
			if (arrOne.length == arrTwo.length) {
				for (int i = 0; i < arrTwo.length; i++) {
					Integer frequency = map.get(arrTwo[i]);
					if (frequency != null) {
						frequency = frequency - 1;
						map.put(arrTwo[i], frequency);
					} else {
						elementsDiffCounter++;
					}
			}
			}  else {
				output = UNEQUAL;
			}
		}
	}

	private static void parseInputAndPutElementsInMap(int[] arr) {
		parseForValidity(arr);
		if (!output.equals(INVALID)) {
			for (int i = 0; i < arr.length; i++) {
					Integer frequency = map.get(arr[i]);
					if (frequency != null) {
						frequency = frequency + 1;
						map.put(arr[i], frequency);
					} else {
						map.put(arr[i], 1);
					}
			}
		}
			}

	private static void parseForValidity(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				output = INVALID;
				return;
			} 
		}
	}
}
