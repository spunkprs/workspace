package com.prateek.binaryoperations;

public class PositionOfOnlySetBit {

	public static int getPositionOfOnlySetBit(final int number) throws Exception {
		int positionOfOnlySetBit = -1;
		
		if(IsNumberPowerOfTwo.isPowerOfTwo(number)) {
			positionOfOnlySetBit = getPosition(number);
		} else {
			throw new Exception("More than One Set Bits Were Found");
		}
		return positionOfOnlySetBit;
	}

	private static int getPosition(int number) {
		int position = 0;
		int i = 1;
		
		while (i != number) {
			position++;
			i = i << 1;
		}
		return position;
	}
}
