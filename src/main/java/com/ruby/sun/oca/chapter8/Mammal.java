package com.ruby.sun.oca.chapter8;

public class Mammal {
    private final int age;
    protected static int size;
    public Mammal(int age){
        this.age = 1;
    }

    public Object eat(int food){ return 0; }
}

//class Elephant extends Mammal{} //does not compile as there is no default constructor available in 'Mammal'
class Elephant extends Mammal{
    public Elephant(){
        super(0);
    }

    public Integer eat(int food){ return 0;}

    public void display() {
        System.out.println(super.size); //super cannot be referenced from a static context
        System.out.println(this.size); //static variables accessed through instance reference
        System.out.println(size);
    }
}

class MouseHouse {
    private final int volume;
    private final String type;
    { this.volume = 10; }

    public MouseHouse(String type){
        this.type = type;
    }

    public MouseHouse(){
        this(null); // could also assign null value
    } //does not initialize final variable type
}