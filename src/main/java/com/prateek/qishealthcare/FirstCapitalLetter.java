package com.prateek.qishealthcare;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public class FirstCapitalLetter {

	public static void main(String[] args) {
		final String str = "abcKA";
		//findFirstCapitalLetter(str);
		//System.out.println(largestPrime(2));
		System.out.println(convertCamelCaseToSentence("ThisIsAWordyString"));
	}
	
	static class PatientDetails {
		private String patientName;
		private Date appointmentDate;
		
		public PatientDetails(final String patientName, final Date appointmentDate) {
			this.patientName = patientName;
			this.appointmentDate = appointmentDate;
		}
	}
	
	private static void reformatPatientAppointment(final String[] patientName, final String[] appointmentDate) {
		final Date dates[] = new Date[appointmentDate.length];
		convertFromStringToDate(appointmentDate, dates);
		final TreeMap<Date, List<PatientDetails>> tm = new TreeMap<Date, List<PatientDetails>>();
		for (int i = 0; i < patientName.length; i++) {
			PatientDetails pd = new PatientDetails(patientName[i], dates[i]);
		}
	}
	
	private static void convertFromStringToDate(String[] appointmentDate, Date[] dates) {
		for (int i = 0; i < appointmentDate.length; i++) {
			dates[i] = new Date(appointmentDate[i]);
		}
	}

	private static String convertCamelCaseToSentence(final String str) {
		char arr[] = str.toCharArray();
		final StringBuilder sentence = new StringBuilder("");
		for (int i = 0; i < arr.length; i++) {
			if (i != 0 && arr[i] >= 65 && arr[i] <= 90) {
				final String st = " " + ((Character)arr[i]).toString().toLowerCase();
				sentence.append(st);
			} else {
				sentence.append(((Character)arr[i]).toString());
			}
		}
		return sentence.toString();
	}
	
	static int findFirstCapitalLetter(String str) {
		char arr[] = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if (arr[i] >= 65 && arr[i] <= 90) {
				return i;
			}
		}
		return -1;
    }
	
	private static int largestPrime(int n) {
		int largestNumber = (int) (Math.pow(10, n));
		return processToFindLargestPrimeNumber(largestNumber);
	}

	private static int processToFindLargestPrimeNumber(int largestNumber) {
		int largestPrimeNumber = 0;
		for (int i = largestNumber; i >= 2; i--) {
			if (isPrimeNumber(i)) {
				largestPrimeNumber = i;
				break;
			}
		}
		return largestPrimeNumber;
	}

	private static boolean isPrimeNumber(int number) {
		int squareRoot = (int) Math.sqrt(number);
		for (int i = 2; i <= squareRoot; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	

}
