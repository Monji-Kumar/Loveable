package com.monji.projects.lovable_clone.service.authservice;

import com.monji.projects.lovable_clone.dto.auth.AuthResponse;
import com.monji.projects.lovable_clone.dto.auth.LoginRequest;
import com.monji.projects.lovable_clone.dto.auth.SignUpRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService{
    @Override
    public AuthResponse signUp(SignUpRequest signUpRequest) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        return null;
    }
}
