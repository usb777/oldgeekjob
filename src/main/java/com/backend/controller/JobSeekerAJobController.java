package com.backend.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import model.JobAssignment;
import dao.JobAssignment_Dao;


@Controller
@SessionAttributes("user_id")
public class JobSeekerAJobController
{
	@Autowired  
	JobAssignment_Dao assignedjobsdao;//will inject dao from xml file	
	
	
	@RequestMapping("/assignedjobs") 
	public ModelAndView showJobSeekerPage( @SessionAttribute("user_id") int user_id)
	{
	//	int user_id = Integer.valueOf(request.getAttribute("user_id").toString() );//!!!!!!!!!!!!!!
		
		List<JobAssignment> list_assignedjobs = assignedjobsdao.getAssignmentJobs(user_id)  ;  // 2 NO good
		ModelAndView mav = new ModelAndView("adminka/jobseeker/jobseekerpage");
		mav.addObject("list_assignedjobs",list_assignedjobs);
    
    return  mav;
		
	}
	
	
	//delete ---- deleteAJobByJobSeeker , requestParameter id , hided ja_id
	
	 @RequestMapping(value = "/deleteAJobByJobSeeker",  method=RequestMethod.GET)  
	    public ModelAndView deleteJobByEmployer (@RequestParam("id")int ja_id, @SessionAttribute("user_id") int user_id	)
	    
	    {  
		 
		   assignedjobsdao.delete(ja_id);
		 
		    List<JobAssignment> list_assignedjobs = assignedjobsdao.getAssignmentJobs(user_id)  ;  // 2 NO good
			ModelAndView mav = new ModelAndView("adminka/jobseeker/jobseekerpage");
			mav.addObject("list_assignedjobs",list_assignedjobs);
	    
	    return  mav;
	    }
	
}
