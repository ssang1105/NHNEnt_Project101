package com.nhnent.controller;


import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.nhnent.GuestBookApplication;
import com.nhnent.repository.NoteMapper;
import com.nhnent.repository.entity.Note;

@Controller
public class NoteController {
	
	private static Logger logger = Logger.getLogger(GuestBookApplication.class.getName());
	@Autowired
	private NoteMapper noteMapper;
	
	@RequestMapping(value = "/note", method = RequestMethod.POST, produces = "application/json")
	public String uploadNote(@ModelAttribute Note note, WebRequest request,Model model) throws Exception {
		
		logger.info("Note Body : " + note.getBodyText());
		logger.info("user email : " + note.getUserEmail());
		logger.info("user pwd : " + note.getPassword());
		
		note.setRegisteredDate(Date.valueOf(LocalDate.now()));
		noteMapper.insert(note);
		
		return "welcome";
	}

}
