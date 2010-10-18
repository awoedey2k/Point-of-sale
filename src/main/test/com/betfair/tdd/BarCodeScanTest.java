package com.betfair.tdd;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BarCodeScanTest {

	private POSSystem pos;
	
	private Display display;
	private BarcodeScanner scanner;
	private PriceService priceService;
	
	
	@Before
	public void setup() {
		
		pos = new POSSystem();

		
		scanner = new BarcodeScanner();
		display = new Display();
		priceService = new PriceServiceImpl();
		
		
		pos.setScanner(scanner);
		pos.setDisplay(display);
		pos.setPriceService(priceService);
	}
	
	@Test
	public void testBarcodeScan1() {
		
		scanner.scan("1a2s3d");
		
		assertEquals(display.getPrice(), "1.0");
	}
	
	@Test
	public void testBarcodeScan2() {
		
		scanner.scan("5g6h7k");
		
		assertEquals(display.getPrice(), "2.0");
	}
	
	@Test
	public void testException() {
		scanner.scan("oops");
		assertEquals(display.getPrice(), "no code found");
	}

}
