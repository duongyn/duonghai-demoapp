package com.nashtech.duonghai.shoppingonline.repository;

import com.nashtech.duonghai.shoppingonline.entity.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {

}
