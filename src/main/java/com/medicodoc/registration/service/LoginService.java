package com.medicodoc.registration.service;

import com.medicodoc.registration.dto.request.LoginData;
import com.medicodoc.registration.dto.request.RegistrationData;

public interface LoginService {

    public RegistrationData loginUser(LoginData loginData);
}
