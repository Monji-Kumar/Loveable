package com.monji.projects.lovable_clone.service.fileservice;

import com.monji.projects.lovable_clone.dto.file.FileContentResponse;
import com.monji.projects.lovable_clone.dto.file.FileNode;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId);

    FileContentResponse getFileContent(Long projectId, String path);
}
