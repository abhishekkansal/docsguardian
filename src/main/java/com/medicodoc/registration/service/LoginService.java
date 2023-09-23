package com.medicodoc.registration.service;

import com.medicodoc.registration.dto.request.LoginData;

public interface LoginService {

    public String loginUser(LoginData loginData);
}
