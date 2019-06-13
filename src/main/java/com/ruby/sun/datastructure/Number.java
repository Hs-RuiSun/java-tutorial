package com.ruby.sun.datastructure;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Number {
    public void primeNumber(int n){

    }
    public void compositeNumber(){

    }
    @Test
    public void test() {
    	assertTrue(isPalindrome(121));
    	assertFalse(isPalindrome(1212));
    }
    //https://leetcode.com/problems/palindrome-number/
    public boolean isPalindrome(int x) {
    	if(x < 0) return false;
    	int temp = x;
    	int y = 0;
    	while(temp != 0) {
    		y =  y*10 + temp%10; 
    		temp = temp/10;
    	}
        return x==y;
    }
}
