package com.monji.projects.lovable_clone.controller;

import com.monji.projects.lovable_clone.dto.file.FileContentResponse;
import com.monji.projects.lovable_clone.dto.file.FileNode;
import com.monji.projects.lovable_clone.service.fileservice.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/projects/{projectId}/files")
public class FileController {

    private final FileService fileService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId) {
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileTree(userId, projectId));
    }

    @GetMapping(value = "/{*path}")
    public ResponseEntity<FileContentResponse> getFile(@PathVariable Long projectId, @PathVariable String path) {
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileContent(userId, projectId, path));
    }
}
