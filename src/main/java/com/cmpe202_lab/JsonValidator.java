package com.cmpe202_lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 

public class JsonValidator implements Validator{
	
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
	 
	public ArrayList<CreditCard> validate(String input) throws FileNotFoundException{
		ArrayList<CreditCard> store= new ArrayList<CreditCard>();
		CheckMasterCard check1= new CheckMasterCard();
		CheckVisa check2= new CheckVisa();
		CheckAmExCC check3= new CheckAmExCC();
		CheckDiscover check4 =new CheckDiscover();
		

		check1.setNextCard(check2);
		check2.setNextCard(check3);
		check3.setNextCard(check4);
//		CheckSum checkSum= new CheckSum();
		 JSONParser jsonParser = new JSONParser();
         
	        try 
	        {
	        	FileReader reader = new FileReader(input);
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray users = (JSONArray) obj;
//	            System.out.println(users);
//	            System.);
	      
	             for(int i=0;i<users.size();i++) {
	            	 String[] split_comma= users.get(i).toString().split(",");
	            	 String[] split1= split_comma[0].split(":");
	            	 String[] split2= split_comma[1].split(":");
	            	 String[] split3= split_comma[2].split(":");
	            	 
	            	 String ccnumber= split1[1]; 
	            	 ccnumber = ccnumber.replaceAll("^\\s+",""); 
	            	 ccnumber = ccnumber.replaceAll("\\s+$","");
	            	 
	            	 String expd= split2[1];
	            	 expd = expd.replaceAll("^\\s+",""); 
	            	 expd = expd.replaceAll("\\s+$","");
	            	 expd=expd.replace("\\","");
	            	 expd=expd.replace("\"","");
	            	 String name= split3[1].replaceAll("^\\s+","");
	            	 name=name.replaceAll("\\s+$","");
	            	 name=name.replace("\"","");
	            	 name=name.replace("}","");

	            		//If Credit card is not a Numeric value, return invalid
	            		if(!isNumeric(ccnumber)) {
	            			CreditCard e= new CreditCard(ccnumber, expd, name,"invalid","invalid");
	            			store.add(e);
	            			continue;
	            		}
	            	 
	            	 String checkhere= check1.check(ccnumber);
	            	 
	            	 CreateNewCC createCardFactory = new CreateNewCC();
	            	 
	            	 CreditCard e = createCardFactory.createInstance(ccnumber, expd, name, checkhere);
		         		store.add(e);
	            	 
	             }
	           
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        
	        return store;
		
		}
	
	public void convertFormat(ArrayList<CreditCard> cards, String outputFile) {
		System.out.println("JSON Conversion started");

		try {
  			FileWriter fw = new FileWriter(outputFile);
  			fw.write("[");
  			fw.write('\n');
  			for (int i = 0; i < cards.size(); i++) {
  				CreditCard cc = cards.get(i);
  				fw.write(" "+"{");
  				fw.write('\n');
  				fw.write("    "+"\"CardNumber\": "+"\"" + cc.getCardNumber()+ "\""+ ",");
  				fw.write('\n');
  				fw.write("    "+"\"ExpiryDate\": "+ "\"" +cc.getExpiryDate()+ "\""+ ",");
  				fw.write('\n');
  				fw.write("    "+"\"NameOfCardHolder\": "+"\"" + cc.getName()+ "\""+ ",");
  				fw.write('\n');
  				fw.write("    "+"\"Type\": " + "\"" + cc.getType() + "\"" + " ,");
  				fw.write('\n');
  				fw.write("    "+"\"IsValid\": " + "\"" + cc.getValid_cc() + "\"" );
  				fw.write('\n');

  			
  				if(i == cards.size() - 1) {
  					fw.write(" "+"}");
  				}
  				else {
  					fw.write(" "+"},");
  				}
  				fw.write('\n');
  				
  			}
  			fw.write("]");
  			fw.close();
  			System.out.println("JSON conversion done");
  		}
  		catch (IOException e) {
  			System.out.println("An error occurred.");
  			e.printStackTrace();
  		}


  	}
	
	
	}
