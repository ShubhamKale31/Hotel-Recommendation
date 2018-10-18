package com.hotelRecommendation.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.hotelRecommendation.bean.HotelRoomBean;

public class HotelRoomDataBaseHelper {
	
	
Connection conn;
	
	PreparedStatement statement;
	DataBaseConnection db=new DataBaseConnection();
	
	public int addHotelRoom(HotelRoomBean roomBean)
	{
		
		conn=db.connect();
		
		try {
			statement=conn.prepareStatement("insert into hotel_room_info_tbl(hotel_room_id,hotel_id,hotel_room_type,number_of_room,room_prize) values(?,?,?,?,?)");
		
		
		
		
		statement.setInt(1, roomBean.getHotelRoomId());
		statement.setInt(2, roomBean.getHotelId());
		statement.setString(3, roomBean.getRoomType());
		statement.setInt(4, roomBean.getNumberOfRoom());
		statement.setString(5, roomBean.getPrize());
		
		statement.executeUpdate();
		
		
		return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
private ResultSet fetchAllHotelRoom() {
		
		conn= db.connect();
		String query = "select * from hotel_room_info_tbl;";
		ResultSet resultSet = null;
		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultSet;
	}

	
	public ArrayList<HotelRoomBean> fetchAllHotelRoomInfo() {
		ResultSet resultSet = fetchAllHotelRoom();
		ArrayList<HotelRoomBean> hotelroombeanList = new ArrayList<HotelRoomBean>();
		if (resultSet != null) {
			try {
				resultSet.beforeFirst();
				while (resultSet.next()) {
					hotelroombeanList.add(fetchHotelRoomFromResultSet(resultSet));
				}
				resultSet.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return hotelroombeanList;
	}
	
	private HotelRoomBean fetchHotelRoomFromResultSet(ResultSet resultSet) {
    HotelRoomBean roomBean=new HotelRoomBean();
		try {
			
			
			
			roomBean.setHotelRoomId(resultSet.getInt("hotel_room_id"));
			roomBean.setHotelId(resultSet.getInt("hotel_id"));
			roomBean.setRoomType(resultSet.getString("hotel_room_type"));
			roomBean.setNumberOfRoom(resultSet.getInt("number_of_room"));
			roomBean.setPrize(resultSet.getString("room_prize"));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return roomBean;
	}
	
private ResultSet fetchAllHotelRoomById(String hotelId) {
		
		conn= db.connect();
		try {
		statement = conn.prepareStatement("select * from hotel_room_info_tbl where hotel_id=?");
		statement.setString(1, hotelId);
		ResultSet resultSet = null;
		
			resultSet = statement.executeQuery();
			return resultSet;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
	public ArrayList<HotelRoomBean> fetchAllHotelRoomInfoById(String hotelId) {
		ResultSet resultSet = fetchAllHotelRoomById(hotelId);
		ArrayList<HotelRoomBean> hotelroombeanList = new ArrayList<HotelRoomBean>();
		if (resultSet != null) {
			try {
				resultSet.beforeFirst();
				while (resultSet.next()) {
					hotelroombeanList.add(fetchHotelRoomByIdFromResultSet(resultSet));
				}
				resultSet.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return hotelroombeanList;
	}
	
	private HotelRoomBean fetchHotelRoomByIdFromResultSet(ResultSet resultSet) {
    HotelRoomBean roomBean=new HotelRoomBean();
		try {
			
			
			
			roomBean.setHotelRoomId(resultSet.getInt("hotel_room_id"));
			roomBean.setHotelId(resultSet.getInt("hotel_id"));
			roomBean.setRoomType(resultSet.getString("hotel_room_type"));
			roomBean.setNumberOfRoom(resultSet.getInt("number_of_room"));
			roomBean.setPrize(resultSet.getString("room_prize"));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return roomBean;
	}
	public int deleteHotelRoom(String hotelRoomid)
	{
		conn=db.connect();
		
		try {
			String query = "DELETE from hotel_room_info_tbl where hotel_room_id = '" + hotelRoomid + "'";
			Statement statement = conn.createStatement();
			return statement.executeUpdate(query);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	
	
	

}
