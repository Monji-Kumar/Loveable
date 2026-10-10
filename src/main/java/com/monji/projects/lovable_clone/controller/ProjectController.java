package com.monji.projects.lovable_clone.controller;

import com.monji.projects.lovable_clone.dto.project.ProjectRequest;
import com.monji.projects.lovable_clone.dto.project.ProjectResponse;
import com.monji.projects.lovable_clone.dto.project.ProjectSummaryResponse;
import com.monji.projects.lovable_clone.service.projectservice.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping(value = "get-my-projects")
    public ResponseEntity<List<ProjectSummaryResponse>> getProjects() {
        Long userId = 1L;
        return ResponseEntity.ok(projectService.getAllProjects(userId));
    }

    @GetMapping(value = "get-project")
    public ResponseEntity<ProjectResponse> getProjectById(@RequestParam Long id) {
        Long userId = 1L;
        return ResponseEntity.ok(projectService.getUserProjectById(userId, id));
    }

    @PostMapping(value = "create-project")
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest projectRequest) {
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createUserProject(userId, projectRequest));
    }

    @PatchMapping(value = "update-project")
    public ResponseEntity<ProjectResponse> createProject(@RequestParam Long id, @RequestBody ProjectRequest projectRequest) {
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.updateUserProject(userId, id, projectRequest));
    }

    @DeleteMapping(value = "delete-project")
    public ResponseEntity<ProjectResponse> deleteProject(@RequestParam Long id) {
        Long userId = 1L;
        projectService.deleteUserProject(userId, id);
        return ResponseEntity.noContent().build();
    }
}
