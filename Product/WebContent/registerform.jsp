<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" >

</head>
<body>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script src="js/bootstrap.min.js" ></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", 0);
if(session.getAttribute("user")!=null){
	
	response.sendRedirect("profile.jsp");
	
}


%>


<div class= "container">
<%@include file="navbar.html"%>


<br><br>


<form action= "Register"  method="post" enctype="multipart/form-data" class="was-validated">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="	email">Email</label>
      <input type="email" class="form-control" name="email" placeholder="Email" required="required">
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group col-md-6">
      <label for="password">Password</label>
      <input type="password" class="form-control" name="password" placeholder="Password" required="required">
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
  </div>
  <div class="form-group">
    <label for="address">Address</label>
    <input type="text" class="form-control" name="address" placeholder="1234 Main St" required="required">
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  <div class="form-group">
    <label for="phone">Phone</label>
    <input type="number" class="form-control" name="phone" placeholder="+00" required="required">
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  
  <div class="form-row">
  
  
      <div class="form-group col-md-4">
    
      <label for="inputState">Country</label>
      <select name="Country" class="form-control" required="required">
        <option selected>Egypt</option>
        <option>Iraq</option>
        <option>United Status</option>
        <option>Russia</option>
      </select>
      
    </div>
  
    <div class="form-group col-md-4">
      <label for="inputState">State</label>
      <select name="state" class="form-control" required="required">
        <option selected>Single</option>
        <option>Married</option>
      </select>
    </div>
    
    
   <div class="form-group col-md-4">
      <label for="Gender">Gender</label>
      <select name="Gender" class="form-control" required="required">
        <option selected>Male</option>
        <option>Female</option>
      </select>
    </div>
    
  
  
  
  </div>
  

  <br>
   <div class="custom-file">
    <input type="file" class="custom-file-input" name="photo" required="required">
    <label class="custom-file-label" for="photo">Choose Image</label>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
     
  </div>
 
 
 
 <br><br>
 
 <div class="form-row">
  <div class="form-group col-md-6">
  
  <button type="submit" class="btn btn-primary btn-lg btn-block">Sign Up</button>
  
  </div>
 <div class="form-group col-md-6">
  
  <a href="loginform.jsp" class="btn btn-primary btn-lg btn-block">Go To login</a>
  
  </div>
 
 </div>
  
     
</form>

</div>
</body>
</html>