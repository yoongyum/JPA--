package com.fastcampus.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.User;

@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertUser(User user) {
		mybatis.insert("insertUser", user);
	}
	
	public List<User> getUserList() {
		return mybatis.selectList("getUserList");
	}
}
