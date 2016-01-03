package com.prateek.MetricStreamProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CoinCollectionProblem {

	private static Node root = new Node();
	private static int maxCountOfCollectedCoins = 0;
	private static Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
	private static int limit;
	private static int sizeOfStack;
	
	public static void main(final String ar[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int input = Integer.parseInt(line);
        for (int i = 0; i < input; i++) {
        	
        	final String in1 = br.readLine();
        	final String input1 [] = in1.split(" ");
        	
        	sizeOfStack = Integer.parseInt(input1[0]);
        	limit = Integer.parseInt(input1[1]);
        	
        	final String in2 = br.readLine();
        	final String input2 [] = in2.split(" ");
        	System.out.println(countMaximumNumberOfCollectedCoins(populateStacks(input2), limit));
        }
	}
	
	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	private static int[]  populateStacks(final String[] input) {
		int array [] = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			array[i] = Integer.parseInt(input[i]);
		}
		return array;
	}

	public static int countMaximumNumberOfCollectedCoins(final int stacks[], final int limit) {
		countMaxCollectedCoins(stacks, limit, root, 0, 0);
		return maxCountOfCollectedCoins;
	}

	private static void countMaxCollectedCoins(final int[] stacks, final int limit, final Node node, int startIndex, final int level) {
		for (int i = startIndex; i < stacks.length; i++) {
			
			if (stacks[i] <= limit && !alreadyExplored(i, stacks)) {
				Node child = new Node(node, stacks[i], level);
				map.put(i, true);
				countMaxCollectedCoins(stacks, limit, child, i + 1, child.getLevel());
				setMaxCountOfCollectedCoins(child);
			} else if (level != 0){
				break;
			}
		}
	}
	
	private static void setMaxCountOfCollectedCoins(Node child) {
		if (child.getNumberOfCoins() > maxCountOfCollectedCoins) {
			maxCountOfCollectedCoins = child.getNumberOfCoins();
		}
	}

	private static boolean alreadyExplored(int i, int[] stacks) {
		final Boolean flag = map.get(i);
		if (i == 0) {
			return false;
		} else if (flag != null && flag == true) {
			return true;
		}
		return false;
	}
}
