package ro.pub.cs.systems.pdsd.practicaltest01var04;

import ro.pub.cs.systems.pdsd.practicaltest01var04.general.Constants;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class PracticalTest01Var04SecondaryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_practical_test01_var04_secondary);
		
		Intent intent = getIntent();
	    if (intent != null) {
	      String attempt = intent.getStringExtra("outputFromFirstActivity");
	      
	      if(attempt.equals("Do, Mi, Sol, Do'")){
	    	  setResult(Constants.CORRECT_ATTEMPT, new Intent());
	          finish();
	      } else {
	    	  setResult(Constants.INCORRECT_ATTEMPT, new Intent());
	          finish();
	      }
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var04_secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
