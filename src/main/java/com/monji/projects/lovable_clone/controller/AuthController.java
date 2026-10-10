package com.monji.projects.lovable_clone.controller;

import com.monji.projects.lovable_clone.dto.auth.AuthResponse;
import com.monji.projects.lovable_clone.dto.auth.LoginRequest;
import com.monji.projects.lovable_clone.dto.auth.SignUpRequest;
import com.monji.projects.lovable_clone.dto.auth.UserProfileResponse;
import com.monji.projects.lovable_clone.service.AuthService;
import com.monji.projects.lovable_clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping(value = "/sign-up")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authService.signUp(signUpRequest));

    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @GetMapping(value = "/me")
    public ResponseEntity<UserProfileResponse> getUserProfile() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getUserProfile());
    }
}
