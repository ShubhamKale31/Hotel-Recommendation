package com.hotelRecommendation.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotelRecommendation.bean.HotelRoomBean;
import com.hotelRecommendation.database.HotelRoomDataBaseHelper;

/**
 * Servlet implementation class AddHotelRoomServlet
 */
@WebServlet("/AddHotelRoomServlet")
public class AddHotelRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddHotelRoomServlet() {
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

		
		
		String hotelroomType=request.getParameter("roomType");
		String numberOfRoom=request.getParameter("numberOfRoom");
		String hotelid=request.getParameter("hotelname");
		String prize=request.getParameter("prize");
		
		HotelRoomBean roomBean=new HotelRoomBean();
		
		roomBean.setRoomType(hotelroomType);
		roomBean.setNumberOfRoom(Integer.parseInt(numberOfRoom));
		roomBean.setHotelId(Integer.parseInt(hotelid));
		roomBean.setPrize(prize);
		
		
		
		
		HotelRoomDataBaseHelper roomDataBaseHelper=new HotelRoomDataBaseHelper();
		
		
		int result=roomDataBaseHelper.addHotelRoom(roomBean);
		
		if(result==1)
		{
			response.sendRedirect("addHotelRoomImage.jsp");
			
		}
		
		else
		{
			response.sendRedirect("error.jsp");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
