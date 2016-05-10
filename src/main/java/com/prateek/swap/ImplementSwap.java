package com.prateek.swap;

public class ImplementSwap {

	public static void main(String[] args) {
		
		User userOne = new User("UserOne");
		User userTwo = new User("UserTwo");
		
		System.out.println(userOne);
		System.out.println(userTwo);
		
		swapReferences(userOne, userTwo);
		
		System.out.println(userOne);
		System.out.println(userTwo);
	}
	
	private static void swapReferences(User userOne, User userTwo) {
		final User temp = userOne;
		userOne = userTwo;
		userTwo = temp;
	}

	static class User {
		
		private String name;
		User(final String name) {
			this.name = name;
		}
		
		public String toString() {
			return this.name;
		}
		
	}
}
