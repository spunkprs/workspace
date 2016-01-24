package com.prateek.greedyalgorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

public class ActivitySelectionProblem {
	
	protected void getNumberOfMutuallyExclusiveActivitiesPerformed(final int [] startTimings, final int [] finishTimings) {
		final List<Job> jobs = instantiateJobs(startTimings, finishTimings);
		Collections.sort(jobs, new JobComparator());
		getMutuallyExclusiveActivities(jobs);
	}
	
	private void getMutuallyExclusiveActivities(final List<Job> jobs) {
		
	}

	private List<Job> instantiateJobs(final int[] startTimings, final int[] finishTimings) {
		final List<Job> jobs = Lists.newArrayList();
		for (int i = 0; i < startTimings.length; i++) {
			jobs.add(new Job(startTimings[i], finishTimings[i]));
		}
		return jobs;
	}

	private static class Job {
		private int startTime;
		private int finishTime;
		
		private Job(final int startTime, final int finishTime) {
			this.startTime = startTime;
			this.finishTime = finishTime;
		}
		
		private int getFinishTime() {
			return this.finishTime;
		}
		
		private int getStartTime() {
			return this.startTime;
		}
	}
	
	private static class JobComparator implements Comparator<Job> {

		public int compare(final Job j1, final Job j2) {
			return j1.getFinishTime() - j2.getFinishTime();
		}
	}
}
