package com.medicodoc.registration.controller;

import com.medicodoc.registration.dto.request.LoginData;
import com.medicodoc.registration.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(value="/login")
    public String userLogin(@RequestBody(required = true) LoginData loginData) {
        String response;
        try {
            response=loginService.loginUser(loginData);
        } catch (Exception ex) {
            ex.printStackTrace();
            response= "not authorized";
        }
        return response;
    }
}