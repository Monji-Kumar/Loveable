package com.monji.projects.lovable_clone.service.projectservice;

import com.monji.projects.lovable_clone.dto.project.ProjectRequest;
import com.monji.projects.lovable_clone.dto.project.ProjectResponse;
import com.monji.projects.lovable_clone.dto.project.ProjectSummaryResponse;
import com.monji.projects.lovable_clone.entity.project.Project;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getAllProjects();

    ProjectResponse getProjectById(Long id);

    Project findProjectById(Long id);

    ProjectResponse createProject(ProjectRequest request);

    List<ProjectSummaryResponse> getUserProjects();

    ProjectSummaryResponse getUserProjectById(Long id);

    ProjectResponse createUserProject(ProjectRequest projectRequest);

    ProjectResponse updateUserProject(Long projectId, ProjectRequest projectRequest);

    ProjectResponse deleteUserProject(Long id);

    @PreAuthorize("@security.canEditProject(#projectId)")
    ProjectResponse updateProject(Long projectId, ProjectRequest request);

    void softDelete(Long id);
}
