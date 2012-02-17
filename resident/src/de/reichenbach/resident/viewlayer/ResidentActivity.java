package de.reichenbach.resident.viewlayer;

import java.util.ArrayList;
import java.util.Vector;

import de.reichenbach.resident.R;
import de.reichenbach.resident.networklayer.TransferService;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.Toast;

/**
 * @author roberto
 *
 */
public class ResidentActivity extends Activity implements OnClickListener ,Parcelable {
		
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      //Toast.makeText(this, "Aktivieren Sie GPS", Toast.LENGTH_LONG);
    }
    
    public void startTransferService() {
    	Bundle extData = new Bundle();
    	extData.putParcelable("acitvity", this);
      Intent intent = new Intent(this,TransferService.class);
      intent.putExtra("bundleAcitvity", extData);
      startService(intent);
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

		@Override
		public int describeContents() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void writeToParcel(Parcel arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}
}