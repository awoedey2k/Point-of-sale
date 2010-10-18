package com.betfair.tdd;

import java.util.HashMap;
import java.util.Map;

public class PriceRepo {

	private static Map<String,String> map = new HashMap<String, String>();
	
	static {
		map.put("1a2s3d", "1.0");
		map.put("5g6h7k", "2.0");
	}
	
	public String getPrice(String barcode) {
		if (map.get(barcode) != null) {
			return map.get(barcode);
		}
		else return "no code found";
	}
}
