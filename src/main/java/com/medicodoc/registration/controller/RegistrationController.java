package com.medicodoc.registration.controller;

import com.medicodoc.registration.dto.request.RegistrationData;
import com.medicodoc.registration.dto.response.RegistrationResponse;
import com.medicodoc.registration.repository.RegistrationRepository;
import com.medicodoc.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping(value = "/register")
    public RegistrationResponse userRegistration(@RequestBody(required = true) RegistrationData registrationData) {
        String response;
        RegistrationResponse registrationResponse= new RegistrationResponse();
        try {
            registrationService.registerNewUser(registrationData);
            registrationResponse.setRegistrationStatus("Complete");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("some error occured");
            registrationResponse.setRegistrationStatus("Error");

        }
        return registrationResponse;
    }

    @GetMapping(value = "/getuserdata")
    public List<RegistrationData> userRegistration(@RequestParam String username) {
        List<RegistrationData> response = registrationService.getUserDetails(username);
        return response;
    }
}