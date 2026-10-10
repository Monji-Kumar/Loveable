package com.monji.projects.lovable_clone.service.fileservice;

import com.monji.projects.lovable_clone.dto.file.FileContentResponse;
import com.monji.projects.lovable_clone.dto.file.FileNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> getFileTree(Long userId, Long projectId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long userId, Long projectId, String path) {
        return null;
    }
}
