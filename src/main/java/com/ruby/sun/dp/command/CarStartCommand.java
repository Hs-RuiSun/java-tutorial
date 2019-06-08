package com.ruby.sun.dp.command;

public class CarStartCommand implements Command{
	public Receiver receiver;
	
	public CarStartCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		System.out.println(receiver.getName() + " CarStartCommand execute");
		receiver.start();
	}

	@Override
	public void undo() {
		System.out.println(receiver.getName() + " CarStopCommand execute");
	}

}
