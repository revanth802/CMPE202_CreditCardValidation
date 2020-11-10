package com.cmpe202_lab;
 
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;  

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String inputFile="sample.csv";
		String outputFile="sample1.csv";
		
		ArrayList<CreditCard> output=new ArrayList<>();
		
		if(inputFile.contains(".csv")) {
//			CsvValidator csv= new CsvValidator();
			Context csv = new Context(new CsvValidator());
			try {
				output =csv.executeValidate(inputFile);
				csv.executeConvertFormat(output, outputFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(inputFile.contains(".json")){
//			JsonValidator jsonv= new JsonValidator();
			Context jsonv = new Context(new JsonValidator());
			try {
				output= jsonv.executeValidate(inputFile);
				jsonv.executeConvertFormat(output, outputFile);
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
				
	}

		if(inputFile.contains(".xml")){
//			XmlValidator xmlv= new XmlValidator();
			Context xmlv = new Context(new XmlValidator());
				output= xmlv.executeValidate((inputFile));
				xmlv.executeConvertFormat(output, outputFile);
			
			
		}
	}
}
