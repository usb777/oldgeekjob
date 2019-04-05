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
		<h1>Job Description </h1>
</center>
		
  
    <c:set var="job"  value ="${job}" ></c:set> 
    
 <div class="job" id="job" > 
 
   <h2>${job.title}</h2>     
   
  <p> ${job.city}, ${job.state_id}<br> </p>
    
   <p>posted: ${job.date_publication}</p>      
   <p><b>Description:</b> ${job.description}   </p>  
  
    
   <b>${job.education}</b>   <br> 
  <p> <b>Responsibilies:</b> ${job.responsibilities} <br> </p> 
   <p><b>Qualification:</b>${job.qualification}<br> </p> 
   <p><b>Skills:</b>${job.skills}<br><br> </p> 
  <!--   
   ${job.u_id}<br> - take this parameter for employer
   ${job.jobstatus_id}  <br>
   ${job.employmenttype_id} <br>
   -->
  <p><b>Benefits:</b> ${job.benefits} <br></p>
   ${job.contact_info}<br>
  

  
  </div>
    
 <% 
 String sessionRoleId ="";
int s_roleid = 0;
if (session.getAttribute("role_id")!=null) 
{   sessionRoleId = session.getAttribute("role_id").toString();
    s_roleid = Integer.valueOf(session.getAttribute("role_id").toString());
	//out.print(s_roleid);
	
	if (s_roleid==4) 
	{
		
		//out.println("<br><br><input type='button' value='Apply'>") ;
		out.println("<br><br><form action='AssignToJob' method='POST'>") ;
		
		out.println("<br><input type='hidden' name='job_id' value='"+request.getAttribute("job_id")+"'>") ;
	
		if (request.getAttribute("applyButtonVisible").equals("1") )
		{	
		out.println("<br><br><input type='submit' value='Apply'>") ;
		}
		
		else 
		{
			out.println("<br><br><input type='submit' value='Applied' disabled>") ;
		}
		
		out.println("<br><br></form>") ;
		
	}
	else 
	{
		out.println("<br><br><b>Only Job Seekers can apply for this Job!</b>") ;
	}
	
}

else 
{
	out.println("<br><br><b>Only Job Seekers can apply for this Job!</b>"+ 
	"<br> Please register ==> <a href='register'> Register </a> ") ;
	}

%>
    
 

</div> <!--// col-6 col-m-9 //-->




<!--// right menu //-->
<jsp:include page="/resources/theme_oldgeek/menuRight.jsp" />
<!--// right menu END //-->

<jsp:include page="/resources/theme_oldgeek/footer.jsp" />