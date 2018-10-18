package com.java.android.hotelActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.java.android.hotel.ApplicationContext;
import com.java.android.hotel.HotelBean;
import com.java.android.hotel.R;
import com.java.android.hotel.UserBean;
import com.java.android.service.WebServiceParser;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class BookRoomActivity extends Activity implements OnClickListener {
	private ImageButton startDate;
	private ImageButton endDate;
	private Calendar cal;
	private int day;
	private int month;
	private int year;
	private EditText startDateEditText;
	private EditText endDateEditText;
	private TextView prizeTextView;
	private String roomId;
	private String hotelId;
	private Button book;
	
	//DatePickerDialog.OnDateSetListener from_dateListener,to_dateListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_room);
		// mDateButton = (Button) findViewById(R.id.date_button);
		Intent i = new Intent();
		String prize=getIntent().getStringExtra("prize").toString();
		 roomId =getIntent().getStringExtra("roomId").toString();
		 hotelId=getIntent().getStringExtra("hotelId").toString();
		prizeTextView=(TextView)findViewById(R.id.prize);
		prizeTextView.setText(prize);
		
		book=(Button)findViewById(R.id.bookButton);
		book.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				BookRoomTask bookRoomTask = new BookRoomTask();
				bookRoomTask.execute();
				
			}
		});
		
		startDate = (ImageButton) findViewById(R.id.startDateImageButton);
		endDate = (ImageButton) findViewById(R.id.endDateimageButton);
		cal = Calendar.getInstance();
		day = cal.get(Calendar.DAY_OF_MONTH);
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
		startDateEditText = (EditText) findViewById(R.id.startDateeditText);
		endDateEditText = (EditText) findViewById(R.id.endDateEditText);
		startDate.setOnClickListener(this);
		endDate.setOnClickListener(this);
		startDate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				showDialog(0);
				
			}
		});
	}

	@Override
	public void onClick(View v) {
		showDialog(1);
	}

	@Override
	@Deprecated
	
	protected Dialog onCreateDialog(int id) {
		final int DATE_PICKER_FROM=0; 
		final int DATE_PICKER_TO=1;
		
		switch(id)
		{
        case DATE_PICKER_FROM:
                return new DatePickerDialog(this, from_dateListener, year, month, day); 
            case DATE_PICKER_TO:
                return new DatePickerDialog(this, to_dateListener, year, month, day);
    }
		return null;
	}


	
	private DatePickerDialog.OnDateSetListener from_dateListener = new DatePickerDialog.OnDateSetListener()  {
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			startDateEditText.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
					+ selectedYear);
						
		}
	};
	
	
	private DatePickerDialog.OnDateSetListener to_dateListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			endDateEditText.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
					+ selectedYear);
			
		}
	};
	private class BookRoomTask extends AsyncTask<String, Void, String> {
		@Override
		protected  String doInBackground(String... urls) {
			@SuppressWarnings("unused")

			WebServiceParser webServiceParser = new WebServiceParser(
					BookRoomActivity.this, "http://" + WelcomeActivity.serverIp
					+ ":8080/HotelRecommendationServer/rest/webService/");
			UserBean userBean=((ApplicationContext)BookRoomActivity.this.getApplicationContext()).getUserBean();
			int userId=userBean.getUserId();

			Map<String, String> params = new HashMap<String, String>();
			params.put("userId",userId+"");
			params.put("roomId",roomId);
			params.put("hotelId", hotelId);
			params.put("checkInDate", startDateEditText.getText().toString());
			params.put("checkOutDate", endDateEditText.getText().toString());
			params.put("prize", prizeTextView.getText().toString());
			
			int result= webServiceParser.BookRoom(params);
			/*((ApplicationContext)BookRoomActivity.this.getApplicationContext()).setHotelBeanList(hotelBeanList);*/
			return result+"";
		}

		@Override
		protected void onPostExecute(String result) {
			
			int res=Integer.parseInt(result);
			if(res>0)
			{
				Intent i=new Intent(BookRoomActivity.this,SuccessActivity.class);
				startActivity(i);

			}
			else
			{
				Toast.makeText(getApplicationContext(), "Booking failed", Toast.LENGTH_LONG).show();
			}

			
		}
	}
	
}


