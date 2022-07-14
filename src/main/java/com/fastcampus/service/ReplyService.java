package com.fastcampus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastcampus.domain.Reply;
import com.fastcampus.dto.ReplyDto;
import com.fastcampus.persistence.PostRepository;
import com.fastcampus.persistence.ReplyRepository;
import com.fastcampus.persistence.UserRepository;

@Service
@Transactional
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;

	//댓글 생성
	public void insertReply(int postId, ReplyDto replyDto, int userId) {
		
		var postRes = postRepository.findById(postId);
		
		//포스트가 존재하는 경우
		postRes.ifPresent(post ->{
			//Dto로 기반으로 댓글 Entity 생성
			Reply reply = Reply.builder(replyDto).build();
			var user = userRepository.findById(userId).orElse(null);
			user.addReply(reply,post);
			replyRepository.save(reply);
		});
		
	}

	public int deleteReply(int id) {
		var reply = replyRepository.findById(id).orElse(null);
		int postId = reply.getPost().getId();
		replyRepository.delete(reply);
		return postId;
	}
}
