package com.medicodoc.registration.service;

import com.medicodoc.registration.dto.request.RegistrationData;

import java.util.List;

public interface RegistrationService {

    public String registerNewUser(RegistrationData registrationData);
    public List<RegistrationData> getUserDetails(String username);
}
