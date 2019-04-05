package com.frontend.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dao.JobAssignment_Dao;
import dao.JobStatus_Dao;
import dao.Jobs_Dao;
import dao.Profile_Dao;
import dao.Role_User_Dao;
import dao.States_Dao;
import dao.Users_Dao;
import model.JobAssignment;
import model.JobStatus;
import model.Jobs;
import model.Role_User;
import model.States;
import model.Users;
import util.Bcrypting;



@Controller
@SessionAttributes("user_id")
@RequestMapping("/")
public class IndexController 
{
	
	@Autowired  
    Role_User_Dao role_userdao;//will inject dao from xml file
	
	@Autowired
	Users_Dao usersdao;//will inject dao from xml file
	
	@Autowired
	Jobs_Dao jobsdao;//will inject dao from xml file
	
	@Autowired  
	JobStatus_Dao jobstatusdao;//will inject dao from xml file
	
	@Autowired  
	JobAssignment_Dao assignedjobsdao;//will inject dao from xml file
	
	@Autowired 
	Profile_Dao profiledao;
	
	@Autowired	
	States_Dao statesdao;
	
	
	
	@RequestMapping("/index")
	public ModelAndView showIndexPage() 
	{	 
		List<Jobs> list_jobs=jobsdao.getJobsFrontEnd()	;
		ModelAndView mv = new ModelAndView("index","list_jobs",list_jobs);

		List <States> list_states = statesdao.getStates() ;
		mv.addObject("list_states",list_states);
		System.out.println("IndexController");
		return mv;
	}
	

	@RequestMapping("/")
	public ModelAndView indexpage(HttpServletRequest request) 
	{	
		List<Jobs> list_jobs=jobsdao.getJobsFrontEnd();		
		ModelAndView mv = new ModelAndView("index","list_jobs",list_jobs);
		
		List <States> list_states = statesdao.getStates() ;
		mv.addObject("list_states",list_states);
		
		System.out.println("Hello world!");
		
		/*
		HttpSession session = request.getSession();	
			   session.setAttribute("user_id", null );
		*/
		return mv;		
	}
	
	@RequestMapping("/jobs")
	public ModelAndView showJobsPage() 
	{	
		List<Jobs> list_jobs=jobsdao.getJobsFrontEnd();		
		ModelAndView mv = new ModelAndView("index","list_jobs",list_jobs);
		
		List <States> list_states = statesdao.getStates() ;
		mv.addObject("list_states",list_states);
		
		return mv;		
	}
	
	
	
	
	
	
	  @RequestMapping("/viewru")  
	    public ModelAndView viewru()
	   {  
	        List<Role_User> list=role_userdao.getRoleUsers()  ;
	        return new ModelAndView("viewru","list",list);  
	        
	     
	        
	        
	        
	    }  

	  @RequestMapping("/register")  
		public ModelAndView pageRegister() 
		{
							 
			ModelAndView mv = new ModelAndView("register");		
		
			return mv;
		}
	
	 
		@RequestMapping("/okregistr")
		public ModelAndView okRegister() 
		{
			 
			ModelAndView mv = new ModelAndView("okregistr");
			
		
			return mv;
		}
	  
	  @RequestMapping(value = "/registerUser", method=RequestMethod.POST)
		public  ModelAndView registerNewUser( 
				@ModelAttribute("users") Users users,				
				@RequestParam("fname") String fname,
				@RequestParam("lname") String lname,
				@RequestParam("login") String login, 
				@RequestParam("email") String email,
				@RequestParam("telefona") String telefona,
				@RequestParam("role_id") int role_id,
				@RequestParam("password")String password,
				@RequestParam("password1")String password1	) 
		{ // body of method	
		   ModelAndView mav = null;
		   
		   Bcrypting bcrypt = new Bcrypting();
		   
		
		   
		   
		  if (usersdao.isValidLogin(login)) 
	    	{
	    		
		    	 
			    	mav =  new ModelAndView("register");
			    	mav.addObject("errorRegLogin","this user with same login already in system");
			    return mav;
	    	}
		 
		  
		    if( (  bcrypt.verifyHash(password1, bcrypt.hash(password) )  )&&(!password.equals("")) &&(!password1.equals("")) &&(password!=null)  &&(password1!=null)&&(!login.equals("")) &&(login!=null)    )
		    {
		    	
		    	
		    	users.setPassword(bcrypt.hash(password));
		    			    	
		    	
		    			    	    
		    	usersdao.save(users);
		    	
		  	    //    return new ModelAndView("redirect:/viewemp");//will redirect to viewemp request mapping  
		  	  
		    	
		    	//Create Deafault profile field for this User
		    	if (role_id == 4) // JobSeeker Enter
		    	{  
		    		System.out.println(usersdao.getMaxUserId());
		    		
		    	  	profiledao.save(usersdao.getMaxUserId());
		    	}
		  	     
		    		
		  	    	 
		  	     
		  	  
		    	
		    		mav =  new ModelAndView("okregistr");
		    		
		    		 return mav;	
		    
		    	
		    }
		    else 
		    {
		    	 
		    	 
		    	mav =  new ModelAndView("register");
		    	
		    	if (usersdao.isValidLogin(login)) 
		    	{
		    		mav.addObject("errorRegLogin","this user with same login already in system");
		    	}
		    	
		    	mav.addObject("errorRegPassw","Password or Login do not match!");
		    	 return mav;	
		    }
		  
		  
		
		   
		} // user_info_changes
	
	  
	  @RequestMapping(value = "/jobPage", method=RequestMethod.GET)
	  public ModelAndView showJobPage(@RequestParam("job_id") int jobId, @SessionAttribute("user_id") int user_id,  HttpServletRequest request)
	    {  
		  Jobs job = new Jobs();
		  job = jobsdao.getJobById(jobId);		
		  
		  String applyButtonVisible = "1";
		  
	
		  if( assignedjobsdao.checkAssignment(jobId, user_id) )
		  {
			  applyButtonVisible = "0";
		  }
		 
		  
			  
		  ModelAndView mav = new ModelAndView("jobPage");
		  mav.addObject("job",job);
		  mav.addObject("job_id",jobId);
		  mav.addObject("applyButtonVisible",applyButtonVisible);
		  
		  return mav;
	    }
	  
	 	 
	  
	  
	/*  
	  @RequestMapping("/owners/{ownerId}/pets/{petId}", method=RequestMethod.GET)
	  public String findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {
	    Owner owner = ownerService.findOwner(ownderId);  
	    Pet pet = owner.getPet(petId);  
	    model.addAttribute("pet", pet);  
	    return "displayPet"; 
	  } 
	  
	  */
	  
	  
	  @RequestMapping(value = "/oldGeekLogin", method=RequestMethod.POST)
		public ModelAndView loginUser(
				@RequestParam("login") String login,
				@RequestParam("password") String password,
				               HttpServletRequest request) throws Exception
		{ 
		 		  
		      	       
		       ModelAndView mav=null;
		       
		    
		       Bcrypting bcrypt = new Bcrypting();
				//  System.out.println(bcrypt.hash("admin") );
				  
				  if (usersdao.isValidLogin(login))
				  {
					  Users user=usersdao.getUserByLogin(login)  ;	
					  
					  if ( user.getLogin().equals(login) && bcrypt.verifyHash(password, user.getPassword())  )
				       {  
						  //TODO send user to page , depends on his Role
						 
						  List<Users> list_users = null;
						  HttpSession session = null;
						  Users users = null ;
						  
				    	 switch (user.getRole_id()) 
				    	 {
				    	 case 1:  // SuperAdmin Part
				    		 list_users=usersdao.getUsers()  ;
				    		 mav = new ModelAndView("adminka/superadmin/adminpage","user",user); 
				    		 mav.addObject("list_users",list_users);
				    		 
				    		 
				    		session = request.getSession();
				    		 users = new Users();
				    		users = usersdao.getUserByLogin(login);
				 		    session.setAttribute("login", login); 
				  		    session.setAttribute("user_id",users.getU_id() );
				  		    session.setAttribute("role_id",users.getRole_id() );
				    		 
				    		 break;
				    	 case 2: // Moderator Part
				    		 
				    		list_users=usersdao.getUsers()  ;
				    		mav = new ModelAndView("adminka/moderator/moderatorpage","user",user); 
				    		mav.addObject("list_users",list_users);
				    		 
				    		 
				    		session = request.getSession();
				    		users = new Users();
				    		users = usersdao.getUserByLogin(login);
				 		    session.setAttribute("login", login); 
				  		    session.setAttribute("user_id",users.getU_id() );
				  		    session.setAttribute("role_id",users.getRole_id() );
				    		 
				    		  break;
				    		 
				    		 
				    	 case 3:  // Employer Part
				    		 
				    		 
				    		 session = request.getSession();
					    		users = new Users();
					    		users = usersdao.getUserByLogin(login);
					 		    session.setAttribute("login", login); 
					  		    session.setAttribute("user_id",users.getU_id() );
					  		    session.setAttribute("role_id",users.getRole_id() );
				    		 
		          List <JobStatus> list_jobstatus = jobstatusdao.getJobStatus() ; 		 
		          List<Jobs> list_jobs_employer = jobsdao.getJobsWithShortDescriptionsForEmployer(users.getU_id());               
					          
					         mav = new ModelAndView("adminka/employer/employerpage","list_jobs_employer",list_jobs_employer);
					         mav.addObject("list_jobstatus",list_jobstatus) ;
					         mav.addObject("list_users",list_users) ; 
				    		
				    		 
				    		 
				    		 
				    	   // mav.addObject("errorRegLogin","this user with same login already in system");
				    		      
				    		 
				    	 break;
				    	 
				    	 case 4:  //JOBSEEKER part
				    		 
				    	//	 mav = new ModelAndView("adminka/jobseeker/jobseekerpage","user",user);
				    		
				    		 
				    		 
				    		 session = request.getSession();
					    		users = new Users();
					    		users = usersdao.getUserByLogin(login);
					 		    session.setAttribute("login", login); 
					  		    session.setAttribute("user_id",users.getU_id() );
					  		    session.setAttribute("role_id",users.getRole_id() );
					  		    
					  		  List<JobAssignment> list_assignedjobs = assignedjobsdao.getAssignmentJobs(users.getU_id())  ;
				    			mav = new ModelAndView("adminka/jobseeker/jobseekerpage");
				    			mav.addObject("list_assignedjobs",list_assignedjobs);
				    			
				    			
				    			
				    			
				    	 break;
				    	 
				    	 
				    	 
				    	 
				    	 default:   { 
				    		         mav =  new ModelAndView("/index");
				    	             mav.addObject("errorLogin","Invalid user credentials");
				    	             break;
				    	 			}
				    	 
				    	 
				    	 } //switch				 	   
				       }
				       else  // Login exist, but password do not match
				       {
				    	   mav =  new ModelAndView("/index");
				    	   mav.addObject("errorLogin","Invalid user credentials");
				       }
					  
				  } // if (usersdao.isValidLogin(login))  END===
				  
				  else //invalid user login, Login doesn't exist in system
				  {
					  mav =  new ModelAndView("/index");
			    	   mav.addObject("errorLogin","Invalid user credentials");  
				  }
				  
		  
		       return mav;
		}
	  
	  
		 /**
		  * logout Action , destroy session variables 
		  * @param request
		  * @return
		  */
		 @RequestMapping("/logout")  
		    public ModelAndView logOut(HttpServletRequest request)
		    {  
			 HttpSession session = request.getSession(); 
			 
			
	  		    session.setAttribute("user_id", null );
	  		    session.setAttribute("role_id",null );
			    session.setAttribute("login", null);
			 
		     session.invalidate(); 
		     
		     List<Jobs> list_jobs=jobsdao.getJobsFrontEnd();
		     
			 ModelAndView mav = new ModelAndView("index","list_jobs",list_jobs);
		   
		     
		     return   mav;
		    } 
		  
		
		 @RequestMapping(value = "/AssignToJob", method=RequestMethod.POST)  
		    public ModelAndView AssignToJobAction
		           ( 
		    		@SessionAttribute("user_id") int user_id,
		    		@RequestParam("job_id") int job_id
		    		)
		    {
			 
			if( !assignedjobsdao.checkAssignment(job_id, user_id) )
			{
			 assignedjobsdao.save(job_id, user_id);
			}
             List<Jobs> list_jobs=jobsdao.getJobsFrontEnd();		     
			 ModelAndView mav = new ModelAndView("index","list_jobs",list_jobs);
			 
			 mav.addObject("messageOk","You applied to this Job");
			 return mav;
			 
		    }
	
}


