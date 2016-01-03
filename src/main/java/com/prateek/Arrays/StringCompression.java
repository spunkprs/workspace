package com.prateek.Arrays;

public class StringCompression {

	private int len = 0;
	private String compressedString = new String();
	private int initialPosition = 0;
	
	public String compress(final String input) {
		
		final char arr[] = input.toCharArray();
		if (input.length() > 1) {
			while (len < arr.length) {
				buildCompressedString(arr); 
			}
		}
		return checkIsSmallerThanOriginal(input);
	}
	
	private String checkIsSmallerThanOriginal(final String input) {
		return compressedString.length() < input.length() ? compressedString : input; 
	}

	private void buildCompressedString(char[] arr) {
		int i = initialPosition;
		int j = i + 1;
		int counter = 1;
		
		while (j < arr.length && arr[i] == arr[j]) {
			i++;
			j++;
			counter++;
		}
		len += counter;
		String st = Character.valueOf(arr[initialPosition]).toString();
		compressedString += st + Integer.valueOf(counter).toString();
		initialPosition = j;
	}
}
