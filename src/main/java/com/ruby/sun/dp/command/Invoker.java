package com.ruby.sun.dp.command;

//remote controller
public class Invoker {
	CarStartCommand startCommand;
	CarStopCommand stopCommand;
	
	public Invoker(CarStartCommand startCommand, CarStopCommand stopCommand) {
		super();
		this.startCommand = startCommand;
		this.stopCommand = stopCommand;
	}
	public void startButtonPressed() {
		startCommand.execute();
	}
	public void stopButtonPressed() {
		stopCommand.execute();
	}
}
