package com.nashtech.duonghai.shoppingonline.other.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SignUpRequest {
    private String username;
    private String email;
    private String password;
    private List<String> roles;

    public SignUpRequest(String username, String email, String password, List<String> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
