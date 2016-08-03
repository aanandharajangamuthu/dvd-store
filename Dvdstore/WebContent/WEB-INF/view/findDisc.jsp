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
<div style="color: green;font-size: 30px">Disc Details</div>
<br><br>
<br><br>
<div style="color: green;font-size: 30px">To Find Particular Disc</div>
<br><br>
<c:url var="getDisc" value="discFind.html"/>
<form:form id="discForm" modelAttribute="disc" method="post" action="${getDisc}">
<table width="400px" height="150px">
<tr>
<td><form:label style="color:white" path="name">Disc Id</form:label></td>
<td><form:input path="id" /></td>
</tr>
<tr><td></td><td>
<input type="submit" value="Submit" />
</td></tr>
</table>
</form:form>
<br>
<a href="discList.html" >Click Here to see Disc List</a>
</center>
</body>
</html>