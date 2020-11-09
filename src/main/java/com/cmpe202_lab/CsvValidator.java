package com.cmpe202_lab;

import java.io.*;
import java.util.ArrayList;

public class CsvValidator implements Validator{
	
public ArrayList<CreditCard> validate(String input) throws IOException {
	
	ArrayList<CreditCard> store= new ArrayList<CreditCard>();
//	CheckSum checksum=new CheckSum();
	CheckMasterCard check1= new CheckMasterCard();
	CheckVisa check2= new CheckVisa();
	CheckAmExCC check3= new CheckAmExCC();
	CheckDiscover check4 =new CheckDiscover();
	
	
	String line="";
	String splitBy=",";
	try {
		BufferedReader br = new BufferedReader(new FileReader(input));  
		br.readLine();
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		String[] Credit = line.split(splitBy);    // use comma as separator  
		double temp= Double.valueOf(Credit[0]);
		String ccnumber= String.format("%.0f",temp);;
		
//		System.out.println(ccnumber);
//		if(CheckSum.check(ccnumber)) {
//   		 CreditCard e= new CreditCard(Credit[0],Credit[1],Credit[2],"","error");
//    			store.add(e);
//   	 }
		if(check1.check(ccnumber)) {
			CreditCard e= new CreditCard(Credit[0],Credit[1],Credit[2],"MasterCard","valid");
			store.add(e);
		}
		else if(check2.check(ccnumber)) {
			CreditCard e= new CreditCard(Credit[0],Credit[1],Credit[2],"Visa","valid");
			store.add(e);
		}
		else if(check3.check(ccnumber)) {
			CreditCard e= new CreditCard(Credit[0],Credit[1],Credit[2],"American Express","valid");
			store.add(e);
		}
		else if(check4.check(ccnumber)) {
			CreditCard e= new CreditCard(Credit[0],Credit[1],Credit[2],"Discover","valid");
			store.add(e);
		}
		else {
			CreditCard e= new CreditCard(Credit[0],Credit[1],Credit[2],"","error");
			store.add(e);
		}
		
		}  
		br.close();
		 
	}
	catch (NumberFormatException e) {
		
	}
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException e)   
	{  
	e.printStackTrace();  
	}  
	
	return store;
}

public void convertFormat(ArrayList<CreditCard> Cards, String outputFile) {

	try (PrintWriter writer = new PrintWriter(new File(outputFile))) {

	      StringBuilder sb = new StringBuilder();
	      sb.append("CardNumber,ExpirationDate,NameOfCardHolder,IsValid,Type");
	      sb.append('\n');
//	      System.out.println(Cards.size());
	      for (CreditCard card: Cards) {
				sb.append(card.getCardNumber()+','+card.getExpiryDate()+','+card.getName()+','+card.getValid_cc()+',');
				sb.append(card.getType()+'\n');
				System.out.println(sb.toString());
	      }
	      writer.write(sb.toString());
	    }
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
	    }

	return ;
}
}
