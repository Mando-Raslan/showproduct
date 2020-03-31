<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginForm</title>


<link rel="stylesheet" href="css/bootstrap.min.css" >


</head>
<body>
 <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
 <script src="js/bootstrap.min.js" ></script>
<%

response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", 0);
if(session.getAttribute("user")!=null){
	
	response.sendRedirect("profile.jsp");
}


%>






<div class="container">
<%@include file="navbar.html"%>

<br><br>
<form action="Login" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="Enter email" required="required">
    <small id="email" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Password" required="required">
  </div>
  <br>
  <button   type="submit" class="btn btn-primary btn-lg btn-block">   Sign In </button>
    
  
 
</form>

<br>
<a href="registerform.jsp" class="btn btn-primary btn-lg btn-block"> Sign Up   </a>

</div>



</body>
</html>