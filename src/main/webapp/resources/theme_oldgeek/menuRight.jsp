<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<div class="col-3 col-m-12">


<!--// Loginform  //-->
<div class="aside">
<% 
if (session.getAttribute("login")!=null) 
{
    int role_id = Integer.valueOf(session.getAttribute("role_id").toString()) ;
 	
    
    switch (role_id) 
    {
    case 1:
    out.print("<a href='adminusers' >Go to admin page </a> <br><br>"); break;
    case 2:
        out.print("<a href='moderatorusers' >Go to Moderator page </a> <br><br>"); break;
    case 3:
        out.print("<a href='employerpage' >Go to Employer page </a> <br><br>"); break;
    case 4:
        out.print("<a href='assignedjobs' >Go to JobSeeker page </a> <br><br>"); break;
    }
 	%>
 	<a href="logout" >logout</a> <br><br>
 
 
 <%
}
else 
{
	%>
<font color="red">${errorLogin}</font>
<form action="oldGeekLogin" method="POST">
<label for="login" > Login </label> <br>
<input type="text" name="login"> <br><br>
<label for="login" > Password </label> <br>
<input type="password" name="password"> <br><br>
<input type="submit" name="submit" value="Login">
</form>
<br> 
<a href="register"> Sign Up!</a> 
<a href="#">Forgot your password? </a> <br>
<% 
}
%>


</div> <!--// aside //-->
<!--// end LoginForm//-->


<br/>


<div class="aside">


<h2>Promotion</h2>
<p>Here you can place your amazing text advertising. Remember, no pictures, no videos, just text. We don't want scary  geeks, focused on code!</p>
<h2>Why OldGeekJob for job seeker?</h2>
<p>Here you can find best job of your dream. Try it right now).</p>
<h2>Are you employer</h2>
<p>Welcome, here you can find best professional, well focused on code and backend design. Place your job, it's totally free</p>

</div> <!--// aside //-->


</div>  <!--// col-3 col-m-12 //-->