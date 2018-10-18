package com.java.android.hotelActivity;

import java.util.HashMap;
import java.util.Map;

import com.java.android.hotel.R;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.java.android.hotel.ApplicationContext;
import com.java.android.hotel.UserBean;
import com.java.android.service.WebServiceParser;

public class LoginActivity extends Activity {

	private Button buttonlogin;
	private Button buttonregister;
	private EditText username;
	private EditText password;
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		buttonregister = (Button) findViewById(R.id.RegisterButton);
		buttonlogin = (Button) findViewById(R.id.LoginButton);
		username = (EditText) findViewById(R.id.editTextUserName);
		password = (EditText) findViewById(R.id.editTextPassword);

		buttonregister.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				try {
					// String str = WelcomeActivity.serverIp;
					if (!TextUtils.isEmpty(WelcomeActivity.serverIp)) {
						Intent intent = new Intent(LoginActivity.this,
								RegistrationActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(LoginActivity.this,
								"Please fill details of Server IP",
								Toast.LENGTH_SHORT).show();
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});

		buttonlogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				try {
					if (!TextUtils.isEmpty(WelcomeActivity.serverIp)) {

						String user_name = username.getText().toString();
						String pass_word = password.getText().toString();

						if (TextUtils.isEmpty(user_name)) {
							username.setError("Invalid User Name");
						}
						else if (TextUtils.isEmpty(pass_word)) {
							password.setError("Invalid Password");
						} else {
							LoginTask task = new LoginTask();
							task.execute(new String[] { "hello" });
						}
					} else {
						Toast.makeText(LoginActivity.this,
								"Please fill details of Server IP",
								Toast.LENGTH_SHORT).show();
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
	}

	private class LoginTask extends AsyncTask<String, Void, UserBean> {
		@Override
		protected UserBean doInBackground(String... urls) {
			@SuppressWarnings("unused")
			String response = urls[0];
			WebServiceParser webServiceParser = new WebServiceParser(
					LoginActivity.this, "http://" + WelcomeActivity.serverIp
							+ ":8080/HotelRecommendationServer/rest/webService/");
			Map<String, String> params = new HashMap<String, String>();
			params.put("UserName", username.getText().toString());
			params.put("PassWord", password.getText().toString());

			UserBean bean = webServiceParser.validateUser(params);
			((ApplicationContext)LoginActivity.this.getApplicationContext()).setUserBean(bean);
			return bean;
		}

		@Override
		protected void onPostExecute(UserBean bean) {
			if (bean.getUserId()>0) {
				
				Intent intent = new Intent(LoginActivity.this,
						MenuActivity.class);
				startActivity(intent);
			} else
				Toast.makeText(LoginActivity.this, "Login failed.",
						Toast.LENGTH_SHORT).show();
			username.setText("");
			password.setText("");

		}
	}
}