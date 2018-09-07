package com.ruby.sun.jclass;

/**
 * from JDK8 there can be default and static methods in interface
 * compile errors when multiple implementation interface has the same default method, and forced to override default method
 * default method enables you to add new functionality to interface and ensure good compatibility with older versions of those interfaces
 */
interface JInterfaceA {
    default void methodA() {
        System.out.println("methodA from interfaceA");
    }
    static void methodB() {
        System.out.println("methodB from interfaceA");
    }
}

interface JInterfaceB {
    default void methodA() {
        System.out.println("methodA from interfaceB");
    }
    static void methodB() {
        System.out.println("methodB from interfaceB");
    }
}

interface JInterfaceC extends JInterfaceA, JInterfaceB{
    @Override
    default void methodA() {
        JInterfaceA.super.methodA();
    }
}

public class JMultipleImplementation implements JInterfaceA, JInterfaceB{
    public static void main(String[] args) {
        JInterfaceA.methodB();
    }
    @Override
    public void methodA() {
        JInterfaceA.super.methodA();
    }
}
