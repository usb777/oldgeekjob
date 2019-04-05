<jsp:include page="/WEB-INF/views/adminka/moderator/res/header.jsp" />
<jsp:include page="/WEB-INF/views/adminka/moderator/res/menu.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<div class="col-9 col-m-12">

<% String sessionLogin ="";
if (session.getAttribute("login")!=null) 
{  sessionLogin = session.getAttribute("login").toString();
	}

%>

<h1>Job Update</h1> 
  
  <form action="updateJobByAdmin" method = "GET"  >
		<input type="hidden" id="id" name="id" value="${currentJob.id}">
		
		<label for="jobstatus_id" > Job Status </label><br>
	<!--// 
				TODO text == jobstatus name
		<input type="hidden" id="jobstatus_id" name="jobstatus_id" value="${currentJob.jobstatus_id}"> 
	//-->
			<select id="jobstatus_id" name="jobstatus_id"> 
			
  <c:forEach var="job_status" items="${list_jobstatus}">     	
       <c:choose>         
         <c:when test = "${job_status.js_id == currentJob.jobstatus_id}">
           <option value="${job_status.js_id}" selected > ${job_status.name}</option> 
         </c:when>         
         <c:when test = "${job_status.js_id != currentJob.jobstatus_id}">
             <option value="${job_status.js_id}"  > ${job_status.name}</option> 
         </c:when>         
         <c:otherwise>
             <option value="${job_status.js_id}" > ${job_status.name}</option> 
         </c:otherwise>
      </c:choose>  			       
  </c:forEach>  
  
  			</select>
		<br>
		<small><font-color="red">disabled</font-color> and pending jobs will not available on home page</small> <br></br>
		<br>
		
		<label for="title" > Title </label><br>
		<input type="text" name = "title" value="${currentJob.title}" /><br><br>
		
		<label for="compensation" > Compensation </label><br>
		<input type="text" name = "compensation" value="${currentJob.compensation}" /><br><br>
		
		<label for="description" > Description </label><br>
		<textarea name = "description"  rows="15" cols="100" >${currentJob.description}</textarea>		<br><br>
		
		<label for="education" > Required Education </label><br>
		<input type="text" name = "education" value="${currentJob.education}" size="35" /><br><br>
		
		
		<label for="responsibilities" >Your Responsibility </label><br>		
		<textarea name = "responsibilities"  rows="15" cols="100" >${currentJob.responsibilities}</textarea>		<br><br>
		
		
		<label for="qualification" >Your Qualification </label><br>		
		<textarea name = "qualification"  rows="15" cols="100" >${currentJob.qualification}</textarea>		<br><br>
		
		<label for="skills" >Your Skills </label><br>
		<textarea name = "skills"  rows="15" cols="100" >${currentJob.skills}</textarea>		
		<br><br>
		
		<!--// TODO text == employer name //-->
		
		<input type="hidden" id="u_id" name="u_id" value="${currentJob.u_id}">
		
	
		
		<!--// TODO text == employmenttype name //-->
		<input type="hidden" id="employmenttype_id" name="employmenttype_id" value="${currentJob.employmenttype_id}">
		
		<label for="benefits" >Benefits</label><br>
		<textarea name = "benefits"  rows="15" cols="100" >${currentJob.benefits}</textarea>	
		<br><br>
		<label for="contact_info" >Contact_info</label><br>
		<textarea name = "contact_info"  rows="8" cols="100" >${currentJob.contact_info}</textarea>	
	<br><br>
	<!--// TODO text == date_publication//-->		
		<input type="hidden" id="date_publication" name="date_publication" value="${currentJob.date_publication}">	
		
		<label for="city" > City </label><br>
		<input type="text" name = "city" value="${currentJob.city}" /><br><br>
		
		
			<label for="state_id" > States </label><br>
 
	
    <select id="state_id" name="state_id"> 
  		
   <c:forEach var="states" items="${list_states}">     	
       <c:choose>         
         <c:when test = "${states.st_id == currentJob.state_id}">
           <option value="${states.st_id}" selected > ${states.name}</option> 
         </c:when>         
         <c:when test = "${states.st_id != currentJob.jobstatus_id}">
             <option value="${states.st_id}"  > ${states.name}</option> 
         </c:when>         
         <c:otherwise>
             <option value="${states.st_id}" > ${states.name}</option> 
         </c:otherwise>
      </c:choose>  			       
  </c:forEach> 
  		  
  	 
  		  
  	</select><br><br>
	
	<input type="submit" value="Update this Job">
	</form>			

</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
