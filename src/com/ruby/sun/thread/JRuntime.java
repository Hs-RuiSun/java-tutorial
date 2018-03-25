package com.ruby.sun.thread;

import java.io.IOException;

public class JRuntime {
	public static void main(String[] args) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("totalMemory: " + runtime.totalMemory());
		System.out.println("freeMemory: " + runtime.freeMemory());
		for(int i=0;i<10000;i++){  
			   new JRuntime();  
		} 
		System.out.println(runtime.freeMemory());
		System.gc();
		System.out.println(runtime.freeMemory());
	}

}
