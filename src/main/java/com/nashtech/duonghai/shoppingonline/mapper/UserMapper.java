package com.nashtech.duonghai.shoppingonline.mapper;

import com.nashtech.duonghai.shoppingonline.dto.UserDTO;
import com.nashtech.duonghai.shoppingonline.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDto(UserEntity user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        List<String> roles = user.getRoles().stream().map(roleEntity -> roleEntity.getRoleName().toString()).toList();
        userDTO.setRoles(roles);
        return userDTO;
    }

    public UserEntity convertToEntity(UserDTO dto) {
        UserEntity entity = modelMapper.map(dto, UserEntity.class);

        return entity;
    }

    public List<UserDTO> toListDto(List<UserEntity> entities) {
        return entities.stream().map(this::convertToDto).toList();
    }
}
