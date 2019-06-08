package com.ruby.sun.dp.command;

public class Receiver {
	String name;
	public Receiver(String name) {
		super();
		this.name = name;
	}
	
	public void start() {
		System.out.println(this.name + " is moving");
	}
	
	public void stop() {
		System.out.println(this.name + " is stoping");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
