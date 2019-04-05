<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Tipo Helloworld


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="role_user" items="${list}">   
   <tr>  
   <td>${role_user.role_id}</td>  
   <td>${role_user.name}</td>  
   <td>2</td>  
   <td>3</td>  
   <td><a href="">Edit</a></td>  
   <td><a href="">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
  


</body>
</html>