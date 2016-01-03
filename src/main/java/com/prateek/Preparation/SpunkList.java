package com.prateek.Preparation;

import java.util.Iterator;

public class SpunkList<T> implements Iterable<T> {
	
	private Node<T> head;
	private Node<T> currentNode;
	
	public void add(T obj) {
		
		if (head != null) {
			Node<T> n = new Node<T>(obj);
			n.next = head;
			head = n;
			currentNode = head;
		} else {
			head = new Node<T>(obj);
			currentNode = head;
		}
	}
	
	private void regainPreviousState() {
		currentNode = head;
	}
	
	public class Node<T> {
		T object;
		Node<T> next;
		private Node(final T obj) {
			this.object = obj;
		}
		
		private Node<T> getNext() {
			return next;
		}
		
		private T getObject() {
			return object;
		}
	}
	
	public Iterator<T> iterator() {
		
		return new Iterator<T>() {
			
			private T obj;

			public boolean hasNext() {
				boolean flag = false;
				
				if (currentNode == null) {
					flag = false; 
					regainPreviousState();
				} else {
					flag = true;
					obj = currentNode.getObject();
					currentNode = currentNode.getNext();
				}
				return flag;
			}

			public T next() {
				return obj;
			}

			public void remove() {
				
			}
		};
	}

}
