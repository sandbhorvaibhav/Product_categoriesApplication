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
import com.productcat.demo.model.Product;
import com.productcat.demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	
	@Autowired ProductService ps;
	
	@PostMapping("/products")
	public ResponseEntity<String> saveProduct(@RequestBody Product pr)
	{
		
		ps.saveProducts(pr);
		return new ResponseEntity<String>("product save sucessfully",HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAll(@RequestParam Integer page)
	{
		List<Product> pro=ps.getALL(page);
		return  new ResponseEntity<List<Product>>(pro,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getSingleProduct(@PathVariable Integer productId) throws IDNotFoundException
	{
		Product product=ps.getSingleProduct(productId);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
 
	 @DeleteMapping("/products/{productId}")
	 public ResponseEntity<String> deleteProduct(@PathVariable Integer productId) throws IDNotFoundException
	 {
	     ps.deleteProduct(productId);
		return new ResponseEntity<String>("Product deleted sucesfuuly",HttpStatus.NO_CONTENT);
		 
	 }
	 @PutMapping("/products/{productId}")
	 public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,@RequestBody Product prr) throws IDNotFoundException
	 {
		 ps.updateProdcut(productId,prr);
		 Product pp=ps.getSingleProduct(productId);
		return new ResponseEntity<Product>(pp,HttpStatus.ACCEPTED);
		 
	 }
}
