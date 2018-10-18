package com.hotelRecommendation.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelRecommendation.bean.BookingBean;

public class BookingDataBaseHelper {

	Connection conn;

	PreparedStatement statement;
	DataBaseConnection db=new DataBaseConnection();

	public int bookRoom(BookingBean bookingBean)
	{

		conn=db.connect();

		try {
			statement=conn.prepareStatement("insert into hotel_booking_table(booking_id,user_id,room_id,hotel_id,check_in_date,check_out_date,total_cost,status) values(?,?,?,?,?,?,?,?)");



			statement.setInt(1, bookingBean.getBookingId());
			statement.setInt(2, bookingBean.getUserId());
			statement.setInt(3, bookingBean.getRoomId());
			statement.setInt(4, bookingBean.getHotelId());
			statement.setString(5, bookingBean.getCheckInDate());
			statement.setString(6, bookingBean.getCheckOutDate());
			statement.setString(7, bookingBean.getTotalAmount());
			statement.setString(8, "Start");


			statement.executeUpdate();


			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	public boolean checkPreviousUserHotelBooking(int userId, int hotelid) {

		conn=db.connect();

		try {
			statement=conn.prepareStatement("select * from hotel_booking_table where user_id=? and hotel_id=? ");

			statement.setInt(1, userId);
			statement.setInt(2, hotelid);

			ResultSet rs=statement.executeQuery();

			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return false;
	}

	public boolean checkPreviousOtherUserHotelBooking(int hotelid) {
		conn=db.connect();

		try {
			statement=conn.prepareStatement("select * from hotel_booking_table where hotel_id=? ");
			statement.setInt(1, hotelid);

			ResultSet rs=statement.executeQuery();

			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return false;

	}


}
