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
<% String hotelid=request.getParameter("id");%>
<% String name=request.getParameter("name");%>
<% String address=request.getParameter("address");%>
        <table align="center">
        <tr>
        <td>
            <table>
            <tr>
            <td>
            <img height="250" width="250" src="AddHotelImage?id=<%=hotelid%>"/>
            </td>
            </table>
             </td>
           <td>
           
            <table>
            <tr>
            <td>name:<%=name%></td>
            </tr>
            <tr>
            <td>address:<%=address%></td>
            </tr>
            <tr>
            <td>name:<%=name%></td>
            </tr>
            
            </tr>
            </table>
            
            
            </td>
   
    

</table>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>