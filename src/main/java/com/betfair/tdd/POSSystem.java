package com.betfair.tdd;

public class POSSystem implements ScannerListener{

	private PriceService priceService;
	
	private Display display;
	
	@SuppressWarnings("unused")
	private BarcodeScannerHandler scanner;
	
	public POSSystem(BarcodeScannerHandler scanner, Display display,
			PriceService priceService) {
		this.scanner = scanner;
		scanner.setListener(this);
		this.display = display;		
		this.priceService = priceService;	
	}

	@Override
	public void barcodeScanned(ScannerEvent event) {
		Price price = priceService.getPrice(event.getBarcode());
		display.setPrice(price);
	}

}
