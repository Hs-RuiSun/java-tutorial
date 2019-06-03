package com.ruby.sun.inheritance;

public class Animal {
    String type = "animal";
    public Animal getInstance() {
        System.out.println("parent instance");
        return new Animal();
    }
    public static void display(){
        System.out.println("parent display");
    }

    private void method(){

    }
}

class Cat extends Animal implements JInterface{
    @Override
    public Cat getInstance() { //return subtype
        super.getInstance();
        System.out.println("child instance " + super.type);
        return new Cat();
    }
    public static void display(){
        System.out.println("child display ");
    }

    public static void main(String[] args) {
        Animal child = new Cat();
        child.getInstance();
        Animal parent = new Animal();
        parent.getInstance();
        Cat.display();
        Animal.display();;
    }
}