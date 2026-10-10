package com.monji.projects.lovable_clone.dto.member;

import com.monji.projects.lovable_clone.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email (message = "Invalid email") @NotBlank(message = "Email is mandatory") String email,
        @NotNull(message = "Role is mandatory") ProjectRole role
) {
}
