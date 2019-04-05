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
<tr><th>Id</th>
<th>Name</th></tr> 
 
   <c:forEach var="emptype" items="${list_emptype}">   
   <tr>  
   <td>${emptype.et_id}</td>  
   <td>${emptype.name}</td>      
    
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  


</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
