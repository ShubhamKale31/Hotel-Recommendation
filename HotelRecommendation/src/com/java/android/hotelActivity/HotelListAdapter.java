package com.java.android.hotelActivity;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.java.android.hotel.HotelBean;
import com.java.android.hotel.R;


public class HotelListAdapter  extends BaseAdapter {
	
	//private final int[] bgColors = new int[] { R.color.list_bg_1, R.color.list_bg_2 };
	private final String TAG = HotelListAdapter.class.getCanonicalName();
	private Context mContext;
	private ArrayList<HotelBean> hotelBeanList;
	//Constructor
	public  HotelListAdapter(Context context,ArrayList<HotelBean> hotelBeanList){
		mContext=context;
		this.hotelBeanList = hotelBeanList;
	}
	
	public void updateLocationBeanList(ArrayList<HotelBean> productBeanList)
	{
		this.hotelBeanList = hotelBeanList;
	}
	
	@Override
	public void notifyDataSetChanged() {
		// TODO Auto-generated method stub
		super.notifyDataSetChanged();
		
	}


	@Override
	public void notifyDataSetInvalidated() {
		// TODO Auto-generated method stub
		super.notifyDataSetInvalidated();
	}


	public int getCount() {
		// TODO Auto-generated method stub
		return hotelBeanList.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	//TODO Mayank use view holderfrom dishADapter

	public View getView(int position, View view, ViewGroup arg2) {
		
		ViewHolder viewHolder;
		if(view == null)
		{
			LayoutInflater layoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = layoutInflater.inflate(R.layout.hotel_list_layout, null);
			
			viewHolder = new ViewHolder();
			viewHolder.hotelNameTextView=(TextView)view.findViewById(R.id.hotel_list_layout_hotelNameTextView);
			viewHolder.addressTextView=(TextView)view.findViewById(R.id.hotel_list_layout_addressTextView);
			viewHolder.contactPersonTextView=(TextView)view.findViewById(R.id.hotel_list_layout_contactPersonTextView);
			viewHolder.contactNoTextView=(TextView)view.findViewById(R.id.hotel_list_layout_contactNoTextView);
			viewHolder.emailIdTextView=(TextView)view.findViewById(R.id.hotel_list_layout_emailTextView);
			viewHolder.hotelImageView=(ImageView)view.findViewById(R.id.hotel_list_layout_hotelImageView);
			view.setTag(viewHolder);
        }
        else
        {
        	viewHolder = (ViewHolder)view.getTag();
        }
		
		viewHolder.hotelNameTextView.setText("Name:" + hotelBeanList.get(position).getHotelname());
		viewHolder.addressTextView.setText("Address:"+hotelBeanList.get(position).getHoteladdress());
		viewHolder.contactPersonTextView.setText("ContactPerson:"+hotelBeanList.get(position).getHotelcontactperson());
		viewHolder.contactNoTextView.setText("ContactNo:"+hotelBeanList.get(position).getHotelcontact());
		viewHolder.emailIdTextView.setText("EmailId:"+hotelBeanList.get(position).getHotelemail());
		//
		Bitmap bitmap = BitmapFactory.decodeByteArray(hotelBeanList.get(position).getHotelImage(), 0, hotelBeanList.get(position).getHotelImage().length);
		viewHolder.hotelImageView.setImageBitmap(bitmap);
		return view;
	}

	private static class ViewHolder{

		ImageView hotelImageView;
		TextView hotelNameTextView, addressTextView, contactPersonTextView, contactNoTextView, emailIdTextView;
	}
}
