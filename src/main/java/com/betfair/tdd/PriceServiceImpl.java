package com.betfair.tdd;

import java.util.HashMap;
import java.util.Map;

import com.betfair.tdd.tax.TaxCalculator;

public class PriceServiceImpl implements PriceService {

	private TaxCalculator taxCalculator = new TaxCalculator();
	
	private static Map<String,Long> map = new HashMap<String, Long>();
	
	static {
		map.put("1a2s3d", 1L);
		map.put("5g6h7k", 2L);
		
	}
	
	public PriceServiceImpl() {
		taxCalculator = new TaxCalculator();
	}

	public Price getPrice(String barcode) {
		if (map.get(barcode) != null) {
			double price = map.get(barcode);
			return new Price(price,addTax(barcode));
		}
		else return new Price("Product not found for " + barcode);
	}

	private double addTax(String barcode) {
		double tax = taxCalculator.getTax(barcode);
		return tax;
	}


}
