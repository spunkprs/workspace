package com.prateek.XORLinkList;

public class XORDoublyLinkList {

	public static void main(final String... abc) {
		final String s1 = "hello";
		final String s2 = "elloh";
		System.out.println("Hello");
		int a = 2;
		int b = 4;
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("value of a"+" "+a);
		System.out.println("value of b"+" "+b);
		
		final char ch1[] = s1.toCharArray();
		final char ch2[] = s2.toCharArray();
		int xor = 0;
		for (int i = 0; i < ch1.length; i++) {
			xor ^= ch1[i]^ch2[i];
		}
		
		if (xor == 0) {
			System.out.println("both strings are anagrams");
		}
	}
}
