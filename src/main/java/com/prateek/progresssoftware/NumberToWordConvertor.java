package com.prateek.progresssoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class NumberToWordConvertor {
	
	private static Map<Integer, String> mapOne = PrepareMaps.prepareMapOne();
	private static Map<Integer, String> mapTwo = PrepareMaps.prepareMapTwo();
	private static Map<Integer, String> mapThree = PrepareMaps.prepareMapThree();
	private static Map<String, Integer> mapFour = PrepareMaps.prepareMapFour();
	
	private static List<String> words = new ArrayList<String>();
	
	public static String convertNumberToWord(final int number) {
		words = new ArrayList<String>();
		convert(number, 1);
		return prepareAndGetFinalWord();
	}
	
	private static String prepareAndGetFinalWord() {
		String word = "";
		for (int i = words.size() - 1; i >= 0; i--) {
			word += words.get(i); 
		}
		return word;
	}

	private static void convert(int number, int level) {
		int digit = number % 10;
		number = number / 10;
		getWord(digit, level);
		if(number != 0) {
			convert(number, level + 1);
		}
	}

	private static void getWord(final int digit, int level) {
		if (level < 3) {
			if (level == 1) {
				final String word = mapTwo.get(digit);
				checkNullability(word, digit);
			} else {
				if (digit != 1) {
					final String word = mapThree.get(digit);
					checkNullability(word, digit);
				} else if (!words.isEmpty()) {
					int num = 10 + mapFour.get(words.get(0));
					words = new ArrayList<String>();
					words.add(mapTwo.get(num));
				} else {
					words.add("Ten");
				}
				
			}
		} else {
			final String wordOne = mapOne.get(level);
			final String wordTwo = mapTwo.get(digit);
			if (wordOne.contains("Ten")) {
				if (digit != 1) {
					if (words.contains(mapOne.get(level - 1))) {
						words.add(mapThree.get(digit));
					} else {
						words.add(mapOne.get(level - 1));
						words.add(mapThree.get(digit));
					}
					
				} else {
					if (words.contains(mapOne.get(level - 1))) {
						int num = mapFour.get(words.get(words.size() - 1)) + 10;
						words.remove(words.size() - 1);
						words.add(mapTwo.get(num));
					} else {
						words.add(mapOne.get(level - 1));
						words.add("Ten");
					}
				}
				
			} else if (wordTwo != null) {
				words.add(wordOne);
				words.add(wordTwo);
			}
		}
	}

	private static void checkNullability(String word, int digit) {
		if (word != null) {
			words.add(word);
		}
	}

	static class PrepareMaps {
		
		private static Map<Integer, String> prepareMapOne() {
			final Map<Integer, String> map = Maps.newHashMap();
			prepare(map);
			return map;
		}
		
		public static Map<String, Integer> prepareMapFour() {
			final Map<String, Integer> map = Maps.newHashMap();
			map.put("One", 1);
			map.put("Two", 2);
			map.put("Three", 3);
			map.put("Four", 4);
			map.put("Five", 5);
			map.put("Six", 6);
			map.put("Seven", 7);
			map.put("Eight", 8);
			map.put("Nine", 9);
			return map;
		}

		public static Map<Integer, String> prepareMapThree() {
			final Map<Integer, String> map = Maps.newHashMap();
			map.put(1, "Ten");
			map.put(2, "Twenty");
			map.put(3, "Thirty");
			map.put(4, "Forty");
			map.put(5, "Fifty");
			map.put(6, "Sixty");
			map.put(7, "Seventy");
			map.put(8, "Eighty");
			map.put(9, "Ninety");
			return map;
		}

		private static void prepare(final Map<Integer, String> map) {
			map.put(3, "Hundred");
			map.put(4, "Thousand");
			map.put(5, "Ten Thousand");
			map.put(6, "Lakh");
			map.put(7, "Ten Lakh");
			map.put(8, "Crore");
			map.put(9, "Ten Crore");
		}

		private static Map<Integer, String> prepareMapTwo() {
			final Map<Integer, String> map = Maps.newHashMap();
			map.put(1, "One");
			map.put(2, "Two");
			map.put(3, "Three");
			map.put(4, "Four");
			map.put(5, "Five");
			map.put(6, "Six");
			map.put(7, "Seven");
			map.put(8, "Eight");
			map.put(9, "Nine");
			map.put(11, "Eleven");
			map.put(12, "Twelve");
			map.put(13, "Thirteen");
			map.put(14, "Fourteen");
			map.put(15, "Fifteen");
			map.put(16, "Sixteen");
			map.put(17, "Seventeen");
			map.put(18, "Eighteen");
			map.put(19, "Nineteen");
			return map;
		}
	}
}
