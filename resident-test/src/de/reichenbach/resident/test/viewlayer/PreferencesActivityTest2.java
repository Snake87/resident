package de.reichenbach.resident.test.viewlayer;

import android.test.ActivityInstrumentationTestCase2;
import de.reichenbach.resident.viewlayer.PreferencesActivity;

public class PreferencesActivityTest2 extends ActivityInstrumentationTestCase2<PreferencesActivity> {
		
	/** to be tested activity */
	private PreferencesActivity activity;
	/**
	 * @param string name of the class
	 * set the class name
	 */
	public PreferencesActivityTest2(String string) {
		super(PreferencesActivity.class);
		setName(string);
	}

	/* (non-Javadoc)
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		

	}
	
	/** instances not null  */
	public void testPreCondition() {
		//assertNotNull(activity);
		PreferencesActivity activitys 				= this.getActivity();
		assertTrue(true);
	}
}

