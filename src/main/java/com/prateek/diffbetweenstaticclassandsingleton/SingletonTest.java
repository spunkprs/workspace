package com.prateek.diffbetweenstaticclassandsingleton;

public class SingletonTest {

	public static void main(String[] args) {
			Singleton s1 = Singleton.getInstance();
			Singleton s2 = Singleton.getInstance();
			checkForEquality(s1, s2);
	}

	private static void checkForEquality(Singleton s1, Singleton s2) {
		if (s1 == s2) {
			System.out.println("Same objects");
		} else {
			System.out.println("Different");
		}
	}

}
