package org.shyu.springboot.controller;

import org.shyu.springboot.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/user")
public class TopicController {
	@Autowired
	TopicService topicService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login() {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("custom-login");
	    return modelAndView;
    }
	
	@RequestMapping(value="/secure/topic-details", method=RequestMethod.GET)
	public ModelAndView getAllTopic() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("usertopics", topicService.getAllTopics());
		modelAndView.setViewName("topics");
		return modelAndView;
	}

	@RequestMapping(value="/error", method=RequestMethod.GET)
	public ModelAndView error() {
	    ModelAndView modelAndView = new ModelAndView();
	    String errorMessage= "You are not authorized for the requested data.";
	    modelAndView.addObject("errorMsg", errorMessage);
	    modelAndView.setViewName("error");
	    return modelAndView;
    }	
	
}
