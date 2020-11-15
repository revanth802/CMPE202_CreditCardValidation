package com.cmpe202_lab;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class JunitTests {
	@Test
	public void test1() {
		
		AmExCC amex_obj=new AmExCC("341000000000000","3/20/2030","Alice","valid","MasterCard");
		
		
	}
	
	public void test2() {
		CheckAmExCC checkamex = new CheckAmExCC();
		String res = checkamex.check("341000000000000");
		assertEquals("AmericanExpress",res);
	}
	
	@Test
	public void test3() {
		CheckDiscover checkd = new CheckDiscover();
		String res = checkd.check("6011000000000000");
		assertEquals("Discover",res);
	}

	@Test
	public void test4() {
		CheckMasterCard checkmstr = new CheckMasterCard();
		String res = checkmstr.check("5410000000000000");
		assertEquals("MasterCard",res);
	}
	
	@Test
	public void test5() {
		CheckVisa check_visa = new CheckVisa();
		String res = check_visa.check("4120000000000");
		assertEquals("Visa",res);
	}
	
	Context context = new Context(new CsvValidator());
	 ArrayList<CreditCard> cc = new ArrayList<CreditCard>();

   Validator strategy = new CsvValidator();
	

	@Test
	public void test6() throws IOException {
		 ArrayList<CreditCard> cardsexpected  = strategy.validate("sample.csv");
	     cc.add(new CreditCard("5410000000000000","3/20/2030","Alice","MasterCard","valid"));
	     cc.add(new CreditCard("4120000000000","4/20/2030","Bob","Visa","valid"));
	     cc.add(new CreditCard("341000000000000","5/20/2030","Eve","AmericanExpress","valid"));
	     cc.add(new CreditCard("6010000000000000","6/20/2030","Richard","N/A","invalid"));
		 assertEquals(cardsexpected.size(),cc.size());
	}
	@Test
	public void test7() throws IOException {
		
	     cc.add(new CreditCard("5410000000000000","3/20/2030","Alice","MasterCard","valid"));
	     cc.add(new CreditCard("4120000000000","4/20/2030","Bob","Visa","valid"));
	     cc.add(new CreditCard("341000000000000","5/20/2030","Eve","AmericanExpress","valid"));
	     cc.add(new CreditCard("6010000000000000","6/20/2030","Richard","N/A","invalid"));
		strategy.convertFormat(cc, "test_context.csv");
	     
	}
	
	@Test
	public void test8() {
       CreateNewCC createnew = new CreateNewCC();
       CreditCard cc = createnew.createInstance("5.41E+15", "3/20/2030", "Alice", "Master");
       assertEquals(new CreditCard("5.41E+15", "3/20/2030", "Alice", "Master", "Invalid").getClass(),cc.getClass());
	}
	
	@Test
	public void test9() {
		CreditCard cc_obj=new CreditCard("4120000000000","3/20/2030","Alice","valid","Visa");
	}
	
	@Test
	public void test10() {
     CsvValidator csv = new CsvValidator();
     csv.isNumeric("898989898");
	}

	
	@Test
	public void test11() {
     CsvValidator csv = new CsvValidator();
     csv.isNumeric("9898dddd");
	}
	
	@Test
	public void test12() throws IOException {
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
	public void test13() {
       CsvValidator csv = new CsvValidator();
   	 ArrayList<CreditCard> Cards = new ArrayList<CreditCard>();
   	 String outputfile = "test_csv.csv";

       csv.convertFormat(Cards, outputfile);
	 }
	
	@Test
	public void test14() {
		DiscoverCC discover_obj=new DiscoverCC("6011000000000000","3/20/2030","Alice","valid","Discover");
	}
	

	@Test
	public void test15() {
     JsonValidator jsonv = new JsonValidator();
     jsonv.isNumeric("898989898");
	}

	
	@Test
	public void test16() {
	 JsonValidator jsonv = new JsonValidator();
     jsonv.isNumeric("9898dddd");
	}
	
	@Test
	public void test17() throws IOException {
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
	public void test18() {
	JsonValidator jsonv = new JsonValidator();
   	 ArrayList<CreditCard> cccards = new ArrayList<CreditCard>();
   	 String outputfile = "test_json.json";

       jsonv.convertFormat(cccards, outputfile);
	 }
	
	@Test
	public void test19() {
		MasterCC master_obj=new MasterCC("5410000000000000","3/20/2030","Alice","valid","MasterCard");
	}
	
	@Test
	public void test20() {
		VisaCC visa_obj=new VisaCC("4120000000000","3/20/2030","Alice","valid","Visa");
	}
	
	@Test
	public void test21() {
     CsvValidator csv = new CsvValidator();
     csv.isNumeric("898989898");
	}

	
	@Test
	public void test22() {
     CsvValidator csv = new CsvValidator();
     csv.isNumeric("9898dddd");
	}
	
	@Test
	public void test23() throws IOException {
		XmlValidator xml = new XmlValidator();
     ArrayList<CreditCard> alist = xml.validate("Sample.xml");
     ArrayList<CreditCard> cc = new ArrayList<CreditCard>();
     cc.add(new CreditCard("3333", "4/20/2030", "revanth", "AmericanExpress", "valid"));
     cc.add(new CreditCard("3333", "4/20/2030", "revanth", "AmericanExpress", "valid"));
     cc.add(new CreditCard("3333", "4/20/2030","revanth", "AmericanExpress", "valid"));
     cc.add(new CreditCard("3333", "4/20/2030", "revanth", "AmericanExpress", "valid"));
     assertEquals(cc.size(),alist.size());
     
	}

	@Test
	public void test24() {
       XmlValidator xml = new XmlValidator();
   	 ArrayList<CreditCard> Cards = new ArrayList<CreditCard>();
   	 String outputfile = "test_xml.xml";

       xml.convertFormat(Cards, outputfile);
	 }

}
