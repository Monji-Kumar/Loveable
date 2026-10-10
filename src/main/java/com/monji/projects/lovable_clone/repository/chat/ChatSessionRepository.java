package com.monji.projects.lovable_clone.repository.chat;

import com.monji.projects.lovable_clone.entity.chat.ChatSession;
import com.monji.projects.lovable_clone.entity.chat.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}
