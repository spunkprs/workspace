package com.prateek.mindtreeproblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuffixTree {
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

