package com.medicodoc.registration.controller;

import com.medicodoc.registration.dto.request.LoginData;
import com.medicodoc.registration.dto.request.RegistrationData;
import com.medicodoc.registration.dto.response.LoginResponse;
import com.medicodoc.registration.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(value = "/login")
    public LoginResponse userLogin(@RequestBody(required = true) LoginData loginData) {
        RegistrationData response= null;
        LoginResponse loginResponse= new LoginResponse();

        try {
            response = loginService.loginUser(loginData);
            loginResponse.setLoginStatus("Success");
            loginResponse.setUsername(response.getUsername());

        } catch (Exception ex) {
            ex.printStackTrace();
            loginResponse.setLoginStatus("Failed");
            loginResponse.setUsername(null);
        }
        return loginResponse;
    }
}