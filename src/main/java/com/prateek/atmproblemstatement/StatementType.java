package com.prateek.atmproblemstatement;

public enum StatementType {
CREDIT_CARD_STATEMENT("Credit Card"),
MINI_STATEMENT("Mini Statement"), 
DETAIL_STATEMENT("Detail Statement");

private String statementType;

private StatementType(final String statementType) {
	this.statementType = statementType;
}

public String getStatement() {
	return this.statementType;
}
}
