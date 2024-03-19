package com.tiagolearnspring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagolearnspring.course.entities.OrderItem;
import com.tiagolearnspring.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
