package com.prateek.atmproblemstatement;

public class CreditCardStatement implements Statement {

	private static CreditCardStatement creditCardStatement;
	
	private CreditCardStatement() {
		
	}
	
	public static synchronized CreditCardStatement getInstance() {
		if (creditCardStatement == null) {
			creditCardStatement = new CreditCardStatement();
			return creditCardStatement;
		}
		return creditCardStatement;
	}
	
	public void printStatement() {
		System.out.println("Printing Credit Card Statement");
	}
}
