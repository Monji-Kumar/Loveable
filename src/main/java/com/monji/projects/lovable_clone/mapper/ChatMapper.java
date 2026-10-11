package com.monji.projects.lovable_clone.mapper;

import com.monji.projects.lovable_clone.dto.chat.ChatResponse;
import com.monji.projects.lovable_clone.entity.chat.ChatMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    @Mapping(target = "events", source = "chatEvents")
    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);
}
