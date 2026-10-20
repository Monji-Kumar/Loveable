package com.monji.projects.lovable_clone.service.chatservice;

import com.monji.projects.lovable_clone.dto.chat.ChatResponse;
import com.monji.projects.lovable_clone.entity.chat.ChatMessage;
import com.monji.projects.lovable_clone.entity.chat.ChatSession;
import com.monji.projects.lovable_clone.entity.chat.ChatSessionId;
import com.monji.projects.lovable_clone.mapper.ChatMapper;
import com.monji.projects.lovable_clone.repository.chat.ChatMessageRepository;
import com.monji.projects.lovable_clone.repository.chat.ChatSessionRepository;
import com.monji.projects.lovable_clone.security.AuthUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatSessionRepository chatSessionRepository;
    private final AuthUtil authUtil;
    private final ChatMapper chatMapper;

    @Override
    public List<ChatResponse> getProjectChatHistory(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        ChatSession chatSession = chatSessionRepository.getReferenceById(
                new ChatSessionId(projectId, userId)
        );

        List<ChatMessage> chatMessageList = chatMessageRepository.findByChatSession(chatSession);

        return chatMapper.fromListOfChatMessage(chatMessageList);
    }
}
