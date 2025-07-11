package com.krish.expensestracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.krish.expensestracker.dao.UserDao;
import com.krish.expensestracker.model.User;
import com.krish.expensestracker.model.UserPrincipal;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByUsername(username);
		if(user == null) {
			System.out.println("User not found!");
			throw new UsernameNotFoundException("User not found!");
		}
		
		return new UserPrincipal(user);
	}

}
