package com.medicodoc.registration.service.impl;

import com.medicodoc.registration.dto.request.LoginData;
import com.medicodoc.registration.dto.request.RegistrationData;
import com.medicodoc.registration.repository.RegistrationRepository;
import com.medicodoc.registration.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public RegistrationData loginUser(LoginData loginData) {
        RegistrationData regData = registrationRepository.validateIdPassword(loginData.getUsername(), loginData.getPassword());
        return regData;
    }
}
