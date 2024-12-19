package com.example.project2.controller;

import com.example.project2.model.RoleModel;
import com.example.project2.model.UserModel;
import com.example.project2.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/reg")
    public String getRegister(UserModel user) {
        return "register";
    }

    @PostMapping("/regTest")
    public String postRegister(
            @Valid
            @ModelAttribute(name = "user")
            UserModel user) {

        userService.save(user);
        return "/login";

    }


}
