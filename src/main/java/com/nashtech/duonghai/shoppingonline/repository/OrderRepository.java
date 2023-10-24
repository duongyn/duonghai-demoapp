package com.nashtech.duonghai.shoppingonline.repository;

import com.nashtech.duonghai.shoppingonline.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
