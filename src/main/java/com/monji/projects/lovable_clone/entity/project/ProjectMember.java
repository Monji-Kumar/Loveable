package com.monji.projects.lovable_clone.entity.project;

import com.monji.projects.lovable_clone.entity.user.User;
import com.monji.projects.lovable_clone.enums.ProjectRole;

import java.time.Instant;

public class ProjectMember {

    ProjectMemberId id;

    Project project;

    User user;

    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}
