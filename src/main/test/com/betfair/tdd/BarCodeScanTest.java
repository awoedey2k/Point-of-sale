package com.betfair.tdd;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BarCodeScanTest {

	
	private Display display;
	private POSSystem pos;
	
	
	@Before
	public void setup() {
		display = new Display();
		PriceRepo repo = new PriceRepo();
		
		pos = new POSSystem(display, repo);
		
	}
	
	@Test
	public void testBarcodeScan1() {
		
		pos.scan("1a2s3d");
		
		assertEquals(display.getPrice(), "1.0");
	}
	
	@Test
	public void testBarcodeScan2() {
		
		pos.scan("5g6h7k");
		
		assertEquals(display.getPrice(), "2.0");
	}
	
	@Test
	public void testException() throws POSException{
		pos.scan("oops");
		assertEquals(display.getPrice(), "no code found");

	}

}
