package com.prateek.designpatterns;

public abstract class Processor {

	private Processor nextProcessor;
	
	public void setNextProcessor(final Processor processor) {
		this.nextProcessor = processor;
	}
	
	public Processor getNextProcessor() {
		return this.nextProcessor;
	}
	
	public abstract void process(final Number number);
}
