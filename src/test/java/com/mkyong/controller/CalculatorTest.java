package com.mkyong.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.mkyong.controller.ICalculator;
import com.mkyong.controller.Calculator;

public class CalculatorTest {
	private static ICalculator calculator;

	@BeforeClass
	public static void initCalculator() {
		calculator = new Calculator();
	}
	
	@Before
	public void beforeEachTest() {
		System.out.println("This is executed before each Test");
	}
	
	@Test
	public void testSum() {
		int result = calculator.sum(3, 4);

		assertEquals(7, result);
	}
	
	//@Ignore
	@Test
	public void testSubstraction() {
		int result = 10 - 3;

		assertTrue(result == 9);
	}
	
}
