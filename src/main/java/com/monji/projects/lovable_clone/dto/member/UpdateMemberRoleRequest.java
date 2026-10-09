package com.monji.projects.lovable_clone.dto.member;

import com.monji.projects.lovable_clone.enums.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole role
) {
}
