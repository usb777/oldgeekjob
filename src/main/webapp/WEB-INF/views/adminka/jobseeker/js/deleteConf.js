
            
            
            /* this function ask about delete Assigned Jobs by JobSeeker from admin panel*/
            function deleteAJobsConfirmationJobSeeker(ja_id)
            {        
				
				
                var retVal = confirm("Do you want to DELETE data of this Assigned Job ? assigned job_id="+ja_id);
                if( retVal == true ){
                   window.location="deleteAJobByJobSeeker?id="+ja_id+"&action=deleteAJob";
                   return true;
                }
                else{
                   
                   return false;
                }
             } // end of function	 
			 
            
            /* this function ask about delete Inbox Message by JobSeeker from admin panel*/
                 function deleteInMsgByJobSeeker(m_id)
         {        
				
				
                var retVal = confirm("Do you want to DELETE this Inbox Message ? message id="+m_id);
                if( retVal == true ){
                   window.location="deleteInboxMessageByJobseeker?m_id="+m_id+"&action=deleteInMessage";
                   return true;
                }
                else{
                   
                   return false;
                }
             } // end of function	
                 
                
     /* this function ask about delete Inbox Message by JobSeeker from admin panel*/
         function deleteOutMsgByJobSeeker(m_id)
         {        
				
				
                var retVal = confirm("Do you want to DELETE this OutBox Message ? message id="+m_id);
                if( retVal == true ){
                   window.location="deleteOutboxMessageByJobseeker?m_id="+m_id+"&action=deleteOutMessage";
                   return true;
                }
                else{
                   
                   return false;
                }
             } // end of function	