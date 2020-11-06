package com.cmpe202_lab;

import java.util.*;

public class CreditCard {
	protected String cardNumber;
	protected Date expiryDate;
	protected String name;
	protected boolean valid_cc;
	protected String type;
	
	/**
	 * @param cardNumber
	 * @param expiryDate
	 * @param name
	 * @param valid_cc
	 * @param type
	 */
	
	public CreditCard(String cardNumber, Date expiryDate, String name, boolean valid_cc, String type) {
		super();
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.name = name;
		this.valid_cc = valid_cc;
		this.type = type;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
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
	public boolean getvalid_cc() {
		return valid_cc;
	}
	public void setValid(boolean valid_cc) {
		this.valid_cc = valid_cc;
	}

}

class MasterCard extends CreditCard{

	public MasterCard(String cardNumber, Date expiryDate, String name, boolean valid_cc, String type) {
		super(cardNumber, expiryDate, name, valid_cc, type);
		// TODO Auto-generated constructor stub
	}
	
}
class Visa extends CreditCard {

	public Visa(String cardNumber, Date expiryDate, String name, boolean valid_cc, String type) {
		super(cardNumber, expiryDate, name, valid_cc, type);
		// TODO Auto-generated constructor stub
	}

}

class AmericanExpress extends CreditCard{

	public AmericanExpress(String cardNumber, Date expiryDate, String name, boolean valid_cc, String type) {
		super(cardNumber, expiryDate, name, valid_cc, type);
		// TODO Auto-generated constructor stub
	}
	
}

class Discover extends CreditCard{

	public Discover(String cardNumber, Date expiryDate, String name, boolean valid_cc, String type) {
		super(cardNumber, expiryDate, name, valid_cc, type);
		// TODO Auto-generated constructor stub
	}
	
}


