package com.monji.projects.lovable_clone.service.projectfileservice;

import com.monji.projects.lovable_clone.dto.file.FileContentResponse;
import com.monji.projects.lovable_clone.dto.file.FileTreeResponse;

public interface ProjectFileService {
    FileTreeResponse getFileTree(Long projectId);

    FileContentResponse getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);
}
