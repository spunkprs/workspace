package com.prateek.KrisQuestion;

import java.util.Map;

import com.google.common.collect.Maps;

public class ConvertStringToInteger {

	final Map<Character, Integer> map = Maps.newHashMap();
	
	public int convert(final String st) {
		
		int num = 0;
		final char arr[] = st.toCharArray();
		final int integerarr[] = new int[arr.length];
		prepareMap();
		
		for (int i = 0; i < arr.length; i++) {
			integerarr[i] = map.get(new Character(arr[i]));
		}
		
		for (int i = integerarr.length - 1 ; i >=0; i--) {
			if (i > 0) {
				num += Math.pow(10, i)*integerarr[integerarr.length- 1- i];
			} else {
				num += integerarr[integerarr.length- 1- i];
			}
		}
		
		return num;
	}

	private void prepareMap() {
		map.put('0', 0);
		map.put('1', 1);
		map.put('2', 2);
		map.put('3', 3);
		map.put('4', 4);
		map.put('5', 5);
		map.put('6', 6);
		map.put('7', 7);
		map.put('8', 8);
		map.put('9', 9);
	}
}
