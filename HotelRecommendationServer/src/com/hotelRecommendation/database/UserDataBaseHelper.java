package com.hotelRecommendation.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelRecommendation.bean.UserBean;

public class UserDataBaseHelper {
	
	
Connection conn;
	
	PreparedStatement statement;
	DataBaseConnection db=new DataBaseConnection();
	
	public int addUser(UserBean userBean)
	{
		
		conn=db.connect();
		
		try {
			statement=conn.prepareStatement("insert into hotel_user_tbl(user_id,user_firstname,user_lastname,user_address,user_emailId,user_contactno,username,password) values(?,?,?,?,?,?,?,?)");
		
		
		
		statement.setInt(1, userBean.getUserId());
		statement.setString(2, userBean.getFirstName());
		statement.setString(3, userBean.getLastName());
		statement.setString(4, userBean.getAddress());
		statement.setString(5, userBean.getEmaild());
		statement.setString(6, userBean.getContactNo());
		statement.setString(7, userBean.getUserName());
		statement.setString(8, userBean.getPassWord());
		
		
		statement.executeUpdate();
		
		
		return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
	public UserBean validateUser(UserBean userbean)
	{
		conn=db.connect();
		
		try {
			statement=conn.prepareStatement("select * from hotel_user_tbl where username=? and password=?;");
		
		statement.setString(1, userbean.getUserName());
		statement.setString(2, userbean.getPassWord());
	
		ResultSet rs=statement.executeQuery();
		
		rs.beforeFirst();
		
		if(rs.next())
		{
			userbean.setUserId(rs.getInt("user_id"));
			userbean.setFirstName(rs.getString("user_firstname"));
			userbean.setLastName(rs.getString("user_lastname"));
			userbean.setAddress(rs.getString("user_address"));
			userbean.setEmaild(rs.getString("user_emailId"));
			userbean.setContactNo(rs.getString("user_contactno"));
			
			
			
			return userbean;
		}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	
}
