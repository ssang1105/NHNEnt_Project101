package com.nhnent;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nhnent.controller.NoteController;
import com.nhnent.repository.NoteMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GuestBookApplication.class)
@WebAppConfiguration
public class NoteControllerTests {

	@Mock
    NoteMapper noteMapper;
    @InjectMocks
    private NoteController noteController;
    
    @Before
    public void setUp() throws Exception {
         MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void isValidEmailTest(){
		assertEquals(noteController.isValidEmail("sangwoo@nhnent.com"), true);
		assertEquals(noteController.isValidEmail("asdf@asdf.ca@.co"), false);
		assertEquals(noteController.isValidEmail("sangwoo@naver.com"), true);
		assertEquals(noteController.isValidEmail("11@11.11"), false);
		assertEquals(noteController.isValidEmail("aasdfasdfa@c,."), false);
	}
}
