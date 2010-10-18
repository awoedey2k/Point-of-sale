package com.betfair.tdd;

public class POSSystem {

	private Display display;
	private PriceRepo repo;

	public POSSystem(Display display, PriceRepo repo) {
		this.display = display;
		this.repo = repo;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}
	

	public PriceRepo getRepo() {
		return repo;
	}

	public void setRepo(PriceRepo repo) {
		this.repo = repo;
	}

	public void scan(String barcode) {
		try {
			display.setPrice(repo.getPrice(barcode));
			
 		} catch (Exception e ) {
 			display.setPrice("no code found");
 		}
	}
}
