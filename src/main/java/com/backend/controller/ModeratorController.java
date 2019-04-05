package com.backend.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;



import dao.EmploymentType_Dao;
import dao.JobStatus_Dao;
import dao.Jobs_Dao;
import dao.Profile_Dao;
import dao.Users_Dao;
import dao.Role_User_Dao;
import dao.States_Dao;
import model.EmploymentType;
import model.JobStatus;
import model.Jobs;
import model.Role_User;
import model.States;
import model.Users;
import util.Bcrypting;


@Controller
public class ModeratorController 
{
	@Autowired  
	Users_Dao usersdao;//will inject dao from xml file
	
	@Autowired  
	EmploymentType_Dao emptypedao;//will inject dao from xml file
	
	@Autowired  
	Jobs_Dao jobsdao;//will inject dao from xml file
	
	@Autowired  
	Role_User_Dao role_userdao;//will inject dao from xml file
	
	@Autowired  
	JobStatus_Dao jobstatusdao;//will inject dao from xml file
	
	@Autowired
	Profile_Dao profiledao;
	
	@Autowired	
	States_Dao statesdao;
	
	
	 @RequestMapping("/moderatorusers")  
	    public ModelAndView showUsers()
	    {  
	        List<Users> list_users=usersdao.getUsersForModerator();
	        
	        List<Role_User> list_role_users=role_userdao.getRoleUsers()  ;
	        
	        ModelAndView mav = new ModelAndView("adminka/moderator/moderatorpage","list_users",list_users);
	        mav.addObject("list_role_users", list_role_users);
	        
	        return  mav;
	        
	    } 
	 
	

	 
	 
	
/*	
	 @RequestMapping("/adduser")  
	    public ModelAndView addUserPage(HttpServletRequest request)
	    {  
		     return new ModelAndView("adminka/superadmin/userAddPage");  
	    } 
	*/
	 
	 @RequestMapping("/insertUserByModeratorPage")  
	    public ModelAndView insertUserByModeratorPage()
	    { 		  
		     return new ModelAndView("adminka/moderator/userInsert");  
	    } 
	 
	 @RequestMapping(value = "/insertUserbyModerator", method=RequestMethod.POST)
		public  ModelAndView insertUserByModerator( 
				@ModelAttribute("users") Users users,				
				@RequestParam("fname") String fname,
				@RequestParam("lname") String lname,
				@RequestParam("login") String login, 
				@RequestParam("email") String email,
				@RequestParam("telefona") String telefona,
				@RequestParam("role_id") int role_id,
				@RequestParam("password")String password	) 
		{ // body of method	
		   ModelAndView mav = null;
		   Bcrypting bcrypt = new Bcrypting();
		   
		  if (usersdao.isValidLogin(login)) 
	    	{
	    		
		    	 
			    	mav =  new ModelAndView("adminka/moderator/userAddPage");
			    	mav.addObject("errorInsertLogin","this user with same login already in system");
			    return mav;
	    	}
		  
		    if( (!login.equals("")) &&(login!=null)    )
		    {
		    	users.setPassword(bcrypt.hash(password)); //Encrypt Password
		    	usersdao.save(users);		  	       
		  	    	  	  
		    	
		    	
		    		
		    	List<Users> list_users=usersdao.getUsers()  ;	
		    	
		    	//Create profile for New User
		    	if (role_id == 4) // JobSeeker Enter
		    	{  
		    		
		    	  	profiledao.save(usersdao.getMaxUserId());
		    	}
		    			    		
		    		mav =  new ModelAndView("adminka/moderator/moderatorpage","list_users",list_users); 
		    		mav.addObject("insertUserOk","User "+login+" registered");	
		    		return  mav;	
		    
		    	
		    }
		    else 
		    {
		    	 
		    	 
		    	mav =  new ModelAndView("adminka/moderator/userAddPage");
		    	
		    	if (usersdao.isValidLogin(login)) 
		    	{
		    		mav =  new ModelAndView("adminka/moderator/userAddPage");
			    	mav.addObject("errorInsertLogin","this user with same login already in system");
		    	}
		    	
		    	mav.addObject("errorRegPassw"," Login do not match!");
		    	 return mav;	
		    }
		  
		  
		
		   
		} // user_info_changes 
	
	 
	 @RequestMapping( "/deleteUserbyModerator")  
	    public ModelAndView deleteUserByModerator(@RequestParam("u_id") int u_id )
	    {  
		 
		 usersdao.delete(u_id);
	        List<Users> list_users=usersdao.getUsersForModerator()  ;
	        return new ModelAndView("adminka/moderator/moderatorpage","list_users",list_users); 
	   
		
	    }
	 
	
	 
	 
	 
	
	 
	 @RequestMapping(value = "/updateUserByModeratorPage", method=RequestMethod.GET)  
	    public ModelAndView updateUserPage(HttpServletRequest request, @RequestParam("u_id") int u_id )
	    {   
		 int role_id_user = 0;
		  Users currentUser = new Users();
		  currentUser =  usersdao.getUserById(u_id);
		 
		    HttpSession session = request.getSession(); 
		    session.setAttribute("user_id", u_id);
		    session.setAttribute("role_id", currentUser.getRole_id());
		     
		    role_id_user = currentUser.getRole_id();
		    ModelAndView mav = new ModelAndView("adminka/moderator/userUpdate","currentUser",currentUser);
		    mav.addObject("role_id_user", role_id_user);
		    return mav;  
	    } 
	 	 
	 
	 
	 @RequestMapping( value = "/updateUserbyModerator",   method=RequestMethod.POST)  
	    public ModelAndView updateUserByModerator
	    (		
	    		@ModelAttribute("users") Users users,
	    		@RequestParam("u_id") int u_id,
				@RequestParam("fname") String fname,
				@RequestParam("lname") String lname,
				@RequestParam("login") String login, 
				@RequestParam("email") String email,
				@RequestParam("telefona") String telefona,
				@RequestParam("role_id") int role_id,
				@RequestParam("password")String password  )
	    {
		 Bcrypting bcrypt = new Bcrypting();
		
		
		 
		
			 users.setPassword(bcrypt.hash(password)); //Encrypt Password
			 usersdao.update(u_id, users); 
		 
		 
	        List<Users> list_users=usersdao.getUsersForModerator()  ;
	        
	        return new ModelAndView("adminka/moderator/moderatorpage","list_users",list_users);  
	   
	
	    } 
	 
	 

	 
	 
	 @RequestMapping("/moderatoremptype")  
	    public ModelAndView showEmploymentType()
	    {  
	        List<EmploymentType> list_emptype=emptypedao.getEmpTypes()  ;
	        return new ModelAndView("adminka/moderator/emptype","list_emptype",list_emptype);  
	    }  
	 
	 @RequestMapping("/moderatorjobs")  
	    public ModelAndView showJobs()
	    {  
		   
	        List<Jobs> list_jobs=jobsdao.getJobsWithShortDescriptions();
	        
	        List<String>job_descriptions = new ArrayList<String>() ;       
	        
	        for (int i=0;i<list_jobs.size();i++)
	        { 	
	        	job_descriptions.add(list_jobs.get(i).getDescription());
	        }
	        
	        
	        List<Users> list_users=usersdao.getUsers()  ;
	        List <JobStatus> list_jobstatus = jobstatusdao.getJobStatus() ;
	      
	        ModelAndView mav = new ModelAndView("adminka/moderator/jobs","list_jobs", list_jobs);
	       
	        mav.addObject("list_jobstatus",list_jobstatus) ;
	        mav.addObject("list_users",list_users) ;     
	       
	        mav.addObject("job_descriptions",job_descriptions) ;
	        
	        List <States> list_states = statesdao.getStates() ;
	        mav.addObject("list_states",list_states);
	        
	        return mav;  
	      
	    }  
	 
	 
	 
	 
	 @RequestMapping("/insertJobByModeratorPage")  
	    public ModelAndView insertJobByModeratorPage()
	    {   
		  List <JobStatus> list_jobstatus = jobstatusdao.getJobStatus() ;      
	     
		  ModelAndView mav =   new ModelAndView("adminka/moderator/jobInsert"); 
		  mav.addObject("list_jobstatus",list_jobstatus);
		  List <States> list_states = statesdao.getStates() ;
		  mav.addObject("list_states",list_states);
		  
		  return  mav;
	    } 
	 
	 
	 @RequestMapping(value = "/insertJobByModerator",  method=RequestMethod.GET)  
	    public ModelAndView insertJobByModerator
	    (	    		
	    		@RequestParam("title") String title	,			
				@RequestParam("compensation") String compensation,
				@RequestParam("description") String description, 
				@RequestParam("education") String education,
				@RequestParam("responsibilities") String responsibilities,
				@RequestParam("qualification") String qualification,
				@RequestParam("skills")String skills,				
				@RequestParam("u_id") int u_id,
				@RequestParam("jobstatus_id") int jobstatus_id,
				@RequestParam("employmenttype_id") int employmenttype_id,				
				@RequestParam("benefits") String benefits,
				@RequestParam("contact_info") String contact_info,
			//	@RequestParam("date_publication") String date_publication, 
				@RequestParam("city") String city,
				@RequestParam("state_id") int state_id
				
	    ) 
	    
	    {
		 
		
		    Jobs jobs = new Jobs();  // I can't insert it in TOP
		    jobs = new Jobs();
		   
		    jobs.setTitle(title);				
		    jobs.setCompensation(compensation);
		    jobs.setDescription(description); 
		    jobs.setEducation(education);
		    jobs.setResponsibilities(responsibilities);
		    jobs.setQualification(qualification);
		    jobs.setSkills(skills);				
		    jobs.setU_id(u_id);
		    jobs.setJobstatus_id(jobstatus_id);
		    jobs.setEmploymenttype_id(employmenttype_id);				
		    jobs.setBenefits(benefits);
		    jobs.setContact_info(contact_info);
		//    jobs.setDate_publication(date_publication); 
		    jobs.setCity(city);
		    jobs.setState_id(state_id);
		  
		try { 
		 jobsdao.save(jobs);	
		}
		catch (Exception e) 
		{
			System.out.println("Error is "+e);
			e.printStackTrace();
		}
		
		
		
	     List<Jobs> list_jobs=jobsdao.getJobsWithShortDescriptions();
	     
	     ModelAndView  mav = new ModelAndView("adminka/moderator/jobs","list_jobs", list_jobs); 
	     List <States> list_states = statesdao.getStates() ;
	     mav.addObject("list_states",list_states);
	     
	     return mav;
	    
	    } 
	 
	 
	 
	 
	 
	 
	 
	 @RequestMapping(value = "/updateJobByModeratorPage", method=RequestMethod.GET)  
	    public ModelAndView updateJobPage(HttpServletRequest request, @RequestParam("id") int id )
	    {   
		 
		  Jobs currentJob = new Jobs();
		  currentJob =  jobsdao.getJobById(id);
		  List <JobStatus> list_jobstatus = jobstatusdao.getJobStatus() ;      
		     
		  ModelAndView mav =  new ModelAndView("adminka/moderator/jobUpdate","currentJob",currentJob);
		  mav.addObject("list_jobstatus",list_jobstatus);
		  List <States> list_states = statesdao.getStates() ;
		  mav.addObject("list_states",list_states);
		  return mav;
		    		   
	    }
	 
	 
	 @RequestMapping( value = "/updateJobByModerator",   method=RequestMethod.GET)  
	    public ModelAndView updateJobByModerator
	    (		    	     	  
	    	    @RequestParam("id") int id	,
				@RequestParam("title") String title,				
				@RequestParam("compensation") String compensation,
				@RequestParam("description") String description, 
				@RequestParam("education") String education,
				@RequestParam("responsibilities") String responsibilities,
				@RequestParam("qualification") String qualification,
				@RequestParam("skills")String skills,				
				@RequestParam("u_id") int u_id,
				@RequestParam("jobstatus_id") int jobstatus_id,
				@RequestParam("employmenttype_id") int employmenttype_id,				
				@RequestParam("benefits") String benefits,
				@RequestParam("contact_info") String contact_info,
			//	@RequestParam("date_publication") String date_publication, 
				@RequestParam("city") String city,
				@RequestParam("state_id") int state_id
			
	    ) 
	    
	    {
		    Jobs jobs = new Jobs();  // I can't insert it in TOP
		    jobs = new Jobs();
		    jobs.setId(id);
		    jobs.setTitle(title);				
		    jobs.setCompensation(compensation);
		    jobs.setDescription(description); 
		    jobs.setEducation(education);
		    jobs.setResponsibilities(responsibilities);
		    jobs.setQualification(qualification);
		    jobs.setSkills(skills);				
		    jobs.setU_id(u_id);
		    jobs.setJobstatus_id(jobstatus_id);
		    jobs.setEmploymenttype_id(employmenttype_id);				
		    jobs.setBenefits(benefits);
		    jobs.setContact_info(contact_info);
		//    jobs.setDate_publication(date_publication); 
		    jobs.setCity(city);
		    jobs.setState_id(state_id);
		    
		    ModelAndView mav = null;
		    
		 //System.out.println(jobs.toString());
		 
		 String msgJobUpdate = "Job was updated successfully!";		
		 String msgError = "Job was not insert!";	
		 
			
		 
		 jobsdao.update(id, jobs);
		 
		 List<Jobs> list_jobs=jobsdao.getJobsWithShortDescriptions();
		 
	     mav = new ModelAndView("adminka/moderator/jobs","list_jobs", list_jobs); 
	     List <States> list_states = statesdao.getStates() ;
	     mav.addObject("list_states",list_states);
        // mav.addObject(msgJobUpdate,msgJobUpdate)  ;
		 return   mav; 
	   
	
	    } 
	 /*
	   @ModelAttribute("jobs")
		public Jobs setUpUserForm() {
			return new Jobs();
		}
	 @RequestMapping("/updateJobByAdmin")  
	    public ModelAndView updateJobByAdminPage(@ModelAttribute("jobs") Jobs jobs)
	    {  
	        
	        return new ModelAndView("adminka/superadmin/jobs");  
	    }   
	*/
	 
	 
	
	 
	 
	 
	 
	 
	 @RequestMapping( "/deleteJobByModerator")  
	    public ModelAndView deleteJobByModerator(@RequestParam("id") int id )
	    { 
		 ModelAndView mav = null;
		 int result=-1;
		 
		 String msgJobDeleteOk = "Job was updated successfully!";	
		 String msgJobDeleteError = "Job was not deleted!";
		 
		 
		 
		  result = jobsdao.delete(id);	
		 
		/*pasted new */
		 
		 
		  List<Jobs> list_jobs=jobsdao.getJobsWithShortDescriptions();
	        
	        List<String>job_descriptions = new ArrayList<String>() ;       
	        
	        for (int i=0;i<list_jobs.size();i++)
	        { 	
	        	job_descriptions.add(list_jobs.get(i).getDescription());
	        }
	        
	        
	        List<Users> list_users=usersdao.getUsers()  ;
	        List <JobStatus> list_jobstatus = jobstatusdao.getJobStatus() ;
	      
	        mav = new ModelAndView("adminka/moderator/jobs","list_jobs", list_jobs);
	       
	        mav.addObject("list_jobstatus",list_jobstatus) ;
	        mav.addObject("list_users",list_users) ;     
	        
	        List <States> list_states = statesdao.getStates() ;
	        mav.addObject("list_states",list_states);
		 
	    	/*pasted new */
		 
		 
		 
		 
	    
		if  (result>0)
		{
		 mav.addObject("msgJobDeleteOk",msgJobDeleteOk)  ;
		}  
		else 
		{
	         mav.addObject("msgJobDeleteError",msgJobDeleteError)  ;
		}    
	         
			 
		
		return   mav; 
	    }  
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
