<%@page import="com.hotelRecommendation.database.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RaigadInsight</title>
</head>
<body>

<%
		String hotelRoomid =request.getParameter("id");
		try {
			  HotelRoomDataBaseHelper roomHelper=new HotelRoomDataBaseHelper();
			  roomHelper.deleteHotelRoom(hotelRoomid);

			if (hotelRoomid != null) {
				response.sendRedirect("viewHotelRoom.jsp");

			} else {
				response.sendRedirect("error.jsp");
			}
		}

		catch (Exception e)

		{
			e.printStackTrace();
		}
	%>

</body>
</html>