package com.prateek.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PracticeGenerics {

	public static void main(String[] args) {
		
		final List<String> l = new ArrayList<String>();
		//unsafeAdd(l, new Integer(20));
		//System.out.println(l.get(0));
		
		Set<String> s1 = new HashSet<String>();
		s1.add("one");
		s1.add("two");
		printElements(s1);
		String sOne = "Prateek";
		String sTwo = "Neha";
		System.out.println(sTwo.compareTo(sOne));
	}


	private static void printElements(Set<?> s1) {
		
		Iterator<?> i = s1.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}


	private static void unsafeAdd(List l, Integer integer) {
		l.add(integer);
	}

}
