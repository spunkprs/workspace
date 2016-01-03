package com.prateek.atmproblemstatement;

public class StatementFactory {
	
	private static StatementFactory statementFactory;
	
	private StatementFactory() {
		
	}
	
	public static StatementFactory getInstance() {
		if (statementFactory == null) {
			statementFactory = new StatementFactory();
		}
		return statementFactory;
	}
	
	public Statement getStatement(final String statementType) {
		if (StatementType.CREDIT_CARD_STATEMENT.getStatement().equals(statementType)) {
			return CreditCardStatement.getInstance();
		} else if (StatementType.MINI_STATEMENT.getStatement().equals(statementType)) {
			return MiniStatement.getInstance();
		} else {
			return DetailStatement.getInstance();
		}
	}
}
