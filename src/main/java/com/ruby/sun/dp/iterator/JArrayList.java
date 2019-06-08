package com.ruby.sun.dp.iterator;

import java.util.Arrays;
import java.util.List;

public class JArrayList<T> extends JContainer<T>{
	T[] arr;
	
	public JArrayList() {
		arr = (T[]) new Object[10];
	}
	
	public void add(T t) {
		
	}

	private class ArrayIterator implements JIterator<T>{
		int index = 0;
		ArrayIterator iterator() {
			return new ArrayIterator();
		}

		@Override
		public boolean haveNext() {
			if(index<arr.length)
				return true;
			return false;
		}

		@Override
		public T next() {
			return arr[index++];
		}
	}

	@Override
	public JIterator<T> iterator() {
		return new ArrayIterator();
	}
}
