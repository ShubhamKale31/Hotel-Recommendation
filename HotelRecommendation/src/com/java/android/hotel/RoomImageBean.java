package com.java.android.hotel;

import java.io.FileInputStream;

public class RoomImageBean {
	
	
	private int hotelRoomId;
	private int roomImageId;
	private FileInputStream roomImage;
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
	public FileInputStream getRoomImage() {
		return roomImage;
	}
	public void setRoomImage(FileInputStream roomImage) {
		this.roomImage = roomImage;
	}
	
	
	

}
