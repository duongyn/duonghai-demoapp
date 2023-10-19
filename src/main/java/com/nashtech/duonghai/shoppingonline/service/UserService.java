package com.nashtech.duonghai.shoppingonline.service;

import com.nashtech.duonghai.shoppingonline.dto.UserDTO;
import com.nashtech.duonghai.shoppingonline.entity.BaseEntity;
import com.nashtech.duonghai.shoppingonline.entity.RoleEntity;
import com.nashtech.duonghai.shoppingonline.entity.UserEntity;
import com.nashtech.duonghai.shoppingonline.mapper.UserMapper;
import com.nashtech.duonghai.shoppingonline.repository.RoleRepository;
import com.nashtech.duonghai.shoppingonline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleService roleService;

    public UserDTO save(UserDTO dto) {
        UserEntity entity = userMapper.convertToEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(true);
        entity.setProvider(dto.getProvider());
        entity.setRoles(roleService.getRolesFromString(dto.getRoles()));
        return userMapper.convertToDto(userRepository.save(entity));
    }

    public UserDTO update(UserDTO dto) {
        UserEntity entity = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("Not found user"));
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setDob(dto.getDob());
        entity.setLastUpdatedBy(dto.getLastUpdatedBy());
        entity.setLastUpdatedDate(dto.getLastUpdatedDate());
        return userMapper.convertToDto(entity);
    }

    public UserDTO findById(String userId) {
        return userMapper.convertToDto(userRepository.findById(userId)
                .orElse(null));
    }

    public UserDTO findByUsername(String username) {
        return userMapper.convertToDto(userRepository.findByUsername(username)
                .orElse(null));
    }

    public List<UserDTO> getAll() {
        return userMapper.toListDto(userRepository.findAll()
                .stream()
                .filter(BaseEntity::isStatus)
                .toList());
    }

}
