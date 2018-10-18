package com.hotelRecommendation.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.hotelRecommendation.Utility.Base64;
import com.hotelRecommendation.bean.*;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.hotelRecommendation.bean.UserBean;
import com.hotelRecommendation.database.BookingDataBaseHelper;
import com.hotelRecommendation.database.HotelDataBaseHelper;
import com.hotelRecommendation.database.HotelImageHelper;
import com.hotelRecommendation.database.HotelRoomDataBaseHelper;
import com.hotelRecommendation.database.HotelRoomImage;
import com.hotelRecommendation.database.UserDataBaseHelper;

@Path("webService")
public class WebService {
	// private TakeAwayBean takeAwayBean = new TakeAwayBean();

	// The @Context annotation allows us to have certain contextual objects
	// injected into this class.
	// UriInfo object allows us to get URI information (no kidding).
	@Context
	UriInfo uriInfo;

	// Another "injected" object. This allows us to use the information that's
	// part of any incoming request.
	// We could, for example, get header information, or the requestor's
	// address.
	@Context
	// Request request;
	// Response response;
	HttpServletRequest request;
	HttpServletResponse response;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String respondAsReady() {
		return "Web service is ready!";
	}

	@POST
	@Path("/registerUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject registerUser(String data) {

		System.out.println("in Register user");
		System.out.println(data);

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);

			String fname = jsonObject.getString("FirstName");
			String lname = jsonObject.getString("LastName");
			String address = jsonObject.getString("Address");
			String email = jsonObject.getString("EmailId");
			String phone = jsonObject.getString("PhoneNo");
			String uname = jsonObject.getString("UserName");
			String pwd = jsonObject.getString("PassWord");

			int result = 0;

			UserBean userBean = new UserBean();

			userBean.setFirstName(fname);
			userBean.setLastName(lname);
			userBean.setAddress(address);
			userBean.setEmaild(email);
			userBean.setContactNo(phone);
			userBean.setUserName(uname);
			userBean.setPassWord(pwd);

			UserDataBaseHelper userDataBaseHelper = new UserDataBaseHelper();
			result =userDataBaseHelper.addUser(userBean);
			System.out.println(result);
			if (result > 0) {
				jsonObject = new JSONObject();
				jsonObject.put("result",result );
				System.out.println(jsonObject);
			} else {
				jsonObject = new JSONObject();
				jsonObject.put("result", 0);
				System.out.println(jsonObject);
			}
		} catch (Exception e) {
			System.out.println(e);
			try {
				jsonObject = new JSONObject();
				jsonObject.put("result", -1);
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}

		return jsonObject;
	}


	@POST
	@Path("/validateUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject validateUser(String data) {

		System.out.println("in Validate user");
		System.out.println(data);

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);
			String uname = jsonObject.getString("UserName");
			String pwd = jsonObject.getString("PassWord");



			UserDataBaseHelper helper = new UserDataBaseHelper();
			UserBean userBean = new UserBean();
			userBean.setUserName(uname);
			userBean.setPassWord(pwd);

			UserBean bean =helper.validateUser(userBean);
			if (bean !=null) {
				jsonObject = new JSONObject();
				jsonObject.put("UserId", bean.getUserId());
				jsonObject.put("FirstName", bean.getFirstName());
				jsonObject.put("LastName", bean.getLastName());
				jsonObject.put("Address", bean.getAddress());
				jsonObject.put("EmailID", bean.getEmaild());
				jsonObject.put("ContactNo", bean.getContactNo());
				jsonObject.put("UserName", bean.getUserName());
				jsonObject.put("PassWord", bean.getPassWord());
				System.out.println(jsonObject);
			} else {
				jsonObject = new JSONObject();
				jsonObject.put("userId", 0);
				System.out.println(jsonObject);
			}
		} catch (Exception e) {
			System.out.println(e);
			try {
				jsonObject = new JSONObject();
				jsonObject.put("userId", -1);
			} catch (Exception e1) {  
				System.out.println(e1);
			}
		}

		return jsonObject;
	}



	@POST
	@Path("/getAllHotel")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONArray getCollegeName(String data){
		System.out.println("get All Hotel");
		JSONArray jsonArray = new JSONArray();

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);

			HotelDataBaseHelper hotelDataBaseHelper = new HotelDataBaseHelper();
			ArrayList<HotelBean> hotelBeanList=hotelDataBaseHelper.fetchAllHotelInfo();

			for(HotelBean bean : hotelBeanList)
			{
				
				jsonObject = new JSONObject();
				jsonObject.put("hotelId", bean.getHotelid());
				jsonObject.put("hotelName", bean.getHotelname());
				jsonObject.put("Address", bean.getHoteladdress());
				jsonObject.put("contactPerson", bean.getHotelcontactperson());
				jsonObject.put("Contact", bean.getHotelcontact());
				jsonObject.put("Email", bean.getHotelemail());
				jsonObject.put("Lat", bean.getHotelLat());
				jsonObject.put("Long", bean.getHotelLong());
				jsonObject.put("swimmingPool", bean.getSwimmingPool());
				jsonObject.put("Parking", bean.getParking());
				jsonObject.put("Loundry",bean.getLoundry());



				HotelImageHelper hotelImageHelper = new HotelImageHelper();

				HotelImageBean imageBean=	hotelImageHelper.GetHotelImage(bean.getHotelid());


				InputStream fin=imageBean.getHotelImage();
				byte fileContent[] = new byte[(int)fin.available()];   
				fin.read(fileContent);

				String fileData=Base64.encodeBytes(fileContent);
				jsonObject.put("hotelImag",fileData);
				jsonArray.put(jsonObject);
			}
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		
		

		return jsonArray;
	}

	@POST
	@Path("/criteriaSearch")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONArray criteriaSearch(String data){
		System.out.println("criteriaSearch");
		JSONArray jsonArray = new JSONArray();

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);

			String swimming=jsonObject.getString("SwimmingPool");
			String parking=jsonObject.getString("Parking");
			String laundray=jsonObject.getString("Laundry");
			String latitude=jsonObject.getString("Latitude");
			String longitude=jsonObject.getString("Longitude");

			Double lat1=Double.parseDouble(latitude);
			Double long1=Double.parseDouble(longitude);
			HotelDataBaseHelper hotelDataBaseHelper = new HotelDataBaseHelper();
			ArrayList<HotelBean> hotelBeanList=hotelDataBaseHelper.fetchAllHotelInfoByCriteria(swimming, laundray, parking, lat1, long1,"k");

			for(HotelBean bean : hotelBeanList)
			{

				jsonObject = new JSONObject();
				jsonObject.put("hotelId", bean.getHotelid());
				jsonObject.put("hotelName", bean.getHotelname());
				jsonObject.put("Address", bean.getHoteladdress());
				jsonObject.put("contactPerson", bean.getHotelcontactperson());
				jsonObject.put("Contact", bean.getHotelcontact());
				jsonObject.put("Email", bean.getHotelemail());
				jsonObject.put("Lat", bean.getHotelLat());
				jsonObject.put("Long", bean.getHotelLong());
				jsonObject.put("swimmingPool", "1");
				jsonObject.put("Parking", "1");
				jsonObject.put("Loundry", "1");



				HotelImageHelper hotelImageHelper = new HotelImageHelper();

				HotelImageBean imageBean=	hotelImageHelper.GetHotelImage(bean.getHotelid());


				InputStream fin=imageBean.getHotelImage();
				byte fileContent[] = new byte[(int)fin.available()];   
				fin.read(fileContent);

				String fileData=Base64.encodeBytes(fileContent);
				jsonObject.put("hotelImag",fileData);
				jsonArray.put(jsonObject);
			}
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		return jsonArray;
	}

	@POST
	@Path("/RecommendedHotel")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONArray RecommendedHotel(String data){
		System.out.println("RecommendedHotel");
		JSONArray jsonArray = new JSONArray();

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);

			String id=jsonObject.getString("userId");
			int userId=Integer.parseInt(id);
			String latitude=jsonObject.getString("Latitude");
			String longitude=jsonObject.getString("Longitude");

			Double lat1=Double.parseDouble(latitude);
			Double long1=Double.parseDouble(longitude);
			
			HotelDataBaseHelper hotelDataBaseHelper = new HotelDataBaseHelper();
			ArrayList<HotelBean> hotelBeanList=hotelDataBaseHelper.fetchAllHotelInfoByCriteriaAndRecom("0", "0", "0", lat1, long1, "k", userId);

			for(HotelBean bean : hotelBeanList)
			{

				jsonObject = new JSONObject();
				jsonObject.put("hotelId", bean.getHotelid());
				jsonObject.put("hotelName", bean.getHotelname());
				jsonObject.put("Address", bean.getHoteladdress());
				jsonObject.put("contactPerson", bean.getHotelcontactperson());
				jsonObject.put("Contact", bean.getHotelcontact());
				jsonObject.put("Email", bean.getHotelemail());
				jsonObject.put("Lat", bean.getHotelLat());
				jsonObject.put("Long", bean.getHotelLong());
				jsonObject.put("swimmingPool", bean.getSwimmingPool());
				jsonObject.put("Parking", bean.getParking());
				jsonObject.put("Loundry", bean.getLoundry());



				HotelImageHelper hotelImageHelper = new HotelImageHelper();

				HotelImageBean imageBean=	hotelImageHelper.GetHotelImage(bean.getHotelid());


				InputStream fin=imageBean.getHotelImage();
				byte fileContent[] = new byte[(int)fin.available()];   
				fin.read(fileContent);

				String fileData=Base64.encodeBytes(fileContent);
				jsonObject.put("hotelImag",fileData);
				jsonArray.put(jsonObject);
			}
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		return jsonArray;
	}

	@POST
	@Path("/RecommendedByOtherUserHotel")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONArray RecommendedByOtherUserHotel(String data){
		System.out.println("RecommendedHotel");
		JSONArray jsonArray = new JSONArray();

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);

			String latitude=jsonObject.getString("Latitude");
			String longitude=jsonObject.getString("Longitude");

			Double lat1=Double.parseDouble(latitude);
			Double long1=Double.parseDouble(longitude);
			System.out.println("------------");
			System.out.println(lat1);
			System.out.println("------------");
			System.out.println("------------");
			System.out.println(long1);
			System.out.println("------------");
			HotelDataBaseHelper hotelDataBaseHelper = new HotelDataBaseHelper();
			ArrayList<HotelBean> hotelBeanList=hotelDataBaseHelper.fetchAllHotelInfoByCriteriaAndRecomByOtherUser("0", "0", "0", lat1, long1, "k");

			for(HotelBean bean : hotelBeanList)
			{

				jsonObject = new JSONObject();
				jsonObject.put("hotelId", bean.getHotelid());
				jsonObject.put("hotelName", bean.getHotelname());
				jsonObject.put("Address", bean.getHoteladdress());
				jsonObject.put("contactPerson", bean.getHotelcontactperson());
				jsonObject.put("Contact", bean.getHotelcontact());
				jsonObject.put("Email", bean.getHotelemail());
				jsonObject.put("Lat", bean.getHotelLat());
				jsonObject.put("Long", bean.getHotelLong());
				jsonObject.put("swimmingPool", bean.getSwimmingPool());
				jsonObject.put("Parking", bean.getParking());
				jsonObject.put("Loundry", bean.getLoundry());



				HotelImageHelper hotelImageHelper = new HotelImageHelper();

				HotelImageBean imageBean=	hotelImageHelper.GetHotelImage(bean.getHotelid());
				InputStream fin=imageBean.getHotelImage();
				byte fileContent[] = new byte[(int)fin.available()];   
				fin.read(fileContent);

				String fileData=Base64.encodeBytes(fileContent);
				jsonObject.put("hotelImag",fileData);
				jsonArray.put(jsonObject);
			}
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		return jsonArray;
	}

	@POST
	@Path("/RoomByHotel")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONArray RoomByHotel(String data){
		System.out.println("RoomByHotel");
		JSONArray jsonArray = new JSONArray();

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);

			String hotelId=jsonObject.getString("hotelId");

			HotelRoomDataBaseHelper hotelRoomDataBaseHelper = new HotelRoomDataBaseHelper();
			ArrayList<HotelRoomBean> hotelRoomBeanList=hotelRoomDataBaseHelper.fetchAllHotelRoomInfoById(hotelId);
			System.out.println("in get roomImage");
			for(HotelRoomBean bean:hotelRoomBeanList)
			{

				jsonObject = new JSONObject();
				jsonObject.put("roomId", bean.getHotelRoomId());
				jsonObject.put("hotelId", bean.getHotelId());
				jsonObject.put("numberOfRoom", bean.getNumberOfRoom());
				jsonObject.put("roomType", bean.getRoomType());
				jsonObject.put("prize", bean.getPrize());


				HotelRoomImage hotelRoomImage = new HotelRoomImage();
				RoomImageBean imageBean=hotelRoomImage.GetRoomImage(bean.getHotelRoomId());
				InputStream fin=imageBean.getRoomImage();
				byte fileContent[] = new byte[(int)fin.available()];   
				fin.read(fileContent);

				String fileData=Base64.encodeBytes(fileContent);
				jsonObject.put("roomImage",fileData);
				jsonArray.put(jsonObject);
			}
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		return jsonArray;
	}
	
	@POST
	@Path("/BookRoom")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject BookRoom(String data) {

		System.out.println("in BookRoom");
		System.out.println(data);

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);

			String userId = jsonObject.getString("userId");
			String roomId = jsonObject.getString("roomId");
			String hotelId = jsonObject.getString("hotelId");
			String checkInDate=jsonObject.getString("checkInDate");
			String checkOutDate=jsonObject.getString("checkOutDate");
			String prize=jsonObject.getString("prize");
			int result = 0;

			BookingBean bookingBean = new BookingBean();

			bookingBean.setUserId(Integer.parseInt(userId));
			bookingBean.setRoomId(Integer.parseInt(roomId));
			bookingBean.setHotelId(Integer.parseInt(hotelId));
			bookingBean.setCheckInDate(checkInDate);
			bookingBean.setCheckOutDate(checkOutDate);
			bookingBean.setTotalAmount(prize);

			BookingDataBaseHelper bookingDataBaseHelper = new BookingDataBaseHelper();
			result=bookingDataBaseHelper.bookRoom(bookingBean);
			//result =userDataBaseHelper.addUser(userBean);
			System.out.println(result);
			if (result > 0) {
				jsonObject = new JSONObject();
				jsonObject.put("result",result );
				System.out.println(jsonObject);
			} else {
				jsonObject = new JSONObject();
				jsonObject.put("result", 0);
				System.out.println(jsonObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				jsonObject = new JSONObject();
				jsonObject.put("result", -1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		return jsonObject;
	}

}
