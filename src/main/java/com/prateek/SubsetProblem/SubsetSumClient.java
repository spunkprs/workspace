package com.prateek.SubsetProblem;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

public class SubsetSumClient {
	private Node root = new Node();
	private List<List<Integer>> subSetsForSum = Lists.newArrayList();
	private int desiredSum;
	private Map<Pair, Node> map = Maps.newHashMap();

	public List<List<Integer>> getSubsetsThatSumUpToANumber(final int array[], final int desiredSum) {
		this.desiredSum = desiredSum;
		produceSubSets(array, 0, root);
		return subSetsForSum;
	}

	private void produceSubSets(int[] array, int startIndex, Node parent) {
		for (int i = startIndex; i < array.length; i++) {
			Node child = new Node(i, parent, array[i]);
			if (child.getSum() < desiredSum && i != array.length && !doesNumberAlreadyExistsAtSameLevel(child, array[i])) {
				int j = i + 1;
				
					produceSubSets(array, j, child);
				
				map.put(new Pair(child.getNumber(), child.getLevel()), child.getParent());
			} else if (child.getSum() == desiredSum && !doesNumberAlreadyExistsAtSameLevel(child, array[i])){
				map.put(new Pair(child.getNumber(), child.getLevel()), child.getParent());
				processIndexesAndPrepareSet(child.getVisistedIndexes(), array);
			}
		}
	}

	private void processIndexesAndPrepareSet(final List<Integer> visistedIndexes, final int[] array) {
		final List<Integer> sets = Lists.newArrayList();
		for (int i = 0; i < visistedIndexes.size(); i++) {
			sets.add(array[visistedIndexes.get(i)]);
		}
		subSetsForSum.add(sets);
	}
	
	public boolean doesNumberAlreadyExistsAtSameLevel(final Node node, final int num) {
		final Node n = map.get(new Pair(node.getNumber(), node.getLevel()));
		if (n != null && node.getParent() == n) {
			return true;
		}
		return false;
	}
	
	class Pair {
		@BusinessKey final int left;
		@BusinessKey final int right;
		
		private Pair(final int left, final int right) {
			this.left = left;
			this.right = right;
		}
		
		@Override
		public int hashCode() {
			return BusinessIdentity.getHashCode(this);
		}
		
		public boolean equals(final Object obj) {
			return BusinessIdentity.areEqual(obj, this);
		}
	}
}
