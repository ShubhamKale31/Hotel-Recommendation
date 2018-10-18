<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="com.hotelRecommendation.*"%>
<%@page import="com.hotelRecommendation.bean.*"%>
<%@page import="com.hotelRecommendation.database.*"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>HotelRecommendation</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="main">

<%@ include file="header.jsp"%>
<% 
String hotelId=request.getParameter("id");
int userId=(Integer)session.getAttribute("userId");
	try
	{
		HotelRoomDataBaseHelper roomHelper=new HotelRoomDataBaseHelper();
	
	ArrayList<HotelRoomBean> roomBeanlist=roomHelper.fetchAllHotelRoomInfoById(hotelId);
	
			
	%>

</div>
<!-- start page -->
<div id="page" align="center">
	
	
			<h1 class="title" align="center"><a href="#">Hotel Rooms</h1>
			
		  <div class="entry">
				<table border="0" cellspacing="5" cellpadding="3" align="center">
				<thead>
					<tr>
						
						<th>ROOMTYPE</th>
						<th>NOOFROOM'S</th>
						
						
						
						
					</tr>
				</thead>
				<% for(int i=0;i<roomBeanlist.size();i++) 
				{
					
					int id=roomBeanlist.get(i).getHotelRoomId();
					int hotelid=roomBeanlist.get(i).getHotelId();
					String roomtype=roomBeanlist.get(i).getRoomType();
					int numberofroom=roomBeanlist.get(i).getNumberOfRoom();
					String prize=roomBeanlist.get(i).getPrize();
				 %>
				
				<tbody>
				
				<tr>
						
						<td><%=roomtype%></td>
						<td><%=numberofroom%></td>
						<td><img height="250" width="250" src="AddHotelRoomImage?id=<%=id%>"/></td>
						<td><a href="bookRoom.jsp?hotelId=<%=hotelid%>&roomid=<%=id%>&prize=<%=prize%>"><font color="brown">BookRoom</font></a></td>
			
			</tr>
				<%}/* for block loop end */
						} /* try block end */
						catch (Exception ex) {
							out.println("Unable to connect to database.");
						}
					%>
				
				</tbody>


            
	</table>
                
			    
						 
			</div>
			</div>
	
	<div style="clear: both;">&nbsp;</div>

<!-- end page -->
<hr />
<!-- start footer -->
<%@ include file="footer.jsp"%>
<!-- end footer -->
</body>
</html>