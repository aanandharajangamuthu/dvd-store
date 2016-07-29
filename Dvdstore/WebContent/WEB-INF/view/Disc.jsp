<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Add product</div>
<br><br>
<form name=myForm id="registerForm" modelAttribute="disc" method="post" action="saveDisc.html">
<center>
    <table>                
        <tbody>
            <tr>
                <td>Movie name<br><br></td>
                <td><input required pattern="[a-zA-Z ]*" type="text" name="name" /><br><br></td>
            </tr>
            <tr>
                <td>Director name<br><br></td>
                <td><input required pattern="[a-zA-Z ]*" type="text" name="directorName"/><br><br></td>
            </tr>
            <tr>
                <td>Actor name<br><br></td>
                <td><input required pattern="[a-zA-Z ]*" type="text" name="actorName"/><br><br></td>
            </tr>
            <tr>
                <td>Image Url<br><br></td>
                <td><input type="file" name="imageUrl" size="50" required/><br><br></td>               
            </tr>
            <tr>
                <td>Stock<br><br></td>
                <td><input  required type="text" name="stock"/><br><br></td>
            </tr>
            <tr>
                <td>Price<br><br></td>
                <td><input  required type="text" name="price"/><br><br></td>
            </tr>
                <tr><td></td><td>
                    <input type="submit" value="Submit"/>
                </td></tr>                 
        </tbody>
    </table>
</center>
</form>
<br>
<a href="userList.html" >Click Here to see User List</a>
</center>

</body>
</html>






