package com.tiagolearnspring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagolearnspring.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
