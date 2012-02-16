package de.reichenbach.resident.test.persistencelayer;

import android.content.SharedPreferences;
import android.test.ActivityInstrumentationTestCase2;
import de.reichenbach.resident.persistencelayer.PreferencesHelper;
import de.reichenbach.resident.viewlayer.PreferencesActivity;

public class PreferencesHelperTest extends ActivityInstrumentationTestCase2<PreferencesActivity> {
/*
	public static final String FIRSTNAME = "firstname";
	public static final String LASTNAME = "lastname";
	public static final String YEAROFBIRTH = "year_of_birth";
	public static final String IDENDIFICATION = "idendification";
*/	
	private PreferencesHelper prefHelper;
	private PreferencesActivity activity; 
	private SharedPreferences.Editor editor;

	
	/**
	 * @param string name of the class
	 * set the class name
	 */
	public PreferencesHelperTest(String string) {
		super(PreferencesActivity.class);
		setName(string);
	}
	
	
	protected void setUp() throws Exception {
		super.setUp();
		activity 		= getActivity();
		prefHelper	= new PreferencesHelper(activity);
		editor 			= prefHelper.getPrefs().edit();
//		setValues();
	}
	
	/** set test values */
	/*private void setValues () {
		editor.putString(FIRSTNAME, "Uwe");
		editor.putString(LASTNAME, "Fischer");
		editor.putInt(YEAROFBIRTH, 2000);
		editor.putString(IDENDIFICATION, "abteilung1");
		editor.commit();
	}
		*/	
	/** instances not null  */
	public void testPreCondition() {
		assertNotNull(activity);
		//assertNotNull(prefHelper);
		//assertNotNull(editor);
	}
	
	/** test the return value of getLastname() */
/*	public void testValues() {
		//assertEquals(prefHelper.getFirstname(), "Uwe");
		assertEquals(prefHelper.getLastname(), "Fischer");
		//assertEquals(prefHelper.getIdentification(), "abteilung1");
	}*/
	

	
	
	
	
	
	
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
