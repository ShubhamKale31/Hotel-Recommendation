package com.java.android.hotel;

import java.util.ArrayList;

import android.app.Application;

public class ApplicationContext extends Application {

	// private ConfigBean ipConfigBean;
	private UserBean userBean;
	private HotelBean hotelBean;
	private ArrayList<HotelBean> hotelBeanList;
	private ArrayList<HotelRoomBean> hotelRoomBeanList;
	
	
	
	public ArrayList<HotelBean> getHotelBeanList() {
		return hotelBeanList;
	}

	public void setHotelBeanList(ArrayList<HotelBean> hotelBeanList) {
		this.hotelBeanList = hotelBeanList;
	}

	public HotelBean getHotelBean() {
		return hotelBean;
	}

	public void setHotelBean(HotelBean hotelBean) {
		this.hotelBean = hotelBean;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public ArrayList<HotelRoomBean> getHotelRoomBeanList() {
		return hotelRoomBeanList;
	}

	public void setHotelRoomBeanList(ArrayList<HotelRoomBean> hotelRoomBeanList) {
		this.hotelRoomBeanList = hotelRoomBeanList;
	}
	

}
