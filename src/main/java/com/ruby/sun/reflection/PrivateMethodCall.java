package com.ruby.sun.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateMethodCall {

    public static void main(String[] args) {
        Class s = com.ruby.sun.reflection.JItem.class;
        try {
            JItem item = new JItem();
            Method method = s.getDeclaredMethod("display", new Class[]{String.class});
            method.setAccessible(true);
            method.invoke(item, "private");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
