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

	//게시글 등록
	public void insertPost(Post post) {
		postRepository.save(post);
	}

	//게시글 목록 조회
	public Page<Post> getPostList(Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	//게시글 조회
	public Post getPost(int id) {
		return postRepository.findById(id).orElseThrow();
	}

	//게시글 수정
	public void updatePost(int id, PostDto postDto) {
		Post post = postRepository.findById(id).orElseThrow();
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		postRepository.save(post);
	}

	//게시글 삭제
	public void deletePost(int id) {
		postRepository.deleteById(id);
	}

}
