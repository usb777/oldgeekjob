<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/style.css" var="style" />
<spring:url value="/resources/js/sample.js" var="sampleJS" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<spring:url value="/resources/images/" var="images" />
<spring:url value="/adminka/jobseeker/images/" var="ims" />

<link href="${style}" rel="stylesheet" />

<script src="${sampleJS}"></script>
 
</head>
<body>

<div class="header">
<h1>OldGeekJob</h1>
<img src ="${ims}/delete.gif" >
</div>

<div class="row">