package com.ruby.sun.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JRefelction {

    public static void main(String[] args) {
        Class c;
        try {
            c = Class.forName("com.rui.java.tutorial.reflection.JItem");
            System.out.println(c.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //
        JItem item = new JItem();
        c = item.getClass();
        System.out.println(c.getName());

        c = JItem.class;
        System.out.println(c.getName());

        try {
            item = (JItem) c.newInstance();
            System.out.println(item.getValue());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("refection....");
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods)
            System.out.println(method.getName());

        try {
            Constructor contructor = c.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

}
