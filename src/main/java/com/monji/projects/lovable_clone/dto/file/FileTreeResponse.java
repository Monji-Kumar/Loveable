package com.monji.projects.lovable_clone.dto.file;

import java.util.List;

public record FileTreeResponse(
        List<FileNode> files
) {
}
