package com.monji.projects.lovable_clone.controller;

import com.monji.projects.lovable_clone.dto.deploy.DeployResponse;
import com.monji.projects.lovable_clone.dto.project.ProjectRequest;
import com.monji.projects.lovable_clone.dto.project.ProjectResponse;
import com.monji.projects.lovable_clone.dto.project.ProjectSummaryResponse;
import com.monji.projects.lovable_clone.service.deploymentservice.DeploymentService;
import com.monji.projects.lovable_clone.service.projectservice.ProjectService;
import jakarta.validation.Valid;
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
    private final DeploymentService deploymentService;

    @GetMapping(value = "get-my-projects")
    public ResponseEntity<List<ProjectSummaryResponse>> getProjects() {
        return ResponseEntity.ok(projectService.getUserProjects());
    }

    @GetMapping(value = "get-project")
    public ResponseEntity<ProjectSummaryResponse> getUserProjectById(@RequestParam Long id) {
        return ResponseEntity.ok(projectService.getUserProjectById(id));
    }

    @PostMapping(value = "create-project")
    public ResponseEntity<ProjectResponse> createProject(@Valid @RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(projectRequest));
    }

    @PatchMapping(value = "update-project")
    public ResponseEntity<ProjectResponse> updateProject(@RequestParam Long id, @Valid @RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.updateProject(id, projectRequest));
    }

    @DeleteMapping(value = "delete-project")
    public ResponseEntity<ProjectResponse> deleteProject(@RequestParam Long id) {
        projectService.softDelete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/deploy")
    public ResponseEntity<DeployResponse> deployProject(@PathVariable Long id) {
        return ResponseEntity.ok(deploymentService.deploy(id));
    }
}
