package com.cmpe202_lab;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckAmExCCTest extends CheckAmExCC {
	@Test
	public void testCheck() {
		CheckAmExCC checkamex = new CheckAmExCC();
		String res = checkamex.check("341000000000000");
		assertEquals("AmericanExpress",res);
	}
}
