package com.nashtech.duonghai.shoppingonline.repository;

import com.nashtech.duonghai.shoppingonline.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
