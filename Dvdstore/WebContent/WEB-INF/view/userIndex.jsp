<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Funtainment</title>
<link rel="stylesheet" type="text/css" href="dvdStyle.css">
</head>
 <body bgcolor="black">
 <div id="shell">
  <div id="header"> 
  <h1 id="logo"><a href="#">Fact</a></h1>
 <i><h2 style="color:green">Be a Fanatic and Admire Everything </h2></i>
 </div>
 <div id="navigation">
      <ul>              
        <li><a href="#">IN THEATERS</a></li>
        <li><a href="https://in.bookmyshow.com/movies/comingsoon">COMING SOON</a></li>        
        <li><a href="signOut.html">Sign Out!!!</a></li>
      </ul>
    </div>
 <br><br><br><br><br><br>   
 <center> <div style="color:white">
  <center><p style="color:white"> Welcome User</p></center><br><br><br><br>
   <p>${currentUser.name}</p>
   <p>${currentUser.email}</p>
   <p>${currentUser.mobileNumber}</p>
  </div></center>
</div>
</body>
</html>