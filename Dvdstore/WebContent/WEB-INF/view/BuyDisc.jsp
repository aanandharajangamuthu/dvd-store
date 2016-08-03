<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Disc Detail</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: green;font-size: 30px">Buy Disc</div>
<br><br>
<c:if test="${!empty BuyDisc}">
<table border="1" bgcolor="black" width="600px">
<tr style="background-color: green;color: white;text-align: center;" height="40px">
<td>ID</td>
<td>Disc Movie Name</td>
<td>Director</td>
<td>Actor</td>
<td>Image</td>
<td>Price</td>
<td>Quantity</td>
</tr>
<form:form id="discId" modelAttribute="cart" method="post" action="addProduct.html">
<tr style="background-color:white;color: black;text-align: center;" height="30px" >
<td><input type="hidden" id="id" name="id" value="${BuyDisc.id}"/></td>
<td><c:out value="${BuyDisc.name}"/></td>
<td><c:out value="${BuyDisc.directorName}"/></td>
<td><c:out value="${BuyDisc.actorName}"/></td>
<td><img src="<c:out value="${BuyDisc.imageUrl}"/>" alt="image" border=3 height=100 width=100></img></td>
<td><c:out value="${BuyDisc.price}"/></td>
<td><input type="text" name="quantity"/></td>
<td><input type="submit" value="Add to cart"></td>
</tr>
</form:form> 
</table>
</c:if>
<br>

</center>
</body>
</html>