package com.ruby.sun.oca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Chapter4 {
    @Test
    public void print(){
        int[] numbers = new int[3];
        for(int number : numbers){
            System.out.print(number);
        }
        System.out.println();
        String[] letters = new String[3];
        for(String letter : letters){
            System.out.print(letter);
        }
    }
    @Test
    public void test() {
        //continue vs break vs return
        int height = 1;
        L1: while (height++ <10){
            long humidity = 12;
            System.out.println("L1: " + height);
            L2: do {
                if(humidity-- % 12 == 0) {
                    System.out.println("L2: " + humidity);
                    continue;
                }
                int temperature = 30;
                L3: for(;;){
                    temperature++;
                    if(temperature>32) {
                        System.out.println("L3: " + humidity + "," + temperature);
                        continue L2;
                    }
                }
            } while(humidity > 4);
        }
        /*
        //scope of do while variable
        do {
            int snake = 1;
            snake++;
        } while(snake <=5 );
        //assignment statement in a boolean expression
        int participant = 4;
        while( (participant = participant+1)<10) {}
        assertEquals(10, participant);
        // a semicolon ; is expected at the end of do loop
        int i = 0;
        do {
            i++;
        } while (i<4);
        //switch empty case statement
        int day = 4;
        String value;
        switch (day) {
            default:
            case 1: value = "monday";
            case 7: value = "sunday";
        }
        System.out.println(value);

        //post/pre increment in a for boolean condition/update statement
        for(int i=0;i<4;i++){
            System.out.print(i);
        }
        System.out.println();
        for(int i=0;i<4;++i){
            System.out.print(i);
        }

        //for each date type
        List<Integer> list = new ArrayList<>();
        for(int i : list){}
        for(Object i : list){}
        for(Integer i : new int[3]) {}
        // unary - indicates a literal number is negative or negates an expression
        int temperature = 4;
        int humidity = -temperature + temperature*4;
        assertEquals(12, humidity);
         */
    }
}
