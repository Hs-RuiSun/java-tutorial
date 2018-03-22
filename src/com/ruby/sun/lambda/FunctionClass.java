package com.ruby.sun.lambda;

import java.util.Date;
import java.util.function.Predicate;

public class FunctionClass {
	
	public static void verify(Student t, Predicate<Student> p) {
		if(p.test(t)) {
			System.out.println("verify success");
		}
	}
	
	public static void main(String[] args) {
		Student s = new Student(22, "", new Date());
		//1. Predicate
		Predicate<Student> p1 = t -> { return t.id > 18; };		
		verify(s, p1);
		
		//2. Consumer
		//3. Function
		//4. Supplier
		//5. UnaryOperator
		//6. BinaryOperator
	}
	
}
