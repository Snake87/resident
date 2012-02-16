package de.reichenbach.resident.persistencelayer;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.PreferenceManager;

/**
 * @author roberto reichenbach
 */

public class PreferencesHelper {
	public static final String FIRSTNAME = "firstname";
	public static final String LASTNAME = "lastname";
	public static final String YEAR_OF_BIRTH = "year_of_birth";
	public static final String IDENTIFICATION = "identification";
	public static final String UPDATE_INTERVAL = "updatesInterval";
	public static final String ERROR = "u/a";
	
	/** configuration data manage */
	private SharedPreferences prefs;
	/** current actvity */
	private Activity actvity;
	
	
	public PreferencesHelper(Activity activity) {
		this.actvity = activity;
		prefs 			 = PreferenceManager.getDefaultSharedPreferences(
									 actvity.getApplicationContext());
	}
	
	/**
	 * 
	 * @return the prefs
	 */
	public SharedPreferences getPrefs() {
		return prefs;
	}
	
	/**
	 * 
	 * @return the firstname
	 */
	public String getFirstname() {
		return prefs.getString(FIRSTNAME, ERROR);
	}
	
	/** 
	 * 
	 * @return the lastname
	 */
	public String getLastname() {
		return prefs.getString(LASTNAME, ERROR);
	}
	
	/**
	 * 
	 * @return the identification
	 */
	public String getIdentification() {
		return prefs.getString(IDENTIFICATION, ERROR);
	}
	
	/**
	 * 
	 * @return the update interval
	 */
	public String getUpdateInterval () {
		return prefs.getString(UPDATE_INTERVAL, ERROR);
	}
}
