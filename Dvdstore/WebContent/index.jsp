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
<td><a href="registerLanguage.html"target="iframe_admin"><input type="button" class="button" value="Register Language"></a></td>
<td><a href="languageList.html" target="iframe_admin"><input type="button" class="button" value="List of Languages"></a></td>
<td><a href="registerCategory.html" target="iframe_admin"><input type="button" class="button" value="Register Category"></a></td>
<td><a href="categoryList.html" target="iframe_admin"><input type="button" class="button" value="List of Categories"></a></td>
<td><a href="registerDisc.html" target="iframe_admin"><input type="button"class="button" value="Register Disc"></a></td>
<td><a href="discList.html" target="iframe_admin"><input type="button" class="button" value="List of Discs"></a></td>
</tr>
<tr>
<td><a href="showDisc.html" target="iframe_admin"><input type="button" class="button" value="Disc by Id"></a></td>
<td><a href="userList.html" target="iframe_admin"><input type="button" class="button" value="List of Users"></a><br></td>
<td><a href="assignLanguage.html" target="iframe_admin"><input type="button" class="button" value="Assign Language"></a><br></td>
<td><a href="assignCategory.html" target="iframe_admin"><input type="button" class="button" value="Assign Category"></a><br></td>
</tr>
</table>
  <iframe style="bottom:80px" src="adminAccess.jsp" allowtransparency="yes" scrolling="yes" height="500px" width="100%" src="demo_iframe.htm" name="iframe_admin" style="border:none"></iframe>
  <center><a href="home.jsp" ><input type="button" class="button" value="Go Home!!"></a></center>
</body>
</html>