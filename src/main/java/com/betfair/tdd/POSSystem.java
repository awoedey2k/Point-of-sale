package com.betfair.tdd;

public class POSSystem implements ScannerListener{

	private PriceService priceService;
	
	private Display display;
	
	@SuppressWarnings("unused")
	private BarcodeScanner scanner;
	
	public void setScanner(BarcodeScanner scanner) {
		this.scanner = scanner;
		scanner.setListener(this);
	}

	public void setDisplay(Display display) {
		this.display = display;		
	}

	public void setPriceService(PriceService priceService) {
		this.priceService = priceService;	
	}

	@Override
	public void barcodeScanned(ScannerEvent event) {
		String price = priceService.getPrice(event.getBarcode());
		display.setPrice(price);
	}

}
