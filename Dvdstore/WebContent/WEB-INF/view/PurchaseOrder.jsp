<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Disc Detail</title>
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
        <li><a href="user_home.html">Home</a></li>
        <li><a href="https://in.bookmyshow.com/movies/comingsoon">COMING SOON</a></li>        
        <li><div><a href="userIndex.jsp"><c:out value="${order.getUser().getName()}"/></a></div></li>
        <li><a href="signOut.html">Sign Out!!!</a></li>
      </ul>
    </div>
<br><br><br><br><br><br>
<div align="center" style="color: green;font-size: 30px">Order Details</div>
<h1 style = "color:white">CustomerName : ${order.getUser().getName()}</h1><br><br>
<c:if test="${!empty order}">
<p style = "color:white">Total Amount : <c:out value="${totalAmount}"/></p>
<br><br>
        <table border="1" bgcolor="black" width="600px">
<tr style="background-color: green;color: white;text-align: center;" height="40px">
<td>Disc Movie Name</td>
<td>Director</td>
<td>ImageUrl</td>
<td>Quantity</td>
<td>Total Price</td>
</tr>
<c:forEach items="${cart}" var="cart">
<tr style="background-color:white;color: black;text-align: center;" height="30px" >
<td><c:out value="${cart.disc.getName()}"/></td>
<td><c:out value="${cart.disc.getDirectorName()}"/></td>
<td><img src="<c:out value="${cart.disc.getImageUrl()}"/>" alt="image" border=3 height=100 width=100></img></td>
<td><c:out value="${cart.quantity}"/></td>
<td><c:out value="${cart.totalPrice}"/></td>
</tr>
</c:forEach>
</table>
 </c:if>
<a href="success.html"><input type="button" class="button" value="Confirm Order"/></a><br>
</div>
</div>
</body>
</html>