package com.kenneth.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenneth.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}
