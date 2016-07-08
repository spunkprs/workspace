package com.prateek.Arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumber {

	public ArrayList<Integer> repeatedNumber(final List<Integer> numbers) {
		final ArrayList<Integer> list = new ArrayList<Integer>();
		
		final BigInteger sum = getSumofNumbersInList(numbers);
		final BigInteger sumOfNPositiveIntegers = BigInteger.valueOf(numbers.size()).multiply(BigInteger.valueOf(numbers.size() + 1)).divide(BigInteger.valueOf(2));
		
		int repeatingNumber = fetchRepeatingNumber(numbers);
		BigInteger diff = sum.subtract(BigInteger.valueOf(repeatingNumber));
		BigInteger missingNumber = sumOfNPositiveIntegers.subtract(diff);
		
		list.add(repeatingNumber);
		list.add(missingNumber.intValue());
		return list;
	}
	
	public ArrayList<Integer> repeatedNumberApproachTwo(final List<Integer> numbers) {
		final ArrayList<Integer> list = new ArrayList<Integer>();
		
		final BigInteger sum = getSumofNumbersInList(numbers);
		final BigInteger sumOfNPositiveIntegers = BigInteger.valueOf(numbers.size()).multiply(BigInteger.valueOf(numbers.size() + 1)).divide(BigInteger.valueOf(2));
		
		int repeatingNumber = fetchRepeatingNumber(prepareList(numbers));
		BigInteger diff = sum.subtract(BigInteger.valueOf(repeatingNumber));
		BigInteger missingNumber = sumOfNPositiveIntegers.subtract(diff);
		
		list.add(repeatingNumber);
		list.add(missingNumber.intValue());
		return list;
	}

	private ArrayList<Integer> prepareList(final List<Integer> numbers) {
		final ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numbers.size(); i++) {
			list.add(numbers.get(i));
		}
		return list;
	}

	private int fetchRepeatingNumber(final List<Integer> numbers) {
		int repeatingNumber = -1;
		for (int i = 0; i < numbers.size(); i++) {
			int numberAtIndex = numbers.get(Math.abs(numbers.get(i)) - 1);
			if (numberAtIndex < 0) {
				repeatingNumber = Math.abs(numbers.get(i));
			}
			numbers.set(Math.abs(numbers.get(i)) - 1, numberAtIndex * -1);
			
		}
		for (int i = 0; i < numbers.size(); i++) {
			int num = numbers.get(i);
			if (num < 0) {
				numbers.set(i, num * -1);
			} 
		}
		return repeatingNumber;
	}

	private BigInteger getSumofNumbersInList(final List<Integer> numbers) {
		BigInteger sum = BigInteger.valueOf(0);
		for (Integer number : numbers) {
			sum = sum.add(BigInteger.valueOf(number));
		}
		return sum;
	}
}
