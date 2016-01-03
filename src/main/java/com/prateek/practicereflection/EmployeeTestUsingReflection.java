package com.prateek.practicereflection;

import java.lang.reflect.Field;

public class EmployeeTestUsingReflection {

	public static void main(String[] args) {
     Class employeeClass = Employee.class;
     Employee employee = null;
     Field fields [] = employeeClass.getDeclaredFields();
     try {
		employee = (Employee)employeeClass.newInstance();
	} catch (Exception e) {
		e.printStackTrace();
	} 
     makePrivateFieldAccessible(fields);
     printValuesOfPrivateFields(employee, fields);
     
     Field firstPrivateField = null;
     Field secondPrivateField = null;
     Field thirdPrivateField = null;
     
     try {
		 firstPrivateField = employeeClass.getDeclaredField("employeeId");
		 secondPrivateField = employeeClass.getDeclaredField("employeeName");
	     thirdPrivateField = employeeClass.getDeclaredField("employeeDesignation");
	     
	     makePrivateFieldAccessible(firstPrivateField, secondPrivateField, thirdPrivateField);
	     
	     firstPrivateField.set(employee, 100);
	     secondPrivateField.set(employee, "XYZ");
	     thirdPrivateField.set(employee, "MAJDOOR");
	     
	} catch (Exception e) {
		e.printStackTrace();
	} 
     
     printValuesOfPrivateFields(employee, firstPrivateField, secondPrivateField, thirdPrivateField);
	}

	private static void makePrivateFieldAccessible(Field... fields) {
		for (Field field : fields) {
			field.setAccessible(true);
		}
	}

	private static void printValuesOfPrivateFields(Employee employee, Field ... fields) {
		
		for (Field field : fields) {
			try {
				System.out.println("Value of " + field.getName()+" "+ field.get(employee));
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
}
