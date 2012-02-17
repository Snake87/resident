package de.reichenbach.resident.test.viewlayer;

import de.reichenbach.resident.viewlayer.PreferencesActivity;
import android.app.Instrumentation;
import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.KeyEvent;

public class PreferencesActivityTest extends ActivityInstrumentationTestCase2<PreferencesActivity> {
	
	// keys of the elements
	private static final String LASTNAME   = "lastname";
	private static final String FIRSTNAME = "firstname";
	private static final String YEAROFBIRTH = "yearofbirth";
	private static final String IDENTIFICATION = "identification";
	private static final String UPDATEINTERVAL = "updatesInterval"; 
	
	
	
	/** to be tested activity */
	private PreferencesActivity activity;
	/** EditTextPreference firstname */
	private EditTextPreference firstname;
	/** EditTextPreference lastname */
	private EditTextPreference lastname;
	/** EditTextPreference yearOfBirth */
	private EditTextPreference yearOfBirth;
	/** EditTextPreference identification */
	private EditTextPreference identification;
	/** ListPreference ListPreference */
	private ListPreference updateInterval;
	/** access config data  */
	SharedPreferences preferences;
	/** Instrumentation */
	private Instrumentation instrumentation;
	/**
	 * @param string name of the class
	 * set the class name
	 */
	public PreferencesActivityTest(String string) {
		super(PreferencesActivity.class);
		setName(string);
	}

	/* (non-Javadoc)
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(false);
		activity 				= this.getActivity();
		firstname 			= (EditTextPreference) activity.findPreference(FIRSTNAME);
		lastname 				= (EditTextPreference) activity.findPreference(LASTNAME);
		yearOfBirth 		= (EditTextPreference) activity.findPreference(YEAROFBIRTH);
		identification	= (EditTextPreference) activity.findPreference(IDENTIFICATION);
		updateInterval 	= (ListPreference) activity.findPreference(UPDATEINTERVAL);
		preferences			= PreferenceManager.getDefaultSharedPreferences(activity);
		instrumentation = getInstrumentation();
		
	}
	
	/** instances not null  */
	public void testPreCondition() {
		assertNotNull(activity);
		assertNotNull(firstname);
		assertNotNull(lastname);
		assertNotNull(yearOfBirth);
		assertNotNull(identification);
		assertNotNull(updateInterval);
	}
/*
	public void testLastnameInteraction() {
		selectLastname();
		sendRepeatedKeys(1,KeyEvent.KEYCODE_H);
		String s = preferences.getString(LASTNAME, " n/a");
		Log.d("Test", "Ausgabe:"+s);
		assertEquals(s, "H");		
	}
*/
	/** focus lastname */
	private void selectLastname() {
		try {
			runTestOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					lastname.getEditText().requestFocus();
				}
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
		instrumentation.waitForIdleSync();
	}
}
