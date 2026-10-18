package com.monji.projects.lovable_clone.dto.chat;

import com.monji.projects.lovable_clone.enums.ChatEventType;

public record ChatEventResponse(
        Long id,
        ChatEventType type,
        Integer sequenceOrder,
        String content,
        String filePath,
        String metadata
) {
}
