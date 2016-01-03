package com.prateek.goldmansachs;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution1 {

	public static void main(String[] args) {

		Set s = new TreeSet();
		s.add("3");
		s.add("1");
		s.add("2");
		
		Iterator it = s.iterator();
		while(it.hasNext()) {
			System.out.println(it.next() + " ");
		}
	}

}
