/**
 * 
 */
package de.reichenbach.resident.test.networklayer;

import de.reichenbach.resident.networklayer.LocationHelper;
import de.reichenbach.resident.networklayer.TransferService;
import de.reichenbach.resident.viewlayer.ResidentActivity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * @author roberto reichenbach
 *
 */
public class LocationHelperTest extends ActivityInstrumentationTestCase2<ResidentActivity> {
	public ResidentActivity activity;
	public LocationHelper locationHelper;
	
	/**
	 * @param name
	 */
	public LocationHelperTest(String name) {
		super(ResidentActivity.class);
		setName(name);
	}

	/* (non-Javadoc)
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		activity 				= getActivity();
		
		TransferService a = new TransferService();
		locationHelper 	= new LocationHelper(activity.getApplicationContext(),a);
	}
	
	public void testPreCondition() {
		assertNotNull(activity);
		assertNotNull(locationHelper);
	}

	/* (non-Javadoc)
	 * @see android.test.ActivityInstrumentationTestCase2#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
