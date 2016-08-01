<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Being Java Guys | Registration Form</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: green;font-size: 30px">Being Java Guys | Registration Form</div>
<br><br>
<c:url var="userRegistration" value="saveUser.html"/>
<form:form id="registerForm" modelAttribute="user" method="post" action="${userRegistration}">
<table width="400px" height="150px">
<tr>
<td><form:label path="name">Name</form:label></td>
<td><form:input  path="name"/></td>
</tr>
<tr>
<td><form:label path="lastName">Email</form:label></td>
<td><form:input  path="lastName"/></td>
</tr>
<tr>
<td><form:label path="password">Password</form:label></td>
<td><form:radiobuttons path="password" items="${model.gender}"/></td>
</tr>
<tr>
<td><form:label path="mobileNumber">Mobile no</form:label></td>
<td><form:select path="mobileNumber" items="${model.city}"></form:select></td>
</tr>
<tr><td></td><td>
<input type="submit" value="Register" />
</td></tr>
</table>
</form:form>
</center>
</body>
</html>