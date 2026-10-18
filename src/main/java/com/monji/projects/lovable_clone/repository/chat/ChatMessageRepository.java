package com.monji.projects.lovable_clone.repository.chat;

import com.monji.projects.lovable_clone.entity.chat.ChatMessage;
import com.monji.projects.lovable_clone.entity.chat.ChatSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    @Query("""
        SELECT m FROM ChatMessage m
        LEFT JOIN FETCH m.chatEvents
        WHERE m.chatSession = :chatSession
        ORDER BY m.createdAt ASC, m.id ASC
        """)
    List<ChatMessage> findByChatSession(ChatSession chatSession);
}
