package com.backend.controller;


import java.io.File;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;



import dao.Users_Dao;
import model.Profile;
import dao.JobAssignment_Dao;
import dao.Profile_Dao;
import util.Utilit;

@SessionAttributes("user_id")
@Controller
public class JobSeekerProfileController
{
    private String saveDirectory = "RESUME";
	 
	@Autowired  
	JobAssignment_Dao assignedjobsdao;//will inject dao from xml file
	
	@Autowired  
	Profile_Dao profiledao;
	
	@Autowired  
	Users_Dao usersdao;//will inject dao from xml file
	
	
	@RequestMapping("/profile")
	public ModelAndView showProfileOfJobSeeker(@SessionAttribute("user_id") int user_id)
	{ 
		ModelAndView mav = null;
			Profile profileCurrent = profiledao.getProfileByUserId(user_id);		
		
		mav = new ModelAndView("adminka/jobseeker/profile");
		mav.addObject("profileCurrent",profileCurrent );
		
		return mav;
		
	}
	
	/**
	 * 
	
	
	 * 	 */
	
	 @RequestMapping(value = "/updateProfileByJobSeekerPage", method=RequestMethod.GET)  
	    public ModelAndView updateProfilePage( @SessionAttribute("user_id") int user_id )
	    {   
		  Profile currentProfile = new Profile();
		  
		 /* 
		  Users user = usersdao.getUserById(user_id);
		  System.out.println("USER = "+user.toString());
		  String username = user.getFname()+" "+user.getLname()+" login: "+user.getLogin();
		  */
		  currentProfile =  profiledao.getProfileByUserId(user_id);
		  System.out.println("Current profile = "+currentProfile.toString());
		  ModelAndView mav =  new ModelAndView("adminka/jobseeker/profileUpdate","currentProfile",currentProfile);		 
		//  mav.addObject("username",username);
		  return mav;
		    		   
	    }
	 
	  
		/**
		 * Update Profile Action method
		 * @param p_id
		 * @param description
		 * @param u_id
		 * @param linkedin
		 * @param github
		 * @param resume_url
		 * @return
		 */
	 @RequestMapping(value = "/updateProfileByJobSeeker", method=RequestMethod.GET)  
	    public ModelAndView updateProfileByJobSeeker(
	    		@RequestParam("p_id") int p_id,
	    		@RequestParam("description") String description,
	    		@RequestParam("u_id") int u_id,	    		
	    		@RequestParam("linkedin") String linkedin,
	    		@RequestParam("github") String github,
	    		@RequestParam("resume_url") String resume_url
	    		)
	    {   
		 ModelAndView mav = null;
		  Profile profileUpdated = new Profile();
		 
		  /*
		  Users user = usersdao.getUserById(u_id);
		  String username = user.getFname()+" "+user.getLname()+" login: "+user.getLogin();
		  */
		  profileUpdated.setP_id(p_id); 
		  profileUpdated.setDescription(description);
		  profileUpdated.setU_id(u_id);
		  profileUpdated.setLinkedin(linkedin);
		  profileUpdated.setGithub(github);
		  profileUpdated.setResume_url(resume_url);
		  
		  profiledao.update(p_id, profileUpdated);		  
		  
          Profile currentProfile = new Profile();		  
		  currentProfile =  profiledao.getProfileByUserId(u_id);
		  mav =  new ModelAndView("adminka/jobseeker/profileUpdate","currentProfile",currentProfile);		 
		//  mav.addObject("username",username);
		  return mav;
		    		   
	    }
	 
	 //profileResumeUploadPage
	 @RequestMapping("/profileResumeUploadPage")  
	    public ModelAndView uploadResumePage(@SessionAttribute("user_id") int user_id)
	    {
		 
		 Profile currentProfile = new Profile();		  
		 currentProfile =  profiledao.getProfileByUserId(user_id);
		 
		 ModelAndView mav = new ModelAndView("adminka/jobseeker/profileResumeUpload");
		 mav.addObject("currentProfile",currentProfile);
		 return mav;
		 
	    }
	 
	 
/*	 
	 @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
		public String handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileUpload) 
				throws Exception 
		{
			
			  String appPath = request.getServletContext().getRealPath("");
	    	  
	    	  // constructs path of the directory to save uploaded file
	    	  String savePathResume = appPath + File.separator + saveDirectory+ File.separator;
	    	  
	    	  directoryCreateAndExist(savePathResume); // create directory
	         
	        System.out.println("description: " + request.getParameter("description"));
	         
	        if (fileUpload != null && fileUpload.length > 0) 
	        {
	            for (CommonsMultipartFile aFile : fileUpload)
	            {
	                 
	                System.out.println("Saving file: " + aFile.getOriginalFilename());
	                 
	                if (!aFile.getOriginalFilename().equals("")) 
	                {   //send file to Upload Directory
	                    aFile.transferTo(new File(savePathResume + aFile.getOriginalFilename()));
	                }
	            }
	        }
	 
	        // returns to the view "Result"
	        return "Result";
	    }
	 
	 
	*/ 
	 
	 
	 
	 @RequestMapping(value = "/profileResumeUploadAction",  method=RequestMethod.POST)  
	    public ModelAndView uploadResumeAction
	        (
	    		@SessionAttribute("user_id") int user_id, 
	    		HttpServletRequest request,
	    		@RequestParam CommonsMultipartFile[] fileUpload
	         ) throws Exception 
	    {

		  String appPath = request.getServletContext().getRealPath("");
   	  
   	  // constructs path of the directory to save uploaded file
   	  String savePathResume = appPath +  saveDirectory;
      String directoryUser = savePathResume+ File.separator +user_id+File.separator;
   	  
      directoryCreateAndExist(savePathResume); // create directory
   	  directoryCreateAndExist(directoryUser);
   	 
    //   System.out.println("description: " + request.getParameter("description"));
        
       if (fileUpload != null && fileUpload.length > 0) 
       {
           for (CommonsMultipartFile aFile : fileUpload)
           {
                
               System.out.println("Saving file: " + aFile.getOriginalFilename());
                
               if (!aFile.getOriginalFilename().equals("")) 
               {   //send file to Upload Directory
            	   
            	 //           	   String[] resumeSplit = (aFile.getOriginalFilename()).split(".",5); // Here mistake Cannot take extension
            	  
            	   
            	   
      Utilit utilit = new Utilit();
      String resumeWithExtension = "Resume"+ utilit.getFileExtensionFromString(aFile.getOriginalFilename()); // last element of string array - always extension
      
       aFile.transferTo(new File(directoryUser +resumeWithExtension )); // transfer file to Upload directory
      String resumeUrl = directoryUser +resumeWithExtension;
      System.out.println("RESUME URL === " +resumeUrl);
      System.out.println("USER_ID === " +user_id);
      try 
      {
       profiledao.updateResumeUrl(resumeUrl, user_id) ;   // ERROR ???  
        }    
      catch 
      (Exception se) 
            {
    	       System.out.println("Error e = " + se );
            }
     
               }
           } //for
       }

       // returns to the view "Result"
       ModelAndView mav = new ModelAndView("adminka/jobseeker/successResumeUpload");
       return mav;
       
	    }
	 
	  private void directoryCreateAndExist(String path)
	  {  
		  
		  File filed = new File(path);
	        if(!filed.exists())
	        {  if(filed.mkdir())
	          { System.out.println("directory is created"); }
	        } 
	           else{ System.out.println("directory exist");  }
	  }

}
