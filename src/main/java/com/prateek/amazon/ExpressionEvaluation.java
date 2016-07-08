package com.prateek.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

  public class ExpressionEvaluation {

	private Node head;
	private Node tail;
	private Stack<Node> stack = new Stack<Node>();
	private int expressionResult = 0;
	
	public static void main(final String args[]) {
		ExpressionEvaluation ee = new ExpressionEvaluation();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int inputCount = Integer.parseInt(br.readLine());
			for (int i = 1; i <= inputCount; i++) {
				System.out.println(ee.computeExpression(br.readLine()));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int computeExpression(final String expression) {
		initialState();
		final String st[] = expression.split(" ");
		process(st);
		return expressionResult;
	}

	private void initialState() {
		stack = new Stack<Node>();
		head = null;
		tail = null;
	}

	private void process(final String[] st) {
		prepareList(st);
		parseAndUpdateList();
	}

	private void parseAndUpdateList() {
		while(!stack.isEmpty()) {
			Node startPoint = stack.peek();
			Node endPoint = getNearestNodeWithClosingBracket(startPoint);
			final List<Node> operators = fetchOperatorAddresses(startPoint.getNext(), endPoint.getPrevious());
			final Node result = compute(startPoint.getNext(), endPoint.getPrevious(), operators);
			
			if (startPoint.getPrevious() != null) {
				startPoint.getPrevious().setNext(result);
			} else {
				head = startPoint.getNext();
			}
			
			result.setPrevious(startPoint.getPrevious());
			result.setNext(endPoint.getNext());
			
			if (endPoint.getNext() != null) {
				endPoint.getNext().setPrevious(result);
			} else {
				tail = result;
			}
			stack.pop();
		}
		Node start = head;
		Node end = tail;
		while (start != tail) {
			final List<Node> operators = fetchOperatorAddresses(start, end);
			final Node result = compute(start, end, operators);
			result.setNext(null);
			start = result;
			tail = result;
		}
		expressionResult = tail.getNumValue();
	}

	private Node getNearestNodeWithClosingBracket(final Node nodeWithOpenBracket) {
		Node n = nodeWithOpenBracket;
		while(n.getNumValue() != null || n.getCh() != ')') {
			n = n.getNext();
		}
		return n;
	}

	private Node compute(final Node start, final Node end, final List<Node> operators) {
		Node r = null;
		for (Node operator : operators) {
			Node operandOne = operator.getPrevious();
			Node operandTwo = operator.getNext();
			int result = operation(operator.getCh(), operandOne.getNumValue(), operandTwo.getNumValue());
			operandOne.setNumValue(result);
			if (operandTwo.getNext() != null) {
				operandOne.setNext(operandTwo.getNext());
				operandTwo.getNext().setPrevious(operandOne);
			}
			r = operandOne;
		}
		return r;
	}
	
	private int operation(final char character, final Integer operandOne, final Integer operandTwo) {
		if (character == '/') {
			return operandOne / operandTwo;
		} else if (character == '*') {
			return operandOne * operandTwo;
		} else if (character == '+') {
			return operandOne + operandTwo;
		} else {
			return operandOne - operandTwo;
		}
	}

	private List<Node> fetchOperatorAddresses(Node start, Node end) {
		final List<Node> operators = new ArrayList<Node>();
		Node incept = start;
		while(incept != end) {
			Character ch = incept.getCh();
			if (ch != null && ch != '(' && ch != ')') {
				operators.add(incept);
			}
			incept = incept.getNext();
		}
		Collections.sort(operators, new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				int rankOne = OPERATOR_PRECEDENCE.INSTANCE.fetchRank(n1.getCh());
				int rankTwo = OPERATOR_PRECEDENCE.INSTANCE.fetchRank(n2.getCh());
				return rankOne == rankTwo ? 0 : rankOne > rankTwo ? 1 : -1;
			}
		});
		return operators;
	}

	private void prepareList(final String[] st) {
		for (String character : st) {
			String number = "";
			boolean skip = false;
			for (Character ch : character.toCharArray()) {
				if (isOperationalCharacterOrParanthesis(ch)) {
					if (!number.isEmpty()) {
						Node n = new Node(null, Integer.parseInt(number));
						addToListAtTail(n);
					}
					final Node node = new Node(ch, null);
						addToListAtTail(node);
						pushToEitherStackOrQueue(node, ch);
						skip = true;
				} else {
					number = number + ch;
					skip = false;
				}
			}
			if (!skip) {
				Node n = new Node(null, Integer.parseInt(number));
				addToListAtTail(n);
			}
		}
	}

	private void pushToEitherStackOrQueue(final Node n, final Character ch) {
		if (ch == '(') {
			stack.push(n);
		} 
	}

	private void addToListAtTail(Node node) {
		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
			tail = node;
		}
	}

	private boolean isOperationalCharacterOrParanthesis(final char ch) {
		if (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '(' || ch == ')') {
			return true;
		}
		return false;
	}
}
 
 	class Node {
		Character ch;
		Integer numValue;
		Node next;
		Node previous;
		
		void setNumValue(Integer numValue) {
			this.numValue = numValue;
		}

		Character getCh() {
			return ch;
		}

		Integer getNumValue() {
			return numValue;
		}

		Node getNext() {
			return next;
		}

		Node getPrevious() {
			return previous;
		}

		void setNext(Node next) {
			this.next = next;
		}

		void setPrevious(Node previous) {
			this.previous = previous;
		}

		Node(final Character ch, final Integer numValue) {
			this.ch = ch;
			this.numValue = numValue;
		}
	}
 
  enum OPERATOR_PRECEDENCE {
		
		DIVISION('/', 1),
		MULTIPLICATION('*', 2), 
		ADDITION('+', 3),
		SUBTRACTION('-', 3),
		INSTANCE(' ', Integer.MIN_VALUE);
		
		char ch;
		int rank;
		
		private OPERATOR_PRECEDENCE(final char ch, final int rank) {
			this.ch = ch;
			this.rank = rank;
		}
		
		public int fetchRank(final char character) {
			for (OPERATOR_PRECEDENCE operator : values()) {
				if (operator.ch == character) {
					return operator.rank;
				}
			}
			return -1;
		}
	}
