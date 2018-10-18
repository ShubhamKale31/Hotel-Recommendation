package com.java.android.hotelActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.java.android.hotel.ApplicationContext;
import com.java.android.hotel.HotelBean;
import com.java.android.hotel.R;
import com.java.android.hotel.UserBean;
import com.java.android.service.WebServiceParser;

public class SuccessActivity extends Activity {

	Button back;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.success);
		back=(Button)findViewById(R.id.backButton);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(SuccessActivity.this,MenuActivity.class);
				startActivity(intent);
				
			}
		});
		


	
	}
}