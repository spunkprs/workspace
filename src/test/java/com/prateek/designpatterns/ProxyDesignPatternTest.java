package com.prateek.designpatterns;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class ProxyDesignPatternTest {
	
	private ProxyDesignPattern unit;
	private final String ADMIN_USER = "ADMIN";
	private final String ADMIN_PWD = "ADMIN123";
	
	@Before
	public void setUp() {
		unit = new ProxyDesignPattern();
	}
	
	@Test
	public void shouldProcessRequestWhenUrlContentIsNotViolatingPolicies() throws Exception {
		//Set Up 
		final String url = "XXPPOOSSSEEE";
		final String output = url + " " + "processed";
		
		//Execute && Verify
		Assert.assertEquals(output, unit.processRequest("abcd", "abcd", url));
	}
	
	@Test
	public void shouldProcessRequestWhenUrlContentIsViolatingPoliciesButUserIsAdmin() throws Exception {
		//Set Up 
		final String url = "porn";
		final String output = url + " " + "processed";
		
		//Execute && Verify
		Assert.assertEquals(output, unit.processRequest(ADMIN_USER, ADMIN_PWD, url));
	}
	
	@Test(expected = Exception.class)
	public void shouldThrowExceptionWhenUrlContentIsViolatingPoliciesAndUserIsNonAdminOne() throws Exception {
		//Set Up 
		final String url = "porn";
		final String output = url + " " + "processed";
		
		//Execute && Verify
		Assert.assertEquals(output, unit.processRequest("abcd", "1717", url));
	}
	
	@Test(expected = Exception.class)
	public void shouldThrowExceptionWhenUrlContentIsViolatingPoliciesAndUserIsNonAdminTwo() throws Exception {
		//Set Up 
		final String url = "facebook";
		final String output = url + " " + "processed";
		
		//Execute && Verify
		Assert.assertEquals(output, unit.processRequest("abcd", "1717", url));
	}
}
