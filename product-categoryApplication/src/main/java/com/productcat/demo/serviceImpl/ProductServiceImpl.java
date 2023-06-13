package com.productcat.demo.serviceImpl;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.productcat.demo.exception.IDNotFoundException;
import com.productcat.demo.model.Product;
import com.productcat.demo.repositry.ProductRepositry;
import com.productcat.demo.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	ProductRepositry pr;

	@Override
	public void saveProducts(Product pro) {
	
		pr.save(pro);
	}

	@Override
	public Product getSingleProduct(Integer productId) throws IDNotFoundException {
		
		Optional<Product> pro=pr.findById(productId);
		if(pro.isPresent())
		{
			Product prs=pro.get();
			return prs;
		}
		throw new IDNotFoundException("no product found ");
	}

	@Override
	public void deleteProduct(Integer productId) throws IDNotFoundException {
		Optional<Product> ps=pr.findById(productId);
		if(ps.isPresent())
		{
			pr.deleteById(productId);
		}
		throw new IDNotFoundException("Id not match");
	}

	@Override
	public void updateProdcut(Integer productId, Product prr) {
		
		Optional<Product> pro=pr.findById(productId);
		if(pro.isPresent())
		{
			Product prs=pro.get();
			prs.setProductName(prr.getProductName());
			prs.setDescription(prr.getDescription());
			prs.setProductPrice(prr.getProductPrice());
			
			pr.save(prs);
		}
		
	}

	@Override
	public List<Product> getALL(Integer page) {
	
		PageRequest p=PageRequest.ofSize(page);
		 
		    Page<Product> paa= pr.findAll(p);
		    
		      List<Product> pr=paa.getContent();
		return pr;
	}

}
