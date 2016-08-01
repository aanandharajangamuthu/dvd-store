<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Funtainment</title>
<link rel="stylesheet" type="text/css" href="dvdStyle.css">
</head>
 <body bgcolor="black">
<h2> Have Fun </h2>
 <img src="disc1.jpeg" alt="disc icon" width="100%" height="150"><br>
 <table>
 <tr>
 <td> 
 <a href="home.jsp"><input type="button" class="button" value="Home"></a>
 </td>
  <td> 
 <a href="home.jsp" target="iframe_a"><input type="button" class="button" value="About us"></a>
 </td>
  <td> 
 <a href="movies.jsp" target="iframe_a"><input type="button" class="button" value="Movies"></a>
 </td>
  <td> 
 <a href="songs.jsp" target="iframe_a"><input type="button" class="button" value="Songs"></a>
 </td>
  <td> 
 <a href="tvShows.jsp" target="iframe_a"><input type="button" class="button" value="Tv Shows"></a>
 </td>
  <td> 
 <a href="userIndex.jsp" ><input type="button" class="button" value="Login/Register"></a>
 </td>
 </tr>
 <tr>
 <td>
 <a href="cart.jsp"><input type="button" class="button" value="Cart"></a>
 </td>
 <td>
 <a href="index.jsp"><input type="button" class="button" value="Admin Access"></a>
 </td>
 </tr>
</table>
<iframe frameborder="0"  allowtransparency="yes" scrolling="no" height="500px" width="100%" name="iframe_a" style="border:none";></iframe>
</body>
</html>