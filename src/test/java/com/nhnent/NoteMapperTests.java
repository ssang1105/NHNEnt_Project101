package com.nhnent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.nhnent.repository.NoteMapper;
import com.nhnent.repository.entity.Note;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Transactional
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GuestBookApplication.class)
@WebAppConfiguration
public class NoteMapperTests {
	
	@Autowired
	private NoteMapper noteMapper;
	
	private Note testNote;
	
	@Before
	public void setUp() {
		testNote = new Note();
		testNote.setUserEmail("ssang1105@live.co.kr");
		testNote.setPassword("1234");
		testNote.setBodyText("Hello World!!");
		testNote.setRegisteredDate(Timestamp.valueOf(LocalDateTime.now()));
		
		noteMapper.insert(testNote);
		testNote = noteMapper.selectByUserEmail("ssang1105@live.co.kr");
	}
	
	@Test
	public void insertAndDelete() {
		assertThat(testNote, notNullValue());
		
		Note note = noteMapper.selectByUserEmail("ssang1105@live.co.kr");
		noteMapper.delete(note);
	
		note = noteMapper.selectByUserEmail("ssang1105@live.co.kr");
		assertThat(note, nullValue());
	}
	
	@Test
	public void updateAndSelectByUserEmail() {
		assertThat(testNote, notNullValue());
		
		Note note = noteMapper.selectByUserEmail("ssang1105@live.co.kr");
		note.setUserEmail("asdfasdf@asdfasdf.com");
		noteMapper.update(note);
		
		Note updatednote = noteMapper.selectByUserEmail("asdfasdf@asdfasdf.com");
		assertThat(note.getId(), is(updatednote.getId()));
	}
	
	@Test
	public void selectList() {
		List<Note> notes = noteMapper.selectAll();
		assertThat(notes, notNullValue());
	}
	
	@Test
	public void selectOne() {
		assertThat(testNote, notNullValue());
		
		Note note= noteMapper.selectById(testNote.getId());
		assertThat(note, notNullValue());
	}
}