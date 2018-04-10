package com.ruby.sun.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JReader {
	public static void main(String[] args) throws IOException {
		/**
		 * BufferedReader
		 */
		InputStreamReader r=new InputStreamReader(System.in);    
	    BufferedReader br=new BufferedReader(r);            
	    System.out.println("Enter your name");    
	    String name=br.readLine();    
	    System.out.println("Welcome "+name); 
	}
}
