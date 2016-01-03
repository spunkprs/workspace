package com.prateek.mediaoceanquestion;

public class MediaOceanQuestion {

	private static char[] arr;
	private static int counter = 1;
	private static int startPoint = 0;
	private static int endPoint = 0;
	private static int sum = 0;
	
	public static void main(String[] args) {

	}
	
	public static String validTriangleSum(final String input) {
		try {
			parseInput(input);
		} catch (Exception e) {
			return "Invalid";
		}
		return String.valueOf(sum);
	}
	
	private static void parseInput(final String input) throws Exception {
		arr = input.toCharArray();
		parse(arr);
	}

	private static void parse(final char[] arr) throws Exception {
		int i = 0; 
		int j = 0;
		while (i < arr.length) {
			setStartAndEndPoint();
			checkIfNonNumberExistsThroughStartAndEndIndex(startPoint, endPoint);
			j = 0;
			while(i <= endPoint && i < arr.length) {
				i = i+2;
				j++;
			}
			i = endPoint + 2;
			if (counter != j) {
				throw new Exception("Count mismatch");
			}
			getLargestNumberFromArray(); 
			counter++;
		}
		if (!(arr[arr.length - 1] >=48 && arr[arr.length - 1] <= 57)) {
			throw new Exception("Not an integer");
		}
	}

	private static void getLargestNumberFromArray() {
		
		int length = (endPoint - startPoint) / 2;
		 int indexOne = length;
		 int indexTwo = indexOne - 1;
		 
		 if (endPoint == 0)
			 indexTwo = indexOne;
		 
		 if (length == 1) {
			if (arr[indexTwo] < arr[indexOne]) {
				swap(indexTwo, indexOne);
			}
			 indexOne--;
		 }
		
		while(indexOne != 0) {
			int parentOne = getParent(indexOne);
			int parentTwo = getParent(indexTwo);
			
			if (isParentSame(parentOne, parentTwo)) {
				if (isShufflingRequired(parentOne, indexOne, indexTwo)) {
					if (arr[startPoint + 2 * indexOne] >= arr[startPoint + 2 * indexTwo]) {
						swap(parentOne, indexOne);
					} else {
						swap(parentOne, indexTwo);
					}
				}
				indexOne -= 2;
				indexTwo -= 2;
			} else {
				if (isShufflingRequired(parentOne, indexOne, indexOne)) {
					swap(parentOne, indexOne);
				}
				indexOne--;
				indexTwo--;
			}
		}
		char ch[] = new char[1];
		ch[0] =  arr[startPoint + 2 * indexOne];
		String st = new String(ch);
		sum += Integer.parseInt(st);
	}

	private static void swap(int indexTwo, int indexOne) {
		final char ch = arr[startPoint + 2 * indexTwo];
		arr[startPoint + 2 * indexTwo] = arr[startPoint + 2 * indexOne];
		arr[startPoint + 2 * indexOne] = ch;
	}

	private static boolean isShufflingRequired(int parent, int indexOne, int indexTwo) {
		if (arr[startPoint + 2 * parent] > arr[startPoint + 2 * indexTwo] && arr[startPoint + 2 * parent] > arr[startPoint + 2 * indexOne]) {
			return false;
		}
		return true;
	}

	private static boolean isParentSame(int parentOne, int parentTwo) {
		return parentOne == parentTwo ? true : false;
	}

	private static int getParent(int index) {
		return (index - 1)/2;
	}

	private static void checkIfNonNumberExistsThroughStartAndEndIndex(int startPoint, int endPoint) throws Exception {
		if (!(isCharInRange(startPoint, endPoint))) {
			throw new Exception("Not an integer");
		}
	}

	private static boolean isCharInRange(int startPoint, int endPoint) {
		for (int i = startPoint; i <= endPoint; i+=2) {
			if (!(arr[i] >=48 && arr[i] <=57)) {
				return false;
			}
		}
		return true;
	}

	private static void setStartAndEndPoint() {
		if (counter == 1) {
			startPoint = 0;
			endPoint = 0;
		} else {
			startPoint = endPoint + 2;
			endPoint = startPoint + (counter - 1)*2;
		}
	}
}
