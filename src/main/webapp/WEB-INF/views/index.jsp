<!--// HEADER //-->
<jsp:include page="/resources/theme_oldgeek/header.jsp" />
<!--// HEADER END //-->

<!--// right menu //-->
<jsp:include page="/resources/theme_oldgeek/menuLeft.jsp" />
<!--// right menu END //-->

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<div class="col-6 col-m-9">





		<h2>Choose your dream Job </h2>
		

<div class="searchbox">
<form action="search" method="POST"> 
<input type="text" name="jobName" placeholder="search by job name">&nbsp;&nbsp;&nbsp; 
<input type="text" name="location" placeholder="search by city, state">
<input type="submit" value="Search">
</form>
</div>
<br> <br>

   <c:forEach var="jobs" items="${list_jobs}">   
  <div class="job" id="job" > 
   <b>${jobs.title}</b> <small>${jobs.city},
    
<c:forEach var="states" items="${list_states}"> 
      <c:if test = "${states.st_id==jobs.state_id}">
         ${states.name}
      </c:if>

</c:forEach> 
     
    
    </small> <br>
    ${jobs.date_publication}
    <br>  <a href="jobPage?job_id=${jobs.id}"   > Job info >> </a> 
    

 
<!--   
   <td><b>${jobs.education}</b></td>    
   <td> ${jobs.responsibilities}</td>  
   <td>${jobs.qualification}</td>
   <td>${jobs.skills}</td>
   <td>${jobs.u_id}</td>
   <td>${jobs.jobstatus_id}</td>  
	<td>${jobs.employmenttype_id}</td> 
	<td>${jobs.benefits}</td> 
	<td>${jobs.contact_info}</td> 
	<td>${jobs.date_publication}</td> 
	<td>${jobs.city}, ${jobs.state_id}</td>
-->

  </div>
  
  <br><br>
   </c:forEach>  	



</div> <!--// col-6 col-m-9 //-->




<!--// right menu //-->
<jsp:include page="/resources/theme_oldgeek/menuRight.jsp" />
<!--// right menu END //-->

<jsp:include page="/resources/theme_oldgeek/footer.jsp" />