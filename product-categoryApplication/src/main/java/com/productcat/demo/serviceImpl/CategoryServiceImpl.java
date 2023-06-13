package com.productcat.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.productcat.demo.exception.IDNotFoundException;
import com.productcat.demo.model.Category;
import com.productcat.demo.model.Product;
import com.productcat.demo.repositry.CategoryRepositry;
import com.productcat.demo.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	           CategoryRepositry cr;

	@Override
	public void saveCategrioes(Category cat) {
		// TODO Auto-generated method stub
		
		cr.save(cat);
		
	}

	@Override
	public Category singleCategory(Integer categoryId) throws IDNotFoundException {
		
		Optional<Category> caa=cr.findById(categoryId);
		
		if(caa.isPresent())
		{
			Category cst=caa.get();
			return cst;
		}
		
		throw new IDNotFoundException("Category is not present");
	}

	@Override
	public void deleteCategory(Integer categoryId) throws IDNotFoundException {
		
Optional<Category> caa=cr.findById(categoryId);
		
		if(caa.isPresent())
		{
			cr.deleteById(categoryId);
		}
		
		
		throw new IDNotFoundException("Id not found to delete");
	}

	@Override
	public void updateCategory(Integer categoryId, Category cat) {
		// TODO Auto-generated method stub
Optional<Category> caa=cr.findById(categoryId);
		
		if(caa.isPresent())
		{
			Category cas=caa.get();
			
			cas.setDescription(cat.getDescription());
			cas.setCategoryName(cat.getCategoryName());
			cr.save(cas);
			
		
		}
	}
	@Override
	public List<Category> getALL(Integer page) {
	
		PageRequest pagable =PageRequest.ofSize(page);
		 
		    Page<Category> paa= cr.findAll(pagable);
		    
		      List<Category> pr=paa.getContent();
		return pr;
	}
}
