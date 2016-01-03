package com.prateek.Preparation;

import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
public class FunctionUsageTest {

	private FunctionUsage unit;
	
	@Before
	public void setUp() {
		unit = new FunctionUsage();
	}
	
	@Test
	public void shouldGroupStudentsByDepartment() {
		//Set Up
		final List<Student> students = Lists.newArrayList();
		createInputData(students);
		
		//Execute
		Multimap<Department, Student> map = unit.groupStudentsByDepartment(students);
		
		//Verify
		Assert.assertEquals(2, map.get(Department.COMPUTERS).size());
		Assert.assertEquals(2, map.get(Department.ELECTRICAL).size());
		Assert.assertEquals(1, map.get(Department.MECHANICAL).size());
	}

	private void createInputData(List<Student> students) {
		students.addAll((StudentFixture.createStudents(2, Department.COMPUTERS)));
		students.addAll(StudentFixture.createStudents(2, Department.ELECTRICAL));
		students.addAll(StudentFixture.createStudents(1, Department.MECHANICAL));
	}
}
