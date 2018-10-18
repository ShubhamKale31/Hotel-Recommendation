<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="com.hotelRecommendation.database.*"%>
<%@page import="com.hotelRecommendation.bean.*"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>RightInsight</title>
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
		mapTypeId : google.maps.MapTypeId.ROADMAP  
	};
	
	var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
	google.maps.event.addDomListener(window, 'load', initialize);
}
</script>
</head>
<body>
<div id="main" >
<%@ include file="header.jsp"%>
</div>
<div id="page" align="center">
<% 
HotelDataBaseHelper hotelDataBaseHelper = new HotelDataBaseHelper();
ArrayList<HotelBean> hotelBeanList = hotelDataBaseHelper.fetchAllHotelInfo();

%>
      
	     <table  border="1" align="center" >
      
       <% for(int i=0;i<hotelBeanList.size();i++)
           {
        	   
        	   
        	   
        	   int id=hotelBeanList.get(i).getHotelid();
				String name=hotelBeanList.get(i).getHotelname();
				String address=hotelBeanList.get(i).getHoteladdress();
				String contactperson=hotelBeanList.get(i).getHotelcontactperson();
				String contactno=hotelBeanList.get(i).getHotelcontact();
				String email=hotelBeanList.get(i).getHotelemail();
				Double lat1=hotelBeanList.get(i).getHotelLat();
				Double longi1=hotelBeanList.get(i).getHotelLong();
        	   %>
      
      
     
       
        <tr>
       		<td align="center">
           	 
           	 <table>
           			 <tr>
          		  		<td>
          			 		 <img height="250" width="250" src="AddHotelImage?id=<%=id%>"/>
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
           				 <td>ContactNo:<%=contactno%></td>
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
          			 <div id="<%=id%>" style="width:250px; height: 250px;"></div>
          			<script>

	var mapProp = {
		center : new google.maps.LatLng(<%=lat1%>,
				<%=longi1%>),
		zoom : 12,
		mapTypeId : google.maps.MapTypeId.ROADMAP  
	};
	
	var map = new google.maps.Map(document.getElementById(<%=id%>),mapProp);
	
	var latlng = new google.maps.LatLng(<%=lat1%>, <%=longi1%>);
	var myMarker = new google.maps.Marker( { position: latlng, map: map, title: "<%=name%>" });
	
</script>
          		 
          		  </td>
         	   </tr>
            </table>
             
             </td>
            	
            	<td>
           	 <table>
           		 <tr>
          		  <td>
          			<a href="viewHotelRoomforUser.jsp?id=<%=id%>"><font color="brown">ViewRooms</font></a>
          		  </td>
         	   </tr>
            </table>
             
             </td>
       </td>     
    </tr>




<%}%>
</table>

</div>
<%@ include file="footer.jsp"%>
</body>
</html>