package com.productcat.demo.service;

import java.util.List;

import com.productcat.demo.exception.IDNotFoundException;
import com.productcat.demo.model.Product;

public interface ProductService {

	void saveProducts(Product pr);

	Product getSingleProduct(Integer productId) throws IDNotFoundException;

	void deleteProduct(Integer productId) throws IDNotFoundException;

	void updateProdcut(Integer productId, Product prr);

	List<Product> getALL(Integer page);

}