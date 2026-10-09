package com.monji.projects.lovable_clone.entity.usagelogs;

import com.monji.projects.lovable_clone.entity.project.Project;
import com.monji.projects.lovable_clone.entity.user.User;

import java.time.Instant;

public class UsageLog {

    Long id;
    User user;
    Project project;

    String action;

    Integer tokensUsed;
    Integer durationMs;

    String metaData; // JSON of {model_used, prompt_used},

    Instant createdAt;
}
