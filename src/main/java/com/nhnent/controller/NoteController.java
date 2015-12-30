package com.nhnent.controller;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.nhnent.GuestBookApplication;
import com.nhnent.repository.NoteMapper;
import com.nhnent.repository.entity.Note;

@Controller
public class NoteController {
	
	private static Logger logger = Logger.getLogger(GuestBookApplication.class.getName());
	@Autowired
	private NoteMapper noteMapper;
	
	@RequestMapping(value = "/note", method = RequestMethod.POST)
	public String uploadNote(@ModelAttribute Note note){
		
		logger.info("Insert Note!");
		logger.info("Note Body : " + note.getBodyText());
		logger.info("User email : " + note.getUserEmail());
		logger.info("User pwd : " + note.getPassword());
		logger.info("Current Time : " + Timestamp.valueOf(LocalDateTime.now()));
		
		// 유효성 check하는 함수 추가. 오류발생시 exception. exception -> /error로 redirect
		note.setRegisteredDate(Timestamp.valueOf(LocalDateTime.now())); 
		noteMapper.insert(note);
		
		return "redirect:/"; 
	}
	
	@RequestMapping(value = "/note", method = RequestMethod.PUT)
	public @ResponseBody Object updateNote(@RequestParam("noteId")String noteId, @RequestParam("pwd") String password, @RequestParam("newNoteBody") String newNoteBody){
		
		logger.info("noteID : " + noteId);
		logger.info("pwd : " + password);
		logger.info("new note body : " + newNoteBody);
		
		Note updateNote = noteMapper.selectOne(Long.valueOf(noteId));
		if(updateNote.getPassword() == password){
			updateNote.setBodyText(newNoteBody);
			updateNote.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
			noteMapper.update(updateNote);
			return "success";
		}
		else{
			return "fail";
		}
		
		
		 
	}
	
	@RequestMapping(value = "/note", method = RequestMethod.DELETE)
	public String deleteNote(@ModelAttribute Note note, WebRequest request,Model model){
		
		return "welcome"; 
	} 
	
	@RequestMapping(value = "/notes", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Object showAllNotes(){
		return noteMapper.selectAll();
	}
}
