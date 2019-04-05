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

 <center>
        <h2>The file(s) was uploaded successfully!</h2>
  </center>	

</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
