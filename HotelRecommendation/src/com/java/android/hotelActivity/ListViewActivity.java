package com.java.android.hotelActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.java.android.hotel.ApplicationContext;
import com.java.android.hotel.HotelBean;
import com.java.android.hotel.HotelRoomBean;
import com.java.android.hotel.R;
import com.java.android.service.WebServiceParser;

public class ListViewActivity extends Activity {

	private static final String TAG = "com.example.hotel";
	private ArrayList<HotelBean> hotelBeanList;
	Button viewRoomButton;
	int hotelId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_main);

		ApplicationContext appcontext =(ApplicationContext) getApplicationContext();
		hotelBeanList = appcontext.getHotelBeanList();

		// Getting a reference to listview of main.xml layout file
		ListView listView = ( ListView ) findViewById(R.id.listview);

		HotelListAdapter productListAdapter = new HotelListAdapter(this, hotelBeanList);
		// Setting the adapter to the listView
		listView.setAdapter(productListAdapter);                           

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				final HotelBean hotelBean = hotelBeanList.get(arg2);
				final Dialog dialog = new Dialog(ListViewActivity.this);
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//...........
				dialog.setContentView(R.layout.hotel_layout);
				// set title and cancelable
				ImageView hotelImageView = (ImageView)dialog.findViewById(R.id.hotel_layout_hotelImageView);
				TextView hotelName=(TextView)dialog.findViewById(R.id.hotel_layout_hotelNameTextView);
				TextView hotelAddress=(TextView)dialog.findViewById(R.id.hotel_layout_addressTextView);
				TextView hotelcontactPers=(TextView)dialog.findViewById(R.id.hotel_layout_contactPersTextView);
				TextView hotelContactNo=(TextView)dialog.findViewById(R.id.hotel_layout_contactNoTextView);
				TextView hotelEmail=(TextView)dialog.findViewById(R.id.hotel_layout_emailTextView);
				Bitmap bitmap = BitmapFactory.decodeByteArray(hotelBean.getHotelImage(), 0, hotelBean.getHotelImage().length);
				hotelImageView.setImageBitmap(bitmap);
				
				hotelName.setText("Name:" + hotelBean.getHotelname());
				hotelAddress.setText("Address:"+hotelBean.getHoteladdress());
				hotelcontactPers.setText("ContactPerson:"+hotelBean.getHotelcontactperson());
				hotelContactNo.setText("ContactNo:"+hotelBean.getHotelcontact());
				hotelEmail.setText("EmailId:"+hotelBean.getHotelemail());
				
				
				
				hotelId=hotelBean.getHotelid();
				viewRoomButton=(Button)dialog.findViewById(R.id.viewRoomButton);
				viewRoomButton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
					
						RoomTask roomTask = new RoomTask();
						roomTask.execute();
						
					}
				});
				
				
				
				dialog.setCancelable(true);
				dialog.show();
				
			
			}
		});

	}

	private class RoomTask extends AsyncTask<String, Void, String> {

		private final ProgressDialog dialog = new ProgressDialog(
				ListViewActivity.this);

		// can use UI thread here
		protected void onPreExecute() {
			this.dialog.setMessage("Please Wait...");
			this.dialog.show();
		}

		@Override
		protected String doInBackground(String... urls) {

			WebServiceParser webServiceParser = new WebServiceParser(
					ListViewActivity.this, "http://" + WelcomeActivity.serverIp
							+ ":8080/HotelRecommendationServer/rest/webService/");
			Map<String, String> params = new HashMap<String, String>();
			
			params.put("hotelId", hotelId+"");
			
			ArrayList<HotelRoomBean> hotelRoomBeanList = webServiceParser.RoomByHotel(params);
			((ApplicationContext)ListViewActivity.this.getApplicationContext()).setHotelRoomBeanList(hotelRoomBeanList);
			return hotelRoomBeanList.size()+"";
			
		}

		@Override
		protected void onPostExecute(String kal) {

			
				Intent intent = new Intent(ListViewActivity.this,RoomListViewActivity.class);
				startActivity(intent);

			

	}
	}
}// end Activity