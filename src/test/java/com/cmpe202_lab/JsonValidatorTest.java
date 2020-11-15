package com.cmpe202_lab;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class JsonValidatorTest {

	@Test
	public void testIsNumeric() {
     JsonValidator jsonv = new JsonValidator();
     jsonv.isNumeric("898989898");
	}

	
	@Test
	public void testIsNumeric2() {
	 JsonValidator jsonv = new JsonValidator();
     jsonv.isNumeric("9898dddd");
	}
	
	@Test
	public void testValidate() throws IOException {
	 JsonValidator jsonv = new JsonValidator();
     ArrayList<CreditCard> alist = jsonv.validate("Sample.json");
     ArrayList<CreditCard> cc = new ArrayList<CreditCard>();
     cc.add(new CreditCard("3333", "4/20/2030", "revanth", "AmericanExpress", "valid"));
     cc.add(new CreditCard("3333", "4/20/2030", "revanth", "AmericanExpress", "valid"));
     cc.add(new CreditCard("3333", "4/20/2030","revanth", "AmericanExpress", "valid"));
     cc.add(new CreditCard("3333", "4/20/2030", "revanth", "AmericanExpress", "valid"));
     assertEquals(cc.size(),alist.size());
     
	}

	@Test
	public void testConvertFormat() {
	JsonValidator jsonv = new JsonValidator();
   	 ArrayList<CreditCard> cccards = new ArrayList<CreditCard>();
   	 String outputfile = "test_json.json";

       jsonv.convertFormat(cccards, outputfile);
	 }
}
