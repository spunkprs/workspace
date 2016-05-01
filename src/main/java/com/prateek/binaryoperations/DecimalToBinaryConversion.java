package com.prateek.binaryoperations;

public class DecimalToBinaryConversion {

	private static StringBuilder binaryString;
	public static String decimalToBinaryConversion(final int n) {
		binaryString = new StringBuilder();
		if (n == 0) {
			return "0";
		} else if (n == 1) {
			return "1";
		}
		convert(n);
		return binaryString.toString();
	}

	private static void convert(final int n) {
		if (n > 1) {
			convert(n >> 1);
		}
		binaryString.append(n & 1);
	}
}
