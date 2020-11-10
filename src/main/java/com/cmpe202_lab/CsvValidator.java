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
	
	check1.setNextCard(check2);
	check2.setNextCard(check3);
	check3.setNextCard(check4);
	
	String line="";
	String splitBy=",";
	try {
		BufferedReader br = new BufferedReader(new FileReader(input));  
		br.readLine();
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
			CreateNewCC createCardFactory = new CreateNewCC();
		String[] Credit = line.split(splitBy);    // use comma as separator  
		double temp= Double.valueOf(Credit[0]);
		String ccnumber= String.format("%.0f",temp);
		
		
		String checkhere= check1.check(ccnumber);
//		if(!checkhere.equals("N/A")) {
//			CreditCard e= new CreditCard(Credit[0],Credit[1],Credit[2],checkhere,"valid");
//			store.add(e);
//		}
//		else {
//			
//			CreditCard e= new CreditCard(Credit[0],Credit[1],Credit[2],checkhere,"error");
//			store.add(e);
//		}
		
		CreditCard e = createCardFactory.createInstance(Credit[0], Credit[1], Credit[2], checkhere);
		store.add(e);
		
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
