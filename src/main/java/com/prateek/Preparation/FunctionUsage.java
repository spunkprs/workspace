package com.prateek.Preparation;

import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

public class FunctionUsage {

	public Multimap<Department,Student> groupStudentsByDepartment(final List<Student> students) {
		return Multimaps.index(students, new Function<Student, Department>() {

			public Department apply(Student student) {
				return student.getDepartment();
			}
		});
	}
}
