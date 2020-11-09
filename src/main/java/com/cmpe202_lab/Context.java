package com.cmpe202_lab;

import java.io.IOException;
import java.util.ArrayList;

//Strategy pattern
public class Context {
	   private Validator strategy;

	   public Context(Validator strategy){
	      this.strategy = strategy;
	   }
	   
//	   public ArrayList<CreditCard> validate(String input)
	   public ArrayList<CreditCard> executeValidate(String input) throws IOException{
	      return strategy.validate(input);
	   }
	   
//	   public void convertFormat(ArrayList<CreditCard> cards, String outputFile)
	   public void executeConvertFormat(ArrayList<CreditCard> cards, String outputFile) {
		   strategy.convertFormat(cards, outputFile);
		   
	   }
	}