package com.hotelRecommendation.database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelRecommendation.bean.HotelImageBean;


public class HotelImageHelper {
	
	
	Connection conn;
	
	PreparedStatement statement;
	
	DataBaseConnection db=new DataBaseConnection();
	
	
	
	public int GetMaxid()
	{
		conn=db.connect();
		try
		{
			statement=conn.prepareStatement("select max(hotel_id) from hotel_info_tbl;");
			ResultSet resultset=null;
			resultset=statement.executeQuery();
			if(resultset.next())
			{
				 int hotel_id=resultset.getInt("max(hotel_id)");
				System.out.println("assignment="+hotel_id);
				return hotel_id;
			}
			
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return 0;
	}
	
	
	
	
	public int AddHotelImage(HotelImageBean imageBean)
	{
		conn=db.connect();
		
		try {
			statement=conn.prepareStatement("insert into hotel_image_tbl(hotel_id,hotel_image_id,hotel_image) values(?,?,?)");
			
			statement.setInt(1, imageBean.getHotelId());
			statement.setInt(2, imageBean.getHotelImageId());
			statement.setBinaryStream(3, imageBean.getHotelImage());
			
			statement.executeUpdate();
			
			return 1;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	public HotelImageBean GetHotelImage(int id)
	{
		conn=db.connect();
		
		try {
			statement=conn.prepareStatement("select * from hotel_image_tbl where hotel_id=?");
		
					statement.setInt(1, id);
					
					ResultSet rs=statement.executeQuery();
					
					HotelImageBean bean = new HotelImageBean();
					
					if(rs.next())
					{
						bean.setHotelImage(rs.getBinaryStream("hotel_image"));
						
						return bean;
					}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
