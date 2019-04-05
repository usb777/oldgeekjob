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
<h2>Your Resume file</h2>

currentProfile.getResume_url()

<form action="profileResumeUploadAction" method="post" enctype="multipart/form-data" acceptcharset="ISO-8859-1" >
<input type="hidden" id="p_id" name="p_id" value="${currentProfile.p_id}">
<input type="hidden" id="resume_url" name="resume_url" value="${currentProfile.resume_url}">

<h3>Choose file for Upload( PDF or RTF, DOC):</h3> 
<input type="file" name="fileUpload" size="50"  accept="application/msword, application/vnd.openxmlformats-officedocument.wordprocessingml.document, application/pdf" />
<br /><br/>

<input type="submit" value ="Upload Resume">  

</form>
	
	

</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
