package com.hotelRecommendation.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotelRecommendation.bean.HotelBean;
import com.hotelRecommendation.database.HotelDataBaseHelper;

/**
 * Servlet implementation class AddHotelServlet
 */
@WebServlet("/AddHotelServlet")
public class AddHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHotelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String hotelname=request.getParameter("hotelName");
		String address=request.getParameter("address");
		String contactPerson=request.getParameter("contactPerson");
		String contact=request.getParameter("contactNo");
		String email=request.getParameter("email");
		String lat=request.getParameter("Latitude");
		String longi=request.getParameter("Longitude");
		String swimming=request.getParameter("swimmingPool");
		String parking=request.getParameter("parking");
		String loundry=request.getParameter("loundry");
		
		
		
		
		
		HotelBean hotelBean=new HotelBean();
		
		hotelBean.setHotelname(hotelname);
		hotelBean.setHoteladdress(address);
		hotelBean.setHotelcontactperson(contactPerson);
		hotelBean.setHotelcontact(contact);
		hotelBean.setHotelemail(email);
		hotelBean.setHotelLat(Double.parseDouble(lat));
		hotelBean.setHotelLong(Double.parseDouble(longi));
		hotelBean.setSwimmingPool(swimming);
		hotelBean.setParking(parking);
		hotelBean.setLoundry(loundry);
		
		
		
		
		HotelDataBaseHelper dbHelper=new HotelDataBaseHelper();
		
		int result=dbHelper.addHotel(hotelBean);
		
		
		if(result==1)
		{
			response.sendRedirect("addHotelImage.jsp");
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
