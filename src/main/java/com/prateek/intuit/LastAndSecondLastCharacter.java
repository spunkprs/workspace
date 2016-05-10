package com.prateek.intuit;

public class LastAndSecondLastCharacter {

	public static void main(final String ar[]) {
		final String str = "APPLE";
		lastLetter(str);
	}
	
	private static void lastLetter(final String str) {
		char arr[] = str.toCharArray();
		if (arr.length >= 2) {
			System.out.print(arr[arr.length - 1]);
			System.out.print(" ");
			System.out.println(arr[arr.length - 2]);
		}
	}
}
