package com.medicodoc.registration.service.impl;

import com.medicodoc.registration.dto.request.RegistrationData;
import com.medicodoc.registration.repository.RegistrationRepository;
import com.medicodoc.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Override
    public String registerNewUser(RegistrationData registrationData) {

        registrationRepository.save(registrationData);
        return "Registration Successful";
    }
    @Override
    public List<RegistrationData> getUserDetails(String username) {
        List<RegistrationData> regData = registrationRepository.getuserdetails(username);//.toString();
        System.out.println(regData.toString());
        return regData;
    }
}
