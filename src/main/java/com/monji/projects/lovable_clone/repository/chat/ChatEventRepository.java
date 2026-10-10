package com.monji.projects.lovable_clone.repository.chat;

import com.monji.projects.lovable_clone.entity.chat.ChatEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatEventRepository  extends JpaRepository<ChatEvent, Long> {
}
