package com.prateek.Preparation;

import java.util.List;

import org.apache.commons.lang.math.RandomUtils;

import com.google.common.collect.Lists;

public enum Department {
ELECTRONICS("Electronics"),
COMPUTERS("Computers"),
MECHANICAL("Mechanical"),
ELECTRICAL("Electrical");

private String departmentName;

Department(final String departmentName) {
	this.departmentName = departmentName;
}

public String getDepartmentName() {
	return departmentName;
}

public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}

public static List<Department> getAllDepartments() {
	return Lists.newArrayList(ELECTRONICS, ELECTRICAL, MECHANICAL, COMPUTERS);
}

public static Department getRandomDepartment() {
	final List<Department> departments = getAllDepartments();
	return departments.get(RandomUtils.nextInt(departments.size()));
}

}
