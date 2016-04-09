package com.prateek.designpatterns;

public class PositiveNumberProcessor extends Processor {

	@Override
	public void process(final Number number) {
		if (number.getNumber() >= 1.0) {
			System.out.println("Processing positive number greater than 1.0");
		} else {
			this.getNextProcessor().process(number);
		}
	}

}
