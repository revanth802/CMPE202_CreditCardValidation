package com.cmpe202_lab;

public class CheckAmExCC implements CheckCardHandler{
	
	private CheckCardHandler nextCard;
	
	public void setNextCard(CheckCardHandler nextHandler) {
		this.nextCard= nextHandler;
	}
	
	public String check(String creditCardNumber) {
		
		char first= creditCardNumber.charAt(0);
		char second= creditCardNumber.charAt(1);
		if(first=='3' && creditCardNumber.length()==15 && (second=='4' || second=='7'))
			return "AmericanExpress";
		else
			return nextCard.check(creditCardNumber);
	}
}
