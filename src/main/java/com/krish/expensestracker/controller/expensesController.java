package com.krish.expensestracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.krish.expensestracker.model.Category;
import com.krish.expensestracker.model.User;
import com.krish.expensestracker.service.CategoryService;
import com.krish.expensestracker.service.UserService;

@RestController
@RequestMapping("expenses")
@CrossOrigin
public class expensesController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("categories")
	public ResponseEntity<List<Category>> getCategories() {
		System.out.println("Get request called.");
		 return categoryService.getAll();
	}
	
	@PostMapping("addcategory")
	public ResponseEntity<String> addCategory(@RequestBody Category cat) {
		
		return categoryService.addCategory(cat);
		
	}
	
	@PostMapping("register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	@PostMapping("login")
	public ResponseEntity<String> login(@RequestBody User user){
		return userService.login(user);
	}
	
}
