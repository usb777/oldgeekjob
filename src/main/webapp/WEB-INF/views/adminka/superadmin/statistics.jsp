<jsp:include page="/WEB-INF/views/adminka/superadmin/res/header.jsp" />
<jsp:include page="/WEB-INF/views/adminka/superadmin/res/menu.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<div class="col-9 col-m-12">

<% 

String sessionLogin ="";
if (session.getAttribute("login")!=null) 
{  
	sessionLogin = session.getAttribute("login").toString();
}
%>

<h1>Statistics</h1> 

  
<table border="2" width="50%" cellpadding="2">  
<tr><th>Number of</th><th>TOTAL:</th></tr>      
   <tr>  
   <td><b>Employers</b></td>   <td>${totalEmployers}</td>   
   </tr>  
   
   <tr>   
   <td><b>JobSeekers</b></td>       <td>${totalJobSeekers}</td>
   </tr>  
   
   <tr>
   <td><b>Jobs</b></td>       <td>${totalJobs}</td>
   </tr>  
   
   <tr>
   <td><b>Active Jobs</b></td>       <td>${totalActiveJobs}</td> 
   </tr>
      
   </table>  

</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
