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
<h2>Your Profile</h2>

<a href="${profileCurrent.resume_url}"  >Your Resume file</a><br><br>
 <a href="profileResumeUploadPage"> Upload new resume (with replace)</a><br>
 
<h3><a href="updateProfileByJobSeekerPage">Update Profile </a>  </h3>
<b>ID of JobSeeker</b>: ${profileCurrent.u_id}  <br><br>
<b>Description</b>:<br>
<textarea disabled rows="15" cols="100">${profileCurrent.description}</textarea>
<br><br>
<b>Linkedin Url</b>:  <a href="${profileCurrent.linkedin}" target="new">${profileCurrent.linkedin}</a> <br><br>
<b>GitHub Url</b>:  <a href="${profileCurrent.github}" target="new">${profileCurrent.github} </a>	<br><br>
<b>Date of last modification</b>:  ${profileCurrent.date_modification}<br><br> 	
	

</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
