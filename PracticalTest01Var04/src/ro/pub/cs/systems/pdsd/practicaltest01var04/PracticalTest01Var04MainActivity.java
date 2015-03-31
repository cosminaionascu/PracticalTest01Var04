package ro.pub.cs.systems.pdsd.practicaltest01var04;

import ro.pub.cs.systems.pdsd.practicaltest01var04.R;
import ro.pub.cs.systems.pdsd.practicaltest01var04.general.Constants;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends Activity {

	protected EditText outputEditText;
	protected MyButtonListener buttonListener = new MyButtonListener();
	protected int totalNrAttempts;
	protected int correctAttempts;
	protected int incorrectAttempts;

	private class MyButtonListener implements Button.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String sb = outputEditText.getText().toString();
			if (!sb.isEmpty()) {
				sb += ", ";
			}

			switch (v.getId()) {
			case R.id.button_do1: {
				sb += "Do";
			}
				break;

			case R.id.button_do2: {
				sb += "Do'";
			}
				break;

			case R.id.button_mi: {
				sb += "Mi";
			}
				break;

			case R.id.button_sol: {
				sb += "Sol";
			}
				break;

			case R.id.id_navigate_button: {
				Intent intent = new Intent(
						"ro.pub.cs.systems.pdsd.intent.action.PracticalTest01Var04SecondaryActivity");
				intent.putExtra("outputFromFirstActivity", outputEditText
						.getText().toString());
				startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
			}
				break;
			}

			outputEditText.setText(sb);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var04_main);

		outputEditText = (EditText) findViewById(R.id.edit_text_output);
		Button do1Button = (Button) findViewById(R.id.button_do1);
		Button do2Button = (Button) findViewById(R.id.button_do2);
		Button miButton = (Button) findViewById(R.id.button_mi);
		Button solButton = (Button) findViewById(R.id.button_sol);
		Button navigateToSecondaryActivity = (Button) findViewById(R.id.id_navigate_button);
		
		do1Button.setOnClickListener(buttonListener);
		do2Button.setOnClickListener(buttonListener);
		miButton.setOnClickListener(buttonListener);
		solButton.setOnClickListener(buttonListener);
		navigateToSecondaryActivity.setOnClickListener(buttonListener);

		if (savedInstanceState != null) {
			int totalNrAttempts = savedInstanceState.getInt("totalNrAttempts");
			this.totalNrAttempts = totalNrAttempts;

			int correctAttempts = savedInstanceState.getInt("correctAttempts");
			this.correctAttempts = correctAttempts;

			int incorrectAttempts = savedInstanceState
					.getInt("incorrectAttempts");
			this.incorrectAttempts = incorrectAttempts;
		} else {
			this.totalNrAttempts = 0;
			this.correctAttempts = 0;
			this.incorrectAttempts = 0;
		}

		Log.d("totalNrAttempts", totalNrAttempts + "");
		Log.d("correctAttempts", correctAttempts + "");
		Log.d("incorrectAttempts", incorrectAttempts + "");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var04_main, menu);
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

	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putInt("totalNrAttempts", totalNrAttempts);
		savedInstanceState.putInt("correctAttempts", correctAttempts);
		savedInstanceState.putInt("incorrectAttempts", incorrectAttempts);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		Toast.makeText(this, "The activity returned with result " + resultCode,
				Toast.LENGTH_LONG).show();
		
		if(resultCode == Constants.INCORRECT_ATTEMPT){
			incorrectAttempts++;
		} else {
			correctAttempts++;
		}
		
		outputEditText.setText("");
		totalNrAttempts++;
	}
}
