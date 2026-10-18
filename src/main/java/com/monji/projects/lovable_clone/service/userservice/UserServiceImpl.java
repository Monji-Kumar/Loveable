package com.monji.projects.lovable_clone.service.userservice;

import com.monji.projects.lovable_clone.dto.auth.UserProfileResponse;
import com.monji.projects.lovable_clone.entity.user.User;
import com.monji.projects.lovable_clone.error.ResourceNotFoundException;
import com.monji.projects.lovable_clone.mapper.UserMapper;
import com.monji.projects.lovable_clone.repository.user.UserRepository;
import com.monji.projects.lovable_clone.security.AuthUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthUtil authUtil;
    private final UserMapper userMapper;

    @Override
    public UserProfileResponse getUserProfile() {
        Long userId = authUtil.getCurrentUserId();
        User user = getUser(userId);
        return userMapper.toUserProfileResponse(user);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with the given Id" + username));
    }

    //Helper Methods
    private User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User:", userId.toString()));
    }
}
