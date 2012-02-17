/**
 * 
 */
package de.reichenbach.resident.networklayer;

import de.reichenbach.resident.viewlayer.ResidentActivity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;

/**
 * @author roberto reichenbach
 *
 */
public class TransferService extends Service {

	LocationHelper location;
	
	
	/* (non-Javadoc)
	 * @see android.app.Service#onStartCommand(android.content.Intent, int, int)
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		Bundle bundle = intent.getBundleExtra("bundleAcitvity");
		ResidentActivity activity = bundle.getParcelable("acitvity");
		location = new LocationHelper(activity);
		return super.onStartCommand(intent, flags, startId);
	}
	
	/* (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
