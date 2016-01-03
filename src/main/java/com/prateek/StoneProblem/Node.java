package com.prateek.StoneProblem;

import java.util.List;

import com.google.common.collect.Lists;

public class Node {
private int step;
private Node parent;
private List<Integer> visitedSteps;

public Node(final int step, final Node parent, final int buildingIndex) {
	this.parent = parent;
	this.step = step;
	this.visitedSteps = Lists.newArrayList(parent.getVisitedSteps());
	this.visitedSteps.add(step);
}

public Node(final List<Integer> visitedSteps) {
	this.visitedSteps = visitedSteps;
}

public int getStep() {
	return step;
}

public Node getParent() {
	return parent;
}

public List<Integer> getVisitedSteps() {
	return visitedSteps;
}
}
