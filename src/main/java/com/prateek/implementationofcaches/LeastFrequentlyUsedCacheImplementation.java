package com.prateek.implementationofcaches;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeastFrequentlyUsedCacheImplementation {
	
	private Map<Node, Integer> mapOne = new HashMap<Node, Integer>();
	private TreeMap<Integer, Pair<NodeList, Map<Node, NodeList>>> mapTwo = new TreeMap<Integer, Pair<NodeList, Map<Node, NodeList>>>();
	
	private int sizeOfCache = 3;
	
	public Map<Node, Integer> getNode(final Node n) {
		if (mapOne.get(n) != null) {
			updateMaps(n);
		} else {
			if (mapOne.size() < sizeOfCache) {
				mapOne.put(n, 1);
				populateMapTwo(n, mapTwo, 1);
			} else {
				removalOfLeastFrequentlyUsedNode();
				populateMapTwo(n, mapTwo, 1);
			}
		}
		return mapOne;
	}

	private void updateMaps(final Node n) {
		final Pair<NodeList, Map<Node, NodeList>> pair = mapTwo.get(mapOne.get(n));
		final NodeList existingNodeList = pair.getR().get(n);
		updateReferences(existingNodeList, pair);
		mapOne.put(n, mapOne.get(n) + 1);
		populateMapTwo(n, mapTwo, mapOne.get(n) + 1);
	}

	private void updateReferences(final NodeList existingNodeList, final Pair<NodeList, Map<Node, NodeList>> pair) {
		if (existingNodeList.getNext() == null && existingNodeList.getPrevious() == null) {
			mapTwo.remove(existingNodeList.getNode());
		} else if (existingNodeList.getNext() == null) {
			existingNodeList.getPrevious().setNext(null);
			pair.setL(existingNodeList.getPrevious());
		} else {
			final NodeList nextNodeList = existingNodeList.getNext();
			final NodeList previousNodeList = existingNodeList.getPrevious();
			previousNodeList.setNext(nextNodeList);
			nextNodeList.setPrevious(previousNodeList);
			pair.setL(previousNodeList);
			pair.getR().remove(existingNodeList.getNode());
		}
	}

	private void removalOfLeastFrequentlyUsedNode() {
		final Pair<NodeList, Map<Node, NodeList>> pair =  mapTwo.get(mapTwo.firstKey());
		final NodeList head = pair.getL();
		if (head.getNext() != null) {
			final NodeList nextNodeList = head.getNext();
			nextNodeList.setPrevious(null);
			pair.setL(nextNodeList);
			pair.getR().remove(head.getNode());
		} else {
			mapTwo.remove(mapTwo.firstKey());
		}
		mapOne.remove(head);
	}

	private void populateMapTwo(final Node n, final Map<Integer, Pair<NodeList, Map<Node, NodeList>>> mapTwo, final int frequency) {
		Pair<NodeList, Map<Node, NodeList>> pair = mapTwo.get(frequency);
		 if (null != pair) {
			 final NodeList existingNodeList = pair.getL();
			 final NodeList newNodeList = createNodeList(null, existingNodeList, n);
			 existingNodeList.setNext(newNodeList);
			 pair.getR().put(n, newNodeList);
		 } else {
			 final NodeList nodeList = createNodeList(null, null, n);
			 final Map<Node, NodeList> m = new HashMap<Node, NodeList>();
			 m.put(n, nodeList);
			 pair = new Pair<NodeList, Map<Node,NodeList>>(nodeList, m);
			 mapTwo.put(frequency, pair);
		 }
 	}
	
	private NodeList createNodeList(final NodeList next, final NodeList previous, final Node n) {
		return new NodeList(previous, next, n);
	}

	private static class Pair<L, R> {
		private L l;
		private R r;
		
		private Pair(final L l, final R r) {
			this.l = l;
			this.r = r;
		}
		
		private L getL() {
			return this.l;
		}
		
		private R getR() {
			return this.r;
		}
		
		private void setL(final L l) {
			this.l = l;
		}
		
		private void setR(final R r) {
			this.setR(r);
		}
	}
}
