package com.betfair.tdd;

public class BarcodeScanner {

	private ScannerListener posSystem;
	
	
	public void scan(String barcode) {

		ScannerEvent event = new ScannerEvent();
		event.setBarcode(barcode);
		
		posSystem.barcodeScanned(event);
		
	}

	public void setListener(POSSystem posSystem) {
		this.posSystem = posSystem;
	}

}
