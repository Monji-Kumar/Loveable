package com.monji.projects.lovable_clone.service.aigenerationservice;

import com.monji.projects.lovable_clone.dto.chat.StreamResponse;
import reactor.core.publisher.Flux;

public interface AiGenerationService {
    Flux<StreamResponse> streamResponse(String message, Long projectId);
}
