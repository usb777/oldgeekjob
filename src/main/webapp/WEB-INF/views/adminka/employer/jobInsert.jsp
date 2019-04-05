<jsp:include page="/WEB-INF/views/adminka/employer/res/header.jsp" />
<jsp:include page="/WEB-INF/views/adminka/employer/res/menu.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<div class="col-9 col-m-12">

<% String sessionLogin ="";
if (session.getAttribute("login")!=null) 
{  sessionLogin = session.getAttribute("login").toString();
	
}

%>
User: <%=sessionLogin %> will add Job.
<h1>Job Insert</h1> 
  
  <form action="insertJobByEmployer" method = "GET"  >
			
		<!--// TODO text == jobstatus name 
	   			 <input type="hidden" id="jobstatus_id" name="jobstatus_id" value="1" >	
	    //-->
			<label for="jobstatus_id" > Job Status </label><br>
			
			<select id="jobstatus_id" name="jobstatus_id"> 
  		    	
  			  <option value="1" selected>enabled</option>  
  			  <option value="3">pending</option> 	
  			</select>
  			
		<small>disabled and pending jobs will not available on home page</small> <br></br>
				
			
			<br>	
		<label for="title" > Title </label><br>
		<input type="text" name = "title"  /><br><br>
		
		<label for="compensation" > Compensation </label><br>
		<input type="text" name = "compensation"  /><br><br>
		
		<label for="description" > Description </label><br>
		<textarea name = "description"  rows="15" cols="100" ></textarea>		<br><br>
		
		<label for="education" > Required Education </label><br>
		<input type="text" name = "education"  size="35" /><br><br>
		
		
		<label for="responsibilities" >Your Responsibility </label><br>		
		<textarea name = "responsibilities"  rows="15" cols="100" ></textarea>		<br><br>
		
		
		<label for="qualification" >Your Qualification </label><br>		
		<textarea name = "qualification"  rows="15" cols="100" ></textarea>		<br><br>
		
		<label for="skills" >Your Skills </label><br>
		<textarea name = "skills"  rows="15" cols="100" ></textarea>		
		<br><br>
		
		<!--// TODO text == employer name //-->
		
		<input type="hidden" id="u_id" name="u_id" value ="<%=session.getAttribute("user_id") %>" >
		
		
		
		<!--// TODO text == employmenttype name //-->
		<input type="hidden" id="employmenttype_id" name="employmenttype_id" value="1" >
		
		<label for="benefits" >Benefits</label><br>
		<textarea name = "benefits"  rows="15" cols="100" ></textarea>	
		<br><br>
		<label for="contact_info" >Contact_info</label><br>
		<textarea name = "contact_info"  rows="8" cols="100" ></textarea>	
	<br><br>
	<!--// TODO text == date_publication//-->		
		<input type="hidden" id="date_publication" name="date_publication" >	
		
		<label for="city" > City </label><br>
		<input type="text" name = "city"  /><br><br>
		
		
		<input type="hidden" id="state_id" name="state_id" value="1" >
			
		<input type="submit" value="Insert New Job">
	</form>			

</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
