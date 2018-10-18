package com.java.android.hotel;

public class HotelRoomBean {
	
	
	private int hotelRoomId;
	private int hotelId;
	private String roomType;
	private int numberOfRoom;
	private String prize;
	private byte[] roomImage;
	
	
	
	
	
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	public int getHotelRoomId() {
		return hotelRoomId;
	}
	public void setHotelRoomId(int hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getNumberOfRoom() {
		return numberOfRoom;
	}
	public void setNumberOfRoom(int numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
	}
	public byte[] getRoomImage() {
		return roomImage;
	}
	public void setRoomImage(byte[] roomImage) {
		this.roomImage = roomImage;
	}
	
	
	
	

}
