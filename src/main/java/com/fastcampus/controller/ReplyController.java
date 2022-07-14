package com.fastcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.User;
import com.fastcampus.dto.ReplyDto;
import com.fastcampus.security.jpa.UserDetailsImpl;
import com.fastcampus.service.PostService;
import com.fastcampus.service.ReplyService;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private PostService postService;
	
	//댓글 등록
	@PostMapping("/post/{id}/reply/insertReply")
	public String insertReply(@PathVariable int id,ReplyDto replyDto, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		User user = userDetailsImpl.getUser();
		replyService.insertReply(id,replyDto,user.getId());
		return "redirect:/post/"+id;
	}
	
	
	@DeleteMapping("/reply/replyDelete/{id}")
	@ResponseBody
	public String deleteReply(@PathVariable int id,Model model) {
		int postId = replyService.deleteReply(id);
		model.addAttribute("post",postService.getPost(postId));
		return ""+postId;
	}
}












