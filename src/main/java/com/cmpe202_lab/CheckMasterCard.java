package com.cmpe202_lab;

import java.util.Date;

public class CheckMasterCard {
	
	public boolean check(String creditCardNumber, Date expiryDate) {
		char first= creditCardNumber.charAt(0);
		int second= Character.getNumericValue(creditCardNumber.charAt(1));
		if(creditCardNumber.length()==16 && first=='5' && second>=1 && second<=5)
			return true;
		return false;
	}

}
