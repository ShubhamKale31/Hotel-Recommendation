package com.java.android.hotel;

import java.io.FileInputStream;

public class HotelImageBean {

	
	private int hotelId;
	private int hotelImageId;
	private FileInputStream hotelImage;
	
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
	public FileInputStream getHotelImage() {
		return hotelImage;
	}
	public void setHotelImage(FileInputStream hotelImage) {
		this.hotelImage = hotelImage;
	}
	
	
	
	
	
}
