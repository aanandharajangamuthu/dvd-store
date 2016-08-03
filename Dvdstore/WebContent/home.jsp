<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Funtainment</title>
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
        <li><a href="#">IN THEATERS</a></li>
        <li><a href="https://in.bookmyshow.com/movies/comingsoon">COMING SOON</a></li>        
        <li><a href="userIndex.jsp">LOGIN/REGISTER</a></li>
        <li><a href="cartList.html" target="iframe_a">CART</a></li>
      </ul>
    </div>
    <div id="sub-navigation">
    <ul>
     <li><a href="home.jsp">Home</a></li>
       <div class = "dropdown">
     <li><a href="movies.jsp">Movies</a></li>
     <div class="dropdown-content">
       <a href="tamilMovies.html" target="iframe_a">Tamil</a>
       <a href="englishMovies.html" target="iframe_a">English</a>
       <a href="hindiMovies.html" target="iframe_a">Hindi</a>
       <a href="movieList.html" target="iframe_a">All Movies</a>
     </div>
     </div>
     <div class = "dropdown">
     <li><a href="#">Songs</a></li>
     <div class="dropdown-content">
       <a href="tamilSongs.html" target="iframe_a">Tamil Songs</a>
       <a href="englishSongs.html" target="iframe_a">English Songs</a>
       <a href="hindiSongs.html" target="iframe_a">Hindi Songs</a>
       <a href="songList.html" target="iframe_a">All Songs</a>
     </div>
     </div>
     <div class="dropdown">  
     <li><a href="home.jsp">Tv Shows</a></li>
     <div class="dropdown-content">
       <a href="tamilShows.html" target="iframe_a">Tamil</a>
       <a href="englishShows.html" target="iframe_a">English</a>
       <a href="hindiShows.html" target="iframe_a">Hindi</a>
     </div>
     </div>
   
  <li><a  href="index.jsp">Admin Access</a></li>
  </ul>
  </div>
  </div>
<iframe frameborder="0"  allowtransparency="yes" scrolling="yes" height="500px" width="100%" src="homeIndex.jsp" name="iframe_a" style="border:none";></iframe>
</body>
</html>