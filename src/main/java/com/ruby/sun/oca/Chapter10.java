package com.ruby.sun.oca;

import java.io.*;

abstract class Parent{
    public abstract void print() throws IOException;
}

interface ParentImpl {
    void printName() throws FileNotFoundException;
}
public class Chapter10 extends Parent implements ParentImpl{
    @Override
    public void print() throws FileNotFoundException {
        try (FileReader fr = new FileReader("")){

        } catch (Exception e) {
            throw new FileNotFoundException();
        }
    }

    @Override
    public void printName() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(""));
    }
}
