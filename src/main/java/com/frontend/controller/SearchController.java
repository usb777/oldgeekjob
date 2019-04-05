package com.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;



@Controller
public class SearchController 
{
	@RequestMapping(value = "/search", method=RequestMethod.POST)
	public  ModelAndView searchJob(		
			@RequestParam("jobName") String jobName,
			@RequestParam("location") String location)
	{
		ModelAndView mav = new ModelAndView("jobSearch");
		mav.addObject("jobName",jobName);
		mav.addObject("location",location);
		return mav;
	}
			
	
	
}
