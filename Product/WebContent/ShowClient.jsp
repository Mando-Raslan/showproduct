<%@page import="mohamed.ApiClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Client</title>
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
if(session.getAttribute("user")== null){
	
	response.sendRedirect("loginform.jsp");
	
}else{
	
	
	 List <User> clients = ApiClass.getAllClients();
	 session.setAttribute("clients", clients);
	
	
}





%>


<div class="container">

<%@ include file="navbarProfile.html" %>

<br>


<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">Photo</th>
      <th scope="col">Email</th>
      <th scope="col">address</th>
      <th scope="col">Country</th>
      <th scope="col">state</th>
      <th scope="col">Gender</th>
      <th scope="col">AdminorUser</th>
      <th scope="col">delete</th>
      
    </tr>
  </thead>
  
  <c:forEach var="client" items="${clients}">
  
  
  <tbody>
    <tr>
     <td><img src="data:image/jpg;base64,${client.getBase64()} " width="200" height="120"/></td>
      <td>${client.getEmail()}</td>
      <td>${client.getAddress() }</td>
      <td>${client.getCountry()}</td>
      <td>${client.getState() }</td>
      <td>${client.getGender()}</td>
      <td>${client.getAdminorUser() }</td>
      <td> <a href="DeleteClient?id=${client.getId()}"> delete client </a> </td>
      
    </tr>
  </tbody>
  
  
  </c:forEach>
  
  
</table>


</div>





</body>
</html>