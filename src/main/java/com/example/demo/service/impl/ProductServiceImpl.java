package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.product.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findProductsWithSorting(String field) {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	@Override
	public Page<Product> findProductsWithPagination(int offset, int pageSize) {
		Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize));
		return products;
	}

}
