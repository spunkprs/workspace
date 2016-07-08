package com.prateek.quintype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FindingFactorsOfNumber {
	
	public static void main(final String ar[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			final int numberOfNumbers = Integer.parseInt(line);
			
			line = br.readLine();
			final String[] numbers = line.split(" "); 
			BigInteger product = new BigInteger("1");
			
			for (int i = 0; i < numbers.length; i++) {
				product = product.multiply(new BigInteger(numbers[i]));
			}
			//System.out.print(findFactorsOfNumber(product).size());
			System.out.print(findFactorsOfNumberApproachTwo(product));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static List<BigInteger> findFactorsOfNumber(final BigInteger number) {
		final List<BigInteger> factors = new ArrayList<BigInteger>();
		
		BigInteger startIndex = new BigInteger(String.valueOf(1));
		BigInteger endIndex = new BigDecimal(Math.sqrt(number.doubleValue())).toBigInteger();
		BigInteger nextEndIndex = endIndex.add(new BigInteger("1"));
		
		while(!startIndex.equals(nextEndIndex)) {
			BigInteger remainder = number.remainder(startIndex);
			BigInteger quotient = number.divide(startIndex);
			if (remainder.equals(new BigInteger("0"))) {
				factors.add(startIndex);
			}
			if (!startIndex.equals(quotient)) {
				factors.add(quotient);
			}
			 startIndex = startIndex.add(new BigInteger("1"));
		}
		return factors;
	}
	
	private static BigInteger findFactorsOfNumberApproachTwo(final BigInteger number) {
		BigInteger numberOfFactors = new BigInteger("0");	
		BigInteger startIndex = new BigInteger(String.valueOf(1));
		BigInteger endIndex = new BigDecimal(Math.sqrt(number.doubleValue())).toBigInteger();
		BigInteger nextEndIndex = endIndex.add(new BigInteger("1"));
		
		while(!startIndex.equals(nextEndIndex)) {
			BigInteger remainder = number.remainder(startIndex);
			BigInteger quotient = number.divide(startIndex);
			if (remainder.equals(new BigInteger("0"))) {
				numberOfFactors = numberOfFactors.add(new BigInteger("1"));
			}
			if (!startIndex.equals(quotient)) {
				numberOfFactors = numberOfFactors.add(new BigInteger("1"));
			}
			 startIndex = startIndex.add(new BigInteger("1"));
		}
		return numberOfFactors;
	}

	private static BigInteger calculateProductOfArrayElements(final List<Integer> numbers) {
		BigInteger product = new BigInteger("1");
		for (Integer element : numbers) {
			final BigInteger number = new BigInteger(String.valueOf(element));
			product = product.multiply(number);
		}
		return product;
	}
	
	public static BigInteger fetchNumberOfFactorsForProductOfElements(final List<Integer> numbers) {
		final BigInteger product = calculateProductOfArrayElements(numbers);
		final List<BigInteger> factors = findFactorsOfNumber(product);
		return new BigInteger(String.valueOf(factors.size()));
	}
}
