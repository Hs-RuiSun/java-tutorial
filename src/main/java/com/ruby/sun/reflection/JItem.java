package com.ruby.sun.reflection;

public class JItem {
    String value = "value";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private void display(String value) {
        System.out.println("this is a private method, value = " + value);
    }
}
