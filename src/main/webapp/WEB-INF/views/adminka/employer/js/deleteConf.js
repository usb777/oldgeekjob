  		 
            
            
            /* this function ask about delete Jobs, from admin*/
            function deleteJobsConfirmationEmployer(id)
            {        
				
				
                var retVal = confirm("Do you want to DELETE data of this Job ? job_id="+id);
                if( retVal == true ){
                   window.location="deleteJobByEmployer?id="+id+"&action=deleteJob";
                   return true;
                }
                else{
                   
                   return false;
                }
             } // end of function	 
			 
            
            /* this function ask about delete Inbox Message by JobSeeker from admin panel*/
                 function deleteInMsgByEmployer(m_id)
         {        
				
				
                var retVal = confirm("Do you want to DELETE this Inbox Message ? message id="+m_id);
                if( retVal == true ){
                   window.location="deleteInboxMessageByEmployer?m_id="+m_id+"&action=deleteInMessage";
                   return true;
                }
                else{
                   
                   return false;
                }
             } // end of function	
                 
                
     /* this function ask about delete Inbox Message by JobSeeker from admin panel*/
         function deleteOutMsgByEmployer(m_id)
         {        
				
				
                var retVal = confirm("Do you want to DELETE this OutBox Message ? message id="+m_id);
                if( retVal == true ){
                   window.location="deleteOutboxMessageByEmployer?m_id="+m_id+"&action=deleteOutMessage";
                   return true;
                }
                else{
                   
                   return false;
                }
             } // end of function	