package com.ruby.sun.inheritance;

public interface JInterface {
    default void comment(){
        System.out.println("added but don't need to implement it in the implementation classes");
    }

    static void anotherNewMethod(){
        System.out.println("Newly added static method");
    }
}
interface MyInterface{

    default void newMethod(){
        System.out.println("Newly added default method");
    }
    void existingMethod(String str);
}
interface MyInterface2{

    default void newMethod(){
        System.out.println("Newly added default method");
    }
    void disp(String str);
}
class Example implements MyInterface, MyInterface2{
    // implementing abstract methods
    public void existingMethod(String str){
        System.out.println("String is: "+str);
    }
    public void disp(String str){
        System.out.println("String is: "+str);
    }
    public void newMethod(){
        System.out.println("Implementation of default method");
    }
    public static void main(String[] args) {
        Example obj = new Example();

        //calling the default method of interface
        obj.newMethod();


    }
}
