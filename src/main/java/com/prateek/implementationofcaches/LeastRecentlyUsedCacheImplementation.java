package com.prateek.implementationofcaches;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedCacheImplementation {

	private NodeList head;
	private NodeList tail;
	private Map<Node, NodeList> map = new HashMap<Node, NodeList>();
	
	private int sizeOfCache = 3;
	
	public Map<Node, NodeList> getNode(final Node n) {
		if (map.get(n) != null) {
			final NodeList existingNodeList = map.get(n);
			updateReferences(existingNodeList);
		} else {
			if(map.size() < sizeOfCache) {
				final NodeList newNodeList = createNewNodeList(n);
				map.put(n, newNodeList);
			} else {
				final NodeList leastRecentlyUsedNodeList = getLeastRecentlyUsedCache();
				map.remove(leastRecentlyUsedNodeList.getNode());
				final NodeList newNodeList = createNewNodeList(n);
				map.put(n, newNodeList);
			}
		}
		return map;
	}

	private void updateReferences(final NodeList existingNodeList) {
		if (existingNodeList.getPrevious() != null && existingNodeList.getNext() != null) {
			existingNodeList.getNext().setPrevious(existingNodeList.getPrevious());
			existingNodeList.getPrevious().setNext(existingNodeList.getNext());
			existingNodeList.setPrevious(tail);
			tail.setNext(existingNodeList);
			existingNodeList.setNext(null);
			tail = existingNodeList;
		} else if (existingNodeList.getPrevious() == null && existingNodeList.getNext() != null) {
			head = existingNodeList.getNext();
			existingNodeList.setPrevious(tail);
			tail.setNext(existingNodeList);
			existingNodeList.setNext(null);
			tail = existingNodeList;
		}
	}

	private NodeList getLeastRecentlyUsedCache() {
		NodeList leastRecentlyUsedNodeList = null;
		if (head.getNext() != null) {
			leastRecentlyUsedNodeList = head;
			head = head.getNext();
			return leastRecentlyUsedNodeList;
		} else {
			leastRecentlyUsedNodeList = head;
			head = null;
			tail = null;
			return leastRecentlyUsedNodeList;
		}
	}

	private NodeList createNewNodeList(final Node n) {
		NodeList node = null;
		if (tail == null && head == null) {
			node = new NodeList(null, null, n);
			head = node;
			tail = node;
		} else {
			node = new NodeList(tail, null, n);
			tail.setNext(node);
			tail = node;
		}
		return tail;
	}
}
