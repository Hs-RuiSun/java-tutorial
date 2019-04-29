package com.ruby.sun.jclass;

enum Day {
    MONDAY("Monday", 1),
    TUESDAY("Tuesday", 2),
    WEDNESDAY("Wednesday", 3),
    THURSDAY("Thursday", 4),
    FRIDAY("Friday", 5),
    SATURDAY("Saturday", 6),
    SUNDAY("Sunday", 7);


    String elementName;
    int number;

    Day(String elementName, int number) {
        this.elementName = elementName;
        this.number = number;
    }

    static int getNumber(Day day) {
        return day.number;
    }

    static String getValues(Day day) {
        return day.elementName;
    }
}

public class JEnum {

    public static void main(String[] args) {
        System.out.println(Day.getValues(Day.SATURDAY));
        System.out.println(Day.SATURDAY.elementName);
    }
}
