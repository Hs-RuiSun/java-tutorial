package com.ruby.sun.thread;

public class JThread extends Thread{
	public String name;
	public JThread(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(this.name + " " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		JThread s1 = new JThread("thread 1");
		JThread s2 = new JThread("thread 2");
		JThread s3 = new JThread("thread 3");
		s1.start();
		try {
			s1.join(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		s2.start();
		s3.start();
	}
}
