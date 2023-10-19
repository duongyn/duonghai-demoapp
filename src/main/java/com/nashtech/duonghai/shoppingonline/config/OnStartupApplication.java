package com.nashtech.duonghai.shoppingonline.config;

import com.nashtech.duonghai.shoppingonline.entity.RoleEntity;
import com.nashtech.duonghai.shoppingonline.other.constant.ERole;
import com.nashtech.duonghai.shoppingonline.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OnStartupApplication {

    @Autowired
    private RoleRepository roleRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadRoleData() {
        if(roleRepository.findAll().isEmpty()) {
            RoleEntity roleAdmin = new RoleEntity(ERole.ROLE_ADMIN);
            RoleEntity roleManager = new RoleEntity(ERole.ROLE_MANAGER);
            RoleEntity roleUser = new RoleEntity(ERole.ROLE_USER);
            List<RoleEntity> roles = new ArrayList<>();
            roles.add(roleAdmin);
            roles.add(roleManager);
            roles.add(roleUser);
            roleRepository.saveAll(roles);
        }
    }
}
