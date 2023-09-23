package com.medicodoc.registration.controller;

import com.medicodoc.registration.dto.request.RegistrationData;
import com.medicodoc.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping(value="/register")
    public String userRegistration(@RequestBody(required = true) RegistrationData registrationData) {
        String response;
        try {
            response=registrationService.registerNewUser(registrationData);
        } catch (Exception ex) {
            ex.printStackTrace();
            response= "some error occured";
        }
        return response;
    }

    @GetMapping(value="/getuserdata")
    public List<RegistrationData> userRegistration(@RequestParam String username) {
        List<RegistrationData> response=registrationService.getUserDetails(username);
        return response;
    }
}