package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

	@Rule
    public ExpectedException thrown = ExpectedException.none();

	
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
	public void testAddHeader() throws Exception{
		final String header = "header";
		
		email.addHeader(header, header);
		assertEquals(1, email.headers.size());
		
	}
	
	@Test
	public void testAddHeader2() throws Exception{
		
		thrown.expectMessage("name can not be null or empty");
		email.addHeader("", "header");
		
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
	
	@Test
	public void testgetHostName() throws Exception{
		
		email.setHostName("Local");
		
		assertEquals("Local", email.getHostName());
		
	}
	
	@Test
	public void testgetHostName1() throws Exception{
		
		assertEquals(null, email.getHostName());
		
	}
	
	
	
	
}
