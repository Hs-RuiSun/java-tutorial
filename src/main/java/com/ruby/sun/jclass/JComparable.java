package com.ruby.sun.jclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

class Student implements Comparable<Student> {
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

public class JComparable {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.id > o1.id ? 1 : -1;
            }
        });

        //lambda
        Collections.sort(list, (Student t1, Student t2) -> {
            return t1.id > t2.id ? 1 : -1;
        });
    }
}
