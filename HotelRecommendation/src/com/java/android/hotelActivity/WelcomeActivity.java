package com.java.android.hotelActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.java.android.hotel.R;

public class WelcomeActivity extends Activity {
	public static String serverIp;
	private Button buttonlogin;
	private Button buttonregister;
	private Button IpCancleButton;
	private Button IpSubmitButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);

		buttonregister = (Button) findViewById(R.id.RegisterButton);
		buttonlogin = (Button) findViewById(R.id.LoginButton);

		buttonlogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				try {
					if (!TextUtils.isEmpty(serverIp)) {
						Intent intent = new Intent(WelcomeActivity.this,
								LoginActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(WelcomeActivity.this,
								"Please fill details of Server IP",
								Toast.LENGTH_SHORT).show();
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});

		buttonregister.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				try {
					if (serverIp != null && !serverIp.equals("")) {
						Intent intent = new Intent(WelcomeActivity.this,
								RegistrationActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(WelcomeActivity.this,
								"Please fill details of Server IP",
								Toast.LENGTH_SHORT).show();
					}
				} catch (Exception exception) {
					System.out.println(exception);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.ip_settings:
			final Dialog dialog = new Dialog(WelcomeActivity.this);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.ip_address_config);
			// set title and cancelable

			dialog.setCancelable(true);
			// dialog.setTitle("IP Connection:");

			IpCancleButton = (Button) dialog.findViewById(R.id.IpCancleButton);
			IpCancleButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					dialog.dismiss();
				}
			});

			IpSubmitButton = (Button) dialog.findViewById(R.id.IpSubmitButton);

			IpSubmitButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					EditText editTextipServer = (EditText) dialog.findViewById(R.id.editTextipServer);
					serverIp = editTextipServer.getText().toString();
					if (!serverIp.equals("")) {
						Toast.makeText(WelcomeActivity.this, serverIp,Toast.LENGTH_LONG).show();
						dialog.dismiss();
					} else {
						Toast.makeText(WelcomeActivity.this, "Enter IP",Toast.LENGTH_LONG).show();
					}
				}
			});
			dialog.show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}// end onOptionsItemSelected
}// end Activity