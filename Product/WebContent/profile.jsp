<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
<link rel="stylesheet" href="css/bootstrap.min.css" >

</head>
<body>
<%@ include file="navbarProfile.html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="mohamed.*" %>
<%@page import="java.util.List" %>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script src="js/bootstrap.min.js" ></script>


<%

response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", 0);

if(session.getAttribute("user")==null){
	
	
	response.sendRedirect("loginform.jsp");
	
	
}else{
	
	
	User user             = (User)session.getAttribute("user");
	String userOrAdmin    = user.getAdminorUser();
	if(userOrAdmin.equals("user")){
		response.sendRedirect("userprofile.jsp");
	}
	
	
	List <ProductModel> allRecords = ApiClass.getAllProduct();
	if(allRecords!=null){
		
		session.setAttribute("product", allRecords);
		
	}
	
	
}


%>




<div class="card-group">
<div class="form-row">

 <div class="form-group col-md-3">
  <img src="data:image/jpg;base64,${user.getBase64()} " width="300" height="200"/>
    <div class="card-body">
      <h5 class="card-title">${user.getEmail()}</h5>
      <p class="card-text">${user.getAddress()}</p>
      <p class="card-text">${user.getGender()}</p>
      <p class="card-text">${user.getState()}</p>
      <p class="card-text"><small class="text-muted">Admin Active Now</small></p>
    </div>
  </div>
  
  
  <div class="form-group col-md-6">
  
  <c:forEach var="productObject" items="${product}">
  
   
    <div class="card-body">
      <h5 class="card-title">${productObject.getProductName()}</h5>
      <br>
      <img src="data:image/jpg;base64,${productObject.getBase64()} " width="600" height="150"/>
      <br><br>
      <p class="card-text">${productObject.getDescription()}</p>
      <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      
      
        <div class="form-row">
    <div class="form-group col-md-6">
      <a href="DeleteProduct?id=${productObject.getId()}" class="btn btn-primary btn-lg btn-block">Delete</a>
    </div>
    <div class="form-group col-md-6">
      <a href="EditProductForm.jsp?id=${productObject.getId()}" class="btn btn-primary btn-lg btn-block">Edit</a>
    </div>
  </div>
      
      
      
        
      
    </div>
  
  </c:forEach>
 
  </div>
 


<div class="form-group col-md-3">
    <div class="card-body">
      
      <div class="list-group">
      <a href="#" class="list-group-item list-group-item-action active">
       Tools
     </a>
     <a href="addproductform.jsp" class="list-group-item list-group-item-action">Add Products</a>
     <a href="ShowClient.jsp" class="list-group-item list-group-item-action">Show All Clients</a>
     <a href="#" class="list-group-item list-group-item-action">My Profile</a>
     
     </div>
    </div>
  </div>
 

</div>
 
</div>



<h1> User Profile </h1>

</body>
</html>