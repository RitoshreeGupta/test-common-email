package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;

public class EmailTest{
	
	private static final String[] TEST_EMAILS = { "ab@bc.com", "a.b@c.org", 
			"abcdefghijklmnopqrst@abcdefghifklmnopqrst.com.bd" 
			};
			
	private EmailConcrete email;
	private static final String TESTemail = "abc@cb.com";
	
	@Before
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();
		
	}
	
	@After
	public void tearDownEmailTest() throws Exception {
		
		
	}
	
	@Test
	public void testAddBcc() throws Exception{
		
		email.addBcc(TEST_EMAILS);
		
		assertEquals(3, email.getBccAddresses().size());
		
		
	}
	
	@Test
	public void testAddCc() throws Exception{
		
		email.addCc(TESTemail);
		
		assertEquals(1, email.getCcAddresses().size());
		
	}
	
	@Test
	public void testaddReplyTo() throws Exception{
		
		email.addReplyTo(TESTemail, "Ritoshree");
		
		assertEquals(1, email.getReplyToAddresses().size());
		
	}
	
	@Test
	public void testSetFrom() throws Exception{
		
		email.setFrom("ab@cd.com");
		
		assertEquals("ab@cd.com", email.getFromAddress().toString());
		
	}
	
	


	
}
