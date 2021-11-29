package com.kenneth.springboot.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.kenneth.springboot.entity.User;

public interface UserService extends UserDetailsService{

	public User save(User user);
	
	public List<User> listUsers();
	
	public void deleteUser(int id);
	
	public User findUserById(int id);
	
	public User findUserByEmail(String email);
}
