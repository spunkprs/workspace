package com.prateek.overloadingconceptsbrushup;

public class Test {

	public static void main(String[] args) {
      TestOverloading testOverloading = new TestOverloading();
      
      int l1 = 4;
      int l2 = 3;
      testOverloading.overload(l1, l2);
      testOverloading.overload(2.0, 9.0);
      
	}
}

class TestOverloading {
	
	public void overload(final int i, final int j) {
		System.out.println("Overloading with Integers");
	}

    public void overload(final long i, final long j) {
    	System.out.println("Overloading with Long");
	}
    public void overload(final double i, final double j) {
    	System.out.println("Overloading with Double");
	}
    public void overload(final float i, final float j) {
    	System.out.println("Overloading with Float");
	}
}
