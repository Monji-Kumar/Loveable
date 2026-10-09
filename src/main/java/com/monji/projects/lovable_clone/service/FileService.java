package com.monji.projects.lovable_clone.service;

import com.monji.projects.lovable_clone.dto.file.FileContentResponse;
import com.monji.projects.lovable_clone.dto.file.FileNode;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long userId, Long projectId);

    FileContentResponse getFileContent(Long userId, Long projectId, String path);
}
