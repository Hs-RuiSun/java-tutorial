package com.ruby.sun.oca;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Chapter6 {
    @Test
    public void variableReference(){
        int length = 3;
        for(int i=0; i<4; i++){
            if(i%2 == 0){
                Supplier<Integer> sp = () -> length;
                System.out.println(sp.get());
            } else {
                //sp = () -> i; not effectively final
                int j = i;
                Supplier<Integer> sp = () -> j;
                System.out.println(sp.get());
            }
        }
    }

    public void remove(List<Character> chars){
        char end = 'z';
        chars = new ArrayList<>();
        //char start = 'c';
        //char c = 'e';
        //end = '1';
        chars.removeIf(c -> {
            char start = 'a'; return start <= c && c >= end;
        });
        chars = null;
        chars = new ArrayList<>();
        char start = 'b';
        char c = 'e';
        //end = '1';  compile error
    }

    public void method(){ //lambda variables and method names are allowed to be the same
        x((var x) -> {}, (var x, var y) -> 0);
    }

    public void x(Consumer<String> x, Comparator<Boolean> y){ }
}
