package com.ruby.sun.thread;

public class DeadLock {
	public static String resource1 = "r1";
	public static String resource2 = "r2";
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				synchronized(resource1) {
					System.out.println("thread using resource1");
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(resource2) {
						System.out.println("thread using resource2");
					}
				}
				
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				synchronized(resource2) {
					System.out.println("thread using resource2");
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(resource1) {
						System.out.println("thread using resource1");
					}
				}
			}
		};
		t1.start();
		t2.start();
	}

}
