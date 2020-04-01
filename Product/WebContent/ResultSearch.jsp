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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="mohamed.*" %>
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%

response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", 0);

if(session.getAttribute("user")==null){
	
	response.sendRedirect("loginform.jsp");
	
}else{
	
	
String search                = request.getParameter("search");
List<ProductModel> allData   = ApiClass.Searching(search);
session.setAttribute("productSerach", allData);
	
}


%>


<div class="container">

<%@ include file="navbarProfile.html" %>
<br>

  
  
  
<div class="row">
  <div class="col-sm-8">
    <div class="card">
    
    <c:forEach var="Obj" items="${productSerach}">
    
     <div class="card-body">
      
        <img src="data:image/jpg;base64,${Obj.getBase64() } " width="600" height="150"/> 
        <h5 class="card-title">${Obj.getProductName()}</h5>
        <p class="card-text">${ Obj.getDescription()}</p>
        
      </div>
    
    
    </c:forEach>
    
     
    </div>
  </div>




</div>




</div>





</body>
</html>