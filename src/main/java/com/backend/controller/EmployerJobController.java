package com.backend.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import dao.EmploymentType_Dao;
import dao.JobStatus_Dao;
import dao.Jobs_Dao;
import dao.Role_User_Dao;
import dao.States_Dao;
import dao.Users_Dao;


import model.JobStatus;
import model.Jobs;
import model.States;
import model.Users;





@Controller
public class EmployerJobController
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
	States_Dao statesdao;
	
	
	 @RequestMapping("/employerpage")  
    public ModelAndView showJobsOfEmployer(HttpServletRequest request)
    {  
		 
		 HttpSession session = request.getSession(); 
		 int employer_id =  (Integer)session.getAttribute("user_id");
		    
		 
		List<Users> list_users=usersdao.getUsers()  ;
	    List <JobStatus> list_jobstatus = jobstatusdao.getJobStatus() ; 		 
        List<Jobs> list_jobs_employer = jobsdao.getJobsWithShortDescriptionsForEmployer(employer_id);               
        
        ModelAndView mav = new ModelAndView("adminka/employer/employerpage","list_jobs_employer",list_jobs_employer);
        
        mav.addObject("list_jobstatus",list_jobstatus) ;
        mav.addObject("list_users",list_users) ;     
        mav.addObject("user_id",employer_id) ;
        
        List <States> list_states = statesdao.getStates() ;
        mav.addObject("list_states",list_states);
        
      
        
        return  mav;
        
    }
	 
	 
	 
	 @RequestMapping(value = "/updateJobByEmployerPage", method=RequestMethod.GET)  
	    public ModelAndView updateJobPage( @RequestParam("id") int id )
	    {   
		 
		  Jobs currentJob = new Jobs();
		  currentJob =  jobsdao.getJobById(id);
		  List <JobStatus> list_jobstatus = jobstatusdao.getJobStatus() ;  
		     
		  ModelAndView mav =  new ModelAndView("adminka/employer/jobUpdate","currentJob",currentJob);
		  mav.addObject("list_jobstatus",list_jobstatus);
		  
		  List <States> list_states = statesdao.getStates() ;
		  mav.addObject("list_states",list_states);
		  
		  return mav;
		    		   
	    }
	 
	 
	 @RequestMapping( value = "/updateJobByEmployer",   method=RequestMethod.GET)  
	    public ModelAndView updateJobByEmployer
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
				@RequestParam("state_id") int state_id,
				HttpServletRequest request
			
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
		 
		 HttpSession session = request.getSession(); 
		 int employer_id =  (Integer)session.getAttribute("user_id");
		    
		 
		List<Users> list_users=usersdao.getUsers()  ;
	    List <JobStatus> list_jobstatus = jobstatusdao.getJobStatus() ; 		 
        List<Jobs> list_jobs_employer = jobsdao.getJobsWithShortDescriptionsForEmployer(employer_id);               
        
        mav = new ModelAndView("adminka/employer/employerpage","list_jobs_employer",list_jobs_employer);
        
        mav.addObject("list_jobstatus",list_jobstatus) ;
        mav.addObject("list_users",list_users) ;     
        mav.addObject("user_id",employer_id) ;
        
        List <States> list_states = statesdao.getStates() ;
        mav.addObject("list_states",list_states);
		 
		 return mav;
	    } 
	 
	 
	 
	 @RequestMapping("/insertJobByEmployerPage")  
	    public ModelAndView insertJobByAdminPage()
	    {   
		  List <JobStatus> list_jobstatus = jobstatusdao.getJobStatus() ;      
	     
		  ModelAndView mav =   new ModelAndView("adminka/employer/jobInsert"); 
		  mav.addObject("list_jobstatus",list_jobstatus);
		  
		  List <States> list_states = statesdao.getStates() ;
		  mav.addObject("list_states",list_states);
		  
		  return  mav;
	    } 
	 
	 
	 @RequestMapping(value = "/insertJobByEmployer",  method=RequestMethod.GET)  
	    public ModelAndView insertJobByAdmin
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
				@RequestParam("state_id") int state_id,
				HttpServletRequest request
				
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
		
		
		
		// int user_id =  (Integer)(request.getAttribute("user_id") );
		
		 HttpSession session = request.getSession(); 
		 int employer_id =  (Integer)session.getAttribute("user_id");
		    
		 
		List<Users> list_users=usersdao.getUsers()  ;
	    List <JobStatus> list_jobstatus = jobstatusdao.getJobStatus() ; 		 
        List<Jobs> list_jobs_employer = jobsdao.getJobsWithShortDescriptionsForEmployer(employer_id);               
        
        ModelAndView mav = new ModelAndView("adminka/employer/employerpage","list_jobs_employer",list_jobs_employer);
        
        mav.addObject("list_jobstatus",list_jobstatus) ;
        mav.addObject("list_users",list_users) ;     
        mav.addObject("user_id",employer_id) ;
        
        List <States> list_states = statesdao.getStates() ;
        mav.addObject("list_states",list_states);
	     
	     return mav;
	    
	    } 
	 
	 
	 
	 @RequestMapping(value = "/deleteJobByEmployer",  method=RequestMethod.GET)  
	    public ModelAndView deleteJobByEmployer (@RequestParam("id")int job_id, HttpServletRequest request	)
	    
	    {
		
		 
				 
				 jobsdao.delete(job_id);
				 
				 
				 HttpSession session = request.getSession(); 
				 int employer_id =  (Integer)session.getAttribute("user_id");
				    
				 
				List<Users> list_users=usersdao.getUsers()  ;
			    List <JobStatus> list_jobstatus = jobstatusdao.getJobStatus() ; 		 
		        List<Jobs> list_jobs_employer = jobsdao.getJobsWithShortDescriptionsForEmployer(employer_id);               
		        
		        ModelAndView mav = new ModelAndView("adminka/employer/employerpage","list_jobs_employer",list_jobs_employer);
		        
		        mav.addObject("list_jobstatus",list_jobstatus) ;
		        mav.addObject("list_users",list_users) ;     
		        mav.addObject("user_id",employer_id) ;
		        
		        List <States> list_states = statesdao.getStates() ;
		        mav.addObject("list_states",list_states);
		 
		 return mav;
	    }
	 
	 
	 

}
