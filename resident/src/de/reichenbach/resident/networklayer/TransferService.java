/**
 * 
 */
package de.reichenbach.resident.networklayer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * @author roberto reichenbach
 *
 */
public class TransferService extends Service {
	/** managed the gps access */
	LocationHelper locationHelper;
	
	/* (non-Javadoc)
	 * @see android.app.Service#onCreate()
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		locationHelper = new LocationHelper(getApplicationContext(),this);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
}
