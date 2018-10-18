package com.java.android.hotelActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.Dialog;
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
import com.java.android.hotel.UserBean;
import com.java.android.service.WebServiceParser;

public class RoomListViewActivity extends Activity {

	private static final String TAG = "com.example.hotel";
	private ArrayList<HotelRoomBean> hotelRoomBeanList;
	Button bookRoomButton;
	int roomid;
	int hotelId;
	String roomPrize;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.room_listview_main);
		

		ApplicationContext appcontext =(ApplicationContext) getApplicationContext();
		hotelRoomBeanList = appcontext.getHotelRoomBeanList();

		// Getting a reference to listview of main.xml layout file
		ListView listView = ( ListView ) findViewById(R.id.roomlistview);

		RoomListAdapter roomListAdapter = new RoomListAdapter(this, hotelRoomBeanList);
		// Setting the adapter to the listView
		listView.setAdapter(roomListAdapter);      

		

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				final HotelRoomBean hotelRoomBean = hotelRoomBeanList.get(arg2);
				final Dialog dialog = new Dialog(RoomListViewActivity.this);
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//...........
				dialog.setContentView(R.layout.room_layout);
				// set title and cancelable
				ImageView roomImageView = (ImageView)dialog.findViewById(R.id.room_layout_roomImageView);
				TextView rooomType=(TextView)dialog.findViewById(R.id.room_layout_roomTypeTextView);
				TextView noOfRoom=(TextView)dialog.findViewById(R.id.room_layout_noOfRoomTextView);
				TextView prize=(TextView)dialog.findViewById(R.id.room_layout_PrizeTextView);
				Bitmap bitmap = BitmapFactory.decodeByteArray(hotelRoomBean.getRoomImage(), 0, hotelRoomBean.getRoomImage().length);
				roomImageView.setImageBitmap(bitmap);

				rooomType.setText("Type:" + hotelRoomBean.getRoomType());
				noOfRoom.setText("NoOfRoom:"+hotelRoomBean.getNumberOfRoom());
				prize.setText("Prize:"+hotelRoomBean.getPrize());
				
				roomid=hotelRoomBean.getHotelRoomId();
				hotelId=hotelRoomBean.getHotelId();
				roomPrize=hotelRoomBean.getPrize();
				bookRoomButton=(Button)dialog.findViewById(R.id.bookRoomButton);
				bookRoomButton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						/*BookRoomTask bookRoomTask = new BookRoomTask();
						bookRoomTask.execute();*/
						
						Intent intent = new Intent(RoomListViewActivity.this,BookRoomActivity.class);
						intent.putExtra("roomId", roomid+"");
						intent.putExtra("hotelId", hotelId+"");
						intent.putExtra("prize", roomPrize);
						startActivity(intent);
					}
				});

				dialog.setCancelable(true);
				dialog.show();


			}
		});

	}
	
	
	}

