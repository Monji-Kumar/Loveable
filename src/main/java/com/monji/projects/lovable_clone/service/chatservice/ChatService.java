package com.monji.projects.lovable_clone.service.chatservice;

import com.monji.projects.lovable_clone.dto.chat.ChatResponse;

import java.util.List;

public interface ChatService {
    List<ChatResponse> getProjectChatHistory(Long projectId);
}
