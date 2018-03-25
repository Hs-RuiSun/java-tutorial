package com.ruby.sun.thread;
class TObect{
	public synchronized void display(int n) { //synchronized method
		for(int i=1;i<=5;i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void getData(int n) {
		synchronized(this) {   //synchronized block
			for(int i=1;i<=5;i++) {
				System.out.println(n * i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
public class JSynchronized {
	final static TObect object = new TObect(); // the same object
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				object.display(5);
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				object.display(50);
			};
		};
		t1.start();
		t2.start();
	}

}
