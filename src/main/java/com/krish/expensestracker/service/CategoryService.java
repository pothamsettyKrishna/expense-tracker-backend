package com.krish.expensestracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.krish.expensestracker.dao.CategoryDao;
import com.krish.expensestracker.model.Category;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao categoryDao;
	
	public ResponseEntity<String> addCategory(Category category) {
		try {
			System.out.println(category);
			categoryDao.save(category);
			return new ResponseEntity<>("success",HttpStatus.CREATED);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Category>> getAll() {
		List<Category> result = categoryDao.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
