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
		HotelDataBaseHelper hotelHelper=new HotelDataBaseHelper();
	
	ArrayList<HotelBean> hotelbeanList=hotelHelper.fetchAllHotelInfo();
	
			
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
						<th>ID</th>
						<th>NAME</th>
						<th>ADDRESS</th>
						<th>CONTACTPERSON</th>
						<th>CONTACTNO</th>
						<th>EMAIL</th>
						<th>LATITUDE</th>
						<th>LONGITUDE</th>
						
						
						
					</tr>
				</thead>
				<% for(int i=0;i<hotelbeanList.size();i++) 
				{
					int id=hotelbeanList.get(i).getHotelid();
					String name=hotelbeanList.get(i).getHotelname();
					String address=hotelbeanList.get(i).getHoteladdress();
					String contactperson=hotelbeanList.get(i).getHotelcontactperson();
					String contactno=hotelbeanList.get(i).getHotelcontact();
					String email=hotelbeanList.get(i).getHotelemail();
					Double lat=hotelbeanList.get(i).getHotelLat();
					Double longi=hotelbeanList.get(i).getHotelLong();
				
				 %>
				
				<tbody>
				
				<tr>
						<td><%=id%></td>
						<td><%=name%></td>
						<td><%=address%></td>
						<td><%=contactperson%></td>
						<td><%=contactno%></td>
						<td><%=email%></td>
						<td><%=lat%></td>
						<td><%=longi%></td>
						<td><a href="viewHotelImage.jsp?id=<%=id%>"><u><font color="brown">ViewHotelImage</font></u></a></td>
						<td><a href="deleteHotel.jsp?id=<%=id%>"
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