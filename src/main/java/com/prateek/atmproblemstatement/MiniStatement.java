package com.prateek.atmproblemstatement;

public class MiniStatement implements Statement {

private static MiniStatement miniStatement;
	
	private MiniStatement() {
		
	}
	
	public static synchronized MiniStatement getInstance() {
		if (miniStatement == null) {
			miniStatement = new MiniStatement();
			return miniStatement;
		}
		return miniStatement;
	}
	
	public void printStatement() {
		System.out.println("Printing Mini Statement");
	}
}
