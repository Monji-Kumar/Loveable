package com.monji.projects.lovable_clone.service.userservice;

import com.monji.projects.lovable_clone.dto.auth.UserProfileResponse;
import com.monji.projects.lovable_clone.entity.user.User;

public interface UserService {
    UserProfileResponse getUserProfile();

    User findById(Long userId);
}
