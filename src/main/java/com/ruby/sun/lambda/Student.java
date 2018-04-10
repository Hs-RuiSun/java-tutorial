package com.ruby.sun.lambda;

import java.util.Date;

public class Student implements Comparable<Student> {
	int id;
	String name;
	Date birth;

	public Student(int id, String name, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
	}

	@Override
	public int compareTo(Student student) {
		return this.id > student.id ? 1 : -1;
	}
}
