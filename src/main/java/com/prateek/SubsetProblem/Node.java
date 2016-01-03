package com.prateek.SubsetProblem;

import java.util.List;

import com.google.common.collect.Lists;

public class Node {
private int startIndex;
private List<Integer> visistedIndexes;
private int number;
private int sum;
private Node parent;
private int level;

public Node getParent() {
	return parent;
}

public Node() {
	
}

public Node(final int startIndex, final Node parent, final int number) {
	this.startIndex = startIndex;
	this.parent = parent;
	this.level = parent.getLevel() + 1;
	addVisitedIndexesAndUpdateSum(startIndex, parent, number);
}

private void addVisitedIndexesAndUpdateSum(final int startIndex, final Node parent, final int number) {
	this.number = number;
	if (parent.getVisistedIndexes() == null) {
		visistedIndexes = Lists.newArrayList(startIndex);
		this.sum = number;
	} else {
		final List<Integer> visited = Lists.newArrayList(parent.getVisistedIndexes());
		visited.add(startIndex);
		this.visistedIndexes = visited;
		this.sum = parent.getSum() + number;
	}
}

public void setParent(Node parent) {
	this.parent = parent;
}

public int getStartIndex() {
	return startIndex;
}

public void setStartIndex(int startIndex) {
	this.startIndex = startIndex;
}

public List<Integer> getVisistedIndexes() {
	return visistedIndexes;
}

public void setVisistedIndexes(List<Integer> visistedIndexes) {
	this.visistedIndexes = visistedIndexes;
}

public int getSum() {
	return sum;
}

public void setSum(int sum) {
	this.sum = sum;
}

public int getNumber() {
	return number;
}

public void setNumber(int number) {
	this.number = number;
}

public int getLevel() {
	return level;
}
}
