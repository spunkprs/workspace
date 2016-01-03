package com.prateek.atmproblemstatement;

public class Client {

	public static void main(String[] args) {
		
		//Get Detailed Statement For User
		Statement statement = StatementFactory.getInstance().getStatement(StatementType.DETAIL_STATEMENT.getStatement());
		statement.printStatement();
		
		//Get Mini Statement For User
		statement = StatementFactory.getInstance().getStatement(StatementType.MINI_STATEMENT.getStatement());
		statement.printStatement();
		
		//Get Credit Card Statement For User
		statement = StatementFactory.getInstance().getStatement(StatementType.CREDIT_CARD_STATEMENT.getStatement());
		statement.printStatement();
	}
}
