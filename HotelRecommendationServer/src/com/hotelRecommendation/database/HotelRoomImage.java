package com.hotelRecommendation.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelRecommendation.bean.HotelImageBean;
import com.hotelRecommendation.bean.RoomImageBean;

public class HotelRoomImage {
	
	
	
	
	
	
Connection conn;
	
	PreparedStatement statement;
	
	DataBaseConnection db=new DataBaseConnection();
	
	
	
	public int GetMaxid()
	{
		conn=db.connect();
		try
		{
			statement=conn.prepareStatement("select max(hotel_room_id) from hotel_room_info_tbl;");
			ResultSet resultset=null;
			resultset=statement.executeQuery();
			if(resultset.next())
			{
				 int hotel_room_id=resultset.getInt("max(hotel_room_id)");
				System.out.println("assignment="+hotel_room_id);
				return hotel_room_id;
			}
			
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return 0;
	}
	
	
	
	
	public int AddHotelRoomImage(RoomImageBean roomImage)
	{
		conn=db.connect();
		
		try {
			statement=conn.prepareStatement("insert into hotel_room_image_tbl(hotel_room_id,hotel_room_image_id,hotel_room_image) values(?,?,?)");
			
			statement.setInt(1, roomImage.getHotelRoomId());
			statement.setInt(2, roomImage.getRoomImageId());
			statement.setBinaryStream(3, roomImage.getRoomImage());
			
			statement.executeUpdate();
			
			return 1;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	public RoomImageBean GetRoomImage(int id)
	{
		conn=db.connect();
		
		try {
			statement=conn.prepareStatement("select * from hotel_room_image_tbl where hotel_room_id=?");
		
					statement.setInt(1, id);
					
					ResultSet rs=statement.executeQuery();
					
					RoomImageBean bean = new RoomImageBean();
					
					if(rs.next())
					{
						bean.setRoomImage(rs.getBinaryStream("hotel_room_image"));
						
						return bean;
					}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
