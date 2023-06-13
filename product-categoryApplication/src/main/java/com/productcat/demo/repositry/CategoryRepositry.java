package com.productcat.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productcat.demo.model.Category;
@Repository
public interface CategoryRepositry extends JpaRepository<Category, Integer> {

}
