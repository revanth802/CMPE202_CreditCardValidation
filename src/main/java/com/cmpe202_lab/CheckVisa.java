package com.cmpe202_lab;

import java.util.Date;

public class CheckVisa {

	public boolean check(String creditCardNumber, Date expiryDate) {
		char first= creditCardNumber.charAt(0);
		if((creditCardNumber.length()==13||creditCardNumber.length()==16) && first=='4')
			return true;
		return false;
	}
	
}
