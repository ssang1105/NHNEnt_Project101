package com.nhnent.controller;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Logger;
import java.util.regex.Pattern;

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
	public String createNote(@ModelAttribute Note note, Model model) throws Exception{
		
		try{
			
			if(note.getBodyText().equals("") || note.getUserEmail().equals("") || note.getPassword().equals("")){
				model.addAttribute("message", "Fill the blank area!");
				return String.format("redirect:/error?message=%s", "Fill the blank area!");
			}
				
			
			if(isValidEmail(note.getUserEmail())){
				note.setRegisteredDate(Timestamp.valueOf(LocalDateTime.now())); 
				noteMapper.insert(note);
				return "redirect:/";
			}
			else{
				model.addAttribute("message", "Wrong Email format!");
				return String.format("redirect:/error?message=%s", "Wrong Email format!");
			}
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return String.format("redirect:/error?message=%s", e.getMessage());
		}
		
		 
	}
	
	@RequestMapping(value = "/note", method = RequestMethod.PUT, produces="application/json")
	public @ResponseBody String updateNote(@RequestParam("noteId")String noteId, @RequestParam("pwd") String password, @RequestParam("newNoteBody") String newNoteBody, Model model)  throws Exception{
		try{
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
			
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return String.format("redirect:/error?message=%s", e.getMessage());
		}
		
		 
	}
	
	@RequestMapping(value = "/note", method = RequestMethod.DELETE)
	public String deleteNote(@ModelAttribute Note note, WebRequest request,Model model){
		// 삭제 기능 개발시 
		return "none"; 
	} 

	public boolean isValidEmail(String email) {
        if (email==null) return false;
        boolean b = Pattern.matches( "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",email.trim());
        return b;
    }
}
