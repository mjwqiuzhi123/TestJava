package com.mjw.JSON.test;

import java.util.List;

public class StudentList {

	private List<Student> student;

	public List<Student> getStuList() {
		return student;
	}

	public void setStuList(List<Student> student) {
		this.student = student;
	}

	public List<Student> getStudent() {
		List<Student> stuList = getStuList();
		return stuList;
	}
}
