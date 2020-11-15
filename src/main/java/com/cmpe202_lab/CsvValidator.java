package com.cmpe202_lab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class CsvValidator implements Validator{
	
	public boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
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
//		System.out.println(Arrays.toString(Credit));
//		System.out.println(Credit.length);
		
		//Invalid inputs
		if(Credit.length!=3) {
			CreditCard e= new CreditCard("invalid","invalid","invalid","invalid","invalid");
			store.add(e);
			continue;
		}
		
		//If Credit card is not a Numeric value, return invalid
		if(!isNumeric(Credit[0])) {
			CreditCard e= new CreditCard(Credit[0],Credit[1],Credit[2],"invalid","invalid");
			store.add(e);
			continue;
		}
		
		
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
		
		CreditCard e = createCardFactory.createInstance(ccnumber, Credit[1], Credit[2], checkhere);
		store.add(e);
		
		}  
		br.close();
		 
	}
	catch (NumberFormatException e) {
		System.out.println(e);
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
	System.out.println("CSV Conversion:");

       	 File file = new File(outputFile);
		   try {
		       FileWriter outputfile = new FileWriter(file);
		 
		       CSVWriter writer = new CSVWriter(outputfile);
		 
		       List<String[]> data = new ArrayList<String[]>();
		       data.add(new String[] {"CardNumber","ExpirationDate","NameOfCardHolder","IsValid","Type"});
		      for(int i=0;i<Cards.size();i++)
		      {
		       data.add(new String[] {String.valueOf(Cards.get(i).getCardNumber()), Cards.get(i).getExpiryDate(), Cards.get(i).getName(),
		    		   Cards.get(i).getValid_cc(),Cards.get(i).getType()});
		       }
		      
		       writer.writeAll(data);

		       writer.close();
		   }
		   catch (IOException e) {
		       e.printStackTrace();
		   }
}
	
}

