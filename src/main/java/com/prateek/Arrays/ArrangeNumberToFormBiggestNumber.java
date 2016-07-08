package com.prateek.Arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrangeNumberToFormBiggestNumber {

	private int zeroCount = 0;
	
	public String biggestNumberApproachOne(final List<Integer> numbers) {
		if (zeroCount == numbers.size()) {
			return "0";
		}
		prepareBiggestNumberApproachTwo(numbers);
		final StringBuffer sb = new StringBuffer();
		for (Integer number : numbers) {
			sb.append(number);
		}
		return sb.toString();
	}

	private Comparator<Integer> fetchComparator() {
		return new Comparator<Integer>() {
			public int compare(Integer elementOne, Integer elementTwo) {
				String strOne = String.valueOf(elementOne);
				String strTwo = String.valueOf(elementTwo);
				return isNumOneGreaterThanNumTwo(strOne, strTwo);
			}
		};
	}
	
	private void prepareBiggestNumberApproachTwo(final List<Integer> numbers) {
		Collections.sort(numbers, fetchComparator());
	}

	private int isNumOneGreaterThanNumTwo(final String strOne, final String strTwo) {
		final String numOne = strOne.concat(strTwo);
		final String numTwo = strTwo.concat(strOne);
		
		final BigInteger numberOne = new BigInteger(numOne);
		final BigInteger numberTwo = new BigInteger(numTwo);
		
		if (numberOne.compareTo(numberTwo) == 1) {
			return -1;
		} else if (numberOne.compareTo(numberTwo) == 0) {
			return 0;
		}
		return 1;
	}
	
	public String biggestNumberApproachTwo(final List<Integer> numbers) {
		final List<Integer> listOfNumbers = prepareListOfNumbers(numbers);
		return biggestNumberApproachOne(listOfNumbers);
	}

	private List<Integer> prepareListOfNumbers(final List<Integer> numbers) {
		final List<Integer> listOfNumbers = new ArrayList<Integer>();
		for (Integer number : numbers) {
			if (number == 0) {
				zeroCount++;
			}
			listOfNumbers.add(number);
		}
		return listOfNumbers;
	}
}
