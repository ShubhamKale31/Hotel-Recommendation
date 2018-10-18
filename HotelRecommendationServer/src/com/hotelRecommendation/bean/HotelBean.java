package com.hotelRecommendation.bean;

import java.io.FileInputStream;

public class HotelBean {

	
	private int hotelid;
	private String hotelname;
	private String hoteladdress;
	private String hotelcontactperson;
	private String hotelcontact;
	private String hotelemail;
	private Double hotelLat;
	private Double hotelLong;
	private String swimmingPool;
	private String parking;
	private String loundry;
	
	
	
	
	
	public String getSwimmingPool() {
		return swimmingPool;
	}
	public void setSwimmingPool(String swimmingPool) {
		this.swimmingPool = swimmingPool;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getLoundry() {
		return loundry;
	}
	public void setLoundry(String loundry) {
		this.loundry = loundry;
	}
	private FileInputStream hotelImage;
	
	

	public FileInputStream getHotelImage() {
		return hotelImage;
	}
	public void setHotelImage(FileInputStream hotelImage) {
		this.hotelImage = hotelImage;
	}
	public int getHotelid() {
		return hotelid;
	}
	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getHoteladdress() {
		return hoteladdress;
	}
	public void setHoteladdress(String hoteladdress) {
		this.hoteladdress = hoteladdress;
	}
	public String getHotelcontactperson() {
		return hotelcontactperson;
	}
	public void setHotelcontactperson(String hotelcontactperson) {
		this.hotelcontactperson = hotelcontactperson;
	}
	public String getHotelcontact() {
		return hotelcontact;
	}
	public void setHotelcontact(String hotelcontact) {
		this.hotelcontact = hotelcontact;
	}
	public Double getHotelLat() {
		return hotelLat;
	}
	
	public String getHotelemail() {
		return hotelemail;
	}
	public void setHotelemail(String hotelemail) {
		this.hotelemail = hotelemail;
	}
	public void setHotelLat(Double hotelLat) {
		this.hotelLat = hotelLat;
	}
	public Double getHotelLong() {
		return hotelLong;
	}
	public void setHotelLong(Double hotelLong) {
		this.hotelLong = hotelLong;
	}
	
	
	
	
	
	
	
}
