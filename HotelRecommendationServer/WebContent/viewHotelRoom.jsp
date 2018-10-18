<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="com.hotelRecommendation.database.*"%>

<%@page import="com.hotelRecommendation.bean.*"%>
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
	try
	{
		HotelRoomDataBaseHelper roomHelper=new HotelRoomDataBaseHelper();
	
	ArrayList<HotelRoomBean> roomBeanlist=roomHelper.fetchAllHotelRoomInfo();
	
			
	%>

</div>
<hr />
<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
			<h1 class="title" align="center"><a href="#">Hotel Details</a></h1>
			
		  <div class="entry">
				<table border="0" cellspacing="5" cellpadding="3">
				<thead>
					<tr>
						<th>ROOMID</th>
						<th>HOTELID</th>
						<th>ROOMTYPE</th>
						<th>NOOFROOM'S</th>
						
						
						
						
					</tr>
				</thead>
				<% for(int i=0;i<roomBeanlist.size();i++) 
				{
					//int id=studentbeanList.get(i).getStudent_id();
					int id=roomBeanlist.get(i).getHotelRoomId();
					int hotelid=roomBeanlist.get(i).getHotelId();
					String roomtype=roomBeanlist.get(i).getRoomType();
					int numberofroom=roomBeanlist.get(i).getNumberOfRoom();
					
				 %>
				
				<tbody>
				
				<tr>
						<td><%=id%></td>
						<td><%=hotelid%></td>
						<td><%=roomtype%></td>
						<td><%=numberofroom%></td>
						<td><img height="250" width="250" src="AddHotelRoomImage?id=<%=id%>"/></td>
						<td><a href="viewRoomImage.jsp?id=<%=id%>"><u><font color="brown">ViewRoomImage</font></u></a></td>
						<td><a href="deleteHotelRoom.jsp?id=<%=id%>"
							onclick="return confirm('Are you sure you want to delete ID:   <%=id%>')"><u><font color="brown">Delete</font></u></a></td>
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
	</div>
	<!-- end content -->
	<!-- start sidebar two -->
	<div id="sidebar2" class="sidebar">
		
	</div>
	<!-- end sidebar two -->
	<div style="clear: both;">&nbsp;</div>
</div>
<!-- end page -->
<hr />
<!-- start footer -->
<%@ include file="footer.jsp"%>
<!-- end footer -->
</body>
</html>