/**
 * @author roberto reichenbach
 */
package de.reichenbach.resident.logiclayer;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Application;

/**
 * @author roberto
 *
 */
public class ServiceInfos {

	/** Interact with the overall activities running in the system. */
	private ActivityManager activityManager;
	/** List with all services.*/
	private List<RunningServiceInfo> services;

	
	public ServiceInfos(Application app) {
		activityManager = (ActivityManager) app.getSystemService(app.ACTIVITY_SERVICE);
		services				= activityManager.getRunningServices(Integer.MAX_VALUE);
	}
	
	public boolean isServiceRunning(String path, String classname) {
		boolean serviceFound = false;
		
		for (int i = 0; i < services.size();i++) {
			if(path.equals(services.get(i).service.getPackageName())) {
				if(classname.equals(services.get(i).service.getClassName())) {
					serviceFound = true;
				}
			}
		}
		return serviceFound;
		
	}
}
