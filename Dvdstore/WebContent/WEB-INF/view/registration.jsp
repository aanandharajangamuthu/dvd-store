<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dvd store</title>
</head>
<script>
function validateForm() {
    var name = document.forms["myForm"]["name"].value;
    var email = document.forms["myForm"]["email"].value;
    var password = document.forms["myForm"]["password"].value;
    var mobileNumber = document.forms["myForm"]["mobileNumber"].value;
    if (name == ""|| email == ""||password == ""|| mobileNumber == "") {
        alert("All field must be filled out");
        return false;
    }   
}   
</script>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Registration Form</div>
<br><br>
<form name=myForm id="registerForm" modelAttribute="user" method="post" action="saveUser.html">
<center>
    <table>                
        <tbody>
            <tr>
                <td>Name<br><br></td>
                <td><input required pattern="[a-zA-Z ]*" type="text" name="name" ><br><br></td>
            </tr>
            <tr>
                <td>Email<br><br></td>
                <td><input required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" type="text" name="email"/><br><br></td>
            </tr>
            <tr>
                <td>Password<br><br></td>
                <td><input type="password" name="password" required pattern=".{6,}" title="Six or more characters"/><br><br></td>
            </tr>
            <tr>
                <td>Mobile no<br><br></td>
                <td><input  required pattern="[789][0-9]{9}" type="text" name="mobileNumber"/><br><br></td>
            </tr>
                <tr><td></td><td>
                    <input type="submit" value="Submit"/>
                </td></tr>              
                    <tr>
                <td colspan="2"><a href="disc.html">Add Disc</a></td>
            </tr>
        </tbody>
    </table>
</center>
</form>
<br>
<a href="userList.html" >Click Here to see User List</a>
</center>
</body>
</html>

