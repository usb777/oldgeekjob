<!--// HEADER //-->
<jsp:include page="/resources/theme_oldgeek/header.jsp" />
<!--// HEADER END //-->
<!--// right menu //-->
<jsp:include page="/resources/theme_oldgeek/menuLeft.jsp" />
<!--// right menu END //-->


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







</div> <!--// col-6 col-m-9 //-->




<!--// right menu //-->
<jsp:include page="/resources/theme_oldgeek/menuRight.jsp" />
<!--// right menu END //-->
<jsp:include page="/resources/theme_oldgeek/footer.jsp" />