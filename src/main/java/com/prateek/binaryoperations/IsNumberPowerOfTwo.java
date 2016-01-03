package com.prateek.binaryoperations;

public class IsNumberPowerOfTwo {

	public static void main(String[] args) {
      System.out.println(isPowerOfTwo(32));
	}
	
	public static boolean isPowerOfTwo(final int number) {
		int num = number - 1;
		int andOperation = number & num;
		return andOperation == 0 ? true : false;
	}
}
