<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin access</title>
<link rel="stylesheet" type="text/css" href="dvdStyle.css">
</head>
<body bgcolor="black">
<img src="disc1.jpeg" alt="disc icon" width="100%" height="150"><br>
<table background="green">
<tr>
<td><a href="register.html"target="iframe_user"><input type="button" class="button" value="Register"></a></td>
<td><a href="login.html" target="iframe_user"><input type="button" class="button" value="Login"></a><br></td>
</tr>
</table>
  <iframe style="bottom:80px" src="userAccess.jsp" allowtransparency="yes" scrolling="no" height="500px" width="100%" src="demo_iframe.htm" name="iframe_user" style="border:none"></iframe>
  <center><a href="home.jsp" ><input type="button" class="button" value="Go Home!!"></a></center>
</body>
</html>