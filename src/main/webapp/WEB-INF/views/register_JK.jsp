<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
* {
    box-sizing: border-box;
}
.row:after {
    content: "";
    clear: both;
    display: block;
}
[class*="col-"] {
    float: left;
    padding: 15px;
}
html {
    font-family: "Courier new",  "Lucida Sans", sans-serif;
	font-size: 18px;
}
.header {
    background-color: white;
    color: black;
    padding: 15px;
/*	text-align: center; */
}

/*
.menu ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}
.menu li {
    padding: 8px;
    margin-bottom: 7px;
    background-color :green;
    color: #ffffff;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}
.menu li:hover {
    background-color: #0099cc;
}

*/

.menu ul {   
   
}
.menu li {
    color:black;
}
.menu li:hover {
    color: #0099cc;
}


a:link:active, a:visited:active 
{ 
    
}

a:link, a:visited { 
  
}
a:hover {color:red;}

.adv {font-size:12px; font-weight: bold;}


.aside {
    background-color: white;
    padding: 15px;
    color: #000000;
    text-align: center;
    font-size: 14px;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}
.footer {
    background-color: white;/*#0099cc; */
    color: #000000;
    text-align: center;
    font-size: 12px;
    padding: 15px;
}
/* For mobile phones: */
[class*="col-"] {
    width: 100%;
}
@media only screen and (min-width: 600px) {
    /* For tablets: */
    .col-m-1 {width: 8.33%;}
    .col-m-2 {width: 16.66%;}
    .col-m-3 {width: 25%;}
    .col-m-4 {width: 33.33%;}
    .col-m-5 {width: 41.66%;}
    .col-m-6 {width: 50%;}
    .col-m-7 {width: 58.33%;}
    .col-m-8 {width: 66.66%;}
    .col-m-9 {width: 75%;}
    .col-m-10 {width: 83.33%;}
    .col-m-11 {width: 91.66%;}
    .col-m-12 {width: 100%;}
}
@media only screen and (min-width: 768px) {
    /* For desktop: */
    .col-1 {width: 8.33%;}
    .col-2 {width: 16.66%;}
    .col-3 {width: 25%;}
    .col-4 {width: 33.33%;}
    .col-5 {width: 41.66%;}
    .col-6 {width: 50%;}
    .col-7 {width: 58.33%;}
    .col-8 {width: 66.66%;}
    .col-9 {width: 75%;}
    .col-10 {width: 83.33%;}
    .col-11 {width: 91.66%;}
    .col-12 {width: 100%;}
}
</style>
</head>
<body>

<div class="header">
<h1>OldGeekJob</h1>
</div>

<div class="row">





<div class="col-3 col-m-3 menu">



<ul>
<li><a href="#">Jobs</a></li>
<li><a href="#">Statistics</a></li>
<li><a href="#">Employers</a></li>
<li><a href="#">Contact</a></li>
<li><a href="#">GuestBook</a></li>
<li><a href="#">About us</a></li>

</ul>




</div>

<div class="col-6 col-m-9">


<center>
		<h2>===Registration===</h2>
		
	</center>

	

<h3>Please, register!</h3>

<font color="red">${errorRegLogin}</font>    <br>
<font color="red">${errorRegPassw}</font>    <br>
<div class="adv">
Only registered users can save job advertisements,<br> contact with employers and rate employers.
</div> <br>
<form action="registerUser" method="POST">
<label for="fname" > First Name </label><br>
<input type="text" name="fname" placeholder="First name"><br><br>
<label for="lname" > Last Name </label><br>
<input type="text" name="lname" placeholder="Last name"><br><br>

<label for="login" > Login </label><font color="red">*</font><br>
<input type="text" name="login" placeholder="enter Login"><br><br>

<label for="password" > Password </label><font color="red">*</font><br>
<input type="password" name="password" placeholder="enter password"><br><br>

<label for="password1" > Password </label><font color="red">*</font><br>
<input type="password" name="password1" placeholder="again password"><br><br>
	
<label for="email" > Email </label><font color="red">*</font><br>
<input type="email" name="email" placeholder="email"><br><br>
<label for="telefona" >Telephon </label><br>
<input type="text" name="telefona" placeholder="telefona"><br><br>

<label for="role_id" >Choose your role </label><br>	
<select name="role_id">
  <option value="3">Employer</option>
  <option value="4" selected>JobSeeker</option>
</select>	
	<br>	<br>
<input type="submit" value="register">
</form>


</div>

<div class="col-3 col-m-12">


<!--// Loginform  //-->
<div class="aside">
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


</div> <!--// aside //-->
<!--// end LoginForm//-->


<br>

<div class="aside">






<h2>Promotion</h2>
<p>Here you can place your amazing text advertising. Remember, no pictures, no videos, just text. We don't want scary  geeks, focused on code!</p>
<h2>Why OldGeekJob for job seeker?</h2>
<p>Here you can find best job of your dream. Try it right now).</p>
<h2>Are you employer</h2>
<p>Welcome, here you can find best professional, well focused on code and backend design. Place your job, it's totally free</p>

</div> <!--// aside //-->


</div>  <!--// col-3 col-m-12 //-->

</div> <!--// row //-->

<div class="footer">
<p>2018 Copyright by <a href = "http://dslab.us" target="new">DsLab</a></p>
</div>

</body>
</html>
