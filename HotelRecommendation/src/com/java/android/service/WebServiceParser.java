package com.java.android.service;

import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.java.android.hotel.Base64;
import com.java.android.hotel.HotelBean;
import com.java.android.hotel.HotelRoomBean;
import com.java.android.hotel.UserBean;

public class WebServiceParser {
	@SuppressWarnings("unused")
	private Context context;
	private WebServiceCommunictor wSCommunictor;
	public WebServiceParser(Context context , String webServiceURL) {
		this.context=context;
		wSCommunictor = new WebServiceCommunictor(context ,webServiceURL);
	}

	public static String TAG="com.hotelRecommendation";


	public int registerUser( Map<String, String> params){
		String response=wSCommunictor.invokeMethod("registerUser", params);
		int result = -1;
		try{
			if(response!=null)
			{

				JSONObject jsonObject=new JSONObject(response);
				result = jsonObject.getInt("result");
			}
		}
		catch(Exception e){
		}
		return result;
	}

	public UserBean validateUser( Map<String, String> params){
		String response=wSCommunictor.invokeMethod("validateUser", params);
		UserBean userBean = new UserBean();;
		try{
			if(!TextUtils.isEmpty(response))
			{
				JSONObject jsonObject=new JSONObject(response);
				userBean.setUserId(jsonObject.getInt("UserId"));
				//userBean.setUser_role(jsonObject.getString("Role"));
				userBean.setFirstName(jsonObject.getString("FirstName"));
				userBean.setLastName(jsonObject.getString("LastName"));
				userBean.setAddress(jsonObject.getString("Address"));
				userBean.setEmaild(jsonObject.getString("EmailID"));
				userBean.setContactNo(jsonObject.getString("ContactNo"));
				userBean.setUserName(jsonObject.getString("UserName"));
				userBean.setPassWord(jsonObject.getString("PassWord"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return userBean;
	}



	public ArrayList<HotelBean> getAllHotel( Map<String, String> params){
		String response=wSCommunictor.invokeMethod("getAllHotel", params);
		Log.d(TAG, "get All Hotel");
		Log.d(TAG,"RESPONSE"+response);

		ArrayList<HotelBean> hotelBeanList = new ArrayList<HotelBean>();
		try{
			if(!TextUtils.isEmpty(response))
			{
				JSONArray jsonArray = new JSONArray(response);
				for(int i=0;i<jsonArray.length();i++)
				{

					JSONObject jsonObject = new JSONObject(jsonArray.getString(i));	
					HotelBean hotelBean = new HotelBean();
					hotelBean.setHotelid(jsonObject.getInt("hotelId"));
					hotelBean.setHotelname(jsonObject.getString("hotelName"));
					hotelBean.setHoteladdress(jsonObject.getString("Address"));
					hotelBean.setHotelcontactperson(jsonObject.getString("contactPerson"));
					hotelBean.setHotelcontact(jsonObject.getString("Contact"));
					hotelBean.setHotelemail(jsonObject.getString("Email"));
					hotelBean.setHotelLat(jsonObject.getDouble("Lat"));
					hotelBean.setHotelLong(jsonObject.getDouble("Long"));
					hotelBean.setSwimmingPool(jsonObject.getString("swimmingPool"));
					hotelBean.setParking(jsonObject.getString("Parking"));
					String imageString = jsonObject.getString("hotelImag");
					byte [] imageByte = Base64.decode(imageString);

					hotelBean.setHotelImage(imageByte);

					hotelBeanList.add(hotelBean);

				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return hotelBeanList;
	}
	public ArrayList<HotelBean> criteriaSearch( Map<String, String> params){
		String response=wSCommunictor.invokeMethod("criteriaSearch", params);
		Log.d(TAG, "in hotel by criteria");
		Log.d(TAG,"RESPONSE"+response);

		ArrayList<HotelBean> hotelBeanList = new ArrayList<HotelBean>();
		try{
			if(!TextUtils.isEmpty(response))
			{
				JSONArray jsonArray = new JSONArray(response);
				for(int i=0;i<jsonArray.length();i++)
				{

					JSONObject jsonObject = new JSONObject(jsonArray.getString(i));	
					HotelBean hotelBean = new HotelBean();
					hotelBean.setHotelid(jsonObject.getInt("hotelId"));
					hotelBean.setHotelname(jsonObject.getString("hotelName"));
					hotelBean.setHoteladdress(jsonObject.getString("Address"));
					hotelBean.setHotelcontactperson(jsonObject.getString("contactPerson"));
					hotelBean.setHotelcontact(jsonObject.getString("Contact"));
					hotelBean.setHotelemail(jsonObject.getString("Email"));
					hotelBean.setHotelLat(jsonObject.getDouble("Lat"));
					hotelBean.setHotelLong(jsonObject.getDouble("Long"));
					hotelBean.setSwimmingPool(jsonObject.getString("swimmingPool"));
					hotelBean.setParking(jsonObject.getString("Parking"));
					String imageString = jsonObject.getString("hotelImag");
					byte [] imageByte = Base64.decode(imageString);

					hotelBean.setHotelImage(imageByte);

					hotelBeanList.add(hotelBean);

				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return hotelBeanList;
	}
	public ArrayList<HotelBean> RecommendedHotel( Map<String, String> params){
		String response=wSCommunictor.invokeMethod("RecommendedHotel", params);
		Log.d(TAG, "in hotel by criteria");
		Log.d(TAG,"RESPONSE"+response);

		ArrayList<HotelBean> hotelBeanList = new ArrayList<HotelBean>();
		try{
			if(!TextUtils.isEmpty(response))
			{
				JSONArray jsonArray = new JSONArray(response);
				for(int i=0;i<jsonArray.length();i++)
				{

					JSONObject jsonObject = new JSONObject(jsonArray.getString(i));	
					HotelBean hotelBean = new HotelBean();
					hotelBean.setHotelid(jsonObject.getInt("hotelId"));
					hotelBean.setHotelname(jsonObject.getString("hotelName"));
					hotelBean.setHoteladdress(jsonObject.getString("Address"));
					hotelBean.setHotelcontactperson(jsonObject.getString("contactPerson"));
					hotelBean.setHotelcontact(jsonObject.getString("Contact"));
					hotelBean.setHotelemail(jsonObject.getString("Email"));
					hotelBean.setHotelLat(jsonObject.getDouble("Lat"));
					hotelBean.setHotelLong(jsonObject.getDouble("Long"));
					hotelBean.setSwimmingPool(jsonObject.getString("swimmingPool"));
					hotelBean.setParking(jsonObject.getString("Parking"));
					String imageString = jsonObject.getString("hotelImag");
					byte [] imageByte = Base64.decode(imageString, i);

					hotelBean.setHotelImage(imageByte);

					hotelBeanList.add(hotelBean);

				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return hotelBeanList;
	}
	public ArrayList<HotelBean> RecommendedByOtherUserHotel( Map<String, String> params){
		String response=wSCommunictor.invokeMethod("RecommendedByOtherUserHotel", params);
		Log.d(TAG, "in hotel by criteria");
		Log.d(TAG,"RESPONSE"+response);

		ArrayList<HotelBean> hotelBeanList = new ArrayList<HotelBean>();
		try{
			if(!TextUtils.isEmpty(response))
			{
				JSONArray jsonArray = new JSONArray(response);
				for(int i=0;i<jsonArray.length();i++)
				{

					JSONObject jsonObject = new JSONObject(jsonArray.getString(i));	
					HotelBean hotelBean = new HotelBean();
					hotelBean.setHotelid(jsonObject.getInt("hotelId"));
					hotelBean.setHotelname(jsonObject.getString("hotelName"));
					hotelBean.setHoteladdress(jsonObject.getString("Address"));
					hotelBean.setHotelcontactperson(jsonObject.getString("contactPerson"));
					hotelBean.setHotelcontact(jsonObject.getString("Contact"));
					hotelBean.setHotelemail(jsonObject.getString("Email"));
					hotelBean.setHotelLat(jsonObject.getDouble("Lat"));
					hotelBean.setHotelLong(jsonObject.getDouble("Long"));
					hotelBean.setSwimmingPool(jsonObject.getString("swimmingPool"));
					hotelBean.setParking(jsonObject.getString("Parking"));
					String imageString = jsonObject.getString("hotelImag");
					byte [] imageByte = Base64.decode(imageString, i);

					hotelBean.setHotelImage(imageByte);
					hotelBeanList.add(hotelBean);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return hotelBeanList;
	}
	public ArrayList<HotelRoomBean> RoomByHotel( Map<String, String> params){
		String response=wSCommunictor.invokeMethod("RoomByHotel", params);
		Log.d(TAG, "in hotel by criteria");
		Log.d(TAG,"RESPONSE"+response);

		ArrayList<HotelRoomBean> hotelRoomBeanList = new ArrayList<HotelRoomBean>();
		try{
			if(!TextUtils.isEmpty(response))
			{
				JSONArray jsonArray = new JSONArray(response);
				for(int i=0;i<jsonArray.length();i++)
				{

					JSONObject jsonObject = new JSONObject(jsonArray.getString(i));	
					HotelRoomBean roomBean = new HotelRoomBean();
					roomBean.setHotelRoomId(jsonObject.getInt("roomId"));
					roomBean.setHotelId(jsonObject.getInt("hotelId"));
					roomBean.setNumberOfRoom(jsonObject.getInt("numberOfRoom"));
					roomBean.setRoomType(jsonObject.getString("roomType"));
					roomBean.setPrize(jsonObject.getString("prize"));
					String imageString = jsonObject.getString("roomImage");
					byte [] imageByte = Base64.decode(imageString, i);

					roomBean.setRoomImage(imageByte);

					hotelRoomBeanList.add(roomBean);

				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return hotelRoomBeanList;
	}
	
	public int BookRoom( Map<String, String> params){
		String response=wSCommunictor.invokeMethod("BookRoom", params);
		int result = -1;
		try{
			if(response!=null)
			{

				JSONObject jsonObject=new JSONObject(response);
				result = jsonObject.getInt("result");
			}
		}
		catch(Exception e){
		}
		return result;
	}
}
