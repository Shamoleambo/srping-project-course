package com.tiagolearnspring.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagolearnspring.course.entities.Product;
import com.tiagolearnspring.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService services;
	
	@GetMapping
	public List<Product> findAll(){
		return services.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Product findById(@PathVariable Long id) {
		return services.findById(id);
	}
}
