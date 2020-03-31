<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css" >

<title>Insert title here</title>
</head>
<body>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script src="js/bootstrap.min.js" ></script>
<%@ include file="navbarProfile.html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", 0);

if(session.getAttribute("user")==null){
	
	
	response.sendRedirect("loginform.jsp");
	
}


%>







<div class="card-group">
<div class="form-row">

 <div class="form-group col-md-3">
  <img src="data:image/jpg;base64,${user.getBase64()} " width="200" height="200"/>
    <div class="card-body">
      <h5 class="card-title">${user.getEmail()}</h5>
      <p class="card-text">${user.getAddress()}</p>
      <p class="card-text">${user.getGender()}</p>
      <p class="card-text">${user.getState()}</p>
      <p class="card-text"><small class="text-muted">Admin Active Now</small></p>
    </div>
  </div>
  
  
  <div class="form-group col-md-6">
    <div class="card-body">
      <h5 class="card-title">Card title</h5>
      <p class="card-text">Here There Are Many Product And u Can Search About any Product Here Just click on Search and u will Find ur Product if it is here.</p>
      <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
    </div>
  </div>
 


<div class="form-group col-md-3">
    <div class="card-body">
      
      <div class="list-group">
      <a href="#" class="list-group-item list-group-item-action active">
       Tools
     </a>
     <a href="#" class="list-group-item list-group-item-action">Add Products</a>
     <a href="ShowClient" class="list-group-item list-group-item-action">Show All Clients</a>
     <a href="#" class="list-group-item list-group-item-action">My Profile</a>
     
     </div>
    </div>
  </div>
 

</div>
 
</div>


</body>
</html>