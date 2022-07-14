package com.fastcampus.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(nullable = false, length = 100)
	private String title; 
	
	@Lob // 아주 긴 문자데이터(GB)를 저장할 수 있는 설정
	@Column(nullable = false)
	private String content; 
	
	@CreationTimestamp 
	private Timestamp createDate;
	
	// 포스트 : 회원은 N : 1 관계다.
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "USER_ID") // FK
	private User user;
	
	
	@OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE)
	private List<Reply> replyList = new ArrayList<>();


	//게시글에 댓글 추가
	public void addReply(Reply reply) {
		this.replyList.add(reply);
		reply.setPost(this);
	}
}








