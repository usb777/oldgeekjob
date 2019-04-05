<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  
<spring:url value="/adminka/jobseeker/css/style.css" var="style" />
<spring:url value="/adminka/jobseeker/js/deleteConf.js" var="deleteConf" />

<spring:url value="/adminka/jobseeker/js/updateConf.js" var="updateConf" />
<spring:url value="/adminka/jobseeker/js/jquery.js" var="jquery" />
<spring:url value="/adminka/jobseeker/js/jquery_min1_11_2.js" var="jquery_min" />

<spring:url value="/adminka/jobseeker/js/showmore.js" var="showmore" />
<spring:url value="/adminka/jobseeker/js/showme.js"   var="showme" />
<spring:url value="/adminka/jobseeker/images/" var="ims" />

<!-- 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
 -->
<link href="${style}" rel="stylesheet" />

<script src="${jquery}"></script>
<script src="${jquery_min}"></script>
<script src="${deleteConf}"></script>
<script src="${updateConf}"></script>
<script src="${showme}"></script>
<script src="${showmore}"></script>



</head>
<body>



<div class="header">
<h1>OldGeekJob</h1>
</div>

<div class="row">