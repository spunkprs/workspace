package com.prateek.Preparation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

public class SpunkListTest {
	
	@Test
	public void shouldBeAbleToAddObjectOfAnyTypeToList() {
		//Set Up
		SpunkList<Integer> list = new SpunkList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(40);
		l1.add(30);
		l1.add(20);
		l1.add(10);
		
		List<Integer> l2 = new ArrayList<Integer>();
		
		for (Integer i : list) {
			l2.add(i);
		}
		
		Assert.assertEquals(l1.size(), l2.size());
		verify(l1, l2);
	}

	private void verify(List<Integer> l1, List<Integer> l2) {
		for (int i = 0; i < l1.size(); i++) {
			Assert.assertEquals(l1.get(i), l2.get(i));
		}
	}
}
