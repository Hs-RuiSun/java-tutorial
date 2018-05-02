package com.ruby.sun.unitest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ruby.sun.unittest.Calculator;

public class CalculatorTest {
	@Test
	public void testAdd_emptyString() {
		Calculator cal = new Calculator();
		assertEquals(0, cal.add(""));
	}
	
	@Test
	public void testAdd_1number() {
		Calculator cal = new Calculator();
		assertEquals(1, cal.add("1"));
	}
	
	@Test
	public void testAdd_AmountsOfNumber() {
		Calculator cal = new Calculator();
		assertEquals(6, cal.add("1,2,3"));
	}
	
	@Test
	public void testAdd_NewlinesDelimiter() {
		Calculator cal = new Calculator();
		assertEquals(6, cal.add("1\n2\n3"));
	}
	
	@Test
	public void testAdd_MixedDelimiter() {
		Calculator cal = new Calculator();
		assertEquals(6, cal.add("1,2,3"));
		assertEquals(6, cal.add("1\n2\n3"));
		assertEquals(6, cal.add("1,2\n3"));
		assertEquals(6, cal.add("1\n\n2,,3"));
	}
}
