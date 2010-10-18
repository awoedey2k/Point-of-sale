package com.betfair.tdd.tax;

import java.util.ArrayList;
import java.util.List;


public class TaxCalculator {

	private List<Tax> taxList = new ArrayList<Tax>();
	
	public TaxCalculator() {
		Tax tax1 = new FederalTax();
		Tax tax2 = new SpecificTax();
		taxList.add(tax1);
		taxList.add(tax2);
		
	}


	public double getTax(String barcode) {
		double finalTax = 0;
		for (Tax t:taxList) {
			finalTax += t.getValue(barcode);
		}
		return finalTax;
	}

}
