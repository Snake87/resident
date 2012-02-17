package de.reichenbach.resident.networklayer;

import de.reichenbach.resident.persistencelayer.PreferencesHelper;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/**
 * @author roberto reichenbach
 *
 */
public class LocationHelper implements LocationListener {
	
	public static final int NOTREQUEST = 0;
	public static final int MINDISTANCE = 2;
	
	
	/** check is provider enable */
	private boolean providerEnable;
	/** LocationManager location */ 
	private LocationManager location;
	/** current activity */
	private Activity activity;
	/** PreferencesHelper */
	private PreferencesHelper prefHelper;
	/** Latitude */
	private Double latitude;
	/** Longitude */
	private Double longitude;
	
	
	/** 
	 * Initialize the variables and start gps sensor.
	 * @param activity
	 */
	public LocationHelper(Activity activity) {
		this.activity 	= activity;
		this.prefHelper = new PreferencesHelper(activity);
		this.providerEnable 	= true;
		this.startLocationService();
	}
	
	/** start the gps sensor */
	public void startLocationService() {
		int interval	 	= Integer.valueOf(prefHelper.getUpdateInterval()).intValue();
		this.location 	= (LocationManager) activity.getSystemService (activity.LOCATION_SERVICE);
		this.location.requestLocationUpdates(LocationManager.GPS_PROVIDER, interval, MINDISTANCE, this);
	}
	
	/* (non-Javadoc)
	 * @see android.location.LocationListener#onLocationChanged(android.location.Location)
	 */
	@Override
	public void onLocationChanged(Location location) {
		try {
			this.latitude  = location.getLatitude();
			this.longitude = location.getLongitude(); 
		} catch (NullPointerException e) {
			Log.i("Null pointer location", null);
		}
	}
	
	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @return the providerEnable
	 */
	public boolean isProviderEnable() {
		return providerEnable;
	}
	
	/* (non-Javadoc)
	 * @see android.location.LocationListener#onProviderDisabled(java.lang.String)
	 */
	@Override
	public void onProviderDisabled(String arg0) {
		this.providerEnable = false;
	}

	/* (non-Javadoc)
	 * @see android.location.LocationListener#onProviderEnabled(java.lang.String)
	 */
	@Override
	public void onProviderEnabled(String arg0) {
	
	}

	/* (non-Javadoc)
	 * @see android.location.LocationListener#onStatusChanged(java.lang.String, int, android.os.Bundle)
	 */
	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
	}
}
