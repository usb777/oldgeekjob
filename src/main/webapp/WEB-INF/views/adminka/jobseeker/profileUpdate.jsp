<jsp:include page="/WEB-INF/views/adminka/jobseeker/res/header.jsp" />
<jsp:include page="/WEB-INF/views/adminka/jobseeker/res/menu.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

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
<h3>Update Profile</h3>
<br>
	
<a href="${currentProfile.resume_url}" target="new" >Resume</a>
 <a href="profileResumeUploadPage"> Upload new resume (with replace)</a><br>	
 
<form action="updateProfileByJobSeeker" method = "GET"  >

<input type="hidden" id="p_id" name="p_id" value="${currentProfile.p_id}">
<input type="hidden" id="u_id" name="u_id" value="${currentProfile.u_id}">
<input type="hidden" id="resume_url" name="resume_url" value="${currentProfile.resume_url}">

<label for="description" >About Me (Skills, Qualification)</label><br>		
<textarea name = "description"  rows="15" cols="100" >${currentProfile.description}</textarea>	<br><br>


<label for="linkedin" >Linkedin Url </label><br>
<input type="text" name = "linkedin" value="${currentProfile.linkedin}" size="55" /><br><br>

<label for="github" >GitHub Url</label><br>
<input type="text" name = "github" value="${currentProfile.github}" size="55" /><br><br>
<!--MADE IT LATER Date date_modification; -->
<input type="submit" value ="Update Profile">  
</form>
	

</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
