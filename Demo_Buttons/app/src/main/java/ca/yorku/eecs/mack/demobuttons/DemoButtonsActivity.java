package ca.yorku.eecs.mack.demobuttons;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Demo_Android - with modifications by Matthew MacEachern
 *
 * Login ID - mcmaceac
 * Student ID - 213960216
 * Last name - MacEachern
 * First name(s) - Matthew
 */

@SuppressWarnings("unused")
public class DemoButtonsActivity extends Activity
{
	private final static String MYDEBUG = "MYDEBUG"; // for Log.i messages

	Button b;
	CheckBox cb;
	RadioButton rb1, rb2, rb3;
	ToggleButton tb;
	ImageButton backspaceButton, smileButton;
	TextView buttonClickStatus, checkBoxClickStatus, radioButtonClickStatus, toggleButtonClickStatus,
			backspaceButtonClickStatus, smileButtonClickStatus;
	//Button exitButton; //no longer used

	String buttonClickString, backspaceString, smileString;
	boolean checkStatus;
	boolean rb1Status, rb2Status, rb3Status;
	boolean tbStatus;

	// called when the activity is first created
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		init();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		//outState.putBoolean("red", rb1Status);		//storing status of all 3 radio buttons
		//outState.putBoolean("green", rb2Status);
		//outState.putBoolean("blue", rb3Status);
		outState.putString("button", buttonClickString);	//storing simple button's output
		//outState.putBoolean("checkbox", checkStatus);		//storing checkbox's status
		//outState.putString();
		outState.putString("back", backspaceString);		//storing the backspace output
		outState.putString("smiley", smileString);			//storing the smiley output


	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		buttonClickString = savedInstanceState.getString("button");
		buttonClickStatus.setText(buttonClickString);

		backspaceString = savedInstanceState.getString("back");
		backspaceButtonClickStatus.setText(backspaceString);
		
		smileString = savedInstanceState.getString("smiley");
		smileButtonClickStatus.setText(smileString);

		// radio button #1 (RED)
		if (rb1.isChecked())								//setting the radio button status message
		{
			//rb1.setChecked(true);
			radioButtonClickStatus.setText(R.string.red);
			radioButtonClickStatus.setTextColor(Color.RED);
		}

		// radio button #2 (GREEN)
		else if (rb2.isChecked())
		{
			//rb2.setChecked(true);
			radioButtonClickStatus.setText(R.string.green);
			radioButtonClickStatus.setTextColor(Color.GREEN);
		}

		// radio button #3 (BLUE)
		else if (rb3.isChecked())
		{
			//rb3.setChecked(true);
			radioButtonClickStatus.setText(R.string.blue);
			radioButtonClickStatus.setTextColor(Color.BLUE);
		}

		if (cb.isChecked())									//setting clickbox status message
		{
			cb.setChecked(true);
			checkBoxClickStatus.setText(R.string.checked);
		}
		else
		{
			cb.setChecked(false);
			checkBoxClickStatus.setText(R.string.unchecked);
		}

		if (tb.isChecked())									//setting toggle button status message
			toggleButtonClickStatus.setText(R.string.on);
		else
			toggleButtonClickStatus.setText(R.string.off);


	}

	private void init()
	{
		b = (Button)findViewById(R.id.button);
		cb = (CheckBox)findViewById(R.id.checkbox);
		rb1 = (RadioButton)findViewById(R.id.radiobutton1);
		rb2 = (RadioButton)findViewById(R.id.radiobutton2);
		rb3 = (RadioButton)findViewById(R.id.radiobutton3);
		rb1.toggle();
		tb = (ToggleButton)findViewById(R.id.togglebutton);
		backspaceButton = (ImageButton)findViewById(R.id.backspacebutton);
		//exitButton = (Button)findViewById(R.id.exitbutton); //removed, no longer in use
		smileButton = (ImageButton)findViewById(R.id.smilebutton);

		buttonClickStatus = (TextView)findViewById(R.id.buttonclickstatus);
		checkBoxClickStatus = (TextView)findViewById(R.id.checkboxclickstatus);
		radioButtonClickStatus = (TextView)findViewById(R.id.radiobuttonclickstatus);
		toggleButtonClickStatus = (TextView)findViewById(R.id.togglebuttonclickstatus);
		backspaceButtonClickStatus = (TextView)findViewById(R.id.backspacebuttonclickstatus);
		smileButtonClickStatus = (TextView)findViewById(R.id.smilebuttonclickstatus);

		buttonClickString = "";
		backspaceString = "";
		smileString = "";

		buttonClickStatus.setText(buttonClickString);
		checkBoxClickStatus.setText(R.string.unchecked);
		radioButtonClickStatus.setText(R.string.red);
		radioButtonClickStatus.setTextColor(Color.RED);
		toggleButtonClickStatus.setText(R.string.off);
	}

	// handle button clicks
	public void buttonClick(View v)
	{
		// plain button
		if (v == b)
		{
			buttonClickString += ".";
			buttonClickStatus.setText(buttonClickString);
		}

		// checkbox
		else if (v == cb)
		{
			if (cb.isChecked())
			{
				cb.setChecked(true);
				checkBoxClickStatus.setText(R.string.checked);
			} else
			{
				cb.setChecked(false);
				checkBoxClickStatus.setText(R.string.unchecked);
			}
		}

		// radio button #1 (RED)
		else if (v == rb1)
		{
			rb1.setChecked(true);
			radioButtonClickStatus.setText(R.string.red);
			radioButtonClickStatus.setTextColor(Color.RED);
		}

		// radio button #2 (GREEN)
		else if (v == rb2)
		{
			rb2.setChecked(true);
			radioButtonClickStatus.setText(R.string.green);
			radioButtonClickStatus.setTextColor(Color.GREEN);
		}

		// radio button #3 (BLUE)
		else if (v == rb3)
		{
			rb3.setChecked(true);
			radioButtonClickStatus.setText(R.string.blue);
			radioButtonClickStatus.setTextColor(Color.BLUE);
		}

		// toggle button
		else if (v == tb)
		{
			tb.setActivated(tb.isChecked());
			if (tb.isChecked())
				toggleButtonClickStatus.setText(R.string.on);
			else
				toggleButtonClickStatus.setText(R.string.off);
		}

		// backspace button
		else if (v == backspaceButton)
		{
			backspaceString += "BK ";
			backspaceButtonClickStatus.setText(backspaceString);
		}

		// exit button
		else if (v == smileButton)
		{
			smileString += ":) ";
			smileButtonClickStatus.setText(smileString);
		}
	}
}