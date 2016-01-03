package com.prateek.Preparation;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;

import com.google.common.collect.Lists;

public class StudentFixture {

	public static List<Student> createStudents(final int numberOfStudents, final Department department) {
		final List<Student> students = Lists.newArrayList();
		for (int i = 0; i < numberOfStudents; i++) {
			students.add(Student.createStudent(RandomStringUtils.randomAlphabetic(5), department));
		}
		return students;
	}
}
