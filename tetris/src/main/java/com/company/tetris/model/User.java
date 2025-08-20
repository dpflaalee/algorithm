package com.company.tetris.model;

public class User {
	private String name;
	private String userId;
	private String password;
	
	
	public User(String name, String userId, String password) {
		this.name = name;
		this.userId = userId;
		this.password = password;
	}

	public String getName() { return name; }
	public String getUserId() { return userId; }
	public String getPassword() { return password; }
	
	
}
