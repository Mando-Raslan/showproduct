<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editing</title>
<link rel="stylesheet" href="css/bootstrap.min.css" >

</head>

<body>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script src="js/bootstrap.min.js" ></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="mohamed.*" %>
<%@page import="java.util.List" %>

<%

response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", 0);

if(session.getAttribute("user")==null){
	
	
	response.sendRedirect("loginform.jsp");
	
}else{
	
	int id                    = Integer.parseInt(request.getParameter("id"));
	ProductModel productModel = ApiClass.getProduct(id);
	
	if(productModel!=null){
		
		session.setAttribute("product", productModel);
		
	}
	
	
}


%>




<div class= "container">
<%@ include file="navbarProfile.html" %>

<br><br>


<form action= "UpdateProduct"  method="post" enctype="multipart/form-data" class="was-validated">
  
  <div class="form-group">
    <label for="productName">Product Name</label>
    <input type="text" class="form-control" name="productName" value="${product.getProductName()}" required="required">
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
 
 
 <div class="form-group">
    <label for="description">Description</label>
    <input type="text" class="form-control" name="description" value="${product.getDescription()}" required="required">
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
 
 
   <div class="custom-file">
    <input type="file" class="custom-file-input" name="photo" required="required" >
    <label class="custom-file-label" for="photo">Choose Image</label>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
     
  </div>
 
  
 
 <br><br>
 
 <div class="form-row">
  <div class="form-group col-md-6">
  
  <button type="submit" class="btn btn-primary btn-lg btn-block">Done edited</button>
  
  </div>

 </div>
  
     
</form>

</div>




</body>
</html>