package de.reichenbach.resident.networklayer;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;

public class LocationHelper implements LocationListener {
	
	/** LocationManager location */ 
	private LocationManager location;
	/** current activity */
	private Activity activity;
	
	/** 
	 * Initialize the variables and start gps sensor.
	 * @param activity
	 */
	public LocationHelper(Activity activity) {
		this.activity = activity;
		this.startLocationService();
	}
	
	/** start the gps sensor */
	public void startLocationService() {
		this.location = (LocationManager) activity.getSystemService (activity.LOCATION_SERVICE);
		this.location.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 2, this);
	}

	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
	

}
