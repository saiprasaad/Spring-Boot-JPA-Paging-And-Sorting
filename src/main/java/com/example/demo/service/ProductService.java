package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.product.Product;

public interface ProductService {
	public List<Product> findAllProducts();
	public List<Product> findProductsWithSorting(String field);
	public Page<Product> findProductsWithPagination(int offset, int pageSize);
}
