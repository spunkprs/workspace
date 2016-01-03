package com.prateek.Preparation;

import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class PredicateUsageTest {
	
	private PredicateUsage predicateUsage; 
	
	@Before
	public void setUp() {
		predicateUsage = new PredicateUsage();
	}

	@Test
	public void shouldFilterStudentsByDepartment() {
		//Set Up
		final Department department = Department.getRandomDepartment();
		final List<Student> students = createStudents();
		
		//Execute
		List<Student> filteredStudents = predicateUsage.filterStudentsByDepartment(students, department);
		
		//Verify
		Assert.assertEquals(students.size() - (students.size() - 1) , filteredStudents.size());
	}

	private List<Student> createStudents() {
     return Lists.newArrayList(StudentFixture.createStudents(1, Department.COMPUTERS).get(0), 
    		 StudentFixture.createStudents(1, Department.ELECTRICAL).get(0),
    		 StudentFixture.createStudents(1, Department.ELECTRONICS).get(0),
    		 StudentFixture.createStudents(1, Department.MECHANICAL).get(0));		
	}
}
