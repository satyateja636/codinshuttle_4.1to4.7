package com.codingshuttle.prod_ready_fearures.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.codingshuttle.prod_ready_fearures.dto.PostDTO;
import com.codingshuttle.prod_ready_fearures.entities.PostEntity;
import com.codingshuttle.prod_ready_fearures.exceptions.ResourceNotFoundException;
import com.codingshuttle.prod_ready_fearures.repositories.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;
	private final ModelMapper modelMapper;

	@Override
	public List<PostDTO> getAllPosts() {

		return postRepository.findAll().stream().map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public PostDTO createNewPost(PostDTO inputPost) {
		PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
		return modelMapper.map(postRepository.save(postEntity), PostDTO.class) ;
	}

	@Override
	public PostDTO getPostById(Long postId) {
		return modelMapper.map(postRepository.findById(postId).orElseThrow(
				() -> new ResourceNotFoundException("Post not found with this id " + postId)), PostDTO.class);
	}

}
