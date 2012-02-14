package de.reichenbach.resident.logiclayer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormValidate {
	
	public static final String ALPHANUMERIC = "[a-zA-Z]*";
	
	private Pattern pattern;
	private Matcher matcher;	
	
	public boolean isAlphanumeric(String value) {
		pattern = Pattern.compile( ALPHANUMERIC );
		matcher = pattern.matcher( value ); 
		
		return matcher.matches();
	}
}
