package com.prateek.basicthreadsynchronization;

import java.util.ArrayList;
import java.util.List;

public class ProducerAndConsumerOne {
	
	private List<Integer> list = new ArrayList<Integer>();
	
	public void produce(final int number) {
		list.add(number);
	}
	
	public void consume() {
		if (list.size() > 0)
			System.out.println("Consuming" + list.remove(0));
	}
	
	public List<Integer> getList() {
		return list;
	}
}
