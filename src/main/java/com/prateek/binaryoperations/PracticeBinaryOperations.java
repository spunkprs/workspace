package com.prateek.binaryoperations;

public class PracticeBinaryOperations {

	public static void main(final String ar[]) {
		final int x = 10;
		System.out.println(x);
		System.out.println(~x);
		//System.out.println(Math.pow(2, 33));
		int numberOfBitsToBeShifted = 33;
		int number = 5;
		leftBitShift(number, numberOfBitsToBeShifted);
		rightBitShiftWithSign(number, numberOfBitsToBeShifted);
		rightBitShiftWithoutSign(number, numberOfBitsToBeShifted);
	}

	//left bit shift is equivalent to left operand * Math.pow(2, right operand)
	private static void leftBitShift(int number, int numberOfBitsToBeShifted) {
		System.out.println("Number before bit shift" +" "+number);
		number = number << numberOfBitsToBeShifted;
		System.out.println("Number after left bit shift"+" "+ number);
	}
	//right bit sign shift is equivalent to left operand / Math.pow(2, right operand)
	private static void rightBitShiftWithSign(int number, int numberOfBitsToBeShifted) {
		System.out.println("Number before right bit sign shift" +" "+ number);
		number = number >> numberOfBitsToBeShifted;
		System.out.println("Number after right bit sign shift" +" "+ number);
	}
	
	private static void rightBitShiftWithoutSign(int number, int numberOfBitsToBeShifted) {
		System.out.println("Number before right bit shift" +" "+ number);
		number = number >>> numberOfBitsToBeShifted;
		System.out.println("Number after right bit shift" +" "+ number);
	}
}
