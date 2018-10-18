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
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script>

function initialize() {
	var mapProp = {
		center : new google.maps.LatLng(18.516726,
				73.856255),
		zoom : 18,
		mapTypeId : google.maps.MapTypeId.ROADMAP  /* ROADMAP (normal, default 2D map)
												   SATELLITE (photographic map)
												   HYBRID (photographic map + roads and city names)
												   TERRAIN (map with mountains, rivers, etc.) */
	};
	var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
	
	google.maps.event.addListener(map, 'click', function(event) {
		// alert( "Latitude: "+event.latLng.lat()+" "+", longitude: "+event.latLng.lng() ); 
		document.getElementById("Latitude").value = event.latLng.lat();
		document.getElementById("Longitude").value = event.latLng.lng();
	});
	
}
google.maps.event.addDomListener(window, 'load', initialize);


</script>
</head>
<body>
<div id="main" >
<%@ include file="header.jsp"%>
<% String hotelid=request.getParameter("id");%>
<% String name=request.getParameter("name");%>
<% String address=request.getParameter("address");%>
<% String contactNo=request.getParameter("contactno");%>
<% String email=request.getParameter("email");%>
<% String lat=request.getParameter("lat");%>
<% String longi=request.getParameter("longi");%>

        <table  border="1" align="center" >
        <tr>
       		<td align="center">
           	
           	 <table>
           		 <tr>
          		  <td>
          			  <img height="250" width="250" src="AddHotelImage?id=<%=hotelid%>"/>
          		  </td>
         	   </tr>
            </table>
             
             </td>
             
           <td>
           
            <table>
          <tr>
             <td>Name:<%=name%></td>
            </tr>
            <tr>
            <td>Address:<%=address%></td>
            </tr>
            <tr>
            <td>ContactNo:<%=contactNo%></td>
            </tr>
             <tr>
            <td>Email:<%=email%></td>
            </tr>
         
            </table>
            </td>
           	<td>
           	 <table>
           		 <tr>
          		  <td>
          		 
          			 <div id="googleMap" style="width:250px; height: 250px;"></div>
          		  </td>
         	   </tr>
            </table>
             
             </td>
            	<td>
           	 <table>
           		 <tr>
          		  <td>
          		 
          			<a href="viewHotelRoomforUser.jsp?id=<%=hotelid%>"><font color="brown">ViewRooms</font></a>
          		  </td>
         	   </tr>
            </table>
             
             </td>
            
    </tr>

</table>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>