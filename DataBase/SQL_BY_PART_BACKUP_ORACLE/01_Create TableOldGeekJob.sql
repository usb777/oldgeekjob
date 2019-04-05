
  CREATE TABLE CITIES 
   (	"CITY_ID" NUMBER primary key, 
	"NAME" VARCHAR2(100 BYTE), 
	"ZIP" NUMBER(10,0), 
	"ST_ID" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Table EMPLOYMENT_TYPE
--------------------------------------------------------

  CREATE TABLE "EMPLOYMENT_TYPE" 
   ("ET_ID" NUMBER PRIMARY KEY, 
	"NAME" VARCHAR2(100 BYTE)
   );
--------------------------------------------------------
--  DDL for Table JOB_ASSIGNMENT
--------------------------------------------------------

  CREATE TABLE "JOB_ASSIGNMENT" 
   (	"JA_ID" NUMBER PRIMARY KEY, 
	"JOB_ID" NUMBER, 
	"U_ID" NUMBER, 
	"DATE_ASSIGNMENT" DATE
   );
--------------------------------------------------------
--  DDL for Table JOB_STATUS
--------------------------------------------------------

  CREATE TABLE "JOB_STATUS" 
   (	"JS_ID" NUMBER PRIMARY KEY, 
	"NAME" VARCHAR2(30 BYTE)
   );
--------------------------------------------------------
--  DDL for Table JOBS
--------------------------------------------------------

  CREATE TABLE "JOBS" 
   (	"ID" NUMBER PRIMARY KEY, 
	"TITLE" VARCHAR2(400 BYTE), 
	"COMPENSATION" VARCHAR2(200 BYTE), 
	"DESCRIPTION" VARCHAR2(2000 BYTE), 
	"EDUCATION" VARCHAR2(200 BYTE), 
	"RESPONSIBILITIES" VARCHAR2(2000 BYTE), 
	"QUALIFICATION" VARCHAR2(1000 BYTE), 
	"SKILLS" VARCHAR2(1000 BYTE), 
	"U_ID" NUMBER, 
	"JOBSTATUS_ID" NUMBER, 
	"EMPLOYMENTTYPE_ID" NUMBER, 
	"BENEFITS" VARCHAR2(2000 BYTE), 
	"CONTACT_INFO" VARCHAR2(500 BYTE), 
	"DATE_PUBLICATION" DATE, 
	"CITY" VARCHAR2(100 BYTE), 
	"STATE_ID" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Table MESSAGES
--------------------------------------------------------

  CREATE TABLE "MESSAGES" 
   ("M_ID" NUMBER PRIMARY KEY, 
	"FROM_ID" NUMBER, 
	"TO_ID" NUMBER, 
	"TITLE" VARCHAR2(100 BYTE), 
	"MESSAGE" VARCHAR2(2000 BYTE), 
	"CONTACT" VARCHAR2(1000 BYTE), 
	"DATE_MESSAGE" DATE, 
	"STATUS" NUMBER(*,0), 
	"ATTACH_URL" VARCHAR2(300 BYTE)
   )  ;
--------------------------------------------------------
--  DDL for Table PAGE_VISITED
--------------------------------------------------------

  CREATE TABLE"PAGE_VISITED" 
   (	"PV_ID" NUMBER PRIMARY KEY, 
	"URL" VARCHAR2(100 BYTE), 
	"US_ID" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Table PROFILE
--------------------------------------------------------

  CREATE TABLE "PROFILE" 
   (	"P_ID" NUMBER PRIMARY KEY, 
	"DESCRIPTION" VARCHAR2(255 BYTE), 
	"U_ID" NUMBER, 
	"LINKEDIN" VARCHAR2(100 BYTE), 
	"GITHUB" VARCHAR2(100 BYTE), 
	"RESUME_URL" VARCHAR2(100 BYTE), 
	"DATE_MODIFICATION" DATE
   )  ;
--------------------------------------------------------
--  DDL for Table PROPOSED_TECHNOLOGIES
--------------------------------------------------------

  CREATE TABLE "PROPOSED_TECHNOLOGIES" 
   (	"PT_ID" NUMBER PRIMARY KEY, 
        "NAME" VARCHAR2(100 BYTE)
   )  ;
--------------------------------------------------------
--  DDL for Table ROLE_USER
--------------------------------------------------------

  CREATE TABLE "ROLE_USER" 
   (	"ROLE_ID" NUMBER PRIMARY KEY, 
	"NAME" VARCHAR2(40 BYTE)
   )  ;
--------------------------------------------------------
--  DDL for Table STATES
--------------------------------------------------------

  CREATE TABLE "STATES" 
   (	"ST_ID" NUMBER PRIMARY KEY, 
	"SHORTNAME" VARCHAR2(10 BYTE), 
	"NAME" VARCHAR2(50 BYTE)
   )  ;
--------------------------------------------------------
--  DDL for Table TECHNOLOGIES
--------------------------------------------------------

  CREATE TABLE "TECHNOLOGIES" 
   (	"T_ID" NUMBER PRIMARY KEY, 
	"NAME" VARCHAR2(100 BYTE), 
	"POPULARITY" NUMBER
   )  ;
--------------------------------------------------------
--  DDL for Table TESTDATE
--------------------------------------------------------

  CREATE TABLE "TESTDATE" 
   (	"ID" NUMBER PRIMARY KEY, 
	"NAME" VARCHAR2(100 BYTE), 
	"DATET" DATE
   ) ;
--------------------------------------------------------
--  DDL for Table USER_STORY
--------------------------------------------------------

  CREATE TABLE "USER_STORY" 
   (	"US_ID" NUMBER PRIMARY KEY, 
	"IP" VARCHAR2(50 BYTE), 
	"DATE_START" DATE, 
	"U_ID" NUMBER
   )  ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "USERS" 
   (	"U_ID" NUMBER PRIMARY KEY, 
	"FNAME" VARCHAR2(50 BYTE), 
	"LNAME" VARCHAR2(50 BYTE), 
	"LOGIN" VARCHAR2(100 BYTE), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"TELEFONA" VARCHAR2(100 BYTE), 
	"ROLE_ID" NUMBER, 
	"PASSWORD" VARCHAR2(100 BYTE)
   ) ;