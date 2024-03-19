package com.tiagolearnspring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagolearnspring.course.entities.Product;

public interface ProductsRepository extends JpaRepository<Product, Long> {

}
