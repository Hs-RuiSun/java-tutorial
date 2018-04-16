package com.ruby.sun.thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class SerialExecutor implements Executor{
	final Executor executor;
	final Queue<Runnable> queue = new ArrayDeque<Runnable>();
	Runnable active;
	
	SerialExecutor(Executor executor){
		this.executor = executor;
	}

	@Override
	public void execute(Runnable r) {
		queue.offer(() -> {
			try {
				r.run();
			}finally {
				scheduleNext();
			}
			});
	}
	
	protected synchronized void scheduleNext() {
		if((active=queue.poll())!=null) {
			executor.execute(active);
		}
	}

}
