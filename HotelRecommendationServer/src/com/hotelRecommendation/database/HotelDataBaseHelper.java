package com.hotelRecommendation.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hotelRecommendation.Utility.Utility;
import com.hotelRecommendation.bean.HotelBean;

public class HotelDataBaseHelper {


	Connection conn;

	PreparedStatement statement;
	DataBaseConnection db=new DataBaseConnection();

	public int addHotel(HotelBean hotelBean)
	{

		conn=db.connect();

		try {
			statement=conn.prepareStatement("insert into hotel_info_tbl(hotel_id,hotel_name,hotel_address,hotel_contact_person,hotel_contact_no,hotel_email,swimming_pool,parking,loundry,hotel_lat,hotel_long) values(?,?,?,?,?,?,?,?,?,?,?)");



			statement.setInt(1, hotelBean.getHotelid());
			statement.setString(2, hotelBean.getHotelname());
			statement.setString(3, hotelBean.getHoteladdress());
			statement.setString(4, hotelBean.getHotelcontactperson());
			statement.setString(5, hotelBean.getHotelcontact());
			statement.setString(6, hotelBean.getHotelemail());
			statement.setString(7, hotelBean.getSwimmingPool());
			statement.setString(8, hotelBean.getParking());
			statement.setString(9, hotelBean.getLoundry());
			statement.setDouble(10, hotelBean.getHotelLat());
			statement.setDouble(11, hotelBean.getHotelLong());


			statement.executeUpdate();


			return 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;

	}


	//fetch all hotel........	
	private ResultSet fetchAllHotel() {

		conn= db.connect();
		String query = "select * from hotel_info_tbl;";
		ResultSet resultSet = null;
		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultSet;
	}


	public ArrayList<HotelBean> fetchAllHotelInfo() {
		ResultSet resultSet = fetchAllHotel();
		ArrayList<HotelBean> hotelbeanList = new ArrayList<HotelBean>();
		if (resultSet != null) {
			try {
				resultSet.beforeFirst();
				while (resultSet.next()) {
					hotelbeanList.add(fetchHotelFromResultSet(resultSet));
				}
				resultSet.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return hotelbeanList;
	}

	private HotelBean fetchHotelFromResultSet(ResultSet resultSet) {
		HotelBean hotelBean=new HotelBean();
		try {


			hotelBean.setHotelid(resultSet.getInt("hotel_id"));
			hotelBean.setHotelname(resultSet.getString("hotel_name"));
			hotelBean.setHoteladdress(resultSet.getString("hotel_address"));
			hotelBean.setHotelcontactperson(resultSet.getString("hotel_contact_person"));
			hotelBean.setHotelcontact(resultSet.getString("hotel_contact_no"));
			hotelBean.setHotelemail(resultSet.getString("hotel_email"));
			hotelBean.setHotelLat(resultSet.getDouble("hotel_lat"));
			hotelBean.setHotelLong(resultSet.getDouble("hotel_long"));
			hotelBean.setSwimmingPool(resultSet.getString("swimming_pool"));
			hotelBean.setParking(resultSet.getString("parking"));
			hotelBean.setLoundry(resultSet.getString("loundry"));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return hotelBean;
	}
	/////////////////////////////////////////////////////////////

	//fetch hotel by criteria......


	private ResultSet fetchAllHotelByCriteria(String swimming_pool,String loundry,String parking,double lat,double longi) {

		conn= db.connect();


		String query = "select * from hotel_info_tbl ";
		boolean whereClaueAdded = false; 

		if(swimming_pool.equals("1"))
		{
			if(whereClaueAdded == false)
			{
				query += " where swimming_pool=1 ";
				whereClaueAdded = true;
			}
			else
			{
				query += " and swimming_pool=1 ";
			}

		}

		if(loundry.equals("1"))
		{
			if(whereClaueAdded == false)
			{
				query += " where loundry=1 ";
				whereClaueAdded = true;
			}
			else
			{
				query += " and loundry=1 ";
			}

		}

		if(parking.equals("1"))
		{
			if(whereClaueAdded == false)
			{
				query += " where parking=1 ";
				whereClaueAdded = true;
			}
			else
			{
				query += " and parking=1 ";
			}

		}
		ResultSet resultSet = null;
		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery(query);
			return resultSet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;



	}

	public ArrayList<HotelBean> fetchAllHotelInfoByCriteria(String swimming_pool,String loundry,String parking,double lat2,double lon2,String unit) {
		ResultSet resultSet = fetchAllHotelByCriteria(swimming_pool,loundry,parking,lat2,lon2);
		System.out.println(swimming_pool);
		System.out.println(loundry);
		System.out.println(parking);
		System.out.println(lat2);
		System.out.println(lon2);

		ArrayList<HotelBean> hotelbeanList = new ArrayList<HotelBean>();
		if (resultSet != null) {
			try {
				resultSet.beforeFirst();
				while (resultSet.next()) {
					hotelbeanList.add(fetchHotelByCriteriaFromResultSet(resultSet));
				}
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		ArrayList<HotelBean> finalhotelbeanList=new ArrayList<HotelBean>();
		for(HotelBean bean:hotelbeanList)
		{

			double value=Utility.distance(bean.getHotelLat(),bean.getHotelLong(),lat2,lon2,"k");
			if(value<10)
			{
				finalhotelbeanList.add(bean);
			}
		}
		return finalhotelbeanList;

	}


	public ArrayList<HotelBean> fetchAllHotelInfoByCriteriaAndRecom(String swimming_pool,String loundry,String parking,double lat2,double lon2,String unit,int userId) {
		ResultSet resultSet = fetchAllHotelByCriteria(swimming_pool,loundry,parking,lat2,lon2);
		System.out.println(swimming_pool);
		System.out.println(loundry);
		System.out.println(parking);
		System.out.println(lat2);
		System.out.println(lon2);

		ArrayList<HotelBean> hotelbeanList = new ArrayList<HotelBean>();
		if (resultSet != null) {
			try {
				resultSet.beforeFirst();
				while (resultSet.next()) {
					hotelbeanList.add(fetchHotelByCriteriaFromResultSet(resultSet));
				}
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		ArrayList<HotelBean> finalhotelbeanList=new ArrayList<HotelBean>();
		for(HotelBean bean:hotelbeanList)
		{

			double value=Utility.distance(bean.getHotelLat(),bean.getHotelLong(),lat2,lon2,"k");
			if(value<10)
			{
				finalhotelbeanList.add(bean);
			}
		}
		
		
		
		ArrayList<HotelBean> final2hotelbeanList=new ArrayList<HotelBean>();
		for(HotelBean bean: finalhotelbeanList)
		{
          
			BookingDataBaseHelper dataBaseHelper = new BookingDataBaseHelper();
			boolean flag=dataBaseHelper.checkPreviousUserHotelBooking(userId, bean.getHotelid());
			
			if(flag==true)
			{
				final2hotelbeanList.add(bean);
			}
		}
		
		return final2hotelbeanList;

	}

	public ArrayList<HotelBean> fetchAllHotelInfoByCriteriaAndRecomByOtherUser(String swimming_pool,String loundry,String parking,double lat2,double lon2,String unit) {
		ResultSet resultSet = fetchAllHotelByCriteria(swimming_pool,loundry,parking,lat2,lon2);
		System.out.println(swimming_pool);
		System.out.println(loundry);
		System.out.println(parking);
		System.out.println(lat2);
		System.out.println(lon2);

		ArrayList<HotelBean> hotelbeanList = new ArrayList<HotelBean>();
		if (resultSet != null) {
			try {
				resultSet.beforeFirst();
				while (resultSet.next()) {
					hotelbeanList.add(fetchHotelByCriteriaFromResultSet(resultSet));
				}
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		ArrayList<HotelBean> finalhotelbeanList=new ArrayList<HotelBean>();
		for(HotelBean bean:hotelbeanList)
		{

			double value=Utility.distance(bean.getHotelLat(),bean.getHotelLong(),lat2,lon2,"k");
			if(value<10)
			{
				finalhotelbeanList.add(bean);
			}
		}
		
		
		
		ArrayList<HotelBean> final2hotelbeanList=new ArrayList<HotelBean>();
		for(HotelBean bean: finalhotelbeanList)
		{
          
			BookingDataBaseHelper dataBaseHelper = new BookingDataBaseHelper();
			boolean flag=dataBaseHelper.checkPreviousOtherUserHotelBooking(bean.getHotelid());
			
			if(flag==true)
			{
				final2hotelbeanList.add(bean);
			}
		}
		
		return final2hotelbeanList;

	}


	private HotelBean fetchHotelByCriteriaFromResultSet(ResultSet resultSet) {
		HotelBean hotelBean=new HotelBean();
		try {


			hotelBean.setHotelid(resultSet.getInt("hotel_id"));
			hotelBean.setHotelname(resultSet.getString("hotel_name"));
			hotelBean.setHoteladdress(resultSet.getString("hotel_address"));
			hotelBean.setHotelcontactperson(resultSet.getString("hotel_contact_person"));
			hotelBean.setHotelcontact(resultSet.getString("hotel_contact_no"));
			hotelBean.setHotelemail(resultSet.getString("hotel_email"));
			hotelBean.setHotelLat(resultSet.getDouble("hotel_lat"));
			hotelBean.setHotelLong(resultSet.getDouble("hotel_long"));
			hotelBean.setSwimmingPool(resultSet.getString("swimming_pool"));
			hotelBean.setParking(resultSet.getString("parking"));
			hotelBean.setLoundry(resultSet.getString("loundry"));

		} catch (Exception e) {
			System.out.println(e);
		}
		return hotelBean;
	}
	///////////////////////////////////////////////////////////////	

	
	public int deleteHotel(String hotelid)
	{
		conn=db.connect();

		try {
			String query = "DELETE from hotel_info_tbl where hotel_id = '" + hotelid + "'";
			Statement statement = conn.createStatement();
			return statement.executeUpdate(query);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}





}
