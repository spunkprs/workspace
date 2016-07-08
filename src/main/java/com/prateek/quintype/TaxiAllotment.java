package com.prateek.quintype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TaxiAllotment {

	private static TreeSet<Integer> taxiSet = new TreeSet<Integer>();
	private static Taxi head;
	private static Taxi tail;
	private static List<Integer> output = new ArrayList<Integer>();
	
	public static void main(final String ar[]) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			final List<Pair> users = new ArrayList<TaxiAllotment.Pair>();
			String line = br.readLine();
			String st[] = line.split(" ");
			final int numberOfUsers = Integer.parseInt(st[0]);
			final int numberOfTaxis = Integer.parseInt(st[1]);
			
			for (int i = 1; i <= numberOfUsers; i++) {
				line = br.readLine();
				st = line.split(" ");
				users.add(new Pair(st[0], st[1]));
			}
			fetchIndexesOfTaxis(users, numberOfTaxis);
			printOutput();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void printOutput() {
		for (Integer i : output) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public static List<Integer> fetchIndexesOfTaxis(final List<Pair> users, final int numberOfTaxis) {
		populateTaxiSet(numberOfTaxis);
		parseUsersList(users);
		return output;
	}
	
	 private static void parseUsersList(final List<Pair> users) {
		for (Pair p : users) {
			if (!taxiSet.isEmpty()) {
				output.add(taxiSet.first());
				prepareTaxiNode(taxiSet.first(), p);
				taxiSet.remove(taxiSet.first());
			} else {
				output.add(parseTaxiNodesToFindAvailableTaxi(p));
			}
		}
	}

	private static int parseTaxiNodesToFindAvailableTaxi(final Pair user) {
		Taxi node = head;
		int comparison = -1;
		while(node != null) {
			comparison = user.getStartTime().compareTo(node.getReachingTime());
			if (comparison >= 0) {
				repositionNode(node);
				updatePropertiesOfTaxiNode(node, user);
				return node.getTaxiNumber();
			}
			node = node.getNext();
		}
		return comparison;
	}

	private static void updatePropertiesOfTaxiNode(Taxi node, Pair user) {
		node.setStartTime(user.getStartTime());
		node.setTimeToReachDestination(user.getTimeToReachDestination());
		node.setReachingTime(user.getStartTime().add(user.getTimeToReachDestination()));
	}

	private static void repositionNode(final Taxi node) {
		final Taxi next = node.getNext();
		final Taxi previous = node.getPrevious();
		if (node != head && node != tail) {
			previous.setNext(next);
			next.setPrevious(previous);
		} else if (node == head) {
			head = head.getNext();
		}
		if (node != tail) {
			tail.setNext(node);
			node.setPrevious(tail);
			tail = tail.getNext();
			node.setNext(null);
		}
	}

	private static void prepareTaxiNode(final Integer taxiNumber, final Pair user) {
		Taxi node = new Taxi(taxiNumber, user.getStartTime(), user.getTimeToReachDestination());
		if (head == null) {
			head = node;
		} 
		if (tail == null) {
			tail = node;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
			tail = tail.getNext();
		}
	}

	private static void populateTaxiSet(final int numberOfTaxis) {
		for (int i = 1; i <= numberOfTaxis; i++) {
			taxiSet.add(i);
		}
	}

	static class Taxi {
		 private int taxiNumber;
		 private BigInteger startTime;
		 private BigInteger timeToReachDestination;
		 private BigInteger reachingTime;
		 private Taxi next;
		 private Taxi previous;
		 
		 private Taxi(final int taxiNumber, final BigInteger startTime, final BigInteger timeToReachDestination) {
			 this.taxiNumber = taxiNumber;
			 this.startTime = startTime;
			 this.timeToReachDestination = timeToReachDestination;
			 this.reachingTime = this.startTime.add(this.timeToReachDestination);
		 }
		 
		int getTaxiNumber() {
			return taxiNumber;
		}

		BigInteger getStartTime() {
			return startTime;
		}

		BigInteger getTimeToReachDestination() {
			return timeToReachDestination;
		}

		void setStartTime(BigInteger startTime) {
			this.startTime = startTime;
		}

		void setTimeToReachDestination(BigInteger timeToReachDestination) {
			this.timeToReachDestination = timeToReachDestination;
		}

		void setReachingTime(BigInteger reachingTime) {
			this.reachingTime = reachingTime;
		}

		BigInteger getReachingTime() {
			return reachingTime;
		}
		
		void setNext(Taxi next) {
			this.next = next;
		}

		void setPrevious(Taxi previous) {
			this.previous = previous;
		}

		Taxi getNext() {
			return next;
		}

		Taxi getPrevious() {
			return previous;
		}
	 }
	
	static class Pair {
		private BigInteger startTime;
		private BigInteger timeToReachDestination;
		
		public Pair(final String startTime, final String timeToReachDestination) {
			this.startTime = new BigInteger(startTime);
			this.timeToReachDestination = new BigInteger(timeToReachDestination);
		}

		BigInteger getStartTime() {
			return startTime;
		}

		BigInteger getTimeToReachDestination() {
			return timeToReachDestination;
		}
	}
}
