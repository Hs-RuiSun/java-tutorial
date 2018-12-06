package com.ruby.sun.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class JSerialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*Student s1 =new Student(211,"ravi");    
		FileOutputStream fout=new FileOutputStream("/Users/ruisun/Downloads/io");  
		ObjectOutputStream out=new ObjectOutputStream(fout);  
  	    out.writeObject(s1);  
	    out.flush(); */

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/ruisun/Downloads/io"));
        Student s = (Student) ois.readObject();
        System.out.println(s.id + " " + s.name);
    }

}
