package com.nhnent.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnent.GuestBookApplication;
import com.nhnent.repository.NoteMapper;


@Controller
public class WelcomeController {
	
	private static Logger logger = Logger.getLogger(GuestBookApplication.class.getName());
	@Autowired
	private NoteMapper noteMapper;
	
	
	@RequestMapping("/")
	public String index(HttpSession session,Model model) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		model.addAttribute("notesList", mapper.writeValueAsString(noteMapper.selectAll()));
		
		return "welcome";
	}
	
//	@RequestMapping(value = "/error")
//	public String error(@RequestParam String message, Model model) {
//		model.addAttribute("message", message);
//		return "error";
//	}
	
}