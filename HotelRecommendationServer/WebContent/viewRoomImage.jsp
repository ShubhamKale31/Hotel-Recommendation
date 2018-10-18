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
<% String hotelroomid=request.getParameter("id");%>
       
        <table align="center">
            <tr><td><table><tr><td><img height="250" width="250" src="AddHotelRoomImage?id=<%=hotelroomid%>"/></td></tr></td></tr></table>
    <td>
    

</table>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>