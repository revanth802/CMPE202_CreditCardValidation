package com.cmpe202_lab;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckDiscoverTest extends CheckDiscover {

	@Test
	public void testCheck() {
		CheckDiscover checkd = new CheckDiscover();
		String res = checkd.check("6011000000000000");
		assertEquals("Discover",res);
	}

}
