package com.monji.projects.lovable_clone.dto.project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
        @NotBlank(message = "Project name is mandatory") String name
) {
}
