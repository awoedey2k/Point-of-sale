package com.betfair.tdd.tax;

import java.util.ArrayList;
import java.util.List;


public class SpecificTax implements Tax {

	private static double TAX_VALUE =  0.08d;
	private static List<String> specificProducts = new ArrayList<String>();
	
	static {
		specificProducts.add("1a2s3d");
	}
	
	@Override
	public double getValue(String barcode) {
		if (specificProducts.contains(barcode)) {
			return TAX_VALUE;
		} else return 0d;
	}

}
