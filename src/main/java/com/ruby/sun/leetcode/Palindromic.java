package com.ruby.sun.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class Palindromic {
    @Test
    public void test(){
//    	assertEquals("bad", longestPalindrome("babad"));
//    	assertEquals("bb", longestPalindrome("cbbd"));
//    	assertEquals("", longestPalindrome("bacad"));
//    	assertEquals("aaaa", longestPalindrome("aaaa"));
    	assertTrue(canPermutePalindrome("aab"));
    	assertFalse(canPermutePalindrome("carderac"));
    	assertFalse(canPermutePalindrome("AaBb//a"));
    }
    //https://leetcode.com/problems/palindrome-permutation/
    public boolean canPermutePalindrome(String s) {
    	if(s==null || s.length()==0) return false;
    	int[] chars = new int[127];
    	for(char c : s.toCharArray()) {
    		chars[(int)c]++;
    	}
    	int odd = 0;
    	for(int num : chars) {
    		if(odd<2 && num%2!=0) {
    			if(odd == 1) return false;
    			odd++;
    		}
    	}
        return true;
    }
    //https://leetcode.com/problems/palindromic-substrings/
//    public int countSubstrings(String s) {
//        
//    }
    //https://leetcode.com/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        String output = "";
        return output;
    }
}
