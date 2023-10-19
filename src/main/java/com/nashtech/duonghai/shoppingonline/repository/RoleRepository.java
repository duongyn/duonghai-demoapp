package com.nashtech.duonghai.shoppingonline.repository;

import com.nashtech.duonghai.shoppingonline.entity.RoleEntity;
import com.nashtech.duonghai.shoppingonline.other.constant.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByRoleName(ERole roleName);
}
