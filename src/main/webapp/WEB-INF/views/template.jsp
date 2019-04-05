<!--// HEADER //-->
<jsp:include page="/resources/theme_oldgeek/header.jsp" />
<!--// HEADER END //-->

<!--// right menu //-->
<jsp:include page="/resources/theme_oldgeek/menuLeft.jsp" />
<!--// right menu END //-->

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<div class="col-6 col-m-9">





<center>
		<h2>Choose your dream Job </h2>
</center>		
<table width="47%">
<tr>
  <td>
   <c:forEach var="jobs" items="${list_jobs}">   
 <div class="job" id="job" > 
   <h3>${jobs.title}</h3>  
      
   <p>${jobs.description}   </p>
   
   <br>
   <a href="jobPage?id=${jobs.id}" target="new"> Job info >> </a>
   <p>${jobs.date_publication}</p> 
 
 </td>
 </tr> 
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
   <hr>
  </div>
   </c:forEach>  	

</table>

</div> <!--// col-6 col-m-9 //-->




<!--// right menu //-->
<jsp:include page="/resources/theme_oldgeek/menuRight.jsp" />
<!--// right menu END //-->

<jsp:include page="/resources/theme_oldgeek/footer.jsp" />