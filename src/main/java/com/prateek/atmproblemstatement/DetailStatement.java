package com.prateek.atmproblemstatement;

public class DetailStatement implements Statement {

private static DetailStatement detailStatement;
	
	private DetailStatement() {
		
	}
	
	public static synchronized DetailStatement getInstance() {
		if (detailStatement == null) {
			detailStatement = new DetailStatement();
			return detailStatement;
		}
		return detailStatement;
	}
	
	public void printStatement() {
		System.out.println("Printing Detail Statement");
	}
}
