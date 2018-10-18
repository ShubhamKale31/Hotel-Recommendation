package com.hotelRecommendation.bean;

import java.io.FileInputStream;
import java.io.InputStream;

public class RoomImageBean {
	
	
	private int hotelRoomId;
	private int roomImageId;
	private InputStream roomImage;
	public int getHotelRoomId() {
		return hotelRoomId;
	}
	public void setHotelRoomId(int hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}
	public int getRoomImageId() {
		return roomImageId;
	}
	public void setRoomImageId(int roomImageId) {
		this.roomImageId = roomImageId;
	}
	public InputStream getRoomImage() {
		return roomImage;
	}
	public void setRoomImage(InputStream roomImage) {
		this.roomImage = roomImage;
	}
	
	
	

}
