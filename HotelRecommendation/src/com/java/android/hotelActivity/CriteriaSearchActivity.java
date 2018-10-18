package com.java.android.hotelActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.java.android.hotel.ApplicationContext;
import com.java.android.hotel.HotelBean;
import com.java.android.hotel.R;
import com.java.android.service.WebServiceParser;

public class CriteriaSearchActivity extends Activity {
	public static String serverIp;
	
	GPSTracker gps;
	
	public static double currentlat;
	public static double currentlongi;
	double  latitude;
	double longitude;
	
	Spinner swimmingspinner;
	Spinner laundryspinner;
	Spinner parkingspinner;
	private String[] swimmingstr = new String[] { "Optional", "Required" };
	private String[] laundrystr = new String[] { "Optional", "Required" };
	private String[] parking = new String[] { "Optional", "Required" };

	
	Button submit;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.criteriasearch);

		
		  //.......GPS LOCATION...........
        gps = new GPSTracker(CriteriaSearchActivity.this);

        // Check if GPS enabled
        if(gps.canGetLocation()) {

              latitude = gps.getLatitude();
             longitude = gps.getLongitude();

            // \n is for new line
            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
           
            
            
        } else {
            // Can't get location.
            // GPS or network is not enabled.
            // Ask user to enable GPS/network in settings.
            gps.showSettingsAlert();
        }
    
		
		
		swimmingspinner = (Spinner) findViewById(R.id.spinnerpool);
		swimmingspinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View view,
					int arg2, long arg3) {
				((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		ArrayAdapter<String> adapter_pool = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, swimmingstr);
		adapter_pool
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		swimmingspinner.setAdapter(adapter_pool);

	
	//...................................
		parkingspinner = (Spinner) findViewById(R.id.spinnerparking);
		parkingspinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View view,
					int arg2, long arg3) {
				((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		ArrayAdapter<String> adapter_parking= new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, parking);
		adapter_parking
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		parkingspinner.setAdapter(adapter_parking);
//............................
		laundryspinner = (Spinner) findViewById(R.id.spinnerlaundry);
		laundryspinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View view,
					int arg2, long arg3) {
				((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		ArrayAdapter<String> adapter_laundry = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, laundrystr);
		adapter_laundry
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		laundryspinner.setAdapter(adapter_laundry);
		
		
		submit=(Button)findViewById(R.id.submitButton);
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				CriteriaTask task=new CriteriaTask();
				task.execute();
				
				
			}
		});
	
	}
	
	
	private class CriteriaTask extends AsyncTask<String, Void, String> {

		private final ProgressDialog dialog = new ProgressDialog(
				CriteriaSearchActivity.this);

		// can use UI thread here
		protected void onPreExecute() {
			this.dialog.setMessage("Please Wait...");
			this.dialog.show();
		}

		@Override
		protected String doInBackground(String... urls) {

			WebServiceParser webServiceParser = new WebServiceParser(
					CriteriaSearchActivity.this, "http://" + WelcomeActivity.serverIp
							+ ":8080/HotelRecommendationServer/rest/webService/");
			Map<String, String> params = new HashMap<String, String>();
			
			params.put("SwimmingPool", String.valueOf(swimmingspinner.getSelectedItemId()));
			params.put("Parking", String.valueOf(parkingspinner.getSelectedItemId()));
			params.put("Laundry",String.valueOf(laundryspinner.getSelectedItemId()));
			params.put("Latitude",latitude+"" );
			params.put("Longitude",longitude+"" );
			
			
			ArrayList<HotelBean> hotelBeanList = webServiceParser.criteriaSearch(params);
			((ApplicationContext)CriteriaSearchActivity.this.getApplicationContext()).setHotelBeanList(hotelBeanList);
			return hotelBeanList.size()+"";
			
		}

		@Override
		protected void onPostExecute(String kal) {

			
				Intent intent = new Intent(CriteriaSearchActivity.this,CriteriaListViewActivity.class);
				startActivity(intent);

			

	}
	}
}