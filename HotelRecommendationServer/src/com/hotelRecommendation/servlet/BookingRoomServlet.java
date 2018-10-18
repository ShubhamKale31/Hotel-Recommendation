package com.hotelRecommendation.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotelRecommendation.bean.BookingBean;
import com.hotelRecommendation.database.BookingDataBaseHelper;

/**
 * Servlet implementation class BookingRoomServlet
 */
@WebServlet("/BookingRoomServlet")
public class BookingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BookingRoomServlet() {
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
		
		String checkInDate=request.getParameter("checkInDate");
		String checkoutDate=request.getParameter("checkOutDate");
		String prize=request.getParameter("totalAmount");
		String userId=request.getParameter("userId");
		String hotelId=request.getParameter("hotelId");
		String roomId=request.getParameter("roomId");
		
		BookingBean bookingBean = new BookingBean();
		
		bookingBean.setCheckInDate(checkInDate);
		bookingBean.setCheckOutDate(checkoutDate);
		bookingBean.setTotalAmount(prize);
		bookingBean.setUserId(Integer.parseInt(userId));
		bookingBean.setHotelId(Integer.parseInt(hotelId));
		bookingBean.setRoomId(Integer.parseInt(roomId));
		BookingDataBaseHelper bookingDataBaseHelper = new BookingDataBaseHelper();
		
		int result=bookingDataBaseHelper.bookRoom(bookingBean);
		
		if(result==1)
		{
			response.sendRedirect("welcomeUser.jsp");
		}
		
		
		
		
		
		
	}

}
