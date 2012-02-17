/**
 * 
 */
package de.reichenbach.resident.test.logiclayer;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.mock.MockApplication;
import android.test.mock.MockPackageManager;
import de.reichenbach.resident.logiclayer.ServiceInfos;
import de.reichenbach.resident.networklayer.LocationHelper;
import de.reichenbach.resident.viewlayer.ResidentActivity;
import junit.framework.TestCase;

/**
 * @author roberto
 *
 */
public class ServiceInfosTest extends ActivityInstrumentationTestCase2<ResidentActivity> {
	
	public static final String PACKAGE_PATH = "de.reichenbach.resident.networklayer";
	public static final String CLASSNAME = "LocationHelper";
	
	private ServiceInfos serviceInfos;
	private LocationHelper locationService;
	private ResidentActivity activity;
	
	/**
	 * @param name
	 */
	public ServiceInfosTest(String name) {
		super(ResidentActivity.class);
		setName(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		activity 				= getActivity();
		locationService = new LocationHelper(activity);
		serviceInfos		= new ServiceInfos(activity.getApplication());
	}

	public void testPreCondition() {
		assertNotNull(activity);
		assertNotNull(locationService);
		assertNotNull(serviceInfos);
	}
	
	public void testIsServiceRunning() {
		assertFalse(serviceInfos.isServiceRunning(PACKAGE_PATH,CLASSNAME));
		
	}
	
	private void startService() {
		Intent intent = new Intent(activity,LocationHelper.class);
	}
	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
