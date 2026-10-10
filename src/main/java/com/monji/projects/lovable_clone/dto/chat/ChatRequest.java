package com.monji.projects.lovable_clone.dto.chat;

public record ChatRequest(
        String message,
        Long projectId
) {
}
