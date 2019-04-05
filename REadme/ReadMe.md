# OldGeekJob
OldGeekJob - Website used to seek job and offer employment
# Technical requirements: Tomcat 8 (minimum) as webserver, Java 1.8, Spring MVC, Oracle 11g Express
# Technologies: Spring MVC, Java, Oracle Db (ojdbc), Jquery 1.4 (minimum)

#Install: 
•1.deploy oldgeekjob.war file o the server. 

•2.Also in folder -Database- you can find ==OLDGEEKJOB.sql== file , import it to database.

•3. You can change database user and password in ==dispatcher-servlet.xml==
•change xe on your Oracle SID
•username
•password
----------------------------------------------------------------------
<bean id="ds" class="org.springframework.jdbc.datasource.DriverManagerDataSource">  
	<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></property>  
	<property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"></property>  
	<property name="username" value="system"></property>  
	<property name="password" value="password"></property>  
</bean>   
-----------------------------------------------------------------------

Warning! : Admin Login and password  (login , password ) ----> ("admin", "admin")

#User Stories:
1.	Employer will be able to : 
• Create a proposition of job statement(CRUD)
• Answer the job seekers (send message, delete message) 

2.	Job Seeker will be able to:
• Post his/her resume 
• See all history of job requests posted by him. 
• Can create and update his profile that includes his qualifications and skills                                
  (programming languages and technologies)
 • Receive and send messages (inner message system) 

3.	SuperAdmin will be able to:
 • Shows the list of all users(CRUD)
 • Shows all job proposals (CRUD) 
 • General statistics(number of users, number of jobs and etc)
 • Technical features of the website (Server name, database and etc) 

4.	Guests - users without registration or login out will be able to: 
• See all jobs on front-end without applying





JOBS can be in status

 - enabled (Admin, Moderator, Employer) only THIS JOBS will be visible on the FRONT END.

- disabled  (Admin, Moderator)  - Employer can see own  posted JOB,  can modify it, but can NOT enable for FRONT END. Cos while Disabled - doesn't shown on the FRONT END. ADMIN, Moderator can disable, but BAD cases will be deleted!

- pending  (Admin, Moderator, Employer)	 - Employer can see own  posted JOB,  can modify it, but It doesn't present on the FRONT END of site (INDEX.jsp). Employer can ENABLE it


#Bcrypt: Password secured  by Bcrypt method
-
#Junt:  Project Daos--PATH:  OldGeekJob\src\test\java\jUnit\DaoTest




