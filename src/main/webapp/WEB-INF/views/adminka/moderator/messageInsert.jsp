<jsp:include page="/WEB-INF/views/adminka/moderator/res/header.jsp" />
<jsp:include page="/WEB-INF/views/adminka/moderator/res/menu.jsp" />
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
  
  <form action="sendMessageByAdmin" method = "GET"  >
		<label for="to_user" > To: </label><br>	
			<!-- Load users SELECT -->
		<label for="title" > Title </label><br>
		<input type="text" name = "title"  /><br><br>		
			
		<label for="message" > Message </label><br>
		<textarea name = "message"  rows="15" cols="100" >Write your message</textarea>		<br><br>		
<label for="contact" > Message </label><br>
		<textarea name = "contact"  rows="5" cols="100" >Write your message</textarea>		<br><br>		
				
		<input type="hidden" id="state_id" name="state_id" value="1" >	
	
	<!-- Attachment -->
	
	<input type="submit" value="Insert New Job">
	</form>			

</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
