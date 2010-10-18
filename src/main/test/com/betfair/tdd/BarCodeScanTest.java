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
		scanner = new BarcodeScanner();
		display = new Display();
		priceService = new PriceServiceImpl();
		
		pos = new POSSystem(scanner,display,priceService);
	}
	
	@Test
	public void testBarcodeScan1() {
		
		scanner.scan("1a2s3d");
		
		assertEquals(1d, display.getPrice().getPrice());
		assertEquals(0.13d, display.getPrice().getTax());
	}
	
	@Test
	public void testBarcodeScan2() {
		
		scanner.scan("5g6h7k");
		
		assertEquals(2d, display.getPrice().getPrice());
		assertEquals(0.05d, display.getPrice().getTax());
	}
	
	@Test
	public void testException() {
		scanner.scan("oops");
		assertEquals("Product not found for oops", display.getPrice().toString());
	}

}
