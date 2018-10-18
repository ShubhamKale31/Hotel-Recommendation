package com.hotelRecommendation.bean;

import java.io.FileInputStream;
import java.io.InputStream;

public class HotelImageBean {

	
	private int hotelId;
	private int hotelImageId;
	private InputStream hotelImage;
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getHotelImageId() {
		return hotelImageId;
	}
	public void setHotelImageId(int hotelImageId) {
		this.hotelImageId = hotelImageId;
	}
	public InputStream getHotelImage() {
		return hotelImage;
	}
	public void setHotelImage(InputStream hotelImage) {
		this.hotelImage = hotelImage;
	}
	
	
	
	
	
	
}
