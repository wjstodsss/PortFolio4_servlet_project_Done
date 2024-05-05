package com.blacksmith.banchan.util;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PageHandlerTest {

	@Test
	public void test() {
	PageHandler ph = new PageHandler(250, 21);
	ph.print();
	System.out.println("ph =" + ph);
	assertTrue(ph.getBeginPage() == 21);
	assertTrue(ph.getEndPage() == 30);
	}
	
	@Test
	public void test2() {
	PageHandler ph = new PageHandler(250, 10);
	ph.print();
	System.out.println("ph =" + ph);
	assertTrue(ph.getBeginPage() == 1);
	assertTrue(ph.getEndPage() == 10);
	}
	
	@Test
	public void test3() {
	PageHandler ph = new PageHandler(255, 20);
	ph.print();
	System.out.println("ph =" + ph);
	assertTrue(ph.getBeginPage() == 11);
	assertTrue(ph.getEndPage() == 20);
	}
}