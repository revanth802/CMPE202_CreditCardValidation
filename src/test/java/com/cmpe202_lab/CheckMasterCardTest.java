package com.cmpe202_lab;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckMasterCardTest extends CheckMasterCard{

	
	@Test
	public void testCheck() {
		CheckMasterCard checkmstr = new CheckMasterCard();
		String res = checkmstr.check("5410000000000000");
		assertEquals("MasterCard",res);
	}

}
