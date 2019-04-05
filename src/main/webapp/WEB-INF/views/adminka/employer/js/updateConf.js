           
            
            /* this function ask about update Job info, from admin*/
            function updateJobsConfirmationByEmployer(id)
            {
				
				
                var retVal = confirm("Do you want to Update data of this Job ? id="+id);
                if( retVal == true )
                {
                   window.location="updateJobByEmployerPage?id="+id+"&action=updateJob";                	
                   return true;
                }
                else
                {
                  
                   return false;
                }
             } // end of function