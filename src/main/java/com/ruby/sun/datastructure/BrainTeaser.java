package com.ruby.sun.datastructure;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class BrainTeaser {
    @Test
    public void test(){
//        assertEquals(1, bulbSwitch(3));
//        assertEquals(2, bulbSwitch(4));
//        assertEquals(3, bulbSwitch(12));
//        assertEquals(6, bulbSwitch(18));
        assertTrue(canTransform("RXXLRXRXL", "XRLXXRRLX"));
        assertTrue(canTransform("XXXXXLXXXX", "LXXXXXXXXX"));//!!!
        assertFalse(canTransform("XL","LL"));
        assertTrue(canTransform("LXR","XLR"));
        assertFalse(canTransform("XXXLXXXXXX","XXXLXXXXXX"));//!!!!
        assertFalse(canTransform("XXXX","XXXX"));//!!!!
        assertFalse(canTransform("LLR", "RRL"));
    }
    //
    public boolean canTransform(String start, String end) {
        int ptr1 = 0;
        int ptr2 = 0;

        while(ptr1 < start.length() && ptr2 < end.length()){
            if((start.charAt(ptr1) == 'L' && ptr1 < ptr2 && end.charAt(ptr2) != 'X')
                    || (start.charAt(ptr1) == 'R' && ptr1 > ptr2 && end.charAt(ptr2) != 'X'))
                break;
            else if(start.charAt(ptr1) == 'X')
                ptr1++;
            else if(end.charAt(ptr2) == 'X')
                ptr2++;
            else if(start.charAt(ptr1) == end.charAt(ptr2)){
                ptr1++;
                ptr2++;
            } else break;
        }

        while(ptr1 < start.length() && start.charAt(ptr1) == 'X') ptr1++;
        while(ptr2 < end.length() && end.charAt(ptr2) == 'X') ptr2++;

        return ptr1 == start.length() && ptr2 == end.length();
    }

    //https://leetcode.com/problems/bulb-switcher/
    public int bulbSwitch(int n) {
        int bsq = 1 << 30;
        int ibit = 0;
        int isq = 0;
        while (bsq > 0) {
            isq = isq + bsq;
            ibit = (ibit >> 1) + bsq;
            if (isq > n) {
                isq -= ibit;
                ibit -= bsq;
            } else {
                isq += ibit;
            }
            bsq >>= 2;
        }
        return ibit;
    }
    //https://leetcode.com/problems/nim-game/
    public boolean canWinNim(int n) {
        return n%4 != 0;
    }
}
