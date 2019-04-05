          
            /* this function ask about delete User info, from Moderator*/
            function deleteUsersConfirmationSA(user_id)
            {        
				
				
                var retVal = confirm("Do you want to DELETE data of this user ? user_id="+user_id);
                if( retVal == true ){
                   window.location="deleteUserbyModerator?u_id="+user_id+"&action=deleteUser";
                   return true;
                }
                else{
                  
                   return false;
                }
             } // end of function
			 
            
            
            /* this function ask about delete Jobs, from Moderator*/
            function deleteJobsConfirmationSA(id)
            {        
				
				
                var retVal = confirm("Do you want to DELETE data of this Job ? job_id="+id);
                if( retVal == true ){
                   window.location="deleteJobByModerator?id="+id+"&action=deleteJob";
                   return true;
                }
                else{
                   
                   return false;
                }
             } // end of function	 
			 
		