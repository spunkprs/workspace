package com.prateek.WalmartLabExam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CandidateCode {
	
	final static Set<StayTime> stayTimes = new HashSet<StayTime>();
	static List<StayTime> stayTimeList = new ArrayList<StayTime>();
	final static Map<StayTime, Integer> map = new HashMap<StayTime, Integer>();
	static int maxProfit = 0;
	
	public static int jobMachine(String[] input1)
    {
		getTimings(input1);
		populateItems(stayTimes);
        Collections.sort(stayTimeList, new CandidateCode.StayTimeComparator());
        final int i = 0; 
		calculateMaxProfit(stayTimeList.get(i), i+1);
		return maxProfit;
    }

	private static void populateItems(final Set<StayTime> staytimes2) {
		for (StayTime st : staytimes2) {
			stayTimeList.add(st);
		}
	}

	private static void calculateMaxProfit(final StayTime stayTime, final int i) {
		if (i < stayTimes.size()) {
			calculateMaxProfit(stayTimeList.get(i), i+1);
			checkForOverLappingOfTimings(stayTime, stayTimeList.get(i), i-1);
		} else {
			if (!map.containsKey(stayTimeList.get(i-1))) {
				map.put(stayTimeList.get(i-1), 500);
				updateMaxProfit(stayTime);
			}
		}
	}

	private static void checkForOverLappingOfTimings(final StayTime stayTime1, final StayTime stayTime2, final int position) {
		if (stayTime1.getOutTime() <= stayTime2.getInTime()) {
			map.put(stayTime1, map.get(stayTime2) + 500);
			updateMaxProfit(stayTime1);
		} else {
			int pos = position + 1;
			while(pos < stayTimeList.size()) {
				final StayTime posStayTime = stayTimeList.get(pos);
				if (stayTime1.getOutTime() <= posStayTime.getInTime()) {
					map.put(stayTime1, map.get(posStayTime) + 500);
					updateMaxProfit(stayTime1);
					break;
				} else {
					if (!map.containsKey(stayTime1)) {
						map.put(stayTime1, 500);
						updateMaxProfit(stayTime1);
					}
				}
				pos++;
			}
		}
	}

	private static void updateMaxProfit(final StayTime stayTime) {
		if (map.get(stayTime) > maxProfit) {
			maxProfit = map.get(stayTime);
		}
	}

	private static void getTimings(String[] input1) {
		for (int i = 0; i < input1.length; i++) {
		 final String retVal[] = input1[i].split("#");
		 final StayTime st = new StayTime(retVal[0], retVal[1]);
		 if (st.getInTime() >= 5 && st.getOutTime() <=23)
		 stayTimes.add(st);
		}
	}
	
	private static class StayTime {
		private int in;
		private int out;
		
		StayTime(final String inTime, final String outTime) {
			populateInAndOutTimings(inTime, outTime);
		}
		
		private void populateInAndOutTimings(final String inTime, final String outTime) {
			if (inTime.contains("PM")) {
				final String st = inTime.replace("PM", "");
				if (checkForNoon(Integer.parseInt(st))) {
					this.in = 12;
				} else {
					this.in = Integer.parseInt(st) + 12;
				}
				
			} else if (inTime.contains("AM")){
				final String st = inTime.replace("AM", "");
				this.in = Integer.parseInt(st);
			}
			
			if (outTime.contains("PM")) {
				final String st = outTime.replace("PM", "");
				
				if(checkForNoon(Integer.parseInt(st))) {
					this.out = 12;
				} else {
					this.out = Integer.parseInt(st) + 12;
				}
				
			} else if (outTime.contains("AM")) {
				final String st = outTime.replace("AM", "");
				this.out = Integer.parseInt(st);
			}
		}

		private boolean checkForNoon(final int time) {
			if (time == 12)
				return true;
			else 
				return false;
		}

		public int getInTime() {
			return this.in;
		}
		
		public int getOutTime() {
			return this.out;
		}
		
		public int hashCode() {
			return this.in * this.out;
		}
		
		public boolean equals(final Object obj) {
			final StayTime st = (StayTime)obj;
			if (this.in == st.getInTime() && this.out == st.getOutTime())
			return true; 
			else {
				return false;
			}
		}
	}
	
	private static class StayTimeComparator implements Comparator<CandidateCode.StayTime> {

		public int compare(final CandidateCode.StayTime st1, final CandidateCode.StayTime st2) {
			if (st1.getInTime() == st2.getInTime()) {
				return st1.getOutTime() - st2.getOutTime();
			} else if (st1.getInTime() < st2.getInTime()) {
				return -1;
			} else {
				return 1;
			}
		}
	}
}
