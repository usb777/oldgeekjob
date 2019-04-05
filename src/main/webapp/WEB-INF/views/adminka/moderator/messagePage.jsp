<jsp:include page="/WEB-INF/views/adminka/moderator/res/header.jsp" />
<jsp:include page="/WEB-INF/views/adminka/moderator/res/menu.jsp" />
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

<h1>Welcome SuperAdmin aka "<%=sessionLogin %>" <%=session.getAttribute("login") %> </h1>

 
  
<h1>Messages</h1> 

<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>From</th><th>To</th><th>Title</th><th>Message</th><th>Contact</th><th>Date</th>
<th>Status</th><th>Attached</th>
<th>Edit</th>
<th>Delete</th>
</tr>  
   <c:forEach var="messages" items="${list_messages}">   
   <tr>  
   <td>${messages.m_id}</td>  
   <td>${messages.from_id}, ${messages.sender}</td>    
	<td>${messages.to_id},${messages.receptor}</td> 
	<td>${messages.title}</td> 
	<td>${messages.message}</td> 
	<td>${messages.contact}</td> 	
	<td>${messages.date_message}</td> 
	<td>${messages.status}</td>
	<td>${messages.attach_url}</td>
	
 
   <th><a href="#"   onclick='updateUsersConfirmationSA("${users.u_id}")'>Edit</a> </th>
   <th><a href="#" onclick='deleteUsersConfirmationSA("${users.u_id}")'>Delete</a> </th>   
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  

</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
