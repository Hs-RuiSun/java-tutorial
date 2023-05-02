package com.ruby.sun.oca.chapter9;

import com.ruby.sun.oca.chapter8.Chapter8;

abstract public class Chapter9 {
    abstract void print();
    final public String finalVariable = "";
    abstract String chew();
    public Chapter9(){
        System.out.println(chew());
    }
}
interface Fly{
}

class Animal extends Chapter9 implements Fly{
    @Override
     void print() {
    }
    @Override
    String chew() {
        return "yummy";
    }
    public static void main(String[] args) {
        new Animal();
    }
}
