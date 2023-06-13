package com.productcat.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productcat.demo.model.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Integer> {

}
