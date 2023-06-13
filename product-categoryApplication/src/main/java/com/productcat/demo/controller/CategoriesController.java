package com.productcat.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productcat.demo.exception.IDNotFoundException;
import com.productcat.demo.model.Category;
import com.productcat.demo.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoriesController {
	
	
	@Autowired CategoryService cs;
	@PostMapping("/categories")
	public ResponseEntity<String> saveCategroies(@RequestBody Category cat )
	{
		
		cs.saveCategrioes(cat);
		return new ResponseEntity<String>("catggory save sucessfully",HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/categories/{categoryId}")
	public ResponseEntity<Category> getSingleCatgory(@PathVariable Integer categoryId) throws IDNotFoundException
	{
		Category cx =cs.singleCategory(categoryId);
		return new ResponseEntity<Category>(cx,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/categories/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer categoryId) throws IDNotFoundException
	{
		
		cs.deleteCategory(categoryId);
		return new ResponseEntity<String>("category deleted sucessfully",HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAll(@RequestParam Integer page)
	{
		   List<Category> category=cs.getALL(page);
		return new ResponseEntity<List<Category>>(category,HttpStatus.CREATED);
		
	}

@PutMapping("/categories/{categoryId}")
public ResponseEntity<Category> updateCategories(@PathVariable Integer categoryId,@RequestBody Category cat) throws IDNotFoundException
{
	
	cs.updateCategory(categoryId,cat);
	
	return new ResponseEntity<Category>(cs.singleCategory(categoryId),HttpStatus.ACCEPTED);
	
}

}
