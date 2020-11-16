package com.cmpe202_lab;

import java.util.Date;

public class CheckDiscover implements CheckCardHandler{
	
	private CheckCardHandler nextCard;
	
	public void setNextCard(CheckCardHandler nextHandler) {
		this.nextCard= nextCard;
	}
	
	public String check(String creditCardNumber) {
		String first= creditCardNumber.substring(0,4);
		if(first.equals("6011") && creditCardNumber.length()==16)
			return "Discover";
		return "invalid";
	}

}
