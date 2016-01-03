package com.prateek.pubmaticchallenge;

public class QuestionTwo {

	private static StringBuilder modifiedString;
	public static void main(String[] args) {
		String str = "aaabbcccdd";
		int buffer = 1;
		removeConsecutiveRunsOfSameCharacter(str, buffer);
		System.out.println(modifiedString);
	}

	/*
	 * Although there are two loops inside this method but the complexity is O(n) as the variable i is getting 
	 * incremented in both the loops.
	 * */
	
	private static void removeConsecutiveRunsOfSameCharacter(String string, int buffer) {
		modifiedString = new StringBuilder();
		char array[] = string.toCharArray();
		int i = 0;
		int j = 0;
		int counter = 1;
		
		if (array.length > 1) {
			while(i < array.length - 1) {
				j = i + 1;
				while(i < array.length - 1 && array[i] == array[j]) {
					counter++;
					i++;
					j++;
				}
				if (j == array.length) {
					j--;
					i--;
				}
				if (j == array.length - 1 || array[i] != array[j]) {
					if (j == array.length - 1) {
						modifyString(array, counter, buffer, i);
					} else {
						modifyString(array, counter, buffer, i-1);
					}
					counter = 1;
				}
				i++;
			}
			if (array[i - 1] != array[j]) {
				modifiedString.append(array[array.length - 1]);
			}
		} else {
			appendCharactersToModifiedString(0, 0, array);
		}
	}

	private static void modifyString(char array[] , int counter, int buffer, int index) {
		if (counter > buffer) {
			modifiedString.append(array[index]);
		} else if(counter > 1) {
			int endIndex = index + 1;
			int startIndex = endIndex - counter + 1;
			appendCharactersToModifiedString(startIndex, endIndex, array);
		} else {
			appendCharactersToModifiedString(index, index, array);
		}
	}

	private static void appendCharactersToModifiedString(int startIndex, int endIndex, char[] array) {
		for (int i = startIndex; i <= endIndex; i++) {
			modifiedString.append(array[i]);
		}
	}
}
