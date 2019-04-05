ALTER TABLE Cities 
  ADD CONSTRAINT fk_stid 
  FOREIGN KEY (st_id) 
  REFERENCES states(st_id) 
  ON DELETE CASCADE; 
  
  ALTER TABLE JOB_ASSIGNMENT 
  ADD CONSTRAINT fk_jobid 
  FOREIGN KEY (Job_id) 
  REFERENCES Jobs(id) 
  ON DELETE CASCADE; 
  
ALTER TABLE JOB_ASSIGNMENT 
  ADD CONSTRAINT fk_uid 
  FOREIGN KEY (U_ID) 
  REFERENCES Users(U_id) 
  ON DELETE CASCADE;
  
 ---------------- 
  ALTER TABLE JOBS 
  ADD CONSTRAINT fk_userid 
  FOREIGN KEY (U_ID) 
  REFERENCES Users(U_id) 
  ON DELETE CASCADE; 
  
 
  
   ALTER TABLE JOBS 
  ADD CONSTRAINT fk_EMPLOYMENTTYPEID 
  FOREIGN KEY (EMPLOYMENTTYPE_ID) 
  REFERENCES EMPLOYMENT_TYPE(et_id) 
  ON DELETE CASCADE; 
  
  
   ALTER TABLE JOBS 
  ADD CONSTRAINT fk_jobstatusid 
  FOREIGN KEY (jobstatus_id) 
  REFERENCES JOB_STATUS(js_id) 
  ON DELETE CASCADE; 
  
  
ALTER TABLE JOBS 
  ADD CONSTRAINT fk_stateid 
  FOREIGN KEY (state_id) 
  REFERENCES States(st_id) 
  ON DELETE CASCADE;
  --------------------------------------------------------------------
    ALTER TABLE messages 
  ADD CONSTRAINT fk_fromuid 
  FOREIGN KEY (from_id) 
  REFERENCES users(u_id) 
  ON DELETE CASCADE;
  
 ALTER TABLE messages 
  ADD CONSTRAINT fk_touid 
  FOREIGN KEY (to_id) 
  REFERENCES users(u_id) 
  ON DELETE CASCADE; 
 ------------------------------------------------------------------ 
  ALTER TABLE Page_VISITED 
  ADD CONSTRAINT fk_usid
  FOREIGN KEY (us_id) 
  REFERENCES user_story(us_id) 
  ON DELETE CASCADE;
  
  ALTER TABLE USER_STORY 
  ADD CONSTRAINT fk_uid_userstory 
  FOREIGN KEY (u_id) 
  REFERENCES users(u_id) 
  ON DELETE CASCADE;


   ALTER TABLE Profile 
  ADD CONSTRAINT fk_uid_profile 
  FOREIGN KEY (u_id) 
  REFERENCES users(u_id) 
  ON DELETE CASCADE;