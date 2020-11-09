package com.cmpe202_lab;

public interface CheckCardHandler {

	public void setNextCard(CheckCardHandler nextHandler);
	
	public String check(String creditCardNo);

}
