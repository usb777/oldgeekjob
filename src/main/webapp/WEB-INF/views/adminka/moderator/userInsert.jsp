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

<h1>Add New User by <%=sessionLogin %> </h1>

<h3 style="color='red' ">${errorInsertLogin} </h3>
<h3 style="color='red' ">${errorRegPassw} </h3>
<form action="insertUserbyAdmin" method="POST">
<label for="fname" > First Name </label><br>
<input type="text" name="fname" placeholder="First name"><br><br>
<label for="lname" > Last Name </label><br>
<input type="text" name="lname" placeholder="Last name"><br><br>

<label for="login" > Login </label><font color="red">*</font><br>
<input type="text" name="login" placeholder="enter Login"><br><br>

<label for="password" > Password </label><font color="red">*</font><br>
<input type="password" name="password" placeholder="enter password"><br><br>
	
<label for="email" > Email </label><font color="red">*</font><br>
<input type="email" name="email" placeholder="email"><br><br>
<label for="telefona" >Telephon </label><br>
<input type="text" name="telefona" placeholder="telefona"><br><br>

<label for="role_id" >Choose role of user</label><br>	
<select name="role_id">
  <option value="2">Moderator</option>
  <option value="3">Employer</option>
  <option value="4" selected>JobSeeker</option>
</select>	
	<br>	<br>
<input type="submit" value="Create New User">
</form>


</div>  <!--// col-9 col-m-12 //-->

<jsp:include page="/WEB-INF/views/adminka/superadmin/res/footer.jsp" />
