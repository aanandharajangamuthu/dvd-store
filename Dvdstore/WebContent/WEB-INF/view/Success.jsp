<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="dvdStyle.css">
<title>Success</title>
</head>
<body bgcolor="black">
 <div id="shell">
  <div id="header"> 
  <h1 id="logo"><a href="#">Fact</a></h1>
 <i><h2 style="color:green">Be a Fanatic and Admire Everything </h2></i>
 </div>
     <div id="navigation">
      <ul>              
        <li><a href="user_home.html">Home</a></li>
        <li><a href="https://in.bookmyshow.com/movies/comingsoon">COMING SOON</a></li>        
        <li><div><a href="userIndex.jsp"><c:out value="${currentUser.name}"/></a></div></li>
        <li><a href="signOut.html">Sign Out!!!</a></li>
      </ul>
    </div>
<br><br><br><br><br><br>
<center><h1 style = "color:white">Order Successfull!-------</h1></center>
<iframe frameborder="0"  allowtransparency="yes" scrolling="yes" height="500px" width="100%" name="iframe_b" style="border:none";></iframe>
</div>
</body>
</html>