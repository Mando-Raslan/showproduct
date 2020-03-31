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







<div class="container">
<%@include file="navbar.html"%>

<br><br>
<form>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <br>
  <button   type="button" class="btn btn-primary btn-lg btn-block">   Sign In </button>
    
  
 
</form>

<br>
<a href="registerform.jsp" class="btn btn-primary btn-lg btn-block"> Sign Up   </a>

</div>



</body>
</html>