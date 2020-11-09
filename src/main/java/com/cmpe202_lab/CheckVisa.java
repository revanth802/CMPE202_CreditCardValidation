package com.cmpe202_lab;

import java.util.Date;

public class CheckVisa implements CheckCardHandler {
	
	private CheckCardHandler nextCard;
	
	public void setNextCard(CheckCardHandler nextHandler) {
		this.nextCard= nextHandler;
	}
	

	public String check(String creditCardNumber) {
		char first= creditCardNumber.charAt(0);
		if((creditCardNumber.length()==13||creditCardNumber.length()==16) && first=='4')
			return "Visa";
		else
			return nextCard.check(creditCardNumber);	
	}
	
}
