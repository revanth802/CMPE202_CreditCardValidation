package com.cmpe202_lab;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreateNewCCTest {
	@Test
	public void testCreateInstance() {
       CreateNewCC createnew = new CreateNewCC();
       CreditCard cc = createnew.createInstance("5.41E+15", "3/20/2030", "Alice", "Master");
       assertEquals(new CreditCard("5.41E+15", "3/20/2030", "Alice", "Master", "Invalid").getClass(),cc.getClass());
	}
}
