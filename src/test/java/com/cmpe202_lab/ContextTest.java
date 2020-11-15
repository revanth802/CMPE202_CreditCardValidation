package com.cmpe202_lab;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class ContextTest {
	Context context = new Context(new CsvValidator());
	 ArrayList<CreditCard> cc = new ArrayList<CreditCard>();

    Validator strategy = new CsvValidator();
	

	@Test
	public void testExecuteValidate() throws IOException {
		 ArrayList<CreditCard> cardsexpected  = strategy.validate("sample.csv");
	     cc.add(new CreditCard("5410000000000000","3/20/2030","Alice","MasterCard","valid"));
	     cc.add(new CreditCard("4120000000000","4/20/2030","Bob","Visa","valid"));
	     cc.add(new CreditCard("341000000000000","5/20/2030","Eve","AmericanExpress","valid"));
	     cc.add(new CreditCard("6010000000000000","6/20/2030","Richard","N/A","invalid"));
		 assertEquals(cardsexpected.size(),cc.size());
	}
	@Test
	public void testExecuteConvertFormat() throws IOException {
		
	     cc.add(new CreditCard("5410000000000000","3/20/2030","Alice","MasterCard","valid"));
	     cc.add(new CreditCard("4120000000000","4/20/2030","Bob","Visa","valid"));
	     cc.add(new CreditCard("341000000000000","5/20/2030","Eve","AmericanExpress","valid"));
	     cc.add(new CreditCard("6010000000000000","6/20/2030","Richard","N/A","invalid"));
		strategy.convertFormat(cc, "test_context.csv");
	     
	}

}
