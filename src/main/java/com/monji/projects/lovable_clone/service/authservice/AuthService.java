package com.monji.projects.lovable_clone.service.authservice;

import com.monji.projects.lovable_clone.dto.auth.AuthResponse;
import com.monji.projects.lovable_clone.dto.auth.LoginRequest;
import com.monji.projects.lovable_clone.dto.auth.SignUpRequest;

public interface AuthService {
    AuthResponse signUp(SignUpRequest signUpRequest);

    AuthResponse login(LoginRequest loginRequest);
}
