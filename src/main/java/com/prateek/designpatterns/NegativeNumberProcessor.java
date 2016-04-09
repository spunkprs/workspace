package com.prateek.designpatterns;

public class NegativeNumberProcessor extends Processor {

	@Override
	public void process(final Number number) {
		if (number.getNumber() < 0.0) {
			System.out.println("Processing negative numbers");
		} else {
			throw new RuntimeException("Can not process numbers between 0.0 and 1.0");
		}
	}
}
