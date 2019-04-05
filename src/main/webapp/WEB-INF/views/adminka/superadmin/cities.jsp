<jsp:include page="/WEB-INF/views/adminka/superadmin/res/header.jsp" />
<jsp:include page="/WEB-INF/views/adminka/superadmin/res/menu.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<div class="col-9 col-m-12">

<% String sessionLogin ="";
if (session.getAttribute("login")!=null) 
{  sessionLogin = session.getAttribute("login").toString();
	}

%>


<h1>Employment types</h1> 

<table border="2" width="50%" cellpadding="2">  
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Zip</th>
	<th>State_ID</th>
	
	
</tr> 
 
   <c:forEach var="cities" items="${list_cities}">   
   <tr>  
   <td>${cities.city_id}</td>  
   <td>${cities.name}</td> 
   <td>${cities.zip}</td> 
   <td>${cities.st_id}</td> 
   
        
    
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  


</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
