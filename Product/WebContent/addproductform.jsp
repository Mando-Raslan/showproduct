<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Product</title>
<link rel="stylesheet" href="css/bootstrap.min.css" >
</head>
<body>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script src="js/bootstrap.min.js" ></script>

<%

response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", 0);

if(session.getAttribute("user")==null){
	
	
	response.sendRedirect("loginform.jsp");
	
}


%>

<div class= "container">
<%@ include file="navbarProfile.html" %>

<br><br>


<form action= "AddProduct"  method="post" enctype="multipart/form-data" class="was-validated">
  
  <div class="form-group">
    <label for="productName">Product Name</label>
    <input type="text" class="form-control" name="productName"  required="required">
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
 
 
 <div class="form-group">
    <label for="description">Description</label>
    <input type="text" class="form-control" name="description"  required="required">
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
 
 
   <div class="custom-file">
    <input type="file" class="custom-file-input" name="photo" required="required">
    <label class="custom-file-label" for="photo">Choose Image</label>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
     
  </div>
 
  
 
 <br><br>
 
 <div class="form-row">
  <div class="form-group col-md-6">
  
  <button type="submit" class="btn btn-primary btn-lg btn-block">Add Product</button>
  
  </div>

 </div>
  
     
</form>

</div>



</body>
</html>