package com.fastcampus.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fastcampus.dto.ReplyDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "ReplyBuilder")
public class Reply {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String content;	//댓글 내용
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID") 
	User user;		//작성자
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_ID") 
	Post post;		//게시글
	
	
	public static ReplyBuilder builder(ReplyDto replyDto){
        return ReplyBuilder()
        		.content(replyDto.getContent());
    }
}
