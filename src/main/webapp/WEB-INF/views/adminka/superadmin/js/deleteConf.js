          
            /* this function ask about delete User info, from admin*/
            function deleteUsersConfirmationSA(user_id)
            {        
				
				
                var retVal = confirm("Do you want to DELETE data of this user ? user_id="+user_id);
                if( retVal == true ){
                   window.location="deleteUserbyAdmin?u_id="+user_id+"&action=deleteUser";
                   return true;
                }
                else{
                  
                   return false;
                }
             } // end of function
			 
            
            
            /* this function ask about delete Jobs, from admin*/
            function deleteJobsConfirmationSA(id)
            {        
				
				
                var retVal = confirm("Do you want to DELETE data of this Job ? job_id="+id);
                if( retVal == true ){
                   window.location="deleteJobByAdmin?id="+id+"&action=deleteJob";
                   return true;
                }
                else{
                   
                   return false;
                }
             } // end of function	
            
            //deleteMessageConfirmationSA
            /* this function ask about delete Jobs, from admin*/
            function deleteMessageConfirmationSA(id)
            {        
				
				
                var retVal = confirm("Do you want to DELETE this Message ? message_id="+id);
                if( retVal == true ){
                   window.location="deleteMessageByAdmin?id="+id+"&action=deleteMessage";
                   return true;
                }
                else{
                   
                   return false;
                }
             } // end of function     
			 
		