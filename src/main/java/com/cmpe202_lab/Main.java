package com.cmpe202_lab;
 
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;  

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inputFile,outputFile,input_extension,output_extension;
		inputFile="";
		outputFile="";
		if(args.length==2) {
			 inputFile=args[0];
			 outputFile=args[1];
			 input_extension= inputFile.substring(inputFile.indexOf("."));
			 output_extension= outputFile.substring(outputFile.indexOf("."));
			
			 if(!input_extension.equals(output_extension)) {
				 System.out.println("Please enter same input-output formats");
				 System.exit(0);
			 }
			 else {
				 System.out.println("Entered input file- "+inputFile);
				 System.out.println("Entered output file- "+outputFile);
			 }
		}
		
		ArrayList<CreditCard> output=new ArrayList<CreditCard>();
		
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
		
		else if(inputFile.contains(".json")){
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

		else if(inputFile.contains(".xml")){
//			XmlValidator xmlv= new XmlValidator();
			Context xmlv = new Context(new XmlValidator());
				output= xmlv.executeValidate((inputFile));
				xmlv.executeConvertFormat(output, outputFile);
			
			
		}
		else {
			System.out.println("Unsupported file types");
			System.exit(0);
		}
	}
}
