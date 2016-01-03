package com.prateek.Preparation;

public class Student {
	
	private String studentName;
	private Department department;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Student(final String studentName, final Department department) {
		this.studentName = studentName;
		this.department = department;
	}
	
	public static Student createStudent(final String studentName, final Department department) {
		return new Student(studentName, department);
	}
}
