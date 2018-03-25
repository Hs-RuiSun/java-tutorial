package com.ruby.sun.thread;

public class ShutdownHook extends Thread{
	public void run() {
		System.out.println("this is a shutdownhook thread.");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		runtime.addShutdownHook(new ShutdownHook());
		
		Thread.sleep(10000);
	}

}
