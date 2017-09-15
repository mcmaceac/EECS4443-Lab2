package ca.yorku.eecs.mack.demobuttonsmcmaceac;

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
 * Demo_Buttons - demonstrate Android's Button widgets and the subclass widgets, CheckBox,
 * RadioButton, and ToggleButton. An ImageButton is also demonstrated.
 * <p>
 * 
 * Related information:
 * <p>
 * 
 * <blockquote> API Guides:
 * <p>
 * 
 * <ul>
 * <li>
 * <a href="http://developer.android.com/guide/topics/ui/index.html">User Interface</a>
 * <li>
 * <a href="http://developer.android.com/guide/topics/ui/controls/button.html">Buttons</a>
 * <li>
 * <a href="http://developer.android.com/guide/topics/ui/declaring-layout.html">Layouts</a>
 * <li>
 * <a href="http://developer.android.com/guide/topics/ui/controls.html">Input Controls</a>
 * <li>
 * <a href="http://developer.android.com/guide/topics/ui/ui-events.html">Input Events</a>
 * </ul>
 * <p>
 * 
 * API References:
 * <p>
 * 
 * <ul>
 * <li>
 * <a href="http://developer.android.com/reference/android/widget/Button.html"><code>Button</code>
 * </a> (and subclasses)
 * <li>
 * <a href="http://developer.android.com/reference/android/widget/ImageButton.html">
 * <code>ImageButton</code></a>
 * <li>
 * <a href="http://developer.android.com/reference/android/widget/TextView.html">
 * <code>TextView</code></a>
 * </ul>
 * </blockquote>
 * 
 * 
 * Here are screen snaps of the application upon launching and after some interaction:
 * <p>
 * 
 * <center><a href="DemoButtons-1.jpg"><img src="DemoButtons-1.jpg" width="200"></a> <a
 * href="DemoButtons-2.jpg"><img src="DemoButtons-2.jpg" width="200"></a></center>
 * <p>
 * 
 * The following types of Android buttons are seen in the screen snaps above (top to bottom): a
 * basic button, a checkbox, three radio buttons, a toggle button, an image button, and another
 * basic button (to Exit the demo). The classes for each are <code>Button</code>,
 * <code>CheckBox</code>, <code>RadioButton</code>, <code>ToggleButton</code>, and
 * <code>ImageButton</code>.
 * <p>
 * 
 * Our first two demo applications, Demo_Android and Demo_Layout, used a traditional approach to
 * responding to button clicks. The <code>Activity</code> was declared to
 * <code>implement OnClickListener</code> and an implementation was provided for
 * <code>onClick(View v)</code>, the method defined in <code>OnClickListener</code>. This demo takes
 * a different approach. In the XML layout file (<code>main.xml</code>), each button element
 * includes the following attribute:
 * <p>
 * 
 * <pre>
 *      android:onClick="buttonClick"
 * </pre>
 * 
 * With this, a method called <code>buttonClick</code> is called when the button is clicked. The
 * method receives a <code>View</code> object as an argument. This is the button that was clicked.
 * Both approaches amount to the same thing. (See the <code>Button</code> API for additional
 * details.)
 * <p>
 * 
 * Note that Android buttons &mdash; objects of the <code>Button</code> class or its subclasses
 * &mdash; are designed to fire click events. These widgets cannot operate using
 * <code>onTouch</code> (of <code>OnTouchListener</code>) or <code>onTouchEvent</code> (inherited
 * from <code>View</code>) because they are not focusable in touch mode. One consequence is that it
 * is not possible to determine when a button is down &ndash; only a button click can be detected
 * and this occurs on button-up. We will consider ways to get around this in a later demo.
 * <p>
 * 
 * The demo includes a button showing an image instead of text. The example image is the common
 * Backspace symbol used on soft keyboards. The button is an instance of <code>ImageButton</code>, a
 * subclass of <code>ImageView</code>. Configuring a button with an image in lieu of text requires a
 * slightly different approach in the XML layout file. The button is specified using the
 * <code>ImageButton</code> element, instead of the <code>Button</code> element. Within the element,
 * the "<code>android:src=</code>" attribute is used instead of the "<code>android:text=</code>"
 * attribute. Here, the attribute appears as
 * <p>
 * 
 * <pre>
 *      android:src="@drawable/bs_normal"
 * </pre>
 * 
 * The image itself is a <code>.png</code> file stored in a sub-folder within the project's
 * resources folder. There are generally at least three sub-folders; each provides resources for
 * devices with a particular display density. For example, the folder
 * <code>res/drawable-hdpi/</code> contains resources for devices with a <i>high-density</i>
 * display. For <code>DemoButtons</code>, there are two resources in each sub-folder, an image file
 * for the button and an image file for the application icon (which appears on the Android device's
 * home screen):
 * <p>
 * 
 * <center><a href="DemoButtons-3.jpg"><img src="DemoButtons-3.jpg" width="300"></a></center>
 * <p>
 *
 * The image above shows the <i>Android</i> view of the project files, which is the default
 * view within Android Studio.  This is a flattened view of the project's structure and
 * provides quick access to the key source files of Android projects.  To get a better sense of the physical
 * organization of
 * files and folders, switch to the <i>Project Files</i> view.  The following is an example showing the image files
 * in each of the three sub-folders within the resources folder:
 * <p>
 *
 * <center><a href="DemoButtons-5.jpg"><img src="DemoButtons-5.jpg" width="200"></a></center>
 * <p>
 *
 * A more stylized approach to using <code>ImageButton</code> is to include separate images for the
 * <i>normal</i>, <i>focused</i>, and <i>pressed</i> states of the button. This requires creating a
 * <code>.png</code> image file for each of the three states. A <i>state list resource</i> is
 * required to link the button state with the correct image. More details are found in the Buttons
 * API Guide (link above).
 * <p>
 * 
 * There are a number of deficiencies in this demo program. One is that the button click status is
 * lost if the screen orientation changes. Another is that the layout stays the same if the device
 * orientation changes. The consequence of this is readily apparent in the screen snap below,
 * showing this application's appearance in landscape mode:
 * <p>
 * 
 * <center><a href="DemoButtons-4.jpg"><img src="DemoButtons-4.jpg" width="400"></a></center>
 * <p>
 * 
 * The Backspace and Exit buttons at the bottom are not visible, since there is insufficient room on
 * the display. You will be asked to remedy these deficiencies in the lab exercise associated with
 * this demo program. Most of the details needed to do this were demonstrated in Demo_Layout.
 * <p>
 * 
 * @author (c) Scott MacKenzie, 2011-2017
 * 
 */
@SuppressWarnings("unused")
public class DemoButtonsmcmaceacActivity extends Activity
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