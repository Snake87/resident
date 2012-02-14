package de.reichenbach.resident.logiclayer;

import android.text.InputFilter;
import android.text.Spanned;

public class InputFilters {
	private InputFilter filter;
	
	public InputFilter getLetterFilter() {
		filter = new InputFilter() {

			@Override
			public CharSequence filter( CharSequence source, int start, int end,
					Spanned dest, int dstart, int dend ) {
				for( int i=start;i<end;i++ ) {
					if( !Character.isLetter(source.charAt(i)) ) {
						return "";
					}
				}
				return null;
			}
			
		};
		return filter;
	}
}
