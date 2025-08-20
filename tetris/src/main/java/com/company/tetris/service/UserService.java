package com.company.tetris.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.company.tetris.model.User;

@Service
public class UserService {
	private final Map<String, User> userMap = new HashMap<>();
	
	public UserService() {
		userMap.put("nuts", new User("헤넛","nuts", "1234"));
		userMap.put("peanut", new User("피넛", "peanut", "1234"));
	}
	
	//로그인 성공 시 데이터 반환
	public boolean validdateUser(String userId, String password){
		User user = userMap.get(userId);
		if(user!=null && user.getPassword().equals(password)) { return true; }
		return false;
	}
}
