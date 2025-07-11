package com.krish.expensestracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krish.expensestracker.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{

}
