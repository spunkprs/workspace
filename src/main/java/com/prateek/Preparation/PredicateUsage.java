package com.prateek.Preparation;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class PredicateUsage {

	public List<Student> filterStudentsByDepartment(final List<Student> students, final Department department) {
		return Lists.newArrayList(Iterables.filter(students, getStudentPredicate(department)));
	}

	private Predicate<Student> getStudentPredicate(final Department department) {
		return new Predicate<Student>() {
			public boolean apply(final Student student) {
				return student.getDepartment().equals(department) ? true : false;
			}
		};
	}
}
