package com.monji.projects.lovable_clone.service.userservice;

import com.monji.projects.lovable_clone.dto.auth.UserProfileResponse;
import com.monji.projects.lovable_clone.entity.user.User;
import com.monji.projects.lovable_clone.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserProfileResponse getUserProfile() {
        return null;
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}
