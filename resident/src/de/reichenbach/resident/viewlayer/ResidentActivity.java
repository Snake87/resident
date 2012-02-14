package de.reichenbach.resident.viewlayer;

import de.reichenbach.resident.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

/**
 * @author roberto
 *
 */
public class ResidentActivity extends Activity implements OnClickListener {
		
		private Button settings;
		private Button help;
	

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        settings = (Button)findViewById(R.id.settings);
        help		 = (Button)findViewById(R.id.help);
        
        settings.setOnClickListener(this);
        help.setOnClickListener(this);
    }

		/* (non-Javadoc)
		 * @see android.view.View.OnClickListener#onClick(android.view.View)
		 */
		public void onClick(View view) {
			switch(view.getId()) {
			case R.id.settings:
				startActivity(new Intent(ResidentActivity.this, PreferencesActivity.class));
				break;
			}
			
		}
}