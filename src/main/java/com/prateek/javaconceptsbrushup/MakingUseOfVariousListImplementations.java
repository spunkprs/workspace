package com.prateek.javaconceptsbrushup;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MakingUseOfVariousListImplementations {

	public static void main(String[] args) {
      final List<Integer> l1 = new ArrayList<Integer>();
      final List<Integer> l2 = new LinkedList<Integer>();
      
      addElementsToListOne(l1);
      addElementsToListTwo(l2);
      
      final Deque<Integer> deque = (Deque<Integer>)l2;
      deque.addFirst(99);
      deque.addLast(90);
      
      l1.remove(1);
      l2.remove(1);
      System.out.println(deque.remove());
      
      System.out.println("Printing ArrayList Elements");
      printList(l1);
      System.out.println("Printing LinkedList Elements");
      printList(l2);
      
      System.out.println("At Index 2"+" " + l2.get(2));
      //l2.get(9);
	}

	private static void printList(List<Integer> l) {
		for (Integer i : l) {
			System.out.println(i);
		}
	}

	private static void addElementsToListTwo(List<Integer> l2) {
		l2.add(10);
		l2.add(12);
		l2.add(33);
		l2.add(44);
	}

	private static void addElementsToListOne(List<Integer> l1) {
		l1.add(10);
		l1.add(20);
		l1.add(30);
	}
}
