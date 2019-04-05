SET DEFINE OFF;

Insert into EMPLOYMENT_TYPE (ET_ID,NAME) values (1,'full-time');
Insert into EMPLOYMENT_TYPE (ET_ID,NAME) values (2,'part-time');
Insert into EMPLOYMENT_TYPE (ET_ID,NAME) values (3,'contract');
Insert into EMPLOYMENT_TYPE (ET_ID,NAME) values (4,'intermediate');
--------------------------------------------------

insert into JOB_STATUS (JS_ID,NAME) values (1,'enabled');
Insert into JOB_STATUS (JS_ID,NAME) values (2,'disabled');
Insert into JOB_STATUS (JS_ID,NAME) values (3,'pending');

-----------------------------------------------------------------------------------

Insert into ROLE_USER (ROLE_ID,NAME) values (1,'superadmin');
Insert into ROLE_USER (ROLE_ID,NAME) values (2,'moderator');
Insert into ROLE_USER (ROLE_ID,NAME) values (3,'employer');
Insert into ROLE_USER (ROLE_ID,NAME) values (4,'jobseeker');

---------------------------------------------------------------------------------------

Insert into STATES (ST_ID,SHORTNAME,NAME) values (1,'AL','Alabama');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (2,'AK','Alaska');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (3,'AZ','Arizona');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (4,'AR','Arkansas');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (5,'CA','California');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (6,'CO','Colorado');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (7,'CT','Connecticut');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (8,'DE','Delaware');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (9,'FL','Florida');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (10,'GA','Georgia');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (11,'HI','Hawaii');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (12,'ID','Idaho');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (13,'IL','Illinois');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (14,'IN','Indiana');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (15,'IA','Iowa');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (16,'KS','Kansas');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (17,'KY','Kentucky');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (18,'LA','Louisiana');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (19,'ME','Maine');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (20,'MD','Maryland');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (21,'MA','Massachusetts');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (22,'MI','Michigan');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (23,'MN','Minnesota');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (24,'MS','Mississippi');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (25,'MO','Missouri');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (26,'MT','Montana');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (27,'NE','Nebraska');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (28,'NV','Nevada');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (29,'NH','New Hampshire');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (30,'NJ','New Jersey');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (31,'NM','New Mexico');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (32,'NY','New York');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (33,'NC','North Carolina');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (34,'ND','North Dakota');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (35,'OH','Ohio');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (36,'OK','Oklahoma');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (37,'OR','Oregon');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (38,'PA','Pennsylvania');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (39,'RI','Rhode Island');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (40,'SC','South Carolina');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (41,'SD','South Dakota');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (42,'TN','Tennessee');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (43,'TX','Texas');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (44,'UT','Utah');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (45,'VT','Vermont');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (46,'VA','Virginia');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (47,'WA','Washington');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (48,'WV','West Virginia');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (49,'WI','Wisconsin');
Insert into STATES (ST_ID,SHORTNAME,NAME) values (50,'WY','Wyoming');
--------------------------------------------------------------
Insert into USERS (U_ID,FNAME,LNAME,LOGIN,EMAIL,TELEFONA,ROLE_ID,PASSWORD) values (2,'Dzmitry','Samoila','dzsam','dzsam@c.ru','43567567',4,'$2a$10$FH0VMSku1XAhWqi1SpUEEeFgPPd0uBH7r94ENsYeOQWCjBExDMHg6');
Insert into USERS (U_ID,FNAME,LNAME,LOGIN,EMAIL,TELEFONA,ROLE_ID,PASSWORD) values (1,'Administartor','admin','admin','js@js.com','56345645',1,'$2a$10$aZL4tGgvnhKuHlx5z0tqEekeUjFw6fvb.2NKAjScke66xA1ilf4JS');
Insert into USERS (U_ID,FNAME,LNAME,LOGIN,EMAIL,TELEFONA,ROLE_ID,PASSWORD) values (3,'ret','ret','ret','ret@gmail.com','433453453',4,'$2a$10$ISqcct0uT14ErXLWiT78venOIcH7hsAH8d9YqcLODy/0TepnRKjHq');
Insert into USERS (U_ID,FNAME,LNAME,LOGIN,EMAIL,TELEFONA,ROLE_ID,PASSWORD) values (5,'Oracle77','oracle','oracle','oracle@gmail.com','2454645',3,'$2a$10$KoTbhT82PFm0i.1vu9Usu.n7xFpCvmKFWG9e.MGoVRvXZHxweeVNC');
Insert into USERS (U_ID,FNAME,LNAME,LOGIN,EMAIL,TELEFONA,ROLE_ID,PASSWORD) values (4,'fn1',null,'fn1','fn@ma.ru','345345345',4,'$2a$10$19JBSQZnmJrzOi7XW5tSnerXzoXTmfOCvzXMYyR0E7gyVdiBwf/N6');
Insert into USERS (U_ID,FNAME,LNAME,LOGIN,EMAIL,TELEFONA,ROLE_ID,PASSWORD) values (6,'moderator',null,'moder','dzsamoila@gmail.comwewr','34534',2,'$2a$10$AIpkTJB1ut4AuUmRF3i2ouc9arMB.G6I.db9FJYRFpX5xacWGg0m2');
---------------------------------------------------------------------------------
Insert into PROFILE (P_ID,DESCRIPTION,U_ID,LINKEDIN,GITHUB,RESUME_URL,DATE_MODIFICATION) values (3,'JAVA de',4,'linkedinurlwerwe123','github_url123','resume_url ',to_date('20-SEP-18','DD-MON-RR'));
Insert into PROFILE (P_ID,DESCRIPTION,U_ID,LINKEDIN,GITHUB,RESUME_URL,DATE_MODIFICATION) values (1,'updap1',2,'dzLInkedin6','gitHub6','resume6',to_date('20-SEP-18','DD-MON-RR'));
Insert into PROFILE (P_ID,DESCRIPTION,U_ID,LINKEDIN,GITHUB,RESUME_URL,DATE_MODIFICATION) values (2,null,3,'jsLink','jsGit','jsresum',to_date('21-SEP-18','DD-MON-RR'));
-----------------------------------------------------------------------
Insert into JOBS (ID,TITLE,COMPENSATION,DESCRIPTION,EDUCATION,RESPONSIBILITIES,QUALIFICATION,SKILLS,U_ID,JOBSTATUS_ID,EMPLOYMENTTYPE_ID,BENEFITS,CONTACT_INFO,DATE_PUBLICATION,CITY,STATE_ID) values (1,'admin Jobs',null,null,null,null,null,null,1,1,1,null,null,to_date('13-SEP-18','DD-MON-RR'),'amsterdam',1);
Insert into JOBS (ID,TITLE,COMPENSATION,DESCRIPTION,EDUCATION,RESPONSIBILITIES,QUALIFICATION,SKILLS,U_ID,JOBSTATUS_ID,EMPLOYMENTTYPE_ID,BENEFITS,CONTACT_INFO,DATE_PUBLICATION,CITY,STATE_ID) values (2,'oracle developer67867','40K','descr',null,null,null,null,5,1,1,null,null,to_date('13-SEP-18','DD-MON-RR'),'Amsterdam',1);
Insert into JOBS (ID,TITLE,COMPENSATION,DESCRIPTION,EDUCATION,RESPONSIBILITIES,QUALIFICATION,SKILLS,U_ID,JOBSTATUS_ID,EMPLOYMENTTYPE_ID,BENEFITS,CONTACT_INFO,DATE_PUBLICATION,CITY,STATE_ID) values (3,'Java Oracle Tester','55K','descr',null,null,null,null,4,1,1,null,null,to_date('15-SEP-18','DD-MON-RR'),'Mubai',1);
Insert into JOBS (ID,TITLE,COMPENSATION,DESCRIPTION,EDUCATION,RESPONSIBILITIES,QUALIFICATION,SKILLS,U_ID,JOBSTATUS_ID,EMPLOYMENTTYPE_ID,BENEFITS,CONTACT_INFO,DATE_PUBLICATION,CITY,STATE_ID) values (4,'oravv',null,null,null,null,null,null,5,1,1,null,null,to_date('15-SEP-18','DD-MON-RR'),null,1);
Insert into JOBS (ID,TITLE,COMPENSATION,DESCRIPTION,EDUCATION,RESPONSIBILITIES,QUALIFICATION,SKILLS,U_ID,JOBSTATUS_ID,EMPLOYMENTTYPE_ID,BENEFITS,CONTACT_INFO,DATE_PUBLICATION,CITY,STATE_ID) values (5,'mess','50K',null,null,null,null,null,5,1,1,null,null,to_date('13-SEP-18','DD-MON-RR'),'Hren',1);
---------------------------------------------------------------------------------------------------------------------------------------------------
Insert into JOB_ASSIGNMENT (JA_ID,JOB_ID,U_ID,DATE_ASSIGNMENT) values (2,2,4,to_date('20-SEP-18','DD-MON-RR'));
Insert into JOB_ASSIGNMENT (JA_ID,JOB_ID,U_ID,DATE_ASSIGNMENT) values (3,3,4,to_date('20-SEP-18','DD-MON-RR'));
Insert into JOB_ASSIGNMENT (JA_ID,JOB_ID,U_ID,DATE_ASSIGNMENT) values (1,1,4,to_date('20-SEP-18','DD-MON-RR'));


