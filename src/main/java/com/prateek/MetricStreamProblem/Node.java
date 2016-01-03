package com.prateek.MetricStreamProblem;

public class Node {
private Node parent;
private int numberOfCoins;
private int level; 

public Node() {
	
}

public Node(final Node parent, final int numberOfCoins, final int level) {
	this.parent = parent;
	this.numberOfCoins = parent.getNumberOfCoins() + numberOfCoins;
	this.level = level + 1;
}

public Node getParent() {
	return parent;
}

public int getNumberOfCoins() {
	return numberOfCoins;
}

public int getLevel() {
	return level;
}
}
