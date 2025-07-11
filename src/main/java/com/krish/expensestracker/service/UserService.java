package com.krish.expensestracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.krish.expensestracker.dao.UserDao;
import com.krish.expensestracker.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public ResponseEntity<User> registerUser(User user) {
		try {
			user.setPassword(encoder.encode(user.getPassword()));
			userDao.save(user);
			return new ResponseEntity<>(user,HttpStatus.CREATED);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
	}

	
	public ResponseEntity<String> login(User user) {
		try {
			return new ResponseEntity<>("Success",HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed",HttpStatus.UNAUTHORIZED);
	}

}
