package com.monji.projects.lovable_clone.controller;

import com.monji.projects.lovable_clone.dto.chat.ChatRequest;
import com.monji.projects.lovable_clone.dto.chat.ChatResponse;
import com.openai.core.http.StreamResponse;
import com.openai.services.blocking.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/chat")
public class ChatController {

    private final ChatService chatService;
    private final AiGenerationService aiGenerationService;

    @PostMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<StreamResponse>> streamChat(@RequestBody ChatRequest chatRequest) {
        return aiGenerationService.streamResponse(chatRequest.message(), chatRequest.projectId())
                .map(data -> ServerSentEvent.<StreamResponse>builder()
                        .data(data).build());
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ChatResponse>> getChatHistory(
            @RequestParam(required = true) Long projectId) {

        return ResponseEntity.ok(chatService.getProjectChatHistory(projectId));
    }
}
