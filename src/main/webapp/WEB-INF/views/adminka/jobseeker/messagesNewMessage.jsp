<jsp:include page="/WEB-INF/views/adminka/jobseeker/res/header.jsp" />
<jsp:include page="/WEB-INF/views/adminka/jobseeker/res/menu.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<div class="col-9 col-m-12">

<% String sessionLogin ="";

if (session.getAttribute("login")!=null) 
{  sessionLogin = session.getAttribute("login").toString();
	
}

%>

<h1>Welcome JobSeeker aka "<%=sessionLogin %>" <%=session.getAttribute("login") %> </h1>

<h1>New Message</h1>
  
  <form action="sendMessageByJobSeeker" method = "GET"  >
 		 
		<input type="hidden" id="from_id" name="from_id" value="<%=session.getAttribute("user_id") %>" >

		<!-- Load users SELECT -->
				
				
				
				
		<select id="to_id" name="to_id">   		    	
  			   
  			  
  <c:forEach var="users" items="${list_users}">     	
      <option value="${users.u_id}">"${users.login}" ${users.fname} ${users.lname}</option>         
  </c:forEach> 	  
  			  
  			  
  			  				
  		</select><br><br>
		
		<label for="title" > Title </label><br>
		<input type="text" name = "title"  /><br><br>		
			
		<label for="message" > Message </label><br>
		<textarea name = "message"  rows="15" cols="100" >Write your message</textarea>		<br><br>		

        <label for="contact" >Contact</label><br>
		<textarea name = "contact"  rows="5" cols="100" >Write your message</textarea>		<br><br>		
		
		
		<input type="hidden" id="date_message" name="date_message" value="2017-06-06" >		
		<input type="hidden" id="status" name="status" value="0" >	
	<!-- Attachment -->
	    <input type="hidden" id="attach_url" name="attach_url" value="attach_url" >	
	
	
	<input type="submit" value="Send Message">
	</form>			

</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
