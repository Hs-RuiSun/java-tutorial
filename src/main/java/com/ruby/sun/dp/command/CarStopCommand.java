package com.ruby.sun.dp.command;

public class CarStopCommand implements Command{
	public Receiver receiver;
	public CarStopCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		System.out.println(receiver.getName() + " CarStopCommand execute");
		receiver.stop();
	}

	@Override
	public void undo() {
		System.out.println(receiver.getName() + " CarStopCommand execute");
	}
}
