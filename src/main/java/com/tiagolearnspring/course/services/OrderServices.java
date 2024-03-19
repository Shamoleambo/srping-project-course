package com.tiagolearnspring.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagolearnspring.course.entities.Order;
import com.tiagolearnspring.course.repositories.OrderRepository;

@Service
public class OrderServices {

	@Autowired
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Order order = repository.findById(id).get();
		return order;
	}
}
