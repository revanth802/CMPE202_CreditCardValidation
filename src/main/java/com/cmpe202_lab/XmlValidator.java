package com.cmpe202_lab;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.util.ArrayList;

public class XmlValidator implements Validator{
	
	
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
	
	public ArrayList<CreditCard> validate(String input){
		CheckMasterCard check1= new CheckMasterCard();
		CheckVisa check2= new CheckVisa();
		CheckAmExCC check3= new CheckAmExCC();
		CheckDiscover check4 =new CheckDiscover();
	
		check1.setNextCard(check2);
		check2.setNextCard(check3);
		check3.setNextCard(check4);
		ArrayList<CreditCard> store= new ArrayList<CreditCard>();
		try   
		{  
		File file = new File(input);   
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
		DocumentBuilder db = dbf.newDocumentBuilder();  
		Document doc = db.parse(file);  
		doc.getDocumentElement().normalize();  
//		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
		NodeList nodeList = doc.getElementsByTagName("row");  
		for (int itr = 0; itr < nodeList.getLength(); itr++)   
		{  
		Node node = nodeList.item(itr);  
//		System.out.println("\nNode Name :" + node.getNodeName());  
		if (node.getNodeType() == Node.ELEMENT_NODE)   
		{  
		Element eElement = (Element) node;  
		String ccnumber=eElement.getElementsByTagName("CardNumber").item(0).getTextContent();  
		String expd=eElement.getElementsByTagName("ExpirationDate").item(0).getTextContent();   
		String name=eElement.getElementsByTagName("NameOfCardholder").item(0).getTextContent();  
		
		if(!isNumeric(ccnumber)) {
			CreditCard e= new CreditCard(ccnumber,expd,name,"invalid","invalid");
			store.add(e);
			continue;
		}
		
		double temp= Double.valueOf(ccnumber);
		ccnumber= String.format("%.0f",temp);;

		String checkhere= check1.check(ccnumber);
//		if(!checkhere.equals("N/A")) {
//			CreditCard e= new CreditCard(ccnumber,expd,name,checkhere,"valid");
//			store.add(e);
//		}
//		else {
//			CreditCard e= new CreditCard(ccnumber,expd,name,checkhere,"error");
//			store.add(e);
//		}
		CreateNewCC createCardFactory = new CreateNewCC();
		CreditCard e = createCardFactory.createInstance(ccnumber, expd, name, checkhere);
		  		store.add(e);
		}  
		}  
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  
		return store;

}

	public void convertFormat(ArrayList<CreditCard> cards,String output) {
		System.out.println("XML Conversion:");

		
		 try {
			 
	            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
	 
	            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	 
	            Document document = documentBuilder.newDocument();
	 
	            // root element
	            Element root = document.createElement("root");
	            document.appendChild(root);
	 
	            // "CardNumber,ExpirationDate,NameOfCardHolder,IsValid,Type"
	            
	            for(CreditCard card: cards) {
	            Element record = document.createElement("row");
	 
	            root.appendChild(record);

	            Element cc = document.createElement("CardNumber");
	            cc.appendChild(document.createTextNode(card.getCardNumber()));
	            record.appendChild(cc);
	 
	            Element expd = document.createElement("ExpirationDate");
	            expd.appendChild(document.createTextNode(card.getExpiryDate()));
	            record.appendChild(expd);
	 
	            // email element
	            Element name = document.createElement("NameOfCardHolder");
	            name.appendChild(document.createTextNode(card.getName()));
	            record.appendChild(name);
	 
	            // department elements
	            Element valid = document.createElement("IsValid");
	            valid.appendChild(document.createTextNode(card.getValid_cc()));
	            record.appendChild(valid);
	            
	            Element cctype = document.createElement("Type");
	            cctype.appendChild(document.createTextNode(card.getType()));
	            record.appendChild(cctype);
	            }
	 
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            document.setXmlStandalone(true);
	            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	            DOMSource domSource = new DOMSource(document);
	            StreamResult streamResult = new StreamResult(new File(output));
	 
	            transformer.transform(domSource, streamResult);
	 
//	            System.out.println("Done creating XML File");
	 
	        } catch (ParserConfigurationException pce) {
	            pce.printStackTrace();
	        } catch (TransformerException tfe) {
	            tfe.printStackTrace();
	        }
		
	}
	
	
	
}
