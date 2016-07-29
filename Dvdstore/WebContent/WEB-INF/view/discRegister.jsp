<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category Registration</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Disc Registration Form</div>
<br><br>
<c:url var="discRegistration" value="savedisc.html"/>
<form:form id="discForm" modelAttribute="disc" method="post" action="${discRegistration}">
<table width="400px" height="150px">
<tr>
<td><form:label path="name">Disc Movie Name</form:label></td>
<td><form:input path="name" /></td>
</tr>
<tr>
<td><form:label path="name">Director Name</form:label></td>
<td><form:input path="directorName" /></td>
</tr>
<tr>
<td><form:label path="name">Actor Name</form:label></td>
<td><form:input path="actorName" /></td>
</tr>
<tr>
<td><form:label path="name">Image Url</form:label></td>
<td><form:input path="imageUrl" /></td>
</tr>
<tr>
<td><form:label path="name">Price</form:label></td>
<td><form:input path="price" /></td>
</tr>
<tr>
<td><form:label path="name">Num of Stocks</form:label></td>
<td><form:input path="stock" /></td>
</tr>
<tr><td></td><td>
<input type="submit" value="Register" />
</td></tr>
</table>
</form:form>
<br>
<a href="discList.html" >Click Here to see Disc List</a>
</center>
</body>
</html>