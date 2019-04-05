<jsp:include page="/WEB-INF/views/adminka/superadmin/res/header.jsp" />
<jsp:include page="/WEB-INF/views/adminka/superadmin/res/menu.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<div class="col-9 col-m-12">

<% String sessionLogin ="";
int session_userid =-1;
if (session.getAttribute("login")!=null) 
{  sessionLogin = session.getAttribute("login").toString();
	}
if (session.getAttribute("user_id")!=null) 
{  
	 session_userid = (Integer)(session.getAttribute("user_id") );
}

%>

<h1>Update Data of this User</h1>
<h3>Employer id = <%=session_userid %> </h3>
<form action="updateUserbyAdmin" method="POST">
<input type="hidden" id="u_id" name="u_id" value="${currentUser.u_id}">
<label for="fname" > First Name </label><br>
<input type="text" name="fname" value ="${currentUser.fname}"><br><br>
<label for="lname" > Last Name </label><br>
<input type="text" name="lname" value ="${currentUser.lname}"><br><br>

<label for="login" > Login </label><font color="red">*</font><br>
<input type="text" name="login" value ="${currentUser.login}" ><br><br>

<label for="password" > Password </label><font color="red">*</font><br>
<input type="text" name="password" value ="admin"><br><br>
	
<label for="email" > Email </label><font color="red">*</font><br>
<input type="email" name="email" value ="${currentUser.email}"><br><br>
<label for="telefona" >Telephon </label><br>
<input type="text" name="telefona" value ="${currentUser.telefona}"><br><br>

<label for="role_id" >Choose role of user</label><br>	
<select name="role_id" >

 <c:set var="role_users"  value ="${currentUser.role_id}" ></c:set>  
      
 <c:choose>   
 
  <c:when test="${role_users == '1'}">  
   
       ${list_role_users[0].name} 
       <option value="1"  selected >Administrator</option>
    </c:when>
    
    
   <c:when test="${role_users == '2'}">  
   
       ${list_role_users[1].name} 
      <option value="2"  selected>Moderator</option>
	  <option value="3">Employer</option>
	  <option value="4">JobSeeker</option>
    </c:when>
      
   <c:when test="${role_users == '3'}">  
       ${list_role_users[2].name}  
      <option value="2"  >Moderator</option>
	  <option value="3" selected>Employer</option>
	  <option value="4">JobSeeker</option>
    </c:when>
      <c:when test="${role_users == '4'}">  
       ${list_role_users[3].name}
      <option value="2" >Moderator</option>
	  <option value="3">Employer</option>
	  <option value="4" selected>JobSeeker</option>  
    </c:when>
</c:choose>  
  
</select>	
	<br>	<br>
<input type="submit" value="Update this User">
</form>





</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
