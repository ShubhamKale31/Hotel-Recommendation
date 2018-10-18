package com.java.android.hotelActivity;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.java.android.hotel.R;
import com.java.android.service.WebServiceParser;

public class RegistrationActivity extends Activity {

	Button buttonlogin;
	Button buttonregister;
	EditText firstname;
	EditText lastname;
	EditText address;
	EditText phoneno;
	EditText emailid;
	EditText username;
	EditText password;
	Intent intent;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);

		buttonregister = (Button) findViewById(R.id.RegisterButton);
		buttonlogin = (Button) findViewById(R.id.LoginButton);
		firstname = (EditText) findViewById(R.id.editTextFirstName);
		lastname = (EditText) findViewById(R.id.editTextLastName);
		address=(EditText) findViewById(R.id.EditText01);
		phoneno = (EditText) findViewById(R.id.editTextPhone);
		emailid = (EditText) findViewById(R.id.editTextEmail);
		username = (EditText) findViewById(R.id.editTextUserName);
		password = (EditText) findViewById(R.id.editTextPassword);
////////////////////////////////////////////////////////////////////////////////////////
		
		
////////////////////////////////////////////////////////////////////////////////////////////
		
		
/////////////////////////////////////////////////////////////////////////////////////////
		buttonlogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
				startActivity(intent);
			}
		});
	
//////////////////////////////////////////////////////////////////////////////////////
		buttonregister.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String first_name = firstname.getText().toString();
				String last_name = lastname.getText().toString();
				String phone_no = phoneno.getText().toString();
				String email_id = emailid.getText().toString();
				String user_name = username.getText().toString();
				String pass_word = password.getText().toString();

				Validation validation = new Validation();

				

				 if (!validation.isValidFirstName(first_name)) {
					firstname.setError("Invalid First Name");
				}

				else if (!validation.isValidLastName(last_name)) {
					lastname.setError("Invalid Last Name");
				}

				
				else if (!validation.isValidEmail(email_id)) {
					emailid.setError("Invalid Email Id");
				}

				else if (!validation.isValidPhone(phone_no)) {
					phoneno.setError("phone No must be 6 to 13 number");
				}

				else if (!validation.isValidUserName(user_name)) {
					username.setError("Invalid User Name");
				}

				else if (!validation.isValidPassword(pass_word)) {
					password.setError("Password must be six character");
				}
				else
				{
					RegisterTask task = new RegisterTask();
					task.execute(new String[] {"hello"});
				}
				
			}
			
		});
	
////////////////////////END OF ONCREATE METHOD///////////////////////////////////
	}


	private	class RegisterTask extends AsyncTask<String, Void, String> 
	{
			@SuppressWarnings("unused")
			@Override
			protected String doInBackground(String... urls) 
			{
				String response = urls[0];
				WebServiceParser webServiceParser = new WebServiceParser(
						RegistrationActivity.this, "http://" + WelcomeActivity.serverIp
						+ ":8080/HotelRecommendationServer/rest/webService/");
				Map<String, String> params = new HashMap<String, String>();
				
				params.put("FirstName", firstname.getText().toString());
				params.put("LastName", lastname.getText().toString());
				params.put("Address", address.getText().toString());
				params.put("PhoneNo", phoneno.getText().toString());
				params.put("EmailId", emailid.getText().toString());
				params.put("UserName", username.getText().toString());
				params.put("PassWord", password.getText().toString());
				
				int result = webServiceParser.registerUser(params);
				return result + "";
			}
		@Override
		protected void onPostExecute(String result)
		{
			if(Integer.parseInt(result) >0 )
			{
				Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
				startActivity(intent);
				Toast.makeText(RegistrationActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
			}
			else
				Toast.makeText(RegistrationActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
		}
	}

}

