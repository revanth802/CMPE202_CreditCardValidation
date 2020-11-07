package com.cmpe202_lab;

import java.util.*;

public class CreditCard {
	protected String cardNumber;
	protected String expiryDate;
	protected String name;
	protected String type;
	protected String valid_cc;
	
	/**
	 * @param cardNumber
	 * @param expiryDate
	 * @param name
	 * @param type
	 * @param valid_cc
	 */
	
	public CreditCard(String cardNumber, String expiryDate, String name, String type, String valid_cc) {
		super();
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.name = name;
		this.type = type;
		this.valid_cc = valid_cc;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValid_cc() {
		return valid_cc;
	}
	public void setValid_cc(String valid_cc) {
		this.valid_cc = valid_cc;
	}
	
	

}

class MasterCC extends CreditCard{

	public MasterCC(String cardNumber, String expiryDate, String name, String type, String valid_cc) {
		super(cardNumber, expiryDate, name,type, valid_cc);
		// TODO Auto-generated constructor stub
	}
	
}
class VisaCC extends CreditCard {

	public VisaCC(String cardNumber, String expiryDate, String name, String type, String valid_cc) {
		super(cardNumber, expiryDate, name,type, valid_cc);
		// TODO Auto-generated constructor stub
	}

}

class AmExCC extends CreditCard{

	public AmExCC(String cardNumber, String expiryDate, String name, String type, String valid_cc) {
		super(cardNumber, expiryDate, name,type, valid_cc);
		// TODO Auto-generated constructor stub
	}
	
}

class DiscoverCC extends CreditCard{

	public DiscoverCC(String cardNumber, String expiryDate, String name, String type, String valid_cc) {
		super(cardNumber, expiryDate, name,type, valid_cc);
		// TODO Auto-generated constructor stub
	}
	
}


