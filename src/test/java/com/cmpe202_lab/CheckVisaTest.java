package com.cmpe202_lab;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckVisaTest extends CheckVisa {

	
	@Test
	public void testCheck() {
		CheckVisa check_visa = new CheckVisa();
		String res = check_visa.check("4120000000000");
		assertEquals("Visa",res);
	}

}
