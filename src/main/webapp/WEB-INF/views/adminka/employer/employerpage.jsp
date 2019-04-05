<jsp:include page="/WEB-INF/views/adminka/employer/res/header.jsp" />
<jsp:include page="/WEB-INF/views/adminka/employer/res/menu.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  


<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Jobs" %>
<%@ page import="dao.Jobs_Dao" %>

<div class="col-9 col-m-12">

<% String sessionLogin ="";
   int session_uid=-1;
if (session.getAttribute("login")!=null) 
{  sessionLogin = session.getAttribute("login").toString();
    session_uid = (Integer)session.getAttribute("user_id");
}

%>
<h1>Welcome employer <%=sessionLogin %></h1> 

<h1>Jobs List</h1> 

 <font color="green">${msgJobDeleteOk} </font>	
 <font color="red">${msgJobDeleteError}</font>
<br><a href="insertJobByEmployerPage"> Add Job</a> <br> <br>
<table class="simple">  
<tr><th>Id</th>
<th>title</th>
<th>compensation</th>
<th>description</th>

 <!--// 
<th>education</th>
<th>responsibilities</th>
<th>qualification</th>

<th>skills</th> 

//-->
<th> u_id</th> 
<th>jobstatus</th>  
<th>emp type</th> 

<th>benefits</th> 
<th>contact_info</th> 
<th>date posted</th> 
<th>city, state</th> 
<th colspan="2">Action</th>
</tr>  
   <c:forEach var="jobs" items="${list_jobs_employer}">   
   <tr>  
   <td class='bgadmin'>${jobs.id}</td>  
   <td class='bgadmin'>${jobs.title}</td>  
   <td class='bgadmin'>${jobs.compensation}</td>    
   <td class='bgadmin'>
   
  	 
     ${jobs.description}
     
  <% 
  /*
 List<String> job_descriptions = (List<String>)request.getAttribute("job_descriptions"); 
 String description = job_descriptions.get(counter) ; 
 out.println(addShowMoreForDescription(description) ); // TODO get Freedom with this variable  
 counter++;
 */
%>



 </td> 
  
   <td class='bgadmin'>${jobs.u_id}</td>
   
   <td class='bgadmin'>  
   
      
 <c:set var="job_status"  value ="${jobs.jobstatus_id}" ></c:set>  
  
  <select id="jobstatus_id" name="jobstatus_id"> 
     
  <c:choose> 
         
    <c:when test="${job_status == '1'}">  
       
        <option value="${job_status}" selected > ${list_jobstatus[0].name}</option> 
        
        <option value="3" > ${list_jobstatus[2].name}</option> 
    </c:when> 
    
    
     
    <c:when test="${job_status == '3'}">  
      <option value="1" > ${list_jobstatus[0].name}</option> 
        
        <option value="${job_status}" selected > ${list_jobstatus[2].name}</option>    
    </c:when> 
   
</c:choose>   
     
  </select>
  
    
 <c:choose>      
    <c:when test="${job_status == '1'}">  
       ${list_jobstatus[0].name}
    </c:when> 
    
    <c:when test="${job_status == '2'}">  
       ${list_jobstatus[1].name}  
    </c:when> 
    
    <c:when test="${job_status == '3'}">  
       ${list_jobstatus[2].name}  
    </c:when> 
   
</c:choose>  
   
   
   
   
   </td>  
   

<td class='bgadmin'>${jobs.employmenttype_id}</td> 
<td class='bgadmin'>${jobs.benefits}</td> 
<td class='bgadmin'>${jobs.contact_info}</td> 
<td class='bgadmin'>${jobs.date_publication}</td> 
<td class='bgadmin'>${jobs.city}, 

<c:forEach var="states" items="${list_states}"> 
      <c:if test = "${states.st_id==jobs.state_id}">
         ${states.name}
      </c:if>

</c:forEach> 

</td>
   <script src="${jquery_min}"></script>
   <td class='bgadmin'><a href="#"   onclick='updateJobsConfirmationByEmployer("${jobs.id}")'>Edit</a> </td>
   <td class='bgadmin'><a href="#"   onclick='deleteJobsConfirmationEmployer("${jobs.id}")'>Delete</a> </td>   
   </tr>  
   </c:forEach>  
   </table>  
   <br/> 






</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />

<%!


 public String addShowMoreForDescription(String description)
{
	if (description.length()>=100 )
	{  description = "<div class='more'>"+description+"</div>"  ;

          return description;
     }
   else 
	      return description;	
	
}


%>


