package com.prateek.binaryoperations;

import java.util.ArrayList;
import java.util.List;

public class OperationsOnNumbersWithoutArithmeticOperators {
	
	private static int binaryFormat[] = new int[32];
	public static List<Integer> getTwoNumbersWhichAreRepeatedOddNumberOfTimesWhileOtherAreRepeatedEvenNumberOfTimes(final int arr[]) {
		int xorOfAllElements = getXorOfAllElements(arr);
		int lowestSetBit = 1;
		int elementOne = 0;
		int elementTwo = 0;
		while (((xorOfAllElements & lowestSetBit) == 0)) {
			lowestSetBit = lowestSetBit << 1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if ((lowestSetBit & arr[i]) == lowestSetBit) {
				elementOne^= arr[i];
			}
		}
		
		elementTwo = elementOne ^ xorOfAllElements;
		List<Integer> list = new ArrayList<Integer>();
		list.add(elementOne);
		list.add(elementTwo);
		return list;
	}
	
	public static int[] convertDecimalToBinaryWithoutUsingModuloOperator(final int number) {
		convert(number);
		return binaryFormat;
	}
	
	private static void convert(final int number) {
		int helper = 1;
		int position = 0;
		while(helper <= number) {
			helper = helper << 1;
			position++;
		}
		helper = helper >> 1;
		prepareBinaryFormatOfNumber(position);
		if (number > helper) {
			convert(number - helper);
		}
	}

	private static void prepareBinaryFormatOfNumber(int position) {
		binaryFormat[binaryFormat.length - position] = 1;
	}

	private static int getXorOfAllElements(int[] arr) {
		int xor = 0;
		for (int element : arr) {
			xor^= element;
		}
		return xor;
	}

	public static int numberOfOnesInANumber(final int number) {
		int length = 0;
		int zeroCount = 0;
		int a = 2;
		if (isEven(number)) {
			length++;
			zeroCount++;
		} else {
			length++;
		}
		while (number >= a) {
			if ((number & a) == 0) {
				zeroCount++;
			}
			length++;
			a = a << 1;
		}
		return length - zeroCount;
	}

	private static boolean isEven(int number) {
		return (number & 1) == 1 ? false : true;
	}

	public int add(final int a, final int b) {
		if(!checkIfAnyCommonBitIsSet(a, b)) {
			return calculateXOR(a, b);
		} else {
			return calculate(a, b);
		}
	}

	private int calculate(int a, int b) {
		while (b!=0) {
			int carry = (a&b);
			a = calculateXOR(a, b);
			b = carry << 1;
		}
		return a;
	}

	private int calculateXOR(final int a, final int b) {
		return (a^b);
	}

	private boolean checkIfAnyCommonBitIsSet(final int a, final int b) {
		return (a & b) == 0 ? false : true;
	}
	
	public int multiply(final int a, final int b) {
		if(checkIfAnyOperandIsZero(a, b)) {
			return 0;
		} 
		return performMultiplication(a, b);
	}

	private int performMultiplication(int a, int b) {
		boolean flag = false;
		if (isNegative(a)) {
			a = -a;
			flag = true;
		}
		if (isNegative(b)) {
			b = -b;
			if(!flag) {
				flag = true;
			} else {
				flag = false;
			}
		}
		int m = 0;
		while(a!=0) {
			if ((a & 1) == 1) {
				m+=b;
			}
			a = a >> 1;
			b = b << 1;
		}
		return flag == true ? -m : m;
	}

	private boolean isNegative(int a) {
		return a < 0 ? true : false;
	}

	private boolean checkIfAnyOperandIsZero(int a, int b) {
		if (a << 1 == 0 || b << 1 == 0) {
			return true;
		}
		return false;
	}
	
	public int subtract(final int a, final int b) {
		if(!checkIfAnyCommonBitIsSet(~a, b)) {
			return calculateXOR(a, b);
		} else {
			return calculateSubtraction(a, b);
		}
	}

	private int calculateSubtraction(int a, int b) {
		while(b!=0) {
			int borrow = ((~a) & b );
			a = calculateXOR(a, b);
			b = borrow << 1;
		}
		return a;
	}
	
	public int division(int a, int b) {
		int c = b;
		int quotient = 1;
		if (a == b) {
			return 1;
		} else if (a < b) {
			return 0;
		} else {
			while(a >= b) {
				b = b << 1;
				quotient = quotient << 1;
			}
			quotient = quotient >> 1;
			b = b >> 1;
			quotient += division(a - b, c);	
		}
		return quotient;
	}
}
