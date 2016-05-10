package com.prateek.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AmazonQuestionTwo {

	private static int arr[][];
	private static int sum = 0;
	private static boolean flag = false;
	
	public static void main(final String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int size = Integer.parseInt(line);
		int numberOfNodes = 0;
		for (int i = 1; i <= size; i++) {
			numberOfNodes = Integer.parseInt(br.readLine());
			populateDataInArray(numberOfNodes, br);
			processForCalculationOfPathSum(numberOfNodes);
		}
	}
	
	private static void processForCalculationOfPathSum(final int numberOfNodes) {
		for (int i = 0; i < numberOfNodes - 1; i++) {
			for (int j = i + 1; j < numberOfNodes; j++) {
				int source = i;
				int destination = j;
				traverseUsingDFS(source, destination);
			}
		}
		System.out.println(sum);
	}
	
	private static void traverseUsingDFS(int source, int destination) {
		final Stack<Integer> stack = new Stack<Integer>();
		traverse(source, destination, stack, -1);
		flag = false;
		sum += findMax(stack);
	}

	private static int findMax(final Stack<Integer> stack) {
		int max = Integer.MIN_VALUE;
		int prev = stack.pop();
		while(!stack.empty()) {
			int temp = stack.pop();
			int wt = arr[temp][prev];
			if (wt > max) {
				max = wt;
			}
			prev = temp;
		}
		return max;
	}

	private static void traverse(int source, int destination, final Stack<Integer> stack, final int parent) {
		if (source != destination) {
			stack.push(source);
			for (Integer child : getChildren(source)) {
				if (child != parent  && !flag) {
					traverse(child, destination, stack, source);
				}
			}
			if (!flag) {
				stack.pop();
			}
			
		} else {
			stack.push(source);
			flag = true;
		}
	}

	private static List<Integer> getChildren(final int source) {
		final List<Integer> children = new ArrayList<Integer>();
		for (int j = 0; j < arr.length; j++) {
			if (arr[source][j] != 0) {
				children.add(j);
			}
		}
		return children;
	}
	
	private static void populateDataInArray(final int numberOfNodes, final BufferedReader bufferedReader) throws IOException {
		arr = new int[numberOfNodes][numberOfNodes];
		for (int i = 1; i < numberOfNodes; i++) {
			final String line = bufferedReader.readLine();
			final String data[] = line.split(" ");
			arr[Integer.parseInt(data[0]) - 1][Integer.parseInt(data[1]) - 1] = Integer.parseInt(data[2]);
			arr[Integer.parseInt(data[1]) - 1][Integer.parseInt(data[0]) - 1] = Integer.parseInt(data[2]);
		}
	}
}
