/**
 * 
 */
package de.reichenbach.resident.test.logiclayer;

import de.reichenbach.resident.logiclayer.FormValidate;

import junit.framework.TestCase;

/**
 * @author roberto
 *
 */
public class FormValidateTest extends TestCase {
	
	private FormValidate formValidate;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		formValidate = new FormValidate();
		 
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link de.reichenbach.resident.logiclayer.FormValidate#isAlphanumeric(java.lang.String)}.
	 */
	public void testIsAlphanumeric() {
		assertTrue( formValidate.isAlphanumeric( "RobertoReichenbach" ) );
		assertFalse( formValidate.isAlphanumeric("123RobertoReichenbach") );
	}

}
