<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="dvdStyle.css">
</head>
<body bgcolor="black">
    <div id="shell">
        <div id="header"> 
            <center><br><br><br><br><br><br>
                <div style="color: green;font-size: 30px">Login Form</div><br><br>
                <form name=myForm id="registerForm" modelAttribute="user" method="post" action="purchaseDisc.html">            
                    <table>                
                        <tbody>           
                            <tr>
                                <td style="color:white">Email<br><br></td>
                                <td><input required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" type="text" name="email"/><br><br></td>
                            </tr>
                            <tr>
                                <td style="color:white">Password<br><br></td>
                                <td><input required="required" type="password" name="password"/><br><br></td>
                            </tr>            
                            <tr>
                                <td></td>
                                <td>
                                    <input type="submit" class="button" value="Submit"/>
                               </td>
                           </tr>              
                        </tbody>
                    </table>
                </form><br>
                <div>
                    <table>
                        <tr>
                            <td style="color:white;font-size:25px">New User---></td>
                            <td><p><a href="register.html" style="color:green;font-size:25px" >Register Here</a></p></td>
                    </table>
               </div>
           </center>
       </div>
    </div>
</body>
</html>