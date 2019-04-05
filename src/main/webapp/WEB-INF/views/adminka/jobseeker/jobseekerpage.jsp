<jsp:include page="/WEB-INF/views/adminka/jobseeker/res/header.jsp" />
<jsp:include page="/WEB-INF/views/adminka/jobseeker/res/menu.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<spring:url value="/adminka/jobseeker/images/" var="ims" />
<div class="col-9 col-m-12">

<% 

String sessionLogin ="";
int sessionuid=-1;
if (session.getAttribute("login")!=null) 
{  
	sessionLogin = session.getAttribute("login").toString();
	 sessionuid = Integer.valueOf(session.getAttribute("user_id").toString() );
}
%>
   <%=sessionuid %>
<h1>Welcome Job Seeker <%=sessionLogin %></h1> 
<h3>List Assigned Jobs of jobseeker "<%=sessionLogin %>" </h3>

<%
/*
ja.ja_id, 
ja.job_id, 
ja.u_id, 
ja.date_assignment, 
jobs.title AS job_title, 
jobseeker.login as jobseeker, 
jobs.date_publication as job_postdate, 
employer.login as employer  
*/
%>
<table class="simple">  
<tr><th>Id</th>
<th>Employer</th>
<th>Job Title(Click for description)</th>
<th>Job Post Date</th>
<th> Date Assignment</th> 
<th >Delete</th>

</tr>  
   <c:forEach var="assignedjobs" items="${list_assignedjobs}">   
   <tr>  
   <td class='bgadmin'>${assignedjobs.ja_id}</td>  
   <td class='bgadmin'>${assignedjobs.employer}</td>  
   <td class='bgadmin'><a href="jobPage?job_id=${assignedjobs.job_id}" target="new" >${assignedjobs.job_title}</a></td>    
   <td class='bgadmin'><div class="center" > <b>${assignedjobs.job_postdate}</b></div></td>   
   <td class='bgadmin'><div class="center" > ${assignedjobs.date_assignment}</div></td>  
   
   <td class='bgadmin'>
   
   <a href="#"   onclick='deleteAJobsConfirmationJobSeeker("${assignedjobs.ja_id}")'>
    <img src="<c:url value="/resources/images/delete.gif" />" alt="delete" class="center" />
    </a>
    
    </td>   
   </tr>  
   </c:forEach>  
   </table>  


</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
