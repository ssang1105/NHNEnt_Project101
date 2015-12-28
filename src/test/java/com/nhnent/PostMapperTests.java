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

import com.nhnent.repository.PostMapper;
import com.nhnent.repository.entity.Post;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Transactional
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GuestBookApplication.class)
@WebAppConfiguration
public class PostMapperTests {
	
	@Autowired
	private PostMapper postMapper;
	
	private Post entity;
	
	@Before
	public void setUp() {
		entity = new Post();
		entity.setUserEmail("ssang1105@live.co.kr");
		entity.setPassword("1234");
		entity.setBodyText("Hello World!!");
		entity.setRegisteredDate(Date.valueOf(LocalDate.now()));
		
		postMapper.insert(entity);
		entity = postMapper.selectByUserEmail("ssang1105@live.co.kr");
	}
	
	@Test
	public void insertAndDelete() {
		assertThat(entity, notNullValue());
		
		Post post = postMapper.selectByUserEmail("ssang1105@live.co.kr");
		postMapper.delete(post);
	
		post = postMapper.selectByUserEmail("ssang1105@live.co.kr");
		assertThat(post, nullValue());
	}
	
	@Test
	public void updateAndSelectByUserEmail() {
		assertThat(entity, notNullValue());
		
		Post post = postMapper.selectByUserEmail("ssang1105@live.co.kr");
		post.setUserEmail("asdfasdf@asdfasdf.com");
		postMapper.update(post);
		
		Post updatedPost = postMapper.selectByUserEmail("asdfasdf@asdfasdf.com");
		assertThat(post.getId(), is(updatedPost.getId()));
	}
	
	@Test
	public void selectList() {
		List<Post> posts = postMapper.selectList();
		assertThat(posts, notNullValue());
	}
	
	@Test
	public void selectOne() {
		assertThat(entity, notNullValue());
		
		Post post= postMapper.selectOne(entity.getId());
		assertThat(post, notNullValue());
	}
}