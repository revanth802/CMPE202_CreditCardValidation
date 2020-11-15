package com.cmpe202_lab;



public class CreateNewCC implements CreditCardFactory{
	
	public CreditCard createInstance(String Credit0,String Credit1,String Credit2,String checkhere)
	{
		if(checkhere.equals("MasterCard"))
		{
			return new MasterCC(Credit0, Credit1, Credit2, checkhere, "valid");
		}
		else if(checkhere.equals("Visa"))
		{
			return new VisaCC(Credit0, Credit1, Credit2, checkhere, "valid");
		}
		else if(checkhere.equals("AmericanExpress"))
		{
			return new AmExCC(Credit0, Credit1, Credit2, checkhere, "valid");
		}
		else if(checkhere.equals("Discover"))
		{
			return  new DiscoverCC(Credit0, Credit1, Credit2, checkhere, "valid");
		}
		else 
		{
			return  new CreditCard(Credit0, Credit1, Credit2, checkhere, "invalid");
		}
	}
}