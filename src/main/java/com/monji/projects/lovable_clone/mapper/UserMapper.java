package com.monji.projects.lovable_clone.mapper;

import com.monji.projects.lovable_clone.dto.auth.SignUpRequest;
import com.monji.projects.lovable_clone.dto.auth.UserProfileResponse;
import com.monji.projects.lovable_clone.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "passwordHash", ignore = true)
    User toEntity(SignUpRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);

}
