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
	 
	public ArrayList<CreditCard> validate(String input) throws FileNotFoundException{
		ArrayList<CreditCard> store= new ArrayList<CreditCard>();
		CheckMasterCard check1= new CheckMasterCard();
		CheckVisa check2= new CheckVisa();
		CheckAmExCC check3= new CheckAmExCC();
		CheckDiscover check4 =new CheckDiscover();
//		CheckSum checkSum= new CheckSum();
		 JSONParser jsonParser = new JSONParser();
         
	        try (FileReader reader = new FileReader(input))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray users = (JSONArray) obj;
	            System.out.println(users);
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
//	            	 name=name.substring(1, split3[1].length()-1);
//	            	 if(CheckSum.check(ccnumber)) {
//	            		 CreditCard e= new CreditCard(ccnumber,expd,name,"","error");
//		         			store.add(e);
//	            	 }
	            	 if(check1.check(ccnumber)) {
	         			CreditCard e= new CreditCard(ccnumber,expd,name,"MasterCard","valid");
	         			store.add(e);
	         		}
	         		else if(check2.check(ccnumber)) {
	         			CreditCard e= new CreditCard(ccnumber,expd,name,"Visa","valid");
	         			store.add(e);
	         		}
	         		else if(check3.check(ccnumber)) {
	         			CreditCard e= new CreditCard(ccnumber,expd,name,"American Express","valid");
	         			store.add(e);
	         		}
	         		else if(check4.check(ccnumber)) {
	         			CreditCard e= new CreditCard(ccnumber,expd,name,"Discover","valid");
	         			store.add(e);
	         		}
	         		else {
	         			CreditCard e= new CreditCard(ccnumber,expd,name,"","error");
	         			store.add(e);
	         		}
	            	 
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
		JSONArray ccList = new JSONArray();
		for(CreditCard cc:cards) {
//			CardNumber,ExpirationDate,NameOfCardHolder,IsValid,Type
			JSONObject ccobject = new JSONObject();
	        ccobject.put("CardNumber", Long.parseLong(cc.getCardNumber()));
	        ccobject.put("ExpirationDate", cc.getExpiryDate());
	        System.out.println(cc.getExpiryDate());
	        ccobject.put("NameOfCardHolder", cc.getName());
	        ccobject.put("IsValid", cc.getValid_cc());
	        ccobject.put("Type", cc.getType());
	        ccList.add(ccobject);
		}
		try{
            FileWriter  file = new FileWriter(outputFile,false);
            ccList.writeJSONString(ccList, file);
            file.close();
        }catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	
	}
