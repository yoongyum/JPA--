package com.fastcampus.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.Post;
import com.fastcampus.dto.PostDto;
import com.fastcampus.persistence.PostRepository;

@Service
@Transactional
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public void insertPost(Post post) {
		postRepository.save(post);
	}

	public Page<Post> getPostList(Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	public Post getPost(int id) {
		return postRepository.findById(id).orElseThrow();
	}

	public void updatePost(int id, PostDto postDto) {
		Post post = postRepository.findById(id).orElseThrow();
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		
		postRepository.save(post);
	}

}
