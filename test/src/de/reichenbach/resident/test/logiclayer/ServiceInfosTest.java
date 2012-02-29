/**
 * 
 */
package de.reichenbach.resident.test.logiclayer;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ServiceTestCase;
import android.test.mock.MockApplication;
import android.test.mock.MockPackageManager;
import de.reichenbach.resident.logiclayer.ServiceInfos;
import de.reichenbach.resident.networklayer.LocationHelper;
import de.reichenbach.resident.networklayer.TransferService;
import de.reichenbach.resident.viewlayer.ResidentActivity;
import junit.framework.TestCase;

/**
 * @author roberto
 *
 */
public class ServiceInfosTest extends ActivityInstrumentationTestCase2<ResidentActivity> {
	
	private ResidentActivity actvity;
	private ServiceInfos serviceInfos;
	
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
		actvity	= getActivity();
		serviceInfos = new ServiceInfos(getActivity().getApplication());	
	}
	
	public void testPreCondition() {
		assertNotNull(actvity);
		assertNotNull(serviceInfos);
	}

	public void testIsServiceRunning() {
		Intent intent = new Intent(actvity.getApplicationContext(),TransferService.class);
		intent.setClass(actvity.getApplicationContext(), TransferService.class);
		actvity.startService(intent);
		assertTrue(serviceInfos.isServiceRunning());
		
		
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
