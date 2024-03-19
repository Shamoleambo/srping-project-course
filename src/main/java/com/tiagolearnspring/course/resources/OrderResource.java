package com.tiagolearnspring.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagolearnspring.course.entities.Order;
import com.tiagolearnspring.course.services.OrderServices;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderServices service;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

}
