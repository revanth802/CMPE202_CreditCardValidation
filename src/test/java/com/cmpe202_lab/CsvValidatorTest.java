package com.cmpe202_lab;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class CsvValidatorTest extends CsvValidator {


	@Test
	public void testIsNumeric() {
     CsvValidator csv = new CsvValidator();
     csv.isNumeric("898989898");
	}

	
	@Test
	public void testIsNumeric2() {
     CsvValidator csv = new CsvValidator();
     csv.isNumeric("9898dddd");
	}
	
	@Test
	public void testValidate() throws IOException {
     CsvValidator csv = new CsvValidator();
     ArrayList<CreditCard> alist = csv.validate("Sample.csv");
     ArrayList<CreditCard> cc = new ArrayList<CreditCard>();
     cc.add(new CreditCard("3333", "4/20/2030", "revanth", "AmericanExpress", "valid"));
     cc.add(new CreditCard("3333", "4/20/2030", "revanth", "AmericanExpress", "valid"));
     cc.add(new CreditCard("3333", "4/20/2030","revanth", "AmericanExpress", "valid"));
     cc.add(new CreditCard("3333", "4/20/2030", "revanth", "AmericanExpress", "valid"));
     assertEquals(cc.size(),alist.size());
     
	}

	@Test
	public void testConvertFormat() {
       CsvValidator csv = new CsvValidator();
   	 ArrayList<CreditCard> Cards = new ArrayList<CreditCard>();
   	 String outputfile = "test_csv.csv";

       csv.convertFormat(Cards, outputfile);
	 }

}
