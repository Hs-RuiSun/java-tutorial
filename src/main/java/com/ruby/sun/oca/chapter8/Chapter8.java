package com.ruby.sun.oca.chapter8;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Chapter8 extends Parent {
    private String name;
    private int height;
    public Chapter8(String name){}
    //private Chapter8(String name){} it's ok to define a private Constructor
    Chapter8(){}
    public Chapter8(int height, String name){
        this.height = height;
        this.name = name;
    }

    public Chapter8(int height){
        //new Chapter8(height, "Lili");
        this(height, "Lili");
    }

    protected int age = 8;
    public boolean isFlagged() {
        return true;
    }

    public static void main(String[] args) {
        Chapter8 chapter8 = new Chapter8();
        Parent parent = new Chapter8();
        chapter8.print(); //true
        parent.print(); //true
        System.out.println(parent.age); // 2
        System.out.println(chapter8.age); //8
        System.out.println(parent.isFlagged()); //true
        System.out.println(chapter8.isFlagged()); //true


        //Chapter8 chapter8 = new Chapter8(); there are no default constructors generated if any constructors are already defined
//        Chapter8 chapter8 = new Chapter8(8);
//        System.out.println(chapter8.height + ", " + chapter8.name);
//
//        Chapter chapter = new Chapter8();
//        System.out.println(chapter instanceof  Chapter8);
//        Chapter8 chapterChild = (Chapter8) chapter;
//        chapterChild.toString();
    }
}

class Parent {
    protected int age = 2;
    public boolean isFlagged(){
        return false;
    }
    public void print(){
        System.out.println(isFlagged());
    }
    /**
     * overriding vs overloading vs hidden
     * overriding: a method defined in both parent and child classes with the same signature and compatible return type
     * overloading: different method signature
     */


    protected String name;
    protected void setName(String name) {
        this. name = name;
    }
    public void println(){
        System.out.println("parent");
    }
}
class Child extends Parent{
    protected String name;
    protected void setName(String name) {
        this. name = name;
    }
    public void println(){
        System.out.println("child");
    }

    public static void main(String[] args) {
        final Child child = new Child();
        final Parent parent = child;
        parent.println();
        child.name = "Sophia";
        parent.name = "Lily";
        child.setName("Luke");
        parent.setName("Tom");
        assertEquals("Lily", parent.name); //hidden variables
        assertEquals("Tom", child.name);  //overridden setName() method
    }
}