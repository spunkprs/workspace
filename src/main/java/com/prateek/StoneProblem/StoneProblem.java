package com.prateek.StoneProblem;

import java.util.List;

import com.google.common.collect.Lists;

public class StoneProblem {

	private List<List<Integer>> distinctStonePattern = Lists.newArrayList();
	private Node root = new Node(Lists.newArrayList(0));
	
	public List<List<Integer>> getAllPossibleCombinationsOfStones(final int steps[], final int numberOfStones) {
		prepareCombinationOfStones(root, steps, numberOfStones, 0);
		return distinctStonePattern;
	}
	
	private void prepareCombinationOfStones(final Node node, final int[] steps, final int numberOfStones, final int startIndex) {
		for (int i = startIndex; i < steps.length; i++) {
			Node child = new Node(steps[i], node, i);
			if (proceed(child, numberOfStones)) {
				prepareCombinationOfStones(child, steps, numberOfStones, i);
			} else {
				prepareDistinctStonePatternCombination(child);
			}
		}
	}

	private void prepareDistinctStonePatternCombination(final Node node) {
		distinctStonePattern.add(node.getVisitedSteps());
	}

	private boolean proceed(final Node child, final int numberOfStones) {
		if (child.getVisitedSteps().size() != numberOfStones) {
			return true;
		}
		return false;
	}
}
