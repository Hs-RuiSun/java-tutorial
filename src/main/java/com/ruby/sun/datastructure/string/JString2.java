package com.ruby.sun.datastructure.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JString2 {
	@Test
	public void test() {
		assertTrue(validPalindrome("bc"));
		assertTrue(validPalindrome("aba"));
		assertTrue(validPalindrome("abca"));
		assertTrue(validPalindrome("abcbebca"));
		assertTrue(validPalindrome("abcecbca"));
		assertTrue(validPalindrome("bbc"));
		assertFalse(validPalindrome("abceebca"));
		assertTrue(validPalindrome("abcecba"));
	}
	//https://leetcode.com/problems/valid-palindrome-ii/
	public boolean validPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i <= j && s.charAt(i) == s.charAt(j)) {
			i++;
			j--;
		}
		if (i > j) {
			return true;
		}
		int pos = i;
		if (i + 1 <= j && s.charAt(i + 1) == s.charAt(j)) {
			i++;
			while (i <= j && s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			}
			if (i > j) {
				return true;
			}
		}
		i = pos;
		j = s.length() - 1 - i;
		if (j - 1 >= i && s.charAt(j - 1) == s.charAt(i)) {
			j--;
			while (j >= i && s.charAt(j) == s.charAt(i)) {
				i++;
				j--;
			}
			if (i > j) {
				return true;
			}
		}
		return false;
	}
}
