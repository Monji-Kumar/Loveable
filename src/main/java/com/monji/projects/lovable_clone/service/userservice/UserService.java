package com.monji.projects.lovable_clone.service.userservice;

import com.monji.projects.lovable_clone.dto.auth.UserProfileResponse;
import com.monji.projects.lovable_clone.entity.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    UserProfileResponse getUserProfile();

    User findById(Long userId);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
