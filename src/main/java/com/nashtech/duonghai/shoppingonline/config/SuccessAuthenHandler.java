package com.nashtech.duonghai.shoppingonline.config;

import com.nashtech.duonghai.shoppingonline.dto.UserDTO;
import com.nashtech.duonghai.shoppingonline.other.constant.Provider;
import com.nashtech.duonghai.shoppingonline.security.oauth2.CustomOAuth2User;
import com.nashtech.duonghai.shoppingonline.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class SuccessAuthenHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    private UserDTO userDTO = new UserDTO();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
        customInfo(oauthUser.getAttributes());
        userService.save(userDTO);

        response.sendRedirect("/loginSuccess");
    }

    private String customUsernameFromEmail(String email) {
        return email != null ? email.split("@")[0] : "";
    }

    private void customInfo(Map<String, Object> attributes) {
        String attrs = attributes.toString();
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("user");
        userDTO.setRoles(roles);
        if(attrs.contains("github")) {
            userDTO.setEmail(attributes.get("email").toString());
            userDTO.setFirstName(attributes.get("name").toString());
            userDTO.setUsername(attributes.get("login").toString());
            userDTO.setProvider(Provider.GITHUB);
        }
        else if(attrs.contains("google")){
            userDTO.setEmail(attributes.get("email").toString());
            userDTO.setUsername(customUsernameFromEmail(userDTO.getEmail()));
            userDTO.setFirstName(attributes.get("given_name").toString());
            userDTO.setLastName(attributes.get("family_name").toString());
            userDTO.setProvider(Provider.GOOGLE);
        }
        else {
            userDTO.setProvider(Provider.LOCAL);
        }
    }
}
