package com.prateek.mindtreeproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Client {

	private static SuffixTree tree = new SuffixTree();
	
	public static void main(final String ar[]) {
		
		final int arr[] = {15, 3, 15, 3};
		final String output = buildTree(arr);
		System.out.println(output);
	}

	private static String buildTree(int[] arr) {
			return parseInputAndBuildTree(arr);
	}
	
	private static String getOutput(Map<Integer, Integer> map, final int index) {
		String out = null;
			Integer frequency = map.get(index);
			if (frequency == null) {
				out = String.valueOf(0);
			} else {
				out = String.valueOf(frequency.intValue());
		}
		return out;
	}

	private static String parseInputAndBuildTree(int[] arr) {
		String out = null;
		String output = "";
		for (int i = 0; i < arr.length; i++) {
			 if (validate(arr[i])) {
				 final List<String> data = buildStrings(arr, i);
					for (String str : data) {
						build(str, i);
					}
					out = getOutput(tree.getMap(), i);
			 } else {
				 out = "invalid"; 
			 }
			 if(!isLastElement(i, arr.length)) {
				 out = out + ",";
				 output = output + out;
			 } else {
				 output = output + out;
			 }
		}
        return output;		
	}

	private static boolean isLastElement(int i, int length) {
		return i < length - 1 ? false : true;
	}

	private static List<String> buildStrings(int[] arr, int i) {
		final List<String> data = new ArrayList<String>();
		String str = new String();
		for (int j = i; j >= 0; j--) {
			char x = (char) (65 + arr[j]);
			str = Character.toString(x) + str;
			data.add(str);
		}
		return data;
	}

	private static void build(final String data, final int index) {
		tree.addNode(data, index, tree.getRoot(), data);
	}

	private static boolean validate(int num) {
		if (num > 20 || num < 0) {
			return false;
		} else {
			return true;
		}
	}
}
