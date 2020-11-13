package com.cmpe202_lab;

import java.io.IOException;
import java.util.ArrayList;

public interface Validator {
	public ArrayList<CreditCard> validate(String input) throws IOException;
	public void convertFormat(ArrayList<CreditCard> Cards, String outputFile);
	public boolean isNumeric(String strNum);

}
