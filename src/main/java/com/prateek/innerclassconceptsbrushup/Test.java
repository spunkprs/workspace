package com.prateek.innerclassconceptsbrushup;

public class Test {

	public static void main(String[] args) {
		
     OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass("staticInnerClassMessage");
     OuterClass outerClass = new OuterClass("outerClassMessage");
     OuterClass.InnerClass innerClass = outerClass.new InnerClass("innerClassMessage");
     
     OuterClass.StaticInnerClass.InnerOne innerOne = staticInnerClass.new InnerOne();
     
     staticInnerClass.display();
     outerClass.displayMessage();
     innerClass.display();
     innerClass.displayAppendedMessage();
     
     innerOne.display();
     
	}
}


class OuterClass {
	
	private String outerClassMessage;
	OuterClass(final String message) {
		this.outerClassMessage = message;
	}
	
	public void displayMessage() {
		System.out.println(outerClassMessage);
	}
	
	static class StaticInnerClass {
		private String staticInnerClassMessage;
		
		public StaticInnerClass(final String message) {
			this.staticInnerClassMessage = message;
		}
		
		public void display() {
			System.out.println(staticInnerClassMessage);
		}
		
		class InnerOne {
			public void display() {
				System.out.println(staticInnerClassMessage);
			}
		}
		
	}
	
	class InnerClass {
		private String innerClassMessage;
		InnerClass(final String innerClassMessage) {
			this.innerClassMessage = innerClassMessage;
		}
		
		public void display() {
			System.out.println(innerClassMessage);
		}
		
		public void displayAppendedMessage() {
			System.out.println(outerClassMessage + " " + innerClassMessage);
		}
	}
}
