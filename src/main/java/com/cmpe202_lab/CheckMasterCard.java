package com.cmpe202_lab;

import java.util.Date;

public class CheckMasterCard implements CheckCardHandler{
	
	private CheckCardHandler nextCard;
	String cardname= "MasterCard";
	public void setNextCard(CheckCardHandler nextHandler) {
		this.nextCard= nextHandler;
	}
	
	public String check(String creditCardNumber) {
		char first= creditCardNumber.charAt(0);
		int second= Character.getNumericValue(creditCardNumber.charAt(1));
		if(creditCardNumber.length()==16 && first=='5' && second>=1 && second<=5)
			return "MasterCard";
		else
			return nextCard.check(creditCardNumber);
	}

}
