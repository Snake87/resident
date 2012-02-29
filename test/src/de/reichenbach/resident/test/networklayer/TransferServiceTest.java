package de.reichenbach.resident.test.networklayer;

import de.reichenbach.resident.networklayer.TransferService;
import android.content.Intent;
import android.test.ServiceTestCase;

public class TransferServiceTest extends ServiceTestCase <TransferService> {
	
	
	public TransferServiceTest(String name) {
		super(TransferService.class);
		setName(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testStartService() {
		Intent intent = new Intent();
		intent.setClass(getContext(),TransferService.class);
		startService(intent);
		assertNotNull(getService());
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
