package com.fangyuan.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fangyuan.myschool.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
}
