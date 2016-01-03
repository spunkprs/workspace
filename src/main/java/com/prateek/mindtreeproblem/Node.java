package com.prateek.mindtreeproblem;

import java.util.ArrayList;
import java.util.List;

public class Node {
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
