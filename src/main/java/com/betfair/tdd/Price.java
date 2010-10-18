package com.betfair.tdd;

public class Price {

	private double price;
	
	private double tax;
	
	private String errorCode;
	
	public Price(double price, double tax) {
		this.price = price;
		this.tax = tax;
	}

	
	public Price(String errorCode) {
		this.errorCode = errorCode;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		
		if (price == 0d) {
			return errorCode;
		} else return "" + (price + tax) + " ron";
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof String) {
			return this.toString().equals(obj.toString());
		} else return super.equals(obj);
	}
	
	
	
}
