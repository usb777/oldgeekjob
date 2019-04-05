<jsp:include page="/WEB-INF/views/adminka/jobseeker/res/header.jsp" />
<jsp:include page="/WEB-INF/views/adminka/jobseeker/res/menu.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<div class="col-9 col-m-12">

<% 
	String sessionLogin ="";
	if (session.getAttribute("login")!=null) {  sessionLogin = session.getAttribute("login").toString();}
%>   
<h1>Welcome Job Seeker <%=sessionLogin %></h1> 
<h3>Your Outbox Messages</h3>
<br>


<table class="smalltable">  
<tr><th>Id</th><th>To</th><th>Title</th><th>Message</th><th>Contact</th><th>Date</th>
<!-- <th>Status</th><th>Attached</th>  -->
<th>Answer</th>
<th>Delete</th>
</tr>  
   <c:forEach var="messages" items="${list_jobseekermessages}">   
   <tr>  
   <td class="bgadmin">${messages.m_id}</td>  
   <td class="bgadmin">${messages.receptor}</td>    	
	<td class="bgadmin">${messages.title}</td> 
	<td class="bgadmin">${messages.message}</td> 
	<td class="bgadmin">${messages.contact}</td> 	
	<td class="bgadmin">${messages.date_message}</td> 
<!-- <td>${messages.status}</td>
	<td>${messages.attach_url}</td>
	 -->	
 
   <td class="bgadmin"><a href="#" >Write to recipient</a> </td>
    <td class="bgadmin"><a href="#" 
    onclick='deleteOutMsgByJobSeeker("${messages.m_id}")'>Delete</a> 
    </td>
   </tr>  
   </c:forEach>  
   </table>  
   <br/> 




</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
