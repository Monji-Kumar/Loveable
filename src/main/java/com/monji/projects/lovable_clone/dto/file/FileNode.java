package com.monji.projects.lovable_clone.dto.file;

import java.time.Instant;

public record FileNode(
        String path,
        Instant createdAt,
        Long size,
        String type
) {
}
