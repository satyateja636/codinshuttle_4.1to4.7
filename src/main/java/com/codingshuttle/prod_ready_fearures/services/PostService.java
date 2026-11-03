package com.codingshuttle.prod_ready_fearures.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingshuttle.prod_ready_fearures.dto.PostDTO;


public interface PostService {

	List<PostDTO> getAllPosts();
	
	PostDTO createNewPost(PostDTO inputPost);

	PostDTO getPostById(Long postId);

	PostDTO updatePost(PostDTO inputPost, Long postId);
}
