package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import dao.Jobs_Dao;
import dao.Users_Dao;
import model.Users;


@Controller
public class BackendController 
{
	
	@Autowired  
	Users_Dao usersdao;//will inject dao from xml file
	
	@Autowired  
	Jobs_Dao jobsdao;//will inject dao from xml file
		
	 
	  @RequestMapping("/usertest")  
	    public ModelAndView user_test()
	    {  
	        Users user=usersdao.getUserByLogin("dzsamoila")  ;
	        return new ModelAndView("usertest","user",user); 
	        
	    }
	 
	
	
}
