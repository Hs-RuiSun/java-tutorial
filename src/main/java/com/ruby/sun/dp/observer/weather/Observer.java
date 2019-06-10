package com.ruby.sun.dp.observer.weather;

public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
