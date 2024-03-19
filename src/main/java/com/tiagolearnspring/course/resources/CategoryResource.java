package com.tiagolearnspring.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagolearnspring.course.entities.Category;
import com.tiagolearnspring.course.services.CategoryServices;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryServices services;

	@GetMapping
	public List<Category> findAll() {
		return services.findAll();
	}

	@GetMapping(value = "/{id}")
	public Category findById(@PathVariable Long id) {
		return services.findById(id);
	}

}
