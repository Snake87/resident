/**
 * @author roberto reichenbach
 */
package de.reichenbach.resident.logiclayer;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * @author roberto
 *
 */
public class ServiceInfos {

	/** Interact with the overall activities running in the system. */
	private ActivityManager activityManager;
	/** List with all services.*/
	private List<RunningServiceInfo> services;
	/** Application */
	private Application app;
	
	public ServiceInfos(Application app) {
		activityManager = (ActivityManager) app.getSystemService(app.ACTIVITY_SERVICE);
		services				= activityManager.getRunningServices(Integer.MAX_VALUE);
		this.app				= app;
	}
	
	
	public boolean isServiceRunning() {
    ActivityManager manager = (ActivityManager) app.getSystemService(Context.ACTIVITY_SERVICE);
    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
        if ("de.reichenbach.resident.networklayer.TransferService".equals(service.service.getClassName())) {
            return true;
        }
    }
    return false;
}

}
