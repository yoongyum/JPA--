package com.fastcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.User;
import com.fastcampus.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	// 로그인 화면으로 이동
	@GetMapping("/auth/login") 
	public String login() {
		return "system/login";
	}
	
	// 회원가입 화면으로 이동
	@GetMapping("/auth/insertUser") 
	public String insertUser() {
		return "user/insertUser";
	}
	
	// 회원 가입 처리
	@PostMapping("/auth/insertUser")
	public @ResponseBody String insertUser(@RequestBody User user) {
		// username으로 등록된 회원이 있나 검색한다. 
		User findUser = userService.getUser(user.getUsername());
		
		if(findUser.getUsername() == null) {
			user.setRole("USER");
			userService.insertUser(user);
			return user.getUsername() + " 회원 가입 성공";
		} else {
			return user.getUsername() + " 아이디는 이미 존재합니다";
		}
	}


	
//	@Autowired
//	private UserRepository userRepository;	
//	
//	@PostMapping("/user")
//	public String insertUser(@RequestBody User user) {
//		userRepository.save(user); // save() 메소드는 등록, 수정을 모두 처리할 때 사용한다. 
//		return user.getUsername() + "님 회원가입 성공";
//	}
//	
//	@PutMapping("/user")
//	//@Transactional
//	public String updateUser(@RequestBody User user) {
//		Optional<User> findEntity = userRepository.findById(user.getId());
//		if(findEntity.isPresent()) {
//			User findUser = findEntity.get();
//			findUser.setUsername(user.getUsername());
//			findUser.setPassword(user.getPassword());
//			findUser.setEmail(user.getEmail());
//			userRepository.save(findUser);
//			return "회원 수정 성공";
//		} else {
//			return user.getId() + "번 회원이 없습니다.";
//		}
//	}
//	
//	@DeleteMapping("/user/{id}")
//	public String deleteUser(@PathVariable int id) {
//		userRepository.deleteById(id);
//		return "회원 삭제 성공";
//	}
//
//	
//	@GetMapping("/user/get/{id}")
//	public User getUser(@PathVariable int id) {
//	//	// 특정 id(회원 번호)에 해당하는 User 객체를 리턴한다. 
//	//	Optional<User> findUser = userRepository.findById(id); // findById() 메소드는 PK에 해당하는 데이터에 대한 상세조회 
//	//	if(findUser.isPresent()) {
//	//		return findUser.get();
//	//	} else {
//	//		return new User();
//	//	}	
//		// 특정 id(회원 번호)에 해당하는 User 객체를 리턴한다. 
//		return userRepository.findById(id).get(); // findById() 메소드는 PK에 해당하는 데이터에 대한 상세조회 
//	}
//	
//	@GetMapping("/user/list")
//	public List<User> getUserList() {
//		return userRepository.findAll();
//	}
//
//	@GetMapping("/user/page")
//	public Page<User> getUserListPaging(
//		@PageableDefault(page = 0, size = 3, direction = Sort.Direction.DESC, sort = {"id"}) Pageable pageable) {
//		// 첫 번째 페이지(0)에 해당하는 2개의 데이터를 조회하되 id를 내림 차순 정렬한다.
//		return userRepository.findAll(pageable);
//	}

}












