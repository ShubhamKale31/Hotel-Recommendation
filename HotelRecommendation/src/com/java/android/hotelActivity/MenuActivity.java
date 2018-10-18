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

public class MenuActivity extends Activity {
	public static String serverIp;

	Button allHotel;
	Button categorySearch;
	Button recommendedHotel;
	Button recommendedHotelByOtherUser;
	Button logout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);


		allHotel=(Button)findViewById(R.id.allHotelButton);
		categorySearch=(Button)findViewById(R.id.criteriaSearchButton);
		logout=(Button)findViewById(R.id.logoutButton);



		allHotel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				AllHotelTask task=new AllHotelTask();
				task.execute();
			}
		});

		categorySearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MenuActivity.this,CriteriaSearchActivity.class);
				startActivity(i);
			}
		});
		logout=(Button)findViewById(R.id.logoutButton);
		logout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
	}
	private class AllHotelTask extends AsyncTask<String, Void, String> {
		@Override
		protected  String doInBackground(String... urls) {
			@SuppressWarnings("unused")

			WebServiceParser webServiceParser = new WebServiceParser(
					MenuActivity.this, "http://" + WelcomeActivity.serverIp
					+ ":8080/HotelRecommendationServer/rest/webService/");

			Map<String, String> params = new HashMap<String, String>();
			params.put("abc","abc");
			ArrayList<HotelBean> hotelBeanList= webServiceParser.getAllHotel(params);
			((ApplicationContext)MenuActivity.this.getApplicationContext()).setHotelBeanList(hotelBeanList);
			return hotelBeanList.size()+"";
		}

		@Override
		protected void onPostExecute(String kal) {

			Intent i=new Intent(MenuActivity.this,ListViewActivity.class);
			startActivity(i);

		}
	}
}