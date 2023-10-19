package com.nashtech.duonghai.shoppingonline.dto;

import com.nashtech.duonghai.shoppingonline.other.constant.Provider;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@ToString
public class UserDTO {
    private String userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastUpdatedBy;
    private Provider provider;
    private LocalDateTime lastUpdatedDate;
    private List<String> roles;
}
