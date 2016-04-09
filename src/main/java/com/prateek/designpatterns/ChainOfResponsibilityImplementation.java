package com.prateek.designpatterns;

public class ChainOfResponsibilityImplementation {

	public static void main(String[] args) {
		final Processor positiveProcessor = new PositiveNumberProcessor();
		final Processor zeroNumberProcessor = new ZeroNumberProcessor();
		final Processor negativeNumberProcessor = new NegativeNumberProcessor();
		
		positiveProcessor.setNextProcessor(zeroNumberProcessor);
		zeroNumberProcessor.setNextProcessor(negativeNumberProcessor);
		
		positiveProcessor.process(new Number(10.0));
		positiveProcessor.process(new Number(-8.0));
		positiveProcessor.process(new Number(0.0));
		//positiveProcessor.process(new Number(0.5));
	}
}
