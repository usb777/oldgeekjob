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

import dao.Messages_Dao;
import dao.Users_Dao;
import model.Messages;
import model.Users;

@SessionAttributes("user_id")
@Controller
public class JobSeekerMessageController 

{
	@Autowired  
	Messages_Dao messagesdao;//will inject dao from xml file
	
	@Autowired  
	Users_Dao usersdao;//will inject dao from xml file
	

	 @RequestMapping("/inboxMessagesJobSeeker")  
	    public ModelAndView showInboxMessages(@SessionAttribute("user_id") int user_id)
	    {   
		 System.out.println("USER ID  = "+user_id);
		 List<Messages> list_jobseekermessages = messagesdao.getMessagesToUserId(user_id)  ;
	        ModelAndView mav =  new ModelAndView("adminka/jobseeker/messageInbox","list_jobseekermessages",list_jobseekermessages); 
	       
	         return mav;
	    }
	 
	 @RequestMapping("/outboxMessagesJobSeeker")  
	    public ModelAndView showOutboxMessages(@SessionAttribute("user_id") int user_id)
	    {   
		 
		 List<Messages> list_jobseekermessages = messagesdao.getMessagesFromUserId(user_id)  ;
	        ModelAndView mav =  new ModelAndView("adminka/jobseeker/messageOutbox","list_jobseekermessages",list_jobseekermessages); 
	       
	         return mav;
	    }
	 
	 @RequestMapping("/newMessageJobSeeker")  
	    public ModelAndView sendMessage(@SessionAttribute("user_id") int user_id)
	    {  
		    ModelAndView mav = new ModelAndView("adminka/jobseeker/messagesNewMessage");	        
	        
		    /* TODO: Change list for employers only, add Admin and Moderators JIC */
		    
		    List<Users> list_users = usersdao.getUsersExceptById(user_id);
	        mav.addObject("list_users",list_users);
	        
		    return  mav;	        
	    }
	 //sendMessageByJobSeeker
	 @RequestMapping(value = "/sendMessageByJobSeeker",  method=RequestMethod.GET)
	 public  ModelAndView newMessageByAdmin( 
			    @RequestParam("from_id") int from_id,
				@RequestParam("to_id") int to_id,
				@RequestParam("title") String title, 
				@RequestParam("message") String message,
				@RequestParam("contact") String contact,
			/*	@RequestParam("date_message") Date date_message, */
				@RequestParam("status")int status,
				@RequestParam("attach_url")String attach_url
			 ) 
		{
		 Messages msgs = new Messages(0,from_id, to_id, title,	
					 message,  contact, /*date_message,*/ status,	attach_url);
		 
		 messagesdao.save(msgs);
		 
		 
		 	    		
		    	 

		 List<Messages> list_jobseekermessages = messagesdao.getMessagesFromUserId(from_id)  ;
	        ModelAndView mav =  new ModelAndView("adminka/jobseeker/messageOutbox","list_jobseekermessages",list_jobseekermessages); 
	       
	         return mav;        
	  
		}
	 //deleteMessageByAdmin
	 
	 @RequestMapping(value = "/deleteInboxMessageByJobseeker",  method=RequestMethod.GET)
	 public  ModelAndView deleteInboxMessageByJobSeeker(  @RequestParam("m_id") int m_id, 
			 @SessionAttribute("user_id") int user_id )
	 {
		 messagesdao.delete(m_id);
			 
		 List<Messages> list_jobseekermessages = messagesdao.getMessagesToUserId(user_id)  ;
	        ModelAndView mav =  new ModelAndView("adminka/jobseeker/messageInbox","list_jobseekermessages",list_jobseekermessages); 
	       
	         return mav;   
	 }
	 
	 @RequestMapping(value = "/deleteOutboxMessageByJobseeker",  method=RequestMethod.GET)
	 public  ModelAndView deleteOutboxMessageByJobSeeker(  @RequestParam("m_id") int m_id, 
			 @SessionAttribute("user_id") int user_id )
	 {
		 messagesdao.delete(m_id);
			 
		 List<Messages> list_jobseekermessages = messagesdao.getMessagesFromUserId(user_id)  ;
	        ModelAndView mav =  new ModelAndView("adminka/jobseeker/messageOutbox","list_jobseekermessages",list_jobseekermessages); 
	       
	         return mav;
	 }
	 
	
	
}
