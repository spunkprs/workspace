package com.prateek.mindtree.retake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidateCode {

	private static SuffixTree tree = new SuffixTree();
	
	/*
	public static void main(String[] args) {
		final int arr[] = {15,3,15,3};
		System.out.println(getPosition(arr));
	}
	*/
	public static String getPosition(int[] input1)
    {
		return buildTreeAndProduceResult(input1);
    }
	
	private static String buildTreeAndProduceResult(int[] arr) {
		return parseInputAndBuildTree(arr);
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
	
	private static boolean isLastElement(int i, int length) {
		return i < length - 1 ? false : true;
	}
	
	private static void build(final String data, final int index) {
		tree.addNode(data, index, tree.getRoot(), data);
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
	
	private static boolean validate(int num) {
		if (num > 20 || num < 0) {
			return false;
		} else {
			return true;
		}
	}



private static class SuffixTree {
private Node root = new Node("$", "$");
private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
private boolean flag;

public Node getRoot() {
	return root;
}

public Map<Integer, Integer> getMap() {
	return map;
}

public void setRoot(Node root) {
	this.root = root;
}

public void addNode(String data, final int index, final Node parent, final String resultantData) {
	flag = true;
	final List<Node> children = parent.getChildren();
	
	if (children.size() == 0) {
		insertNode(children, new Node(data, resultantData), flag, index);
	} else {
		for (Node child : children) {
			if (matchPattern(data, child.getData())) {
				final String updatedData = data.substring(child.getData().length());
				if (updatedData.length() != 0) {
					addNode(updatedData, index, child, resultantData);
					flag = false;
					break;
				} else {
					flag = false;
					child.getLeafs().add(index);
					buildMap(resultantData, index, child.getLeafs().size());
					break;
				}
			}
		}
		insertNode(children, new Node(data, resultantData), flag, index);
	}
	}

private void insertNode(List<Node> children, Node node, boolean flag, int index) {
	if (flag) {
		children.add(node);
		node.getLeafs().add(index);
	}
}

private void buildMap(final String resultantData, int index, int size) {
		Integer fr = map.get(index);
		int frequency = size > 1 ? resultantData.length() * (size - 1) : resultantData.length(); 
		if (fr != null) {
			if (frequency > fr) {
				map.put(index, frequency);
			}
		} else {
			map.put(index, frequency);
		}
}

private boolean matchPattern(final String text, final String pattern) {
	if (text.length() >= pattern.length()) {
		return text.startsWith(pattern) ? true : false; 
	} else {
		return pattern.startsWith(text) ? true : false; 
	}
}
}

private static class Node {
private String resultantData;	
private String data;
private List<Node> children = new ArrayList<Node>();
private List<Integer> positions = new ArrayList<Integer>();

public Node(final String data, final String resultantData) {
	this.resultantData = resultantData;
	this.data = data;
}

public String getData() {
	return data;
}

public String getResultantData() {
	return resultantData;
}

public List<Node> getChildren() {
	return children;
}
public void setChildren(List<Node> children) {
	this.children = children;
}
public List<Integer> getLeafs() {
	return positions;
}
public void setLeafs(List<Integer> leafs) {
	this.positions = leafs;
}
}

}

