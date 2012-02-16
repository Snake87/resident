package de.reichenbach.resident.viewlayer;

import de.reichenbach.resident.R;
import de.reichenbach.resident.logiclayer.FormValidate;
import de.reichenbach.resident.logiclayer.InputFilters;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.text.InputFilter;
import android.util.Log;
import android.widget.Toast;

/**
 * @author roberto reichenbach
 */

public class PreferencesActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener {
	private static final String FIRSTNAME	= "firstname";
	private static final String LASTNAME 	= "lastname";
	
	
	private InputFilters inputFilter;
	/** EditTextPreference firstname */
	private EditTextPreference firstname;
	/** EditTextPreference lastname */
	private EditTextPreference lastname;
	/** configuration data manage */
	private SharedPreferences prefs;
	/** */
	private SharedPreferences.Editor prefEditor;
	/** It allows access to application-specific resources and classes */
	private Context context;
	
	/* (non-Javadoc)
	 * @see android.preference.PreferenceActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);		 
		addPreferencesFromResource( R.xml.preferences );
		init();
		addInputFilter(firstname);
		addInputFilter(lastname);
	}
	
	/** Initialize the variables. */
	private void init() {
		context			= getApplicationContext();
		prefs				= PreferenceManager.getDefaultSharedPreferences( context );
		inputFilter = new InputFilters();
		lastname 		= (EditTextPreference) findPreference( LASTNAME );
		firstname 	= (EditTextPreference) findPreference( FIRSTNAME );
	}
	
	private void addInputFilter(EditTextPreference editText) {
		editText.getEditText().setFilters(new InputFilter[]{
				inputFilter.getLetterFilter()
		});
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		super.onPause();
		prefs.unregisterOnSharedPreferenceChangeListener(this);	
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		super.onResume();
		prefs.registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		
	}	
}
