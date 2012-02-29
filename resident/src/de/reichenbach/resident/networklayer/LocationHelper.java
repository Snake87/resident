package de.reichenbach.resident.networklayer;

import de.reichenbach.resident.persistencelayer.PreferencesHelper;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.GeomagneticField;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import com.google.android.maps.GeoPoint;

/**
 * @author roberto reichenbach
 */
public class LocationHelper implements LocationListener {
	public static final int MINDISTANCE = 2; 
	
	/** check is provider enable */
	private boolean providerEnable;
	/** LocationManager location */ 
	private LocationManager lManager;
	/** PreferencesHelper */
	private PreferencesHelper pHelper;
	/** Latitude */
	private Double latitude;
	/** Longitude */
	private Double longitude;
	/** current service */
	private TransferService service;

	/** 
	 * Initialize the variables and start gps sensor.
	 * @param activity
	 */
	public LocationHelper(Context systemContext, TransferService service) {
		this.lManager 			= (LocationManager)systemContext.getSystemService(Context.LOCATION_SERVICE);
		this.pHelper			 	= new PreferencesHelper(systemContext.getApplicationContext());
		int interval	 			= Integer.valueOf(pHelper.getUpdateInterval()).intValue();
		this.service				= service;
		this.lManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, interval, MINDISTANCE, this);
	
	
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
	
	/* (non-Javadoc)
	 * @see android.location.LocationListener#onProviderDisabled(java.lang.String)
	 */
	@Override
	public void onProviderDisabled(String arg0) {	
		Log.i("disable","disable");
		service.stopSelf();
	}

	/* (non-Javadoc)
	 * @see android.location.LocationListener#onProviderEnabled(java.lang.String)
	 */
	@Override
	public void onProviderEnabled(String arg0) {
		this.providerEnable = true;
	}

	/* (non-Javadoc)
	 * @see android.location.LocationListener#onStatusChanged(java.lang.String, int, android.os.Bundle)
	 */
	@Override
	public void onStatusChanged(String provider, int status, Bundle extra) {
	}
}
