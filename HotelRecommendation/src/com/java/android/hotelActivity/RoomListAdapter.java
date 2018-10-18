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
import com.java.android.hotel.HotelRoomBean;
import com.java.android.hotel.R;


public class RoomListAdapter  extends BaseAdapter {
	
	//private final int[] bgColors = new int[] { R.color.list_bg_1, R.color.list_bg_2 };
	private final String TAG = RoomListAdapter.class.getCanonicalName();
	private Context mContext;
	private ArrayList<HotelRoomBean> hotelRoomBeanList;
	//Constructor
	public  RoomListAdapter(Context context,ArrayList<HotelRoomBean> hotelRoomBeanList){
		mContext=context;
		this.hotelRoomBeanList = hotelRoomBeanList;
	}
	
	public void updateLocationBeanList(ArrayList<HotelRoomBean> hotelRoomBeanList)
	{
		this.hotelRoomBeanList = hotelRoomBeanList;
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
		return hotelRoomBeanList.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}


	public View getView(int position, View view, ViewGroup arg2) {
		
		ViewHolder viewHolder;
		if(view == null)
		{
			LayoutInflater layoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = layoutInflater.inflate(R.layout.room_list_layout, null);
			
			viewHolder = new ViewHolder();
			viewHolder.roomTypeTextView=(TextView)view.findViewById(R.id.room_list_layout_roomTypeTextView);
			viewHolder.noOfRoomTextView=(TextView)view.findViewById(R.id.room_list_layout_NoOfRoomTextView);
			viewHolder.prizeTextView=(TextView)view.findViewById(R.id.room_list_layout_prizeTextView);
			viewHolder.roomImageView=(ImageView)view.findViewById(R.id.room_list_layout_roomImageView);
			view.setTag(viewHolder);
        }
        else
        {
        	viewHolder = (ViewHolder)view.getTag();
        }
		
		viewHolder.roomTypeTextView.setText("Type:" +hotelRoomBeanList.get(position).getRoomType());
		viewHolder.noOfRoomTextView.setText("NoOfRoom:"+hotelRoomBeanList.get(position).getNumberOfRoom());
		viewHolder.prizeTextView.setText("Prize:"+hotelRoomBeanList.get(position).getPrize());
		//
		Bitmap bitmap = BitmapFactory.decodeByteArray(hotelRoomBeanList.get(position).getRoomImage(), 0, hotelRoomBeanList.get(position).getRoomImage().length);
		viewHolder.roomImageView.setImageBitmap(bitmap);
		return view;
	}

	private static class ViewHolder{

		ImageView roomImageView;
		TextView roomTypeTextView,  noOfRoomTextView, prizeTextView;
	}
}
