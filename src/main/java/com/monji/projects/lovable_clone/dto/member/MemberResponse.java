package com.monji.projects.lovable_clone.dto.member;

import com.monji.projects.lovable_clone.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        String id,
        String email,
        String name,
        String avatarUrl,
        ProjectRole projectRole,
        Instant invitedAt
) {
}
