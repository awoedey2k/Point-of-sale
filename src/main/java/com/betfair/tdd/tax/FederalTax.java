package com.betfair.tdd.tax;


public class FederalTax implements Tax {

	private static double TAX_VALUE = 0.05d;
	@Override
	public double getValue(String barcode) {
		return TAX_VALUE;
	}

}
