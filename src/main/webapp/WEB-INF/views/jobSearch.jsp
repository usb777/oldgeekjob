<!--// HEADER //-->
<jsp:include page="/resources/theme_oldgeek/header.jsp" />
<!--// HEADER END //-->

<!--// right menu //-->
<jsp:include page="/resources/theme_oldgeek/menuLeft.jsp" />
<!--// right menu END //-->

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<div class="col-6 col-m-9">
<H1> Job Search Page</H1>
<br>
You parameters of search <br><br>
<b>Job name: </b> ${jobName}    <br>
<b>Location: </b> ${location}    <br>

<H2> We sorry , Job search doesn't   work at this time... Will be realesead soon.</H2>
    
 

</div> <!--// col-6 col-m-9 //-->




<!--// right menu //-->
<jsp:include page="/resources/theme_oldgeek/menuRight.jsp" />
<!--// right menu END //-->

<jsp:include page="/resources/theme_oldgeek/footer.jsp" />