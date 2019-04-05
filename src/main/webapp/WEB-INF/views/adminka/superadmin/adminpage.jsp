<jsp:include page="/WEB-INF/views/adminka/superadmin/res/header.jsp" />
<jsp:include page="/WEB-INF/views/adminka/superadmin/res/menu.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<div class="col-9 col-m-12">

<% 

String sessionLogin ="";
if (session.getAttribute("login")!=null) 
{  
	sessionLogin = session.getAttribute("login").toString();
}
%>

<h1>Users List</h1> 
<h3>${insertUserOk} </h3>


<a href="insertUserByAdminPage"> Add User    <img src="<c:url value="/resources/images/add.gif"  />" alt="ADD user"  /></a> <br> <br>
<table class="simple">  
<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Login</th>
<th>Hashed Password</th>
<th>Email</th>
<th>telefona</th>
<th>Role</th>
<th>Edit</th>
<th>Delete</th>
</tr>  
   <c:forEach var="users" items="${list_users}">   
   <tr>  
   <td width='5%' class='bgadmin'>${users.u_id}</td>  
   <td width='10%' class='bgadmin'>${users.fname}</td>  
   <td width='10%' class='bgadmin'>${users.lname}</td>  
   <td width='10%' class='bgadmin'><b>${users.login}</b></td> 
   <td width='10%' class='bgadmin'><b>--Hashed--</b></td>    
   <td width='10%' class='bgadmin'> ${users.email}</td>  
   <td width='10%' class='bgadmin'>${users.telefona}</td>
   <td width='10%' class='bgadmin'>
   
      
  <c:set var="role_users"  value ="${users.role_id}" ></c:set>  
      
 <c:choose>      
    <c:when test="${role_users == '1'}">  
       ${list_role_users[0].name}  
    </c:when> 
     
   <c:when test="${role_users == '2'}">  
       ${list_role_users[1].name}  
    </c:when>
      
   <c:when test="${role_users == '3'}">  
       ${list_role_users[2].name}  
    </c:when>
      <c:when test="${role_users == '4'}">  
       ${list_role_users[3].name}  
    </c:when>
</c:choose>  
      
    </td>
   <td class='bg'>
       <a href="#"   onclick='updateUsersConfirmationSA("${users.u_id}")'> 
         <img src="<c:url value="/resources/images/edit.gif" />" alt="edit" class="center"  />
       </a> 
   </td>
   
   <td class='bgadmin'>
     <a href="#"   onclick='deleteUsersConfirmationSA("${users.u_id}")'> 
        <center>  <img src="<c:url value="/resources/images/delete.gif"  />" alt="delete"  /></center>
     </a> 
   </td>
      
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
 <c:set var="role_users"  value ="25" ></c:set> 
 
  




</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
