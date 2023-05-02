package com.ruby.sun.oca.chapter7;

public class Chapter7 {
    int counter = 1;
    public static void main(String[] args) {
        //System.out.println(counter); non-static fields can't be access in the static method

        //the order of choosing an overloaded methods
        print(4);
    }
    //private static void print(int x) { System.out.println("exact match"); }
    //private static void print(long x) { System.out.println("larger primitive type"); }
    //private static void print(Integer x) { System.out.println("autoboxed type"); }
    private static void print(int... x) { System.out.println("varargs"); }
    private static void print(Object x) { System.out.println("object"); }

    public void defineVoidMethod(){}
    public void defineVoidMethod2(){ return; }
}
