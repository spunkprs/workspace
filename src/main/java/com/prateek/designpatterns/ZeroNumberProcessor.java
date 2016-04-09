package com.prateek.designpatterns;

public class ZeroNumberProcessor extends Processor {

	@Override
	public void process(final Number number) {
		if (number.getNumber() == 0.0) {
			System.out.println("Processing number zero");
		} else {
			this.getNextProcessor().process(number);
		}
	}
}
