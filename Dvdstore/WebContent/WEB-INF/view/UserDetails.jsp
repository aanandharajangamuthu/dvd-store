<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Being Java Guys | User Details</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: green;font-size: 30px">User Details</div>
<br><br>
<c:if test="${!empty user}">
<table border="1" bgcolor="black" width="600px">
<tr style="background-color: green;color: white;text-align: center;" height="40px">
<td>User Id</td>
<td>Name</td>
<td>Email</td>
<td>Password</td>
<td>Mobile no</td>
</tr>
<c:forEach items="${user}" var="user">
<tr style="background-color:white;color: black;text-align: center;" height="30px" >
<td><c:out value="${user.id}"/></td>
<td><c:out value="${user.name}"/></td>
<td><c:out value="${user.email}"/></td>
<td><c:out value="${user.password}"/></td>
<td><c:out value="${user.mobileNumber}"/></td>
</tr>
</c:forEach>
</table>
</c:if>
</center>
</body>
</html>