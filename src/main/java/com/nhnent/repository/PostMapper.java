package com.nhnent.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nhnent.repository.entity.Post;

public interface PostMapper {
	public List<Post> selectList();
	
	public Post selectOne(Long id);
	
	public Post selectByUserEmail(@Param("userEmail") String userEmail);
	
	public void insert(Post user);
	
	public void update(Post user);
	
	public void delete(Post user);
}
