package com.krish.expensestracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krish.expensestracker.model.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);

}
