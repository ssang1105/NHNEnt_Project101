package com.nhnent.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhnent.GuestBookApplication;


@Controller
public class WelcomeController {
	
	private static Logger logger = Logger.getLogger(GuestBookApplication.class.getName());
	
	
	
	@RequestMapping("/")
	public String index(HttpSession session,Model model) {
		
		
		
		return "welcome";
	}
	
//	@RequestMapping(value = "/error")
//	public String error(@RequestParam String message, Model model) {
//		model.addAttribute("message", message);
//		return "error";
//	}
	
}