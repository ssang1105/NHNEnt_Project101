package com.nhnent.controller;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.json.JSONObject;
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
		// 유효성 check하는 함수 추가. 오류발생시 exception. exception -> /error로 redirect
		note.setRegisteredDate(Timestamp.valueOf(LocalDateTime.now())); 
		noteMapper.insert(note);
		
		return "redirect:/"; 
	}
	
	@RequestMapping(value = "/note", method = RequestMethod.PUT, produces="application/json")
	public @ResponseBody String updateNote(@RequestParam("noteId")String noteId, @RequestParam("pwd") String password, @RequestParam("newNoteBody") String newNoteBody)  throws Exception{
		
		Note updateNote = noteMapper.selectById(Long.valueOf(noteId));

		
		if(password.equals(updateNote.getPassword())){
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
		// 삭제 기능 개발시 
		return "none"; 
	} 
	
	@RequestMapping(value = "/notes", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Object showAllNotes(){
		return noteMapper.selectAll();
	}
}
