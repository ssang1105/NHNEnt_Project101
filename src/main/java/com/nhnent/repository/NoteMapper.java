package com.nhnent.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nhnent.repository.entity.Note;

public interface NoteMapper {
	
	public Long countAll();
	
	public List<Note> selectAll();
	
	public Note selectOne(Long id);
	
	public Note selectByUserEmail(@Param("userEmail") String userEmail);
	
	public void insert(Note note);
	
	public void update(Note note);
	
	public void delete(Note note);

}
