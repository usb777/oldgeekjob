          
            /* this function ask about update User info, from admin*/
            function updateUsersConfirmationSA(user_id)
            {
				
				
                var retVal = confirm("Do you want to Update data of this user ? user_id="+user_id);
                if( retVal == true )
                {
                   window.location="updateUserByAdminPage?u_id="+user_id+"&action=updateUser";
                	
                   return true;
                }
                else
                {
                  
                   return false;
                }
             } // end of function
            
            
            
            
            /* this function ask about update Job info, from admin*/
            function updateJobsConfirmationSA(id)
            {
				
				
                var retVal = confirm("Do you want to Update data of this Job ? id="+id);
                if( retVal == true )
                {
                   window.location="updateJobByAdminPage?id="+id+"&action=updateJob";
                	
                   return true;
                }
                else
                {
                  
                   return false;
                }
             } // end of function