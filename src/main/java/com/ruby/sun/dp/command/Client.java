package com.ruby.sun.dp.command;

public class Client {
	public static void main(String[] args) {
		Receiver car = new Receiver("BMW");
		CarStartCommand startCommand = new CarStartCommand(car);
		CarStopCommand stopCommand = new CarStopCommand(car);
		Invoker controller = new Invoker(startCommand, stopCommand);
		controller.startButtonPressed();
		controller.stopButtonPressed();
	}
}
