package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.APIResponse;
import com.example.demo.product.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public APIResponse<List<Product>> getAllProducts() {
		List<Product> products = productService.findAllProducts();
		return new APIResponse<>(products.size(), products);
	}
	
	@GetMapping("/products/{field}")
	public APIResponse<List<Product>> getAllProductsWithSort(@PathVariable String field) {
		List<Product> products = productService.findProductsWithSorting(field);
		return new APIResponse<>(products.size(), products);
	}
	
	@GetMapping("/products/pagination/{offset}/{pageSize}")
	public APIResponse<List<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<Product> products = productService.findProductsWithPagination(offset, pageSize);
		return new APIResponse(products.getSize(), products);
	}

}
