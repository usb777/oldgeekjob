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
public class AdminMsgController
{
	
	@Autowired  
	Messages_Dao messagesdao;//will inject dao from xml file
	
	@Autowired  
	Users_Dao usersdao;//will inject dao from xml file
	
	 @RequestMapping("/adminmessages")  
	    public ModelAndView showMessages()
	    {  
		   
		
	        List<Messages> list_messages=messagesdao.getMessages();	      
	        ModelAndView mav = new ModelAndView("adminka/superadmin/messages","list_messages",list_messages);	        
	      
	        
	        
	        return  mav;	        
	    } 
	 
	 @RequestMapping("/newmessage")  
	    public ModelAndView sendMessage(@SessionAttribute("user_id") int user_id)
	    {  
		    ModelAndView mav = new ModelAndView("adminka/superadmin/messagesNewMessage");	        
	        
		    List<Users> list_users = usersdao.getUsersExceptById(user_id);
	        mav.addObject("list_users",list_users);
	        
		    return  mav;	        
	    }
	 
	 
	 @RequestMapping(value = "/sendMessageByAdmin",  method=RequestMethod.GET)
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
		 
		 
		 	    		
		    	 
	      List<Messages> list_messages = messagesdao.getMessages();	      
	      ModelAndView mav = new ModelAndView("adminka/superadmin/messages","list_messages",list_messages);	        
	      return  mav;	        
	  
		}
	 
	 
	 //deleteMessageByAdmin
	 @RequestMapping(value = "/deleteMessageByAdmin",  method=RequestMethod.GET)
	 public  ModelAndView newMessageByAdmin(  @RequestParam("id") int id )
	 {
		 messagesdao.delete(id);
			 
	      List<Messages> list_messages = messagesdao.getMessages();	      
	      ModelAndView mav = new ModelAndView("adminka/superadmin/messages","list_messages",list_messages);	        
	      return  mav;	   
	 }
	
	 
	 
	 @RequestMapping("/inboxMessages")  
	    public ModelAndView inboxMessagesOfAdmin(@SessionAttribute("user_id") int user_id)
	    {  
		   List<Messages> list_messages=messagesdao.getMessagesToUserId(user_id);	      
	       ModelAndView mav = new ModelAndView("adminka/superadmin/messages","list_messages",list_messages);	        
	       return  mav;
	    }
	 
	 @RequestMapping("/outboxMessages")  
	    public ModelAndView outboxMessagesOfAdmin(@SessionAttribute("user_id") int user_id)
	    {  
		   List<Messages> list_messages=messagesdao.getMessagesFromUserId(user_id);	      
	       ModelAndView mav = new ModelAndView("adminka/superadmin/messages","list_messages",list_messages);	        
	       return  mav;
	    }
	 

}
