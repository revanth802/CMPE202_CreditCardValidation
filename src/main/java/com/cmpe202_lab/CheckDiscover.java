package com.cmpe202_lab;

import java.util.Date;

public class CheckDiscover {
	public boolean check(String creditCardNumber) {
		String first= creditCardNumber.substring(0,4);
		if(first.equals("6011") && creditCardNumber.length()==16)
			return true;
		return false;
	}

}
