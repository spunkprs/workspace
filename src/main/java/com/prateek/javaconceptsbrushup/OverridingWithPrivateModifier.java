package com.prateek.javaconceptsbrushup;

public class OverridingWithPrivateModifier {

	public static void main(String ar[]) {
		//Parent p = new Child();
		//p.info();
		OverridingWithPrivateModifier p = new OverridingWithPrivateModifierChild();
		p.info();
	}
	
	private void info() {
		System.out.println("Parent Here");
	}
}

 class OverridingWithPrivateModifierChild extends OverridingWithPrivateModifier {

	 public void info() {
		 System.out.println("Child Here");
	 }
	
}


class Parent {
	 void info() {
		System.out.println("Parent Here");
	}
}

class Child extends Parent {
	public void info() {
		System.out.println("Child Here");
	}
}
