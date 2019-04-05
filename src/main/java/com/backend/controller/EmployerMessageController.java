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
import model.Jobs;
import model.Messages;
import model.Users;

@SessionAttributes("user_id")
@Controller
public class EmployerMessageController 

{
	@Autowired  
	Messages_Dao messagesdao;//will inject dao from xml file
	
	@Autowired  
	Users_Dao usersdao;//will inject dao from xml file
	

	 @RequestMapping("/inboxMessagesEmployer")  
	    public ModelAndView showInboxMessages(@SessionAttribute("user_id") int user_id)
	    {   
		 System.out.println("USER ID  = "+user_id);
		 List<Messages> list_employermessages = messagesdao.getMessagesToUserId(user_id)  ;
	        ModelAndView mav =  new ModelAndView("adminka/employer/messageInbox","list_employermessages",list_employermessages); 
	       
	         return mav;
	    }
	 
	 @RequestMapping("/outboxMessagesEmployer")  
	    public ModelAndView showOutboxMessages(@SessionAttribute("user_id") int user_id)
	    {   
		 
		 List<Messages> list_employermessages = messagesdao.getMessagesFromUserId(user_id)  ;
	        ModelAndView mav =  new ModelAndView("adminka/employer/messageOutbox","list_employermessages",list_employermessages); 
	       
	         return mav;
	    }
	 
	 @RequestMapping("/newMessageEmployer")  
	    public ModelAndView sendMessage(@SessionAttribute("user_id") int user_id)
	    {  
		    ModelAndView mav = new ModelAndView("adminka/employer/messagesNewMessage");	        
	        
		    /*TODO: Change list for employers only, add Admin and Moderators JIC*/
		    List<Users> list_users = usersdao.getUsersExceptById(user_id);
	        mav.addObject("list_users",list_users);
	        
		    return  mav;	        
	    }
	 //sendMessageByEmployer
	 @RequestMapping(value = "/sendMessageByEmployer",  method=RequestMethod.GET)
	 public  ModelAndView newMessageByEmployer( 
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
		 
		 
		 	    		
		    	 

		 List<Messages> list_employermessages = messagesdao.getMessagesFromUserId(from_id)  ;
	        ModelAndView mav =  new ModelAndView("adminka/employer/messageOutbox","list_employermessages",list_employermessages); 
	       
	         return mav;        
	  
		}
	 //deleteMessageByAdmin
	 
	 @RequestMapping(value = "/deleteInboxMessageByEmployer",  method=RequestMethod.GET)
	 public  ModelAndView deleteInboxMessageByEmployer(  @RequestParam("m_id") int m_id, 
			 @SessionAttribute("user_id") int user_id )
	 {
		 messagesdao.delete(m_id);
			 
		 List<Messages> list_employermessages = messagesdao.getMessagesToUserId(user_id)  ;
	        ModelAndView mav =  new ModelAndView("adminka/employer/messageInbox","list_employermessages",list_employermessages); 
	       
	         return mav;   
	 }
	 
	 @RequestMapping(value = "/deleteOutboxMessageByEmployer",  method=RequestMethod.GET)
	 public  ModelAndView deleteOutboxMessageByEmployer(  @RequestParam("m_id") int m_id, 
			 @SessionAttribute("user_id") int user_id )
	 {
		 messagesdao.delete(m_id);
			 
		 List<Messages> list_employermessages = messagesdao.getMessagesFromUserId(user_id)  ;
	        ModelAndView mav =  new ModelAndView("adminka/employer/messageOutbox","list_employermessages",list_employermessages); 
	       
	         return mav;
	 }
	 
	
	
}
