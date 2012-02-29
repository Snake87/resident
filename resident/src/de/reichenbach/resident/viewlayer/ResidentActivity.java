package de.reichenbach.resident.viewlayer;

import de.reichenbach.resident.R;
import de.reichenbach.resident.logiclayer.ServiceInfos;
import de.reichenbach.resident.networklayer.TransferService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author roberto
 *
 */
public class ResidentActivity extends Activity implements OnClickListener {
		
	/** imformation about running services */
		private ServiceInfos serviceInfos;
	
		/* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      serviceInfos 		= new ServiceInfos(getApplication());
      // start service
      Intent service 	= new Intent(this,TransferService.class);
    	startService(service);
    }

    	
    /* (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)keyName
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar, menu);
        return true;
    }
    
		/* (non-Javadoc)
		 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
		 */
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			switch(item.getItemId()) {
			case R.id.setting:
				startActivity(new Intent(ResidentActivity.this, PreferencesActivity.class));
				return true;
			default:
				return super.onOptionsItemSelected(item);
			}
			
		}

		/* (non-Javadoc)
		 * @see android.view.View.OnClickListener#onClick(android.view.View)
		 */
		public void onClick(View view) {	
		}
}