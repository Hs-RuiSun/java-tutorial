package com.ruby.sun.oca.chapter7.goose;

import com.ruby.sun.oca.chapter7.duck.Bird;

public class Goose extends Bird {
    public void helpGooseSwim(){
        floatInWater();
        System.out.println(text);
    }

    public void helpOtherSwim(){
        Goose goose = new Goose();
        goose.floatInWater();
        System.out.println(goose.text);

        Bird bird = new Goose();
        //bird.floatInWater(); not accessible

        Bird b = new Bird();
        //b.floatInWater(); not accessible
    }
}
