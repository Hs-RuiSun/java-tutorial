package com.ruby.sun.unittest;

public class Calculator {
    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;

        String delimiter = ",|\n";
        int sum = 0;
        String[] nums = numbers.split(delimiter);
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
