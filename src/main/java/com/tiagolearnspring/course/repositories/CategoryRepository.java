package com.tiagolearnspring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagolearnspring.course.entities.Category;

public interface CategoryRepository extends  JpaRepository<Category, Long>{

}
